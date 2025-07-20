package com.updated.rollTheDice.Components.Button;

import com.raylib.Raylib;
import com.updated.rollTheDice.Components.Shapes.Rectangle2D;
import com.updated.rollTheDice.DataClasses.*;
import lombok.Builder;

public class RectangleButton extends Rectangle2D {
    private String txt;
    private Shape2D shape2D;
    private Font font;
    private Padding2D padding;
    private int textWidth;
    private Position2D txtPosition;

    @Builder
    public RectangleButton(String txt, Font font, Padding2D padding, Shape2D shape2D) {
        super(shape2D);
        this.txt = txt;
        this.shape2D = shape2D;
        this.font = font;
        this.padding = padding;
        adjustShapeSize();
    }

    private void adjustShapeSize() {
        textWidth = Raylib.MeasureText(txt, font.getFontSize());

        if (shape2D.getSize().getWidth() <= textWidth + padding.getX()) {
            shape2D.setSize(
                    new Size2D()
                            .setWidth(textWidth + padding.getX())
                            .setHeight(shape2D.getSize().getHeight())
            );
        }
        if (shape2D.getSize().getHeight() <= font.getFontSize() + padding.getY()) {
            shape2D.setSize(
                    new Size2D()
                            .setWidth(shape2D.getSize().getWidth())
                            .setHeight(font.getFontSize() + padding.getY())
            );
        }
    }

    @Override
    public void draw() {
        super.draw();
        txtPosition
                .setX(shape2D.getPosition().getX() + (shape2D.getSize().getWidth() - textWidth) / 2)
                .setY(shape2D.getPosition().getY() + (shape2D.getSize().getHeight() - font.getFontSize()) / 2);

        Raylib.Vector2 pivot = new Raylib.Vector2();
        pivot.x(shape2D.getSize().getWidth() / 2)
                .y(shape2D.getSize().getHeight() / 2);

        Raylib.Vector2 position = new Raylib.Vector2();
        position.x((int) txtPosition.getX()).y((int) txtPosition.getY());

        Raylib.Vector2 origin = new Raylib.Vector2();
        origin.x(textWidth/2).y(font.getFontSize()/2);

        Raylib.DrawTextPro(Raylib.GetFontDefault(), txt, position, origin, shape2D.getRotation(), font.getFontSpacing(), font.getFontSize(), font.getColor());
    }
}
