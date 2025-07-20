package com.updated.rollTheDice.DataClasses;

import lombok.Data;

@Data
public class Size2D {
    private float width;
    private float height;

    public Size2D setWidth(float width) {
        this.width = width;
        return this;
    }

    public Size2D setHeight(float height) {
        this.height = height;
        return this;
    }
}
