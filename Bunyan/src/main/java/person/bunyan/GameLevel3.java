/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameLevel3 {

    private static final String[] CHAR_CHARACTERS = {"P", "Q", "W", "M", "T"};
    private static final String[] BOX_CHARACTERS = {"A", "P", "", "L", "E"};  // apple
    private static final String[] BOX_CHARACTERS1 = {"", "A", "G", "I", "C"}; // magic
    private static final String[] BOX_CHARACTERS2 = {"S", "M", "A", "R", ""};  // smart

    private int targetIndex = -1; // Initial value

    private Label label1;
    private Stage stage;
    Label xcoins = new Label("0");
    Label xtree = new Label("0");

    Start_Interface startLv3;

    GameLevel3(Stage stage, Start_Interface startLv3) {
        this.stage = stage;
        this.startLv3 = startLv3;
    }

    private int tree;  // لحساب النقاط
    private int coins;   // لحساب الكوينز

    public Scene Game() {
        tree = startLv3.getLevels().getTotalTrees();  // لحساب النقاط
        coins = startLv3.getLevels().getTotalCoins();
        Group root = new Group();

        VBox vbox1 = new VBox(20);
        vbox1.setPadding(new Insets(30, 0, 0, 1200));

        VBox vbox2 = new VBox(30);
        vbox2.setPadding(new Insets(35, 0, 0, 1170));
        xcoins.setStyle("-fx-font-family: 'Valoon'; -fx-font-size: 15;");
        xtree.setStyle("-fx-font-family: 'Valoon'; -fx-font-size: 15;");

        vbox2.getChildren().addAll(xcoins, xtree);

        VBox vbox = new VBox(130);
        vbox.setPadding(new Insets(280, 0, 0, 300));

        Image background = new Image("file:BunyanImages/Shahad/Interface4.jpg");

        Image charImage = new Image("file:BunyanImages/Shahad/char.png");//char image

        Image image2 = new Image("file:BunyanImages/Shahad/dollar.png");//DOLAR

        Image image3 = new Image("file:BunyanImages/Shahad/tree.png");//TREE

//        Image image4 = new Image("file:BunyanImages/Shahad/chronometer.png");//time
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(30);
        imageView2.setFitHeight(30);

        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(30);
        imageView3.setFitHeight(30);

//        ImageView imageView4 = new ImageView(image4);
//        imageView4.setFitWidth(30);
//        imageView4.setFitHeight(30);
//        vbox1.getChildren().addAll(imageView2, imageView3, imageView4);
        vbox1.getChildren().addAll(imageView2, imageView3);

        ImageView backgroundView = new ImageView(background);
        backgroundView.setPreserveRatio(false);
        backgroundView.setSmooth(true);

        label1 = new Label("Right the correct letter to complete the word");
        label1.setLayoutX(400);
        label1.setLayoutY(100);
        label1.setStyle("-fx-font-family: 'Valoon'; -fx-font-size: 20;");

        HBox hbox1 = createHBox(BOX_CHARACTERS);
        hbox1.setPadding(new Insets(0, 0, 0, 180));

        HBox hbox = new HBox(25);

        for (String character : CHAR_CHARACTERS) {
            ImageView imageView = new ImageView(charImage);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            Label label = new Label(character);
            label.setStyle("-fx-font-size: 20; -fx-text-fill: white;");

            StackPane stackPane = new StackPane(imageView, label);
            hbox.getChildren().add(stackPane);
        }

        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox);

        root.getChildren().addAll(backgroundView, label1, vbox, vbox1, vbox2);

        Scene scene = new Scene(root, 1500, 800);

        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.P) {

                setCoins(10);
                setTree(getCoins());
                xcoins.setText(getCoins() + "");
                xtree.setText(getTree() + "");

                handlePKeyPress(hbox1, scene);
            } else {
                label1.setTextFill(Color.RED);
                label1.setText("Incorrect letter");
                setCoins(-5);
                setTree(coins - 5);

                xcoins.setText(getCoins() + "");
                xtree.setText(getTree() + "");

                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(2), e -> {
                            label1.setTextFill(Color.BLACK);
                            label1.setText("Right the correct letter to complete the word");
                        })
                );

                timeline.play();

            }
        });

        backgroundView.fitWidthProperty().bind(scene.widthProperty());
        backgroundView.fitHeightProperty().bind(scene.heightProperty());

//        Screen screen = Screen.getPrimary();
//        Rectangle2D bounds = screen.getVisualBounds();
//
//        stage.setX(bounds.getMinX());
//        stage.setY(bounds.getMinY());
//        stage.setWidth(bounds.getWidth());
//        stage.setHeight(bounds.getHeight());
        stage.setScene(scene);
        return scene;
    }

    private HBox createHBox(String[] characters) {
        HBox hbox = new HBox(5);

        for (String character : characters) {
            Rectangle rectangle = new Rectangle(50, 50);
            rectangle.setFill(Color.SILVER);
            Label label = new Label(character);

            StackPane stackPane = new StackPane(rectangle, label);
            hbox.getChildren().add(stackPane);

            if (character.isEmpty()) {
                targetIndex = hbox.getChildren().indexOf(stackPane);
            }
        }

        return hbox;
    }

    private void handlePKeyPress(HBox hbox1, Scene scene) {
        hbox1.getChildren().clear();
        hbox1.getChildren().addAll(createHBox(BOX_CHARACTERS2).getChildren());

        handlePKeyPress2(hbox1, scene);

    }

    private void handlePKeyPress2(HBox hbox1, Scene scene) {

        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.T) {
                setCoins(10);
                setTree(getCoins());

                xcoins.setText(getCoins() + "");
                xtree.setText(getTree() + "");

                hbox1.getChildren().clear();
                hbox1.getChildren().addAll(createHBox(BOX_CHARACTERS1).getChildren());
                handlePKeyPress3(hbox1, scene);
            } else {
                label1.setTextFill(Color.RED);
                label1.setText("Incorrect letter");

                setCoins(-5);
                setTree(coins - 5);
                xcoins.setText(getCoins() + "");
                xtree.setText(getTree() + "");

                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(2), e -> {
                            label1.setTextFill(Color.BLACK);
                            label1.setText("Right the correct letter to complete the word");
                        })
                );

                timeline.play();
            }
        });
    }

    private void handlePKeyPress3(HBox hbox1, Scene scene) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.M) {

                setCoins(10);
                setTree(getCoins());
                xcoins.setText(getCoins() + "");
                xtree.setText(getTree() + "");

                hbox1.getChildren().clear();
                System.out.print(getCoins());
                stage.setScene(new CompleatLevel3(stage, startLv3, tree, coins).Compleat());
            } else {
                label1.setTextFill(Color.RED);
                label1.setText("Incorrect letter");

                setCoins(-5);
                setTree(coins - 5);
                xcoins.setText(getCoins() + "");
                xtree.setText(getTree() + "");

                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(2), e -> {
                            label1.setTextFill(Color.BLACK);
                            label1.setText("Right the correct letter to complete the word");
                        })
                );
                timeline.play();
            }
        });
    }

    public int getTree() {
        return tree;
    }

    public void setTree(int coins) {

        if (coins < 0) {
            tree = 0;
        } else {
            this.tree = coins / 5;

        }

    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {

        this.coins += coins;
    }

}
