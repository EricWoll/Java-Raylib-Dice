package com.updated.rollTheDice.Components.Shapes;

import com.raylib.Raylib;
import com.updated.rollTheDice.DataClasses.Position2D;
import com.updated.rollTheDice.DataClasses.Shape2D;
import com.updated.rollTheDice.DataClasses.Size2D;
import com.updated.rollTheDice.Interfaces.IShape2D;

public class BaseShape implements IShape2D {
    private final Shape2D shape2D;

    public BaseShape(Shape2D shape2D) {
        this.shape2D = shape2D;
    }

    @Override
    public void draw() {}

    @Override
    public float getWidth() {
        return shape2D.getSize().getWidth();
    }

    @Override
    public float getHeight() {
        return shape2D.getSize().getHeight();
    }

    @Override
    public float getX() {
        return shape2D.getPosition().getX();
    }

    @Override
    public float getY() {
        return shape2D.getPosition().getY();
    }

    @Override
    public void setPosition(float x, float y) {
        shape2D.setPosition(new Position2D().setX(x).setY(y));
    }

    @Override
    public void setSize(float width, float height) {
        shape2D.setSize(new Size2D().setWidth(width).setHeight(height));
    }

    @Override
    public void setRotation(float rotation) {
        shape2D.setRotation(rotation);
    }

    @Override
    public float getRotation() {
        return shape2D.getRotation();
    }

    @Override
    public void setVisible(boolean isVisible) {
        shape2D.setVisible(isVisible);
    }

    @Override
    public boolean isVisible() {
        return shape2D.isVisible();
    }

    @Override
    public void setHovered(boolean isHovered) {
        shape2D.setHovered(isHovered);
    }

    @Override
    public boolean isHovered() {
        return shape2D.isHovered();
    }

    @Override
    public void setPressed(boolean isPressed) {
        shape2D.setPressed(isPressed);
    }

    @Override
    public boolean isPressed() {
        return shape2D.isPressed();
    }

    @Override
    public void setDisabled(boolean isDisabled) {
        shape2D.setDisabled(isDisabled);
    }

    @Override
    public boolean isDisabled() {
        return shape2D.isDisabled();
    }

    @Override
    public void setBorder(boolean hasBorder) {
        shape2D.setHasBorder(hasBorder);
    }

    @Override
    public boolean hasBorder() {
        return shape2D.isHasBorder();
    }

    @Override
    public void setBackgroundColor(Raylib.Color color) {
        shape2D.setBgColor(color);
    }

    @Override
    public Raylib.Color getBackgroundColor() {
        return shape2D.getBgColor();
    }

    @Override
    public void setHoverColor(Raylib.Color color) {
        shape2D.setHoverColor(color);
    }

    @Override
    public Raylib.Color getHoverColor() {
        return shape2D.getHoverColor();
    }

    @Override
    public void setPressedColor(Raylib.Color color) {
        shape2D.setPressedColor(color);
    }

    @Override
    public Raylib.Color getPressedColor() {
        return shape2D.getPressedColor();
    }

    @Override
    public void setDisabledColor(Raylib.Color color) {
        shape2D.setDisabledColor(color);
    }

    @Override
    public Raylib.Color getDisabledColor() {
        return shape2D.getDisabledColor();
    }
}
