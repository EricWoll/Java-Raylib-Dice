package com.updated.rollTheDice;

import com.raylib.Raylib;
import com.updated.rollTheDice.Components.Shapes.Rectangle2D;
import com.updated.rollTheDice.Components.Shapes.RectangleRounded2D;
import com.updated.rollTheDice.DataClasses.Position2D;
import com.updated.rollTheDice.DataClasses.Shape2D;
import com.updated.rollTheDice.DataClasses.Size2D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.raylib.Colors.*;

public class Game {
    private final static Logger logger = LogManager.getLogger(Game.class);
    private final Size2D windowSize = new Size2D().setWidth(1600).setHeight(800);

    public Game() {
        Raylib.SetConfigFlags(Raylib.FLAG_WINDOW_RESIZABLE);
        Raylib.InitWindow(1600, 900, "Impossible Pong");
        Raylib.SetTargetFPS(60);
        logger.info("Game initialized with window size 800x450 and target FPS set to 60.");
    }

    public void run() {
        logger.info("Running Game!");

        Rectangle2D rectangle2D =
                new Rectangle2D(
                        new Shape2D().builder()
                                .position(new Position2D().setX(100).setY(100))
                                .size(new Size2D().setWidth(100).setHeight(100))
                                .rotation(0)
                                .bgColor(BLACK)
                                .isVisible(true)
                                .build()
                );

        Rectangle2D rectangleSmall2D =
                new Rectangle2D(
                        new Shape2D().builder()
                                .position(new Position2D().setX(300).setY(300))
                                .size(new Size2D().setWidth(20).setHeight(20))
                                .rotation(0)
                                .bgColor(RED)
                                .isVisible(true)
                                .build()
                );

        RectangleRounded2D rectangleRounded2D =
                new RectangleRounded2D(
                        new Shape2D().builder()
                                .position(new Position2D().setX(300).setY(300))
                                .size(new Size2D().setWidth(100).setHeight(100))
                                .rotation(0)
                                .bgColor(BLACK)
                                .isVisible(true)
                                .radius(0.2f)
                                .segments(8)
                                .rotation(45.0f)
                                .build()
                );

        while (!Raylib.WindowShouldClose()) {
            onResize();
            Raylib.BeginDrawing();
            Raylib.ClearBackground(RAYWHITE);
            Raylib.DrawText("Impossible Pong!", 190, 200, 20, VIOLET);
            rectangle2D.draw();
            rectangleRounded2D.draw();
            rectangleSmall2D.draw();
            Raylib.DrawFPS(20, 20);
            Raylib.EndDrawing();
        }

        close();
    }

    public void close() {
        Raylib.CloseWindow();
    }

    private void onResize() {
        if (Raylib.IsWindowResized()) {
            windowSize.setWidth(Raylib.GetScreenWidth());
            windowSize.setHeight(Raylib.GetScreenHeight());
        }
    }
}
