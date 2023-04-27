package com.example.tp3_vrai_sam;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Application extends javafx.application.Application
{
    static int scoreJeu = 0;
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        Circle balle = new Circle(10, Color.CADETBLUE);
        balle.relocate(5,5);

        Circle balle2 = new Circle(10, Color.YELLOW);
        balle2.relocate(100,350);

        Text score = new Text();
        score.setText("Score : " + scoreJeu);
        score.setY(10);
        score.setX(10);

        // Creer un pane racine
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);

        ObservableList list = root.getChildren();
        list.add(balle);
        list.add(balle2);
        list.add(score);

        Controller.timeline(root,balle);
        Controller.timeline2(root,balle2);

        primaryStage.setTitle("Clickball");
        primaryStage.setScene(scene);
        primaryStage.show();

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
    public static void main(String[] args) {
        launch();
    }
}