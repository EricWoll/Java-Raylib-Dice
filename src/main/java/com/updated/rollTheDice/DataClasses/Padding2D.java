package com.updated.rollTheDice.DataClasses;

import lombok.Data;

@Data
public class Padding2D {
    private float x;
    private float y;

    public Padding2D setX(float x) {
        this.x = x;
        return this;
    }

    public Padding2D setY(float y) {
        this.y = y;
        return this;
    }
}
