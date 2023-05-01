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
        // Creer un pane racine
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);

        Controller.start(root, scene);

        primaryStage.setTitle("Clickball");
        primaryStage.setScene(scene);
        primaryStage.show();

        Controller.timeline(root);
        Controller.timeline2(root);
    }
    public static void main(String[] args) {
        launch();
    }
}