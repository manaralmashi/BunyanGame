/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author manaralmashi
 */
public class Loading_Interface {

    public Scene start(Stage primaryStage) {
     
        //-----------------------------------------------------------( Colors )---------------------------------------------------------
        //myColors
        Color myColorDarkBrown = Color.rgb(89, 23, 62);
        Color myColorLightGreen = Color.rgb(217, 209, 121);
        //-------------------------------------------------( Images )-------------------------------------------------
        // image game logo 
        Image imageGameLogo = new Image("file:BunyanImages/Manar/gameLogo.png");
        ImageView imageViewGameLogo = new ImageView(imageGameLogo);
        imageViewGameLogo.setFitHeight(330);
        imageViewGameLogo.setFitWidth(458);

        // image Engineer Man
        Image imageEngineerMan = new Image("file:BunyanImages/Manar/engineerMan.png");
        ImageView imageViewEngineerMan = new ImageView(imageEngineerMan);
        imageViewEngineerMan.setFitHeight(150);
        imageViewEngineerMan.setFitWidth(61);
        imageViewEngineerMan.setTranslateX(-30);
        imageViewEngineerMan.setTranslateY(100);

        // image Engineer Car
        Image imageEngineerCar = new Image("file:BunyanImages/Manar/engineerCar.png");
        ImageView imageViewEngineerCar = new ImageView(imageEngineerCar);
        imageViewEngineerCar.setFitHeight(65);
        imageViewEngineerCar.setFitWidth(90);
        imageViewEngineerCar.setTranslateX(-30);
        imageViewEngineerCar.setTranslateY(100);
        
        //image wood bar
        Image imageWoodBar = new Image("file:BunyanImages/Manar/woodBar.png");
        ImageView imageViewWoodBar = new ImageView(imageWoodBar);
        imageViewWoodBar.setFitHeight(80);
        imageViewWoodBar.setFitWidth(700);
        imageViewWoodBar.setTranslateX(-25);
        //-------------------------------------------------------( Layouts )------------------------------------------------------
        //Create VBox that contain (game logo & wood bar)
        VBox vBoxOnStack = new VBox(60);
        vBoxOnStack.getChildren().addAll(imageViewGameLogo, imageViewWoodBar);
        vBoxOnStack.getChildren().get(0).setTranslateX(100);

        // Create a progress bar
        ProgressBar progressBar = new ProgressBar();
        progressBar.setPrefHeight(35);
        progressBar.setPrefWidth(655);
        progressBar.setTranslateY(100);
        // Apply custom style using CSS
        progressBar.setStyle(
                "-fx-background-color: #" + myColorDarkBrown.toString().substring(2, 8) + "; "
                + "-fx-accent: #" + myColorLightGreen.toString().substring(2, 8) + "; "
                + "-fx-control-inner-background: #ffffff; "
        //            "-fx-border-color: #"+myColorDarkBrown.toString().substring(2, 8)+"; " +
        //            "-fx-border-width: 2; " +
        //            "-fx-border-radius: 5; " +
        //            "-fx-padding: 5; " +
        //            "-fx-font-size: 14px;"
        );

        // Create a StackPane to center the progress bar
        StackPane stackPaneOnCenter = new StackPane();
        stackPaneOnCenter.getChildren().addAll(vBoxOnStack, progressBar,imageViewEngineerMan);
        //stackPaneOnCenter.getChildren().addAll(vBoxOnStack, progressBar, imageViewEngineerCar);
        stackPaneOnCenter.setPadding(new Insets(0, 0, 0, 26));
        stackPaneOnCenter.setAlignment(Pos.CENTER_LEFT);
//        stackPaneOnCenter.setStyle("-fx-background-color: rgba(173, 216, 230, 0.5);");


        //-------------------------------------------------------( the MAIN ROOT )------------------------------------------------------
        Image SceneBackground = new Image("file:BunyanImages/Manar/LoadingInterfaceBackground.jpg");
        BackgroundSize size = new BackgroundSize(2000, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));

        //Creating BorderPane that contains the ALL the layouts
        BorderPane borderRoot = new BorderPane();
        borderRoot.setPadding(new Insets(150, 400, 0, 400));
        borderRoot.setBackground(background);

        borderRoot.setCenter(stackPaneOnCenter);

        //-------------------------------------------------------( Scene & Stage )------------------------------------------------------
        //Creating a scene object 
        Scene scene = new Scene(borderRoot, 1500, 800);
        //setting color to the scene
        scene.setFill(Color.LIGHTSTEELBLUE);
//        //Setting title to the Stage 
//        primaryStage.setTitle("interface (1)_Loading");

        //---------------------------------------------------------( Animation )--------------------------------------------------------
        // Simulate loading that takes 5 seconds to complete
        simulateLoading(progressBar, primaryStage);
        
        
        translationImageView(imageViewEngineerMan, progressBar);
//        translationImageView(imageViewEngineerCar, progressBar);
        return scene;
    }

    //This method is used to (simulate loading & change the scene) over time. 
    private void simulateLoading(ProgressBar progressBar, Stage primaryStage) {
        //GO to lamis interface (Log-in)
        //NEXT_fromLamis lamisLogIn = new NEXT_fromLamis();
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                final int progress = i;
                javafx.application.Platform.runLater(() -> progressBar.setProgress(progress / 100.0));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (progress == 100) {
                    //GO to lamis interface (Log-in)
                    javafx.application.Platform.runLater(() -> primaryStage.setScene(new logIn(primaryStage).Interface()));
                }
            }
        }).start();
    }
    
    //This method continuously translates an ImageView along the X-axis using a Timeline.
    //Also we can use it for update progressBar.
    private void translationImageView(ImageView imageView, ProgressBar progressBar) {
        // Create a Timeline
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(4), e -> {
                    //translation imageView
                    imageView.setTranslateX(imageView.getTranslateX() + 0.48); //for Man
//                    imageView.setTranslateX(imageView.getTranslateX() + 0.45); //for Car
//                //update progressBar
//                progressBar.setProgress(progressBar.getProgress() + 0.25);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

}
