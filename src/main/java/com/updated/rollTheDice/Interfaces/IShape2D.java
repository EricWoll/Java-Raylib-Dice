package com.updated.rollTheDice.Interfaces;

import com.raylib.Raylib;

public interface IShape2D {
    void draw();
    float getWidth();
    float getHeight();
    float getX();
    float getY();

    void setPosition(float x, float y);
    void setSize(float width, float height);
    void setRotation(float rotation);
    float getRotation();

    void setVisible(boolean visible);
    boolean isVisible();
    void setHovered(boolean hovered);
    boolean isHovered();
    void setPressed(boolean pressed);
    boolean isPressed();
    void setDisabled(boolean disabled);
    boolean isDisabled();

    void setBorder(boolean hasBorder);
    boolean hasBorder();

    void setBackgroundColor(Raylib.Color color);
    Raylib.Color getBackgroundColor();

    void setHoverColor(Raylib.Color color);
    Raylib.Color getHoverColor();

    void setPressedColor(Raylib.Color color);
    Raylib.Color getPressedColor();

    void setDisabledColor(Raylib.Color color);
    Raylib.Color getDisabledColor();
}
