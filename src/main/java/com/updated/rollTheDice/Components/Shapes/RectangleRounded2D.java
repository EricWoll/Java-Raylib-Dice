package com.updated.rollTheDice.Components.Shapes;

import com.raylib.Raylib;
import com.updated.rollTheDice.DataClasses.Shape2D;
import com.updated.rollTheDice.Interfaces.IShape2D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RectangleRounded2D extends BaseShape implements IShape2D {
    private Shape2D shape2D;

    private final Logger logger = LogManager.getLogger(RectangleRounded2D.class);

    public RectangleRounded2D(Shape2D shape2D) {
        super(shape2D);
        this.shape2D = shape2D;
    }

    @Override
    public void draw() {
        if (!shape2D.isVisible()) return;

        Raylib.Vector2 pivot = new Raylib.Vector2();
        pivot.x(shape2D.getPosition().getX() + (shape2D.getSize().getWidth() / 2))
                .y(shape2D.getPosition().getY() + (shape2D.getSize().getHeight() / 2));

        DrawRectangleRoundedPro(
                pivot,
                shape2D.getRotation(),
                shape2D.getRadius(),
                shape2D.getSegments(),
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

            DrawRectangleRoundedPro(
                    pivot,
                    shape2D.getRotation(),
                    shape2D.getRadius(),
                    shape2D.getSegments(),
                    shape2D.isDisabled() ? shape2D.getDisabledBorderColor() : (
                            shape2D.isPressed() ? shape2D.getPressedBorderColor() : (
                                    shape2D.isHovered() ? shape2D.getHoveredBorderColor() : shape2D.getBorderColor()
                            )
                    )
            );
        }

    }

    private void DrawRectangleRoundedPro(Raylib.Vector2 pivot, float rotation, float radius, int segments, Raylib.Color color) {
        int actualSegments = (segments <= 0) ? 1 : segments;

        Raylib.rlPushMatrix();
        Raylib.rlTranslatef(pivot.x(),  pivot.y(), 0);
        Raylib.rlRotatef(rotation, 0, 0, 1);
        Raylib.rlTranslatef(-pivot.x(), -pivot.y(), 0);

        Raylib.DrawRectangleRounded(shape2D.getRectangle(), radius, actualSegments, color);

        if (this.shape2D.isHasBorder()) {
            Raylib.DrawRectangleRoundedLines(
                    shape2D.getBorderRectangle(), radius, actualSegments,
                    this.shape2D.isDisabled() ? this.shape2D.getDisabledBorderColor() : (
                            this.shape2D.isPressed() ? this.shape2D.getPressedBorderColor() : (
                                    this.shape2D.isHovered() ? this.shape2D.getHoveredBorderColor() : this.shape2D.getBorderColor()
                            )
                    )
            );
        }

        Raylib.rlPopMatrix();
    }
}
