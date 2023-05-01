package com.example.tp3_vrai_sam;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Controller
{
    static Circle balle = new Circle(25, Color.CADETBLUE);
    static Circle balle2 = new Circle(25, Color.YELLOW);
    static int scoreJeu = 0;

    static Media ding = new Media(new File("src/ressources/sounds/ding.mp3").toURI().toString());
    static MediaPlayer mediaPlayerDing = new MediaPlayer(ding);

    static Media bounce = new Media(new File("src/ressources/sounds/bounce.mp3").toURI().toString());
    static MediaPlayer mediaPlayerBounce = new MediaPlayer(bounce);

    static MediaPlayer mediaPlayerBounce2 = new MediaPlayer(bounce);

    static Image fire = new Image(new File("src/ressources/image/giphy.gif").toURI().toString());
    static ImageView fireView = new ImageView(fire);

    static Image streaks = new Image(new File("src/ressources/image/well.gif").toURI().toString());
    static ImageView streakView = new ImageView(streaks);
    public static void start(Pane root, Scene scene)
    {
        setupImages();
        balle.relocate(5,5);
        balle2.relocate(100,350);

        Text score = new Text();
        score.setText("Score : " + scoreJeu);
        score.setY(20);
        score.setX(15);

        ObservableList list = root.getChildren();
        list.add(balle);
        list.add(balle2);
        list.add(score);
        list.add(fireView);
        list.add(streakView);

        // Lorsqu'on clique sur la balle
        balle.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                mediaPlayerDing.stop();
                scoreJeu = scoreJeu + 1;
                score.setText("Score : " + scoreJeu);
                mediaPlayerDing.play();

                if(scoreJeu == 5)
                {
                    fireView.setVisible(true);
                }

                if(scoreJeu == 15)
                {
                    streakView.setVisible(true);
                }
            }
        });

        balle2.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                mediaPlayerDing.stop();
                scoreJeu = scoreJeu + 1;
                score.setText("Score : " + scoreJeu);
                mediaPlayerDing.play();

                if(scoreJeu == 5)
                {
                    fireView.setVisible(true);
                }

                if(scoreJeu == 15)
                {
                    streakView.setVisible(true);
                }
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
                    mediaPlayerBounce.stop();
                    mediaPlayerBounce.play();
                }

                // Si la balle atteint le maximum en haut ou en bas de la bordure, la donnée du Y devient négative
                if((balle.getLayoutY() >= (bounds.getMaxY() - balle.getRadius()) || (balle.getLayoutY() <= (bounds.getMinY() + balle.getRadius()))))
                {
                    dy = -dy;
                    mediaPlayerBounce.stop();
                    mediaPlayerBounce.play();
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
                    mediaPlayerBounce2.stop();
                    mediaPlayerBounce2.play();
                }

                // Si la balle atteint le maximum en haut ou en bas de la bordure, la donnée du Y devient négative
                if((balle2.getLayoutY() >= (bounds.getMaxY() - balle2.getRadius()) || (balle2.getLayoutY() <= (bounds.getMinY() + balle2.getRadius()))))
                {
                    dy2 = -dy2;
                    mediaPlayerBounce2.stop();
                    mediaPlayerBounce2.play();
                }
            }
        }));

        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();


    }

    static public void setupImages()
    {
        fireView.setVisible(false);
        streakView.setVisible(false);
        fireView.setX(70);
        fireView.setY(1);

        streakView.setX(100);
        streakView.setY(3);

        // Fait en sorte de diminuer la dimension du gif feu
        fireView.setFitWidth(fire.getWidth() * 0.05);
        fireView.setFitHeight(fire.getHeight() * 0.05);

        // Fait en sorte de diminuer la dimension du gif 100
        streakView.setFitWidth(streaks.getWidth() * 0.1);
        streakView.setFitHeight(streaks.getHeight() * 0.1);
    }
}