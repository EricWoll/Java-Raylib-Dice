package com.updated.rollTheDice.JsonReader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.updated.rollTheDice.Exceptions.JsonFileLoadException;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * Reads and parses JSON configuration files with type-safe access.
 */
public class JsonFileReader {
    private final String filePath;
    private JsonNode jsonContent;

    public JsonFileReader(String filePath) throws JsonFileLoadException {
        this.filePath = filePath;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.jsonContent = objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            throw new JsonFileLoadException("Failed to load JSON from: " + filePath, e);
        }
    }

    public String getFilePath() {
        return filePath;
    }
    public JsonNode getRawJsonContent() {
        return jsonContent;
    }

    public Optional<String> getString(String key) {
        return jsonContent.has(key) ? Optional.of(jsonContent.get(key).asText()) : Optional.empty();
    }

    public Optional<Integer> getInt(String key) {
        return jsonContent.has(key) ? Optional.of(jsonContent.get(key).asInt()) : Optional.empty();
    }

    public Optional<Boolean> getBoolean(String key) {
        return jsonContent.has(key) ? Optional.of(jsonContent.get(key).asBoolean()) : Optional.empty();
    }

    public Optional<Double> getDouble(String key) {
        return jsonContent.has(key) ? Optional.of(jsonContent.get(key).asDouble()) : Optional.empty();
    }

    public void reload() throws JsonFileLoadException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.jsonContent = objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            throw new JsonFileLoadException("Failed to reload JSON from: " + filePath, e);
        }
    }
}
