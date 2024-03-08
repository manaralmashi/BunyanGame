/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author manaralmashi-
 */
public class Levels_Interface {

    private Image SceneBackground;
    private Label floorNameLabel = new Label();
    private ImageView imageViewChar;
    private Image[] charImages = null;
    private int currentLevelIndex = 0;

    private Boolean isNotComplete = false;
    private int totalCoins = 0;
    private int totalTrees = 0;
    private int totalTime;
    // private Levels_Interface levels;
    private Start_Interface StartLV;
    private StartLevel1 level1; //murooj
    private Level2 level2; //rahaf
    private StartLevel3 level3; //shahad

    public Levels_Interface() {
    }

    public Scene start(Stage primaryStage) {
        StartLV = StartLV.getLogInObj().getStartObj();
        if (StartLV != null) {
            StartLV.setLevels(StartLV.getLevels());
        } else {
            System.out.println("StartLV is null. Cannot set Start_Interface in Profile_Interface.");
        }

        //---------------------------------------------------( Objects from classes )--------------------------------------------------- 
        //GO to start interface:
//        Start_Interface start = new Start_Interface();
        level1 = new StartLevel1(primaryStage, StartLV);

        level2 = new Level2(primaryStage, StartLV);

        level3 = new StartLevel3(primaryStage, StartLV);

        //-----------------------------------------------------------( Colors )---------------------------------------------------------
        //myColors
        Color myColorLightYellow = Color.rgb(247, 215, 92);
        Color myColorWhiteSuger = Color.rgb(254, 251, 236);
        //------------------------------------------------------------( Fonts )---------------------------------------------------------

        Font fontStarborn = Font.font("starborn", FontWeight.BOLD, 14);
        Font fontValoon = Font.font("valoon", 35);
        Font fontValoonLarge = Font.font("valoon", FontWeight.BOLD, 55);
        Font fontComicSansMS = Font.font("Comic Sans MS", 15);

        //------------------------------------------------------about character images--------------------------------------------------
        imageViewChar = new ImageView();
        imageViewChar.setFitHeight(337);
        imageViewChar.setFitWidth(120);

        // image Characters
        charImages = new Image[]{
            new Image("file:BunyanImages/Manar/ch20.png"),
            new Image("file:BunyanImages/Manar/ch18.png"),
            new Image("file:BunyanImages/Manar/ch10.png")
        };

        // Call updateCurrentLevelIndex Method:
        // that initialise (currentLevelIndex, SceneBackground, imageViewChar, floorNameLabel) depends on levels completed.
        if (isNotComplete == false) {
            updateCurrentLevelIndex(0);
            isNotComplete = true;
        }

        //-----------------------------------------------------------( Images )---------------------------------------------------------
        // image Game Logo
        Image imageGameLogo = new Image("file:BunyanImages/Manar/gameLogo.png");
        ImageView imageViewGameLogo = new ImageView(imageGameLogo);
        imageViewGameLogo.setFitHeight(300);
        imageViewGameLogo.setFitWidth(378);

        //image Lock
        Image imageLock = new Image("file:BunyanImages/Manar/lock.png");
        ImageView imageViewLock = new ImageView(imageLock);
        imageViewLock.setFitHeight(90);
        imageViewLock.setFitWidth(90);

        //immage Done
        Image imageDone = new Image("file:BunyanImages/Manar/save.png");
        ImageView imageViewDone = new ImageView(imageDone);
        imageViewDone.setFitHeight(90);
        imageViewDone.setFitWidth(90);

        // image Wood
        Image imageWoodBackground = new Image("file:BunyanImages/Manar/woodBackground.png");
        ImageView imageViewWoodBackground = new ImageView(imageWoodBackground);
        imageViewWoodBackground.setFitHeight(350);
        imageViewWoodBackground.setFitWidth(494);

        // image Buttons
        Image imageWoodButton = new Image("file:BunyanImages/Manar/button.png");
        ImageView imageViewWoodButton = new ImageView(imageWoodButton);
        imageViewWoodButton.setFitHeight(87);
        imageViewWoodButton.setFitWidth(117);

        Image imagePrevWoodBt = new Image("file:BunyanImages/Manar/prevWoodBt.png");
        ImageView imageViewPrevWoodButton = new ImageView(imagePrevWoodBt);
        imageViewPrevWoodButton.setFitHeight(83);
        imageViewPrevWoodButton.setFitWidth(140);

        Image imageCoinsBt = new Image("file:BunyanImages/Manar/B_dollar.png");
        ImageView imageViewCoinsBt = new ImageView(imageCoinsBt);
        imageViewCoinsBt.setFitHeight(90);
        imageViewCoinsBt.setFitWidth(107);

        Image imageTreesBt = new Image("file:BunyanImages/Manar/B_tree.png");
        ImageView imageViewTreesBt = new ImageView(imageTreesBt);
        imageViewTreesBt.setFitHeight(90);
        imageViewTreesBt.setFitWidth(107);

        Image imageFloor1 = new Image("file:BunyanImages/Manar/floor1.png");
        ImageView imageViewFloor1 = new ImageView(imageFloor1);
        imageViewFloor1.setFitHeight(205);
        imageViewFloor1.setFitWidth(520);
        imageViewFloor1.setTranslateX(-35);
        imageViewFloor1.setOpacity(0);

        Image imageFloor2 = new Image("file:BunyanImages/Manar/floor2.png");
        ImageView imageViewFloor2 = new ImageView(imageFloor2);
        imageViewFloor2.setFitHeight(185);
        imageViewFloor2.setFitWidth(540);
        imageViewFloor2.setTranslateX(-35);
        imageViewFloor2.setOpacity(0);

        Image imageFloor3 = new Image("file:BunyanImages/Manar/floor3.png");
        ImageView imageViewFloor3 = new ImageView(imageFloor3);
        imageViewFloor3.setFitHeight(295);
        imageViewFloor3.setFitWidth(610);
        imageViewFloor3.setTranslateX(-35);
        imageViewFloor3.setOpacity(0);

        //----------------------------------------------------------( Layouts )---------------------------------------------------------
        //-----------------------( LEFT )----------------------
        //Creating VBox that contains (PrevWoodButton image) in the left of borderPane.
        VBox vBoxOnLeft = new VBox();
        vBoxOnLeft.getChildren().add(imageViewPrevWoodButton);
        vBoxOnLeft.setPadding(new Insets(50, 0, 0, 0));
//        vBoxOnLeft.setStyle("-fx-background-color: rgba(200, 200, 200, 0.5);");

        //----------------------( CENTER )----------------------
        //Create 3 rectangles:
        Rectangle rectangleFloor1 = new Rectangle();
        rectangleFloor1.setHeight(205);
        rectangleFloor1.setWidth(520);
        rectangleFloor1.setFill(Color.BEIGE);
        rectangleFloor1.setOpacity(0);

        Rectangle rectangleFloor2 = new Rectangle();
        rectangleFloor2.setHeight(185);
        rectangleFloor2.setWidth(540);
        rectangleFloor2.setFill(Color.PINK);
        rectangleFloor2.setOpacity(0);

        Rectangle rectangleFloor3 = new Rectangle();
        rectangleFloor3.setHeight(295);
        rectangleFloor3.setWidth(610);
        rectangleFloor3.setFill(Color.BLUE);
        rectangleFloor3.setOpacity(0);

        //Creating VBox that contain the (3 rectangles)
        VBox vBoxOnCenter_rectangles = new VBox();
        vBoxOnCenter_rectangles.getChildren().addAll(rectangleFloor3, rectangleFloor2, rectangleFloor1);
        vBoxOnCenter_rectangles.setPadding(new Insets(0, 0, 0, 50));
        vBoxOnCenter_rectangles.setAlignment(Pos.CENTER);

        //Creating VBox that contain the (3 images of Floors) in the center of borderPane.
        VBox vBoxOnCenter_floors = new VBox();
        vBoxOnCenter_floors.getChildren().addAll(imageViewFloor3, imageViewFloor2, imageViewFloor1);
//        vBoxOnCenter_floors.setPadding(new Insets(0, 0, 0, 50));
        vBoxOnCenter_floors.setAlignment(Pos.CENTER);
//        vBoxOnCenter_floors.setTranslateX();//---------------------------------------------------------------------------///////////////////
//        vBoxOnCenter_floors.setStyle("-fx-background-color: rgba(100, 50, 75, 0.5);");

        //Creating StackPane that contain the (2 VBoxes for floors images & rectangles) in the center of borderPane.
        StackPane stackPaneOnCenter = new StackPane();
        stackPaneOnCenter.setPadding(new Insets(0, 0, 0, 55));
        stackPaneOnCenter.setAlignment(Pos.CENTER);
        stackPaneOnCenter.getChildren().addAll(vBoxOnCenter_floors, vBoxOnCenter_rectangles);
//        stackPaneOnCenter.setTranslateX(4);
        //-----------------------( RIGHT )----------------------
        //*****(HBox for collection)*****
        Label coinsNumberLabel = new Label("+" + Integer.toString(totalCoins));
        coinsNumberLabel.setFont(fontValoon);
        coinsNumberLabel.setStyle("-fx-text-fill: #" + myColorLightYellow.toString().substring(2, 8) + ";");
        coinsNumberLabel.setPadding(new Insets(30, 10, 30, 85));

        Label treesNumberLabel = new Label("+" + Integer.toString(totalTrees));
        treesNumberLabel.setFont(fontValoon);
        treesNumberLabel.setStyle("-fx-text-fill: #" + myColorLightYellow.toString().substring(2, 8) + ";");
        treesNumberLabel.setPadding(new Insets(30, 10, 30, 85));

        HBox hBoxForCollection = new HBox();
        hBoxForCollection.getChildren().addAll(treesNumberLabel, imageViewTreesBt, coinsNumberLabel, imageViewCoinsBt);
//        hBoxForCollection.setStyle("-fx-background-color: rgba(200, 55, 250, 0.5);");

        //*******(VBox for Labels)*******
//        floorNameLabel = new Label(); //"FIRST FLOOR"
        floorNameLabel.setFont(fontValoonLarge);
        floorNameLabel.setStyle("-fx-text-fill: #" + myColorWhiteSuger.toString().substring(2, 8) + ";");
        floorNameLabel.setTextAlignment(TextAlignment.CENTER);

        Label floorDescLabel = new Label("Collect the largest amount of\ncoins and trees to build the\n" + floorNameLabel.getText() + " of the house.");
        floorDescLabel.setFont(fontStarborn);
        floorDescLabel.setStyle("-fx-text-fill: #" + myColorWhiteSuger.toString().substring(2, 8) + ";");
        floorDescLabel.setTextAlignment(TextAlignment.CENTER);

        Label floorStartLabel = new Label(">To build this floor, click \non the " + floorNameLabel.getText() + "!");
        floorStartLabel.setFont(fontComicSansMS);
        floorStartLabel.setStyle("-fx-text-fill: #" + myColorWhiteSuger.toString().substring(2, 8) + ";");
        floorStartLabel.setTextAlignment(TextAlignment.CENTER);

        VBox vBoxForLabels = new VBox(40);
        vBoxForLabels.getChildren().addAll(floorNameLabel, floorDescLabel, floorStartLabel);
        vBoxForLabels.setPadding(new Insets(50, 0, 0, 0));
        vBoxForLabels.setAlignment(Pos.CENTER);
//        vBoxForLabels.setStyle("-fx-background-color: rgba(100, 200, 99, 0.5);");

        //*******(HBox for "character image, vBoxForLabels")*******
        HBox hBoxOnStack = new HBox();
        hBoxOnStack.getChildren().addAll(imageViewChar, vBoxForLabels);
        hBoxOnStack.setAlignment(Pos.CENTER);
//        hBoxOnStack.setStyle("-fx-background-color: rgba(255, 255, 50, 0.5);");

        //*******(StackPane for "wood image, hBoxOnStack")*******
        StackPane stackForLevel = new StackPane();
        stackForLevel.getChildren().addAll(imageViewWoodBackground, vBoxForLabels);
        stackForLevel.setAlignment(Pos.CENTER);
        stackForLevel.setVisible(false);

        //Creating VBox that contains the (HBox & stackPane) in the center of borderPane.
        VBox vBoxOnRight = new VBox(100);
        vBoxOnRight.getChildren().addAll(hBoxForCollection, stackForLevel);
//        vBoxOnRight.setPadding(new Insets(40, 0, 0, 0));
//        vBoxOnRight.setAlignment(Pos.TOP_LEFT);
//        vBoxOnRight.setStyle("-fx-background-color: rgba(39, 100, 100, 0.5);");

        //-------------------------------------------------------( the MAIN ROOT )------------------------------------------------------
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));

        //Creating BorderPane that contains the ALL the layouts
        BorderPane borderRoot = new BorderPane();
        borderRoot.setPadding(new Insets(10, 10, 10, 10));
        borderRoot.setBackground(background);

        borderRoot.setCenter(stackPaneOnCenter);
        borderRoot.setRight(vBoxOnRight);
        borderRoot.setLeft(vBoxOnLeft);

        //---------------------------------------------------------( Scene & Stage )--------------------------------------------------------
        //Creating a scene object 
        Scene scene = new Scene(borderRoot, 1500, 800);
        //setting color to the scene
        scene.setFill(Color.LIGHTSTEELBLUE);

        //-------------------------------------------------------( Actions or Events )------------------------------------------------------
        //-------------(PREVIOUS Button Action)------------
        imageViewPrevWoodButton.setOnMouseEntered(e_Entered_PrevWoodBt -> {
            // Zoom-in the image when the mouse hovers over it
            imageViewPrevWoodButton.setScaleX(1.2);
            imageViewPrevWoodButton.setScaleY(1.2);

            imageViewPrevWoodButton.setOnMouseClicked(e_Clicked_PrevWoodBt -> {
                //GO to Start interface
                primaryStage.setScene(StartLV.start(primaryStage));
            });
        });
        imageViewPrevWoodButton.setOnMouseExited(e_Exited_PrevWoodBt -> {
            // Restore the original size when the mouse leaves the image
            imageViewPrevWoodButton.setScaleX(1.0);
            imageViewPrevWoodButton.setScaleY(1.0);
        });

        //----------(Floor Images Buttons Action)----------
        //[1st]
        rectangleFloor1.setOnMouseEntered(e_Entered_Floor1 -> {
            switch (currentLevelIndex) {
                //player Does'nt enter any level
                case 0:
                    // Zoom-in the image when the mouse hovers over it
                    imageViewFloor1.setScaleX(1.02);
                    imageViewFloor1.setScaleY(1.02);
                    imageViewFloor1.setOpacity(1);
                    stackForLevel.setVisible(true);

                    //********HHEERREE********* GO TO GAME 1 INTERFACE
                    rectangleFloor1.setOnMouseClicked(e_Clicked_Floor1 -> {
                        //GO to level1 interface (murooj):
                        primaryStage.setScene(level1.startlevel1());
                    });
                    break;
                //player finish Only (1st level)
                case 1:
                    imageViewFloor1.setImage(imageDone);
                    imageViewFloor1.setFitHeight(90);
                    imageViewFloor1.setFitWidth(90);
                    imageViewFloor1.setScaleX(1.5);
                    imageViewFloor1.setScaleY(1.5);
                    imageViewFloor1.setOpacity(1);
                    break;
                //player finish Only (1st level & 2nd level)
                case 2:
                    imageViewFloor1.setImage(imageDone);
                    imageViewFloor1.setFitHeight(90);
                    imageViewFloor1.setFitWidth(90);
                    imageViewFloor1.setScaleX(1.5);
                    imageViewFloor1.setScaleY(1.5);
                    imageViewFloor1.setOpacity(1);
                    break;
                //player finish ALL levels
                case 3:
                    imageViewFloor1.setImage(imageDone);
                    imageViewFloor1.setFitHeight(90);
                    imageViewFloor1.setFitWidth(90);
                    imageViewFloor1.setScaleX(1.5);
                    imageViewFloor1.setScaleY(1.5);
                    imageViewFloor1.setOpacity(1);
                    break;
                default:
                    System.out.println("I AM HERE IN (ELSE CASE) !!!!!!!!");
                    break;
            }
        });
        rectangleFloor1.setOnMouseExited(e_Exited_Floor1 -> {
            switch (currentLevelIndex) {
                //player Does'nt enter any level
                case 0:
                    // Restore the original size when the mouse leaves the image
                    imageViewFloor1.setScaleX(1.0);
                    imageViewFloor1.setScaleY(1.0);
                    imageViewFloor1.setOpacity(0);
                    stackForLevel.setVisible(false);
                    break;
                //player enter only (1st level)
                case 1:
                    imageViewFloor1.setImage(imageFloor1);
                    imageViewFloor1.setFitHeight(205);
                    imageViewFloor1.setFitWidth(520);
                    imageViewFloor1.setScaleX(1.0);
                    imageViewFloor1.setScaleY(1.0);
                    imageViewFloor1.setOpacity(0);
                    break;
                //player enter only (1st level & 2nd level)
                case 2:
                    imageViewFloor1.setImage(imageFloor1);
                    imageViewFloor1.setFitHeight(205);
                    imageViewFloor1.setFitWidth(520);
                    imageViewFloor1.setScaleX(1.0);
                    imageViewFloor1.setScaleY(1.0);
                    imageViewFloor1.setOpacity(0);
                    break;
                //player enter (1st level & 2nd level & 3rd level)
                case 3:
                    imageViewFloor1.setImage(imageFloor1);
                    imageViewFloor1.setFitHeight(205);
                    imageViewFloor1.setFitWidth(520);
                    imageViewFloor1.setScaleX(1.0);
                    imageViewFloor1.setScaleY(1.0);
                    imageViewFloor1.setOpacity(0);
                    break;
                default:
                    System.out.println("I AM HERE IN (ELSE CASE) !!!!!!!!");
                    break;
            }
        });

        //[2nd]
        rectangleFloor2.setOnMouseEntered(e_Entered_Floor2 -> {
            switch (currentLevelIndex) {
                //player Does'nt enter any level
                case 0:
                    imageViewFloor2.setImage(imageLock);
                    imageViewFloor2.setFitHeight(90);
                    imageViewFloor2.setFitWidth(90);
                    imageViewFloor2.setScaleX(1.5);
                    imageViewFloor2.setScaleY(1.5);
                    imageViewFloor2.setOpacity(1);
                    break;
                //player finish Only (1st level)
                case 1:
                    // Zoom-in the image when the mouse hovers over it
                    imageViewFloor2.setScaleX(1.02);
                    imageViewFloor2.setScaleY(1.02);
                    imageViewFloor2.setOpacity(1);
                    stackForLevel.setVisible(true);
                    rectangleFloor2.setOnMouseClicked(e_Clicked_Floor2 -> {
                        //********HHEERREE********* GO TO GAME 2 INTERFACE
                        primaryStage.setScene(level2.createScene1());
                    });
                    break;
                //player finish Only (1st level & 2nd level)
                case 2:
                    imageViewFloor2.setImage(imageDone);
                    imageViewFloor2.setFitHeight(90);
                    imageViewFloor2.setFitWidth(90);
                    imageViewFloor2.setScaleX(1.5);
                    imageViewFloor2.setScaleY(1.5);
                    imageViewFloor2.setOpacity(1);
                    break;
                //player finish ALL levels
                case 3:
                    imageViewFloor2.setImage(imageDone);
                    imageViewFloor2.setFitHeight(90);
                    imageViewFloor2.setFitWidth(90);
                    imageViewFloor2.setScaleX(1.5);
                    imageViewFloor2.setScaleY(1.5);
                    imageViewFloor2.setOpacity(1);
                    break;
                default:
                    System.out.println("I AM HERE IN (ELSE CASE) !!!!!!!!");
                    break;
            }
        });
        rectangleFloor2.setOnMouseExited(e_Exited_Floor2 -> {
            switch (currentLevelIndex) {
                //player Does'nt enter any level
                case 0:
                    imageViewFloor2.setImage(imageFloor2);
                    imageViewFloor2.setFitHeight(185);
                    imageViewFloor2.setFitWidth(540);
                    imageViewFloor2.setScaleX(1.0);
                    imageViewFloor2.setScaleY(1.0);
                    imageViewFloor2.setOpacity(0);
                    break;
                //player enter only (1st level)
                case 1:
                    // Restore the original size when the mouse leaves the image
                    imageViewFloor2.setScaleX(1.0);
                    imageViewFloor2.setScaleY(1.0);
                    imageViewFloor2.setOpacity(0);
                    stackForLevel.setVisible(false);
                    break;
                //player enter only (1st level & 2nd level)
                case 2:
                    imageViewFloor2.setImage(imageFloor2);
                    imageViewFloor2.setFitHeight(185);
                    imageViewFloor2.setFitWidth(540);
                    imageViewFloor2.setScaleX(1.0);
                    imageViewFloor2.setScaleY(1.0);
                    imageViewFloor2.setOpacity(0);
                    break;
                //player enter (1st level & 2nd level & 3rd level)
                case 3:
                    imageViewFloor2.setImage(imageFloor2);
                    imageViewFloor2.setFitHeight(185);
                    imageViewFloor2.setFitWidth(540);
                    imageViewFloor2.setScaleX(1.0);
                    imageViewFloor2.setScaleY(1.0);
                    imageViewFloor2.setOpacity(0);
                    break;
                default:
                    System.out.println("I AM HERE IN (ELSE CASE) !!!!!!!!");
                    break;
            }
        });

        //[3rd]
        rectangleFloor3.setOnMouseEntered(e_Entered_Floor3 -> {
            switch (currentLevelIndex) {
                //player Does'nt enter any level
                case 0:
                    imageViewFloor3.setImage(imageLock);
                    imageViewFloor3.setFitHeight(90);
                    imageViewFloor3.setFitWidth(90);
                    imageViewFloor3.setScaleX(1.5);
                    imageViewFloor3.setScaleY(1.5);
                    imageViewFloor3.setOpacity(1);
                    break;
                //player finish Only (1st level)
                case 1:
                    imageViewFloor3.setImage(imageLock);
                    imageViewFloor3.setFitHeight(90);
                    imageViewFloor3.setFitWidth(90);
                    imageViewFloor3.setScaleX(1.5);
                    imageViewFloor3.setScaleY(1.5);
                    imageViewFloor3.setOpacity(1);
                    break;
                //player finish Only (1st level & 2nd level)
                case 2:
                    // Zoom-in the image when the mouse hovers over it
                    imageViewFloor3.setScaleX(1.02);
                    imageViewFloor3.setScaleY(1.02);
                    imageViewFloor3.setOpacity(1);
                    stackForLevel.setVisible(true);
                    rectangleFloor3.setOnMouseClicked(e_Clicked_Floor3 -> {
                        //********HHEERREE********* GO TO GAME 3 INTERFACE
                        primaryStage.setScene(level3.start());
                    });
                    break;
                //player finish ALL levels
                case 3:
                    imageViewFloor3.setImage(imageDone);
                    imageViewFloor3.setFitHeight(90);
                    imageViewFloor3.setFitWidth(90);
                    imageViewFloor3.setScaleX(1.5);
                    imageViewFloor3.setScaleY(1.5);
                    imageViewFloor3.setOpacity(1);
                    break;
                default:
                    System.out.println("I AM HERE IN (ELSE CASE) !!!!!!!!");
                    break;
            }
        });
        rectangleFloor3.setOnMouseExited(e_Exited_Floor3 -> {
            switch (currentLevelIndex) {
                //player Does'nt enter any level
                case 0:
                    imageViewFloor3.setImage(imageFloor3);
                    imageViewFloor3.setFitHeight(295);
                    imageViewFloor3.setFitWidth(610);
                    imageViewFloor3.setScaleX(1.0);
                    imageViewFloor3.setScaleY(1.0);
                    imageViewFloor3.setOpacity(0);
                    break;
                //player enter only (1st level)
                case 1:
                    imageViewFloor3.setImage(imageFloor3);
                    imageViewFloor3.setFitHeight(295);
                    imageViewFloor3.setFitWidth(610);
                    imageViewFloor3.setScaleX(1.0);
                    imageViewFloor3.setScaleY(1.0);
                    imageViewFloor3.setOpacity(0);
                    break;
                //player enter only (1st level & 2nd level)
                case 2:
                    // Restore the original size when the mouse leaves the image
                    imageViewFloor3.setScaleX(1.0);
                    imageViewFloor3.setScaleY(1.0);
                    imageViewFloor3.setOpacity(0);
                    stackForLevel.setVisible(false);
                    break;
                //player enter (1st level & 2nd level & 3rd level)
                case 3:
                    imageViewFloor3.setImage(imageFloor3);
                    imageViewFloor3.setFitHeight(295);
                    imageViewFloor3.setFitWidth(610);
                    imageViewFloor3.setScaleX(1.0);
                    imageViewFloor3.setScaleY(1.0);
                    imageViewFloor3.setOpacity(0);
                    break;
                default:
                    System.out.println("I AM HERE IN (ELSE CASE) !!!!!!!!");
                    break;
            }
        });

        return scene;

    }

    public void updateCurrentLevelIndex(int CurrentLevelIndex) {

        //player Does'nt complete any level
        if (CurrentLevelIndex == 0) {
            currentLevelIndex = 0;
            SceneBackground = new Image("file:BunyanImages/Manar/InterfaceEmpty.png");
//            StartLV.getLevels().setImageViewChar(new ImageView (charImages[currentLevelIndex]));
            imageViewChar.setImage(charImages[0]);
            floorNameLabel.setText("FIRST FLOOR");

            //player complete only (1st level)
        } else if (CurrentLevelIndex == 1) {
            currentLevelIndex = 1;
            SceneBackground = new Image("file:BunyanImages/Manar/InterfaceFloor1.png");
//            StartLV.getLevels().setImageViewChar(new ImageView (charImages[currentLevelIndex]));
            imageViewChar.setImage(charImages[1]);
            floorNameLabel.setText("SECOND FLOOR");

            //player complete only (1st level & 2nd level)
        } else if (CurrentLevelIndex == 2) {
            currentLevelIndex = 2;
            SceneBackground = new Image("file:BunyanImages/Manar/InterfaceFloor2.png");
            imageViewChar.setImage(charImages[2]);
            floorNameLabel.setText("THIRD FLOOR");

            // player complete (1st level & 2nd level & 3rd level)
        } else if (CurrentLevelIndex == 3) {
            currentLevelIndex = 3;
            SceneBackground = new Image("file:BunyanImages/Manar/InterfaceFull.png");

        } else {
            System.out.println("I AM HERE IN (ELSE CASE) !!!!!!!!");
        }

    }

    //-------------------------------------------------------( Getters & Setters )------------------------------------------------------
    //totalCoins
    public void setTotalCoins(int levelCoins) {
        totalCoins = levelCoins;
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    //totalTrees
    public void setTotalTrees(int totalTrees) {
        this.totalTrees = totalTrees;
    }

    public int getTotalTrees() {
        return totalTrees;
    }

    //totalTime
    long tmin = 0;
    long thou = 0;
    long tsec = 0;

    public String getTotalTime() {
        String TotalTime = thou + ":" + tmin + ":" + tsec;
        return TotalTime;
    }

    public void setTotalTime(long min, long sec) {
        tmin += min;
        tsec += sec;
        if (tmin >= 60) {
            thou = tmin / 60;
            tmin = 0;
            tmin = +tmin;
        }
        if (tsec >= 60) {
            tmin = tsec / 60;
            tsec = 0;
            tsec = +tsec;
        }

    }

    public Image getSceneBackground() {
        return SceneBackground;
    }

    public void setSceneBackground(Image SceneBackground) {
        this.SceneBackground = SceneBackground;
    }

    public Label getFloorNameLabel() {
        return floorNameLabel;
    }

    public void setFloorNameLabel(Label floorNameLabel) {
        this.floorNameLabel = floorNameLabel;
    }

    public ImageView getImageViewChar() {
        return imageViewChar;
    }

    public void setImageViewChar(ImageView imageViewChar) {
        this.imageViewChar = imageViewChar;
    }

    public Image[] getCharImages() {
        return charImages;
    }

    public void setCharImages(Image[] charImages) {
        this.charImages = charImages;
    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public void setCurrentLevelIndex(int currentLevelIndex) {
        this.currentLevelIndex = currentLevelIndex;
    }

    public Start_Interface getStartLV() {
        return StartLV;
    }

    public void setStartLV(Start_Interface StartLV) {
        this.StartLV = StartLV;
    }

}
