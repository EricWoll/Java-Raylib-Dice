package com.updated.rollTheDice.DataClasses;

import com.raylib.Raylib;
import lombok.Builder;
import lombok.Data;

@Data
public class Shape2D {
    private Raylib.Rectangle rectangle = new Raylib.Rectangle();
    private Raylib.Rectangle borderRectangle = new Raylib.Rectangle();
    // Position and size
    private Position2D position;
    private Size2D size;
    private float rotation;
    private float borderWidth;
    private float radius;
    private int segments;

    // Colors
    private Raylib.Color bgColor;
    private Raylib.Color borderColor;

    private Raylib.Color hoverColor;
    private Raylib.Color hoveredBorderColor;

    private Raylib.Color pressedColor;
    private Raylib.Color pressedBorderColor;

    private Raylib.Color disabledColor;
    private Raylib.Color disabledBorderColor;

    // State
    private boolean isVisible;
    private boolean isHovered;
    private boolean isPressed;
    private boolean isDisabled;
    private boolean hasBorder;

    @Builder
    public static Shape2D create(
            Position2D position, Size2D size, float rotation, float borderWidth, float radius,
            int segments, Raylib.Color bgColor, Raylib.Color borderColor, Raylib.Color hoverColor,
            Raylib.Color hoveredBorderColor, Raylib.Color pressedColor, Raylib.Color pressedBorderColor,
            Raylib.Color disabledColor, Raylib.Color disabledBorderColor, boolean isVisible,
            boolean hasBorder, boolean isHovered, boolean isPressed, boolean isDisabled
    ) {
        Shape2D shape = new Shape2D();
        shape.position = position;
        shape.size = size;
        shape.rotation = rotation;
        shape.borderWidth = borderWidth;
        shape.radius = radius;
        shape.segments = segments;
        shape.bgColor = bgColor;
        shape.borderColor = borderColor;
        shape.hoverColor = hoverColor;
        shape.hoveredBorderColor = hoveredBorderColor;
        shape.pressedColor = pressedColor;
        shape.pressedBorderColor = pressedBorderColor;
        shape.disabledColor = disabledColor;
        shape.disabledBorderColor = disabledBorderColor;
        shape.isVisible = isVisible;
        shape.isHovered = isHovered;
        shape.isPressed = isPressed;
        shape.isDisabled = isDisabled;
        shape.hasBorder = hasBorder;
        shape.getRectangle().x(position.getX())
                    .y(position.getY())
                    .width(size.getWidth())
                    .height(size.getHeight());
        if (hasBorder) {
            shape.getBorderRectangle().x(position.getX() - borderWidth)
                    .y(position.getY() - borderWidth)
                    .width(size.getWidth() + 2 * borderWidth)
                    .height(size.getHeight() + 2 * borderWidth);
        } else {
            shape.getBorderRectangle().x(0).y(0).width(0).height(0);
        }
        return shape;
    }
}
