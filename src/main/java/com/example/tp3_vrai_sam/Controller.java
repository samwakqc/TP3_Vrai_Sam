package com.example.tp3_vrai_sam;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller
{
    static Circle balle = new Circle(10, Color.CADETBLUE);
    static Circle balle2 = new Circle(10, Color.YELLOW);
    static int scoreJeu = 0;
    public static void start(Pane root, Scene scene)
    {
        balle.relocate(5,5);
        balle2.relocate(100,350);

        Text score = new Text();
        score.setText("Score : " + scoreJeu);
        score.setY(10);
        score.setX(10);

        ObservableList list = root.getChildren();
        list.add(balle);
        list.add(balle2);
        list.add(score);
        // Lorsqu'on clique sur la balle
        balle.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                scoreJeu = scoreJeu + 1;
                score.setText("Score : " + scoreJeu);

            }
        });
    }
    public static void timeline(Pane root)
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

    public static void timeline2(Pane root)
    {
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>()
        {
            double dx2 = 3;
            double dy2 = 3;

            @Override
            public void handle(ActionEvent actionEvent)
            {
                balle2.setLayoutX(balle2.getLayoutX() + dx2);
                balle2.setLayoutY(balle2.getLayoutY() + dy2);

                Bounds bounds = root.getLayoutBounds();

                // Si la balle atteint le maximum a gauche ou a droite, elle fait en sorte que la donnée du x devient négative
                if((balle2.getLayoutX() <= (bounds.getMinX() + balle2.getRadius()) || (balle2.getLayoutX() >= (bounds.getMaxX() - balle2.getRadius()))))
                {
                    dx2 = -dx2;
                }

                // Si la balle atteint le maximum en haut ou en bas de la bordure, la donnée du Y devient négative
                if((balle2.getLayoutY() >= (bounds.getMaxY() - balle2.getRadius()) || (balle2.getLayoutY() <= (bounds.getMinY() + balle2.getRadius()))))
                {
                    dy2 = -dy2;
                }
            }
        }));

        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();
    }
}