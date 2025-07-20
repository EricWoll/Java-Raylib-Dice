package com.updated.rollTheDice.DataClasses;

import lombok.Data;

@Data
public class Position2D {
    private float x;
    private float y;

    public Position2D setX(float x) {
        this.x = x;
        return this;
    }

    public Position2D setY(float y) {
        this.y = y;
        return this;
    }
}
