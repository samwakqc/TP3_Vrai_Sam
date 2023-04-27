package com.example.tp3_vrai_sam;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Controller {
    @FXML
    private Label welcomeText;

    public static void timeline(Pane root, Circle balle)
    {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>()
        {
            double dx = 3;
            double dy = 7;
            @Override
            public void handle(ActionEvent actionEvent)
            {
                balle.setLayoutX(balle.getLayoutX() + dx);
                balle.setLayoutY(balle.getLayoutY() + dy);

                Bounds bounds = root.getLayoutBounds();

                // Si la balle atteint le maximum a gauche ou a droite, elle fait en sorte que la donnée du x devient négative
                if((balle.getLayoutX() <= (bounds.getMinX() + balle.getRadius()) || (balle.getLayoutX() >= (bounds.getMaxX() - balle.getRadius()))))
                {
                    dx = -dx;
                }

                // Si la balle atteint le maximum en haut ou en bas de la bordure, la donnée du Y devient négative
                if((balle.getLayoutY() >= (bounds.getMaxY() - balle.getRadius()) || (balle.getLayoutY() <= (bounds.getMinY() + balle.getRadius()))))
                {
                    dy = -dy;
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void timeline2(Pane root, Circle balle)
    {
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>()
        {
            double dx2 = 3;
            double dy2 = 3;

            @Override
            public void handle(ActionEvent actionEvent)
            {
                balle.setLayoutX(balle.getLayoutX() + dx2);
                balle.setLayoutY(balle.getLayoutY() + dy2);

                Bounds bounds = root.getLayoutBounds();

                // Si la balle atteint le maximum a gauche ou a droite, elle fait en sorte que la donnée du x devient négative
                if((balle.getLayoutX() <= (bounds.getMinX() + balle.getRadius()) || (balle.getLayoutX() >= (bounds.getMaxX() - balle.getRadius()))))
                {
                    dx2 = -dx2;
                }

                // Si la balle atteint le maximum en haut ou en bas de la bordure, la donnée du Y devient négative
                if((balle.getLayoutY() >= (bounds.getMaxY() - balle.getRadius()) || (balle.getLayoutY() <= (bounds.getMinY() + balle.getRadius()))))
                {
                    dy2 = -dy2;
                }
            }
        }));

        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}