package com.updated.rollTheDice.Components.Shapes;

import com.raylib.Raylib;
import com.updated.rollTheDice.DataClasses.Shape2D;
import com.updated.rollTheDice.Interfaces.IShape2D;
import lombok.*;

@Getter
@Setter
public class Rectangle2D extends BaseShape implements IShape2D {
    private Shape2D shape2D;

    public Rectangle2D(Shape2D shape2D) {
        super(shape2D);
        this.shape2D = shape2D;
    }

    @Override
    public void draw() {
        if (!shape2D.isVisible()) return;

        shape2D.getRectangle().x(shape2D.getPosition().getX())
                .y(shape2D.getPosition().getY())
                .width(shape2D.getSize().getWidth())
                .height(shape2D.getSize().getHeight());

        Raylib.Vector2 pivot = new Raylib.Vector2();
        pivot.x(shape2D.getSize().getWidth() / 2)
                .y(shape2D.getSize().getHeight() / 2);

        Raylib.DrawRectanglePro(
                shape2D.getRectangle(),
                pivot,
                shape2D.getRotation(),
                shape2D.isDisabled() ? shape2D.getDisabledColor() : (
                        shape2D.isPressed() ? shape2D.getPressedColor() : (
                                shape2D.isHovered() ? shape2D.getHoverColor() : shape2D.getBgColor()
                        )
                )
        );

        if (shape2D.isHasBorder()) {
            shape2D.getBorderRectangle().x(shape2D.getPosition().getX() - shape2D.getBorderWidth())
                    .y(shape2D.getPosition().getY() - shape2D.getBorderWidth())
                    .width(shape2D.getSize().getWidth() + shape2D.getBorderWidth())
                    .height(shape2D.getSize().getHeight() + shape2D.getBorderWidth());

            Raylib.DrawRectanglePro(
                    shape2D.getBorderRectangle(),
                    pivot,
                    shape2D.getRotation(),
                    shape2D.isDisabled() ? shape2D.getDisabledBorderColor() : (
                            shape2D.isPressed() ? shape2D.getPressedBorderColor() : (
                                    shape2D.isHovered() ? shape2D.getHoveredBorderColor() : shape2D.getBorderColor()
                            )
                    )
            );
        }

    }
}
