package com.updated.rollTheDice.JsonReader;

import com.updated.rollTheDice.Exceptions.JsonFileLoadException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonRegistry {
    private final Map<String, JsonFileReader> sections = new HashMap<>();

    public void register(String sectionName, String filePath) throws JsonFileLoadException {
        sections.put(sectionName, new JsonFileReader(filePath));
    }

    /**
     * Registers multiple sections from a 2D array of entries.
     * Each entry should be a pair of section name and file path.
     *
     * @param entries 2D array where each sub-array contains [sectionName, filePath]
     * @throws JsonFileLoadException if any file fails to load
     */
    public void registerAll(String[][] entries) throws JsonFileLoadException {
        Map<String, String> entryMap = mapFromEntries(entries);
        for (Map.Entry<String, String> entry : entryMap.entrySet()) {
            register(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Converts a 2D array of entries into a Map.
     * Each entry should be a pair of section name and file path.
     *
     * @param entries 2D array where each sub-array contains [sectionName, filePath]
     * @return Map with section names as keys and file paths as values
     */
    public static Map<String, String> mapFromEntries(String[][] entries) {
        Map<String, String> map = new LinkedHashMap<>();
        for (String[] pair : entries) {
            if (pair.length == 2) {
                map.put(pair[0], pair[1]);
            }
        }
        return map;
    }

    public JsonFileReader getSection(String sectionName) {
        return sections.get(sectionName);
    }

    public boolean hasSection(String sectionName) {
        return sections.containsKey(sectionName);
    }

    /**
     * Reloads all registered JSON files.
     *
     * @throws JsonFileLoadException if any file fails to reload
     */
    public void reloadSections(String... sectionNames) throws JsonFileLoadException {
        for (String sectionName : sectionNames) {
            JsonFileReader reader = sections.get(sectionName);
            if (reader == null) {
                throw new JsonFileLoadException("Section not found: " + sectionName, null);
            }
            reader.reload();
        }
    }

    /**
     * Reloads specified sections without interruption.
     * If a section is missing, it will log an error instead of throwing an exception.
     *
     * @param sectionNames Names of the sections to reload
     */
    public void reloadSectionsUninterrupted(String... sectionNames) throws JsonFileLoadException {
        for (String sectionName : sectionNames) {
            JsonFileReader reader = sections.get(sectionName);
            if (reader != null) {
                reader.reload();
            } else {
                System.err.println("Missing section: " + sectionName);
            }
        }
    }

    /**
     * Reloads all registered JSON files.
     *
     * @throws JsonFileLoadException if any file fails to reload
     */
    public void reloadAll() throws JsonFileLoadException {
        for (JsonFileReader reader : sections.values()) {
            reader.reload();
        }
    }

    /**
     * Returns the names of all loaded sections.
     *
     * @return Array of section names
     */
    public String[] getLoadedSectionNames() {
        return sections.keySet().toArray(new String[0]);
    }
}
