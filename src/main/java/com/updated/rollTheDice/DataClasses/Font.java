package com.updated.rollTheDice.DataClasses;

import com.raylib.Raylib;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Font {
    private Raylib.Font font;
    private int fontSize;
    private float fontSpacing = 1;
    private Raylib.Color color;
    private Raylib.Color hoverColor;
    private Raylib.Color disabledColor;
}
