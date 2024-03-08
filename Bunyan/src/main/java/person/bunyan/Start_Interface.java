/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
 * @author manaralmashi
 */
public class Start_Interface {

    private Start_Interface start_S; //--> Get it from lamis class by method + Set it by all attribute before go to another interface
    private Profile_Interface profile = new Profile_Interface();
    private logIn logInObjForPowerBt;
    private logIn logInObj;//-------------> the startObj (new) 
    private Label labelInfo = new Label("");
    private Player player;
    private Levels_Interface levels = new Levels_Interface();
    private AchievementGUI achievementGUI;

    public void setLevels(Levels_Interface levels) {
        this.levels = levels;
    }

    public Levels_Interface getLevels() {
        return levels;
    }

    public Start_Interface getStart_S() {
        return start_S;
    }

    public void setStart_S(Start_Interface start_S) {
        this.start_S = start_S;
    }

    public logIn getLogInObj() {
        return logInObj;
    }

    public void setLogInObj(logIn logInObj) {
        this.logInObj = logInObj;
    }

    public Label getLabelInfo() {
        return labelInfo;
    }

    public void setLabelInfo(Label labelInfo) {
        this.labelInfo = labelInfo;
    }

    public Profile_Interface getProfile() {
        return profile;
    }

    public void setProfile(Profile_Interface profile) {
        this.profile = profile;
    }

    public AchievementGUI getAchievementGUI() {
        return achievementGUI;
    }

    public void setAchievementGUI(AchievementGUI achievementGUI) {
        this.achievementGUI = achievementGUI;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Scene start(Stage primaryStage) {

        //-----------------------------------------------------( Objects from classes )------------------------------------------------ 
        //Create Objects from (Profile_Interface + Levels_Interface + LAMIS):
        logInObjForPowerBt = new logIn(primaryStage);

        logInObj = new logIn();
        start_S = logInObj.getStartObj();
        achievementGUI = new AchievementGUI(primaryStage, start_S);

        if (profile != null) {
            profile.setStartObj_P(this);
        } else {
            System.out.println("profileObj_S is null. Cannot set Start_Interface in Profile_Interface.");
        }
        if (levels != null) {
            levels.setStartLV(start_S);
        } else {
            System.out.println("levels is null. Cannot set Start_Interface in Profile_Interface.");
        }

        if (achievementGUI != null) {
            achievementGUI.setStartObj(start_S);
        } else {
            System.out.println("levels is null. Cannot set Start_Interface in Profile_Interface.");
        }

        //-----------------------------------------------------------( Colors )--------------------------------------------------------
        //myColors
        Color myColorDarkRed = Color.rgb(93, 15, 41);
        Color myColorBlue = Color.rgb(9, 163, 230);
        Color myColorLightPink = Color.rgb(255, 250, 247);
        //-----------------------------------------------------------( Fonts )---------------------------------------------------------
        Font fontValoonS = Font.font("valoon", FontWeight.BOLD, 22);
        Font fontValoonL = Font.font("valoon", FontWeight.BOLD, 30);
        //-----------------------------------------------------------( Images )--------------------------------------------------------
        // image game logo
        Image imageGameLogo = new Image("file:BunyanImages/Manar/gameLogo.png");
        ImageView imageViewGameLogo = new ImageView(imageGameLogo);
        imageViewGameLogo.setFitHeight(300);
        imageViewGameLogo.setFitWidth(378);

        // image character
        Image imageCharacter = new Image("file:BunyanImages/Manar/ch16.png");
        ImageView imageViewCharacter = new ImageView(imageCharacter);
        imageViewCharacter.setFitHeight(500);
        imageViewCharacter.setFitWidth(233);

        // image wood
        Image imageWood = new Image("file:BunyanImages/Manar/WoodPeace.png");
        ImageView imageViewWood = new ImageView(imageWood);
        imageViewWood.setFitHeight(550);
        imageViewWood.setFitWidth(478);
        imageViewWood.setOpacity(0.9);

        //1 - image button Info
        Image imageInfo = new Image("file:BunyanImages/Manar/B_info.png");
        ImageView imageViewInfo = new ImageView(imageInfo);
        imageViewInfo.setFitHeight(100);
        imageViewInfo.setFitWidth(117);

        //2 - image button Achievements 
        Image imageAchievements = new Image("file:BunyanImages/Manar/B_achievements.png");
        ImageView imageViewAchievements = new ImageView(imageAchievements);
        imageViewAchievements.setFitHeight(100);
        imageViewAchievements.setFitWidth(117);

        //3 - image button Start
        Image imageStart = new Image("file:BunyanImages/Manar/B_start.png");
        ImageView imageViewStart = new ImageView(imageStart);
        imageViewStart.setFitHeight(200);
        imageViewStart.setFitWidth(217);

        //4 - image button Profile 
        Image imageProfile = new Image("file:BunyanImages/Manar/B_profile.png");
        ImageView imageViewProfile = new ImageView(imageProfile);
        imageViewProfile.setFitHeight(100);
        imageViewProfile.setFitWidth(117);

        //5 - image button Power 
        Image imagePower = new Image("file:BunyanImages/Manar/B_power.png");
        ImageView imageViewPower = new ImageView(imagePower);
        imageViewPower.setFitHeight(100);
        imageViewPower.setFitWidth(117);

        //-------------------------------------------------( SHADOWS for images )-------------------------------------------------
        //------------Create a DropShadow effect for image Character------------
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10.0);
        dropShadow.setOffsetX(5.0);
        dropShadow.setOffsetY(5.0);
        dropShadow.setColor(javafx.scene.paint.Color.rgb(0, 0, 0, 0.3));

        // Apply the DropShadow effect to the ImageView
        imageViewCharacter.setEffect(dropShadow);
        //----------------------------------------------------------------------

        // image game logo shadow
        Image imageGameLogoShadow = new Image("file:BunyanImages/Manar/gameLogoShadow.png");
        ImageView imageViewGameLogoShadow = new ImageView(imageGameLogoShadow);
        imageViewGameLogoShadow.setFitHeight(300);
        imageViewGameLogoShadow.setFitWidth(378);
        imageViewGameLogoShadow.setOpacity(0.8);

        // image Achievements shadow 
        Image imageAchievementsShadow = new Image("file:BunyanImages/Manar/buttonShadow.png");
        ImageView imageViewAchievementsShadow = new ImageView(imageAchievementsShadow);
        imageViewAchievementsShadow.setFitHeight(100);
        imageViewAchievementsShadow.setFitWidth(117);
        imageViewAchievementsShadow.setOpacity(0.8);

        // image Start shadow
        Image imageStartShadow = new Image("file:BunyanImages/Manar/buttonShadow.png");
        ImageView imageViewStartShadow = new ImageView(imageStartShadow);
        imageViewStartShadow.setFitHeight(200);
        imageViewStartShadow.setFitWidth(217);
        imageViewStartShadow.setOpacity(0.8);

        // image Profile shadow
        Image imageProfileShadow = new Image("file:BunyanImages/Manar/buttonShadow.png");
        ImageView imageViewProfileShadow = new ImageView(imageProfileShadow);
        imageViewProfileShadow.setFitHeight(100);
        imageViewProfileShadow.setFitWidth(117);
        imageViewProfileShadow.setOpacity(0.8);

        //-------------------------------------------------------( Layouts )------------------------------------------------------
        //Creating FlowPane that contains the GameLogo and 3 buttons in the center of borderPane.
        FlowPane flowpaneOnCenter = new FlowPane(Orientation.HORIZONTAL);
        flowpaneOnCenter.setHgap(15);
        flowpaneOnCenter.setVgap(15);
        flowpaneOnCenter.setAlignment(Pos.CENTER);
        flowpaneOnCenter.getChildren().addAll(imageViewGameLogo); //1st row
        flowpaneOnCenter.getChildren().addAll(imageViewAchievements, imageViewStart, imageViewProfile); //2nd row
//        flowpaneOnCenter.setStyle("-fx-background-color: rgba(173, 216, 230, 0.5);");

        //Creating FlowPane that contains SHADOWS of GameLogo and 3 buttons in the center of borderPane.
        FlowPane flowpaneOnCenter_SHADOWS = new FlowPane(Orientation.HORIZONTAL);
        flowpaneOnCenter_SHADOWS.setHgap(15);
        flowpaneOnCenter_SHADOWS.setVgap(15);
        flowpaneOnCenter_SHADOWS.setTranslateX(-8);
        flowpaneOnCenter_SHADOWS.setTranslateY(8);
        flowpaneOnCenter_SHADOWS.setAlignment(Pos.CENTER);
        flowpaneOnCenter_SHADOWS.getChildren().add(imageViewGameLogoShadow); //1st row
        flowpaneOnCenter_SHADOWS.getChildren().addAll(imageViewAchievementsShadow, imageViewStartShadow, imageViewProfileShadow); //2nd row
//        flowpaneOnCenter_SHADOWS.setStyle("-fx-background-color: rgba(173, 216, 230, 0.5);");

        //Creating StackPane that contains the (Wood image & flowpaneOnCenter & flowpaneOnCenter_SHADOWS) in the center of borderPane.
        StackPane stackForWood_flowpaneOnCenter = new StackPane();
        stackForWood_flowpaneOnCenter.getChildren().addAll(imageViewWood, flowpaneOnCenter_SHADOWS, flowpaneOnCenter);
//        stackForWood_flowpaneOnCenter.setStyle("-fx-background-color: rgba(173, 216, 230, 0.5);");

        //------------------------------------
        //> create H-Boxes for (Info button).
        HBox hboxInfoButton = new HBox();
        hboxInfoButton.getChildren().add(imageViewInfo);
        hboxInfoButton.setAlignment(Pos.TOP_RIGHT);

        //> setting for Labels
        //[1] wellcomelabel
        Label wellcomelabel = new Label("Welcome to\nthe Bunyan game !\n\n");
        wellcomelabel.setFont(fontValoonL);
        wellcomelabel.setStyle("-fx-text-fill: #" + myColorBlue.toString().substring(2, 8) + ";");
        wellcomelabel.setTextAlignment(TextAlignment.CENTER);

        //[2] labelInfo
        labelInfo.setFont(fontValoonS);
        labelInfo.setStyle("-fx-text-fill: #" + myColorDarkRed.toString().substring(2, 8) + ";");
        labelInfo.setTextAlignment(TextAlignment.CENTER);

        try {
            //Create a file instance
            java.io.File myFile = new java.io.File("gameInfoFile.txt");
            if (!myFile.exists()) {
                System.out.println("********* the File does NOT Exists *********");
            }
//            //Create a scanner for the file (read WORD-by-WORD)
//            Scanner reader = new Scanner(myFile);
//
//            while (reader.hasNext()) {
//                // Read data from the file
//                labelInfo.setText(labelInfo.getText() + " " + reader.next());
//            }

            // Create a BufferedReader for the file (read LINE-by-LINE)
            BufferedReader reader = new BufferedReader(new FileReader(myFile));

            String line;
            if (labelInfo.getText() == "") {
                while ((line = reader.readLine()) != null) {
                    // Read data from the file line by line
//                labelInfo.setText(labelInfo.getText() + " " + line);
                    //separate lines, you can append a newline character:
                    labelInfo.setText(labelInfo.getText() + line + "\n");
                }
                System.out.println("IAM HERE ON if (labelInfo.getText() == \"\")");
            }

            // Close the file
            reader.close();

            System.out.println("Data imported from " + myFile + " successfully!!");
        } catch (IOException ex) {
            System.out.println("I AM HERE ON catch");
            System.out.println("Error importing data from file: " + ex.getMessage());
        }

        //> create VBox that contain the two labels on stackPane.
        VBox vBoxForLabels = new VBox(30);
        vBoxForLabels.getChildren().addAll(wellcomelabel, labelInfo);
        vBoxForLabels.setAlignment(Pos.CENTER);
        vBoxForLabels.setPadding(new Insets(0, 20, 0, 20));
//        vBoxForLabels.setStyle("-fx-background-color: rgba(70, 200, 200, 0.4);");

        // Create a rectangle (background of Game Information)
        Rectangle roundedRectangle = new Rectangle();
        roundedRectangle.setHeight(550);
        roundedRectangle.setWidth(378);
        roundedRectangle.setArcWidth(20);
        roundedRectangle.setArcHeight(20);
        roundedRectangle.setFill(myColorLightPink);
        roundedRectangle.setOpacity(0.9);

        //> create StackPane for (roundedRectangle & vBoxForLabels).
        StackPane stackPaneGameInformation = new StackPane();
        stackPaneGameInformation.getChildren().addAll(roundedRectangle, vBoxForLabels);

        //Creating (VBox) that contain the two H-Boxes (Info button & game Information image) in the right of borderPane.
        VBox vBoxOnRight = new VBox(40);
        vBoxOnRight.getChildren().addAll(hboxInfoButton, stackPaneGameInformation);
        vBoxOnRight.setPadding(new Insets(0, 50, 0, 50));
//        vBoxOnRight.setStyle("-fx-background-color: rgba(255, 56, 89, 0.4);");
        //------------------------------------
        //> create H-Boxes for (Power button).
        HBox hboxPowerButton = new HBox();
        hboxPowerButton.getChildren().add(imageViewPower);

        //> create H-Boxes for (Character image).
        HBox hboxCharacterImage = new HBox();
        hboxCharacterImage.getChildren().add(imageViewCharacter);
        hboxCharacterImage.setPadding(new Insets(50, 0, 0, 250));
        hboxCharacterImage.setAlignment(Pos.BOTTOM_RIGHT);

        //> Creating (VBox) that contain the two H-Boxes (Power button & Character image) in the left of borderPane.
        VBox vBoxOnLeft = new VBox(40);
        vBoxOnLeft.getChildren().addAll(hboxPowerButton, hboxCharacterImage);
        vBoxOnLeft.setPadding(new Insets(0, 20, 0, 0));
//        vBoxOnLeft.setStyle("-fx-background-color: rgba(255, 216, 230, 0.5);");

        //-------------------------------------------------------( the MAIN ROOT )------------------------------------------------------
        Image SceneBackground = new Image("file:BunyanImages/Manar/StartInterfaceBackground.jpg");
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));

        //Creating BorderPane that contains the ALL the layouts
        BorderPane borderRoot = new BorderPane();
        borderRoot.setPadding(new Insets(10, 10, 10, 10));
        borderRoot.setBackground(background);

        borderRoot.setCenter(stackForWood_flowpaneOnCenter);
        borderRoot.setRight(vBoxOnRight);
        borderRoot.setLeft(vBoxOnLeft);

        //-------------------------------------------------------( Scene & Stage )------------------------------------------------------
        //Creating a scene object 
        Scene scene = new Scene(borderRoot, 1500, 800);
        //setting color to the scene
        scene.setFill(Color.LIGHTSTEELBLUE);

        //-------------------------------------------------------( Actions or Events )------------------------------------------------------
        //imageViewInfo, imageViewAchievements, imageViewStart, imageViewProfile, imageViewPower.
        stackPaneGameInformation.setVisible(false);

        start_S.setLabelInfo(labelInfo);
        start_S.setLogInObj(logInObj);
        start_S.setProfile(profile);
        start_S.setAchievementGUI(achievementGUI);
        start_S.setPlayer(player);
        start_S.setLevels(levels);
        //--------------(Info Button Action)-------------
        imageViewInfo.setOnMouseEntered(e_Entered_Info -> {

            // Zoom-in the image when the mouse hovers over it
            imageViewInfo.setScaleX(1.2);
            imageViewInfo.setScaleY(1.2);

            // show the GameInfotmation image when the mouse hovers over it
            stackPaneGameInformation.setVisible(true);

        });
        imageViewInfo.setOnMouseExited(e_Exited_Info -> {
            // Restore the original size when the mouse leaves the image
            imageViewInfo.setScaleX(1.0);
            imageViewInfo.setScaleY(1.0);
            // hidden the GameInfotmation image when the mouse hovers over it
            stackPaneGameInformation.setVisible(false);
        });
        //----------(Achievements Button Action)----------
        imageViewAchievements.setOnMouseEntered(e_Entered_Achievements -> {
            // Zoom-in the image when the mouse hovers over it
            imageViewAchievements.setScaleX(1.2);
            imageViewAchievements.setScaleY(1.2);
            imageViewAchievementsShadow.setScaleX(1.2);
            imageViewAchievementsShadow.setScaleY(1.2);

            imageViewAchievements.setOnMouseClicked(e_Clicked_Achievements -> {
                //************************************************************* HERE LAAAAMMMMIIIISSSSSSS **********************
                //GO to lamis interface
                primaryStage.setScene(achievementGUI.achievementInterface());
            });
        });
        imageViewAchievements.setOnMouseExited(e_Exited_Achievements -> {
            // Restore the original size when the mouse leaves the image
            imageViewAchievements.setScaleX(1.0);
            imageViewAchievements.setScaleY(1.0);
            imageViewAchievementsShadow.setScaleX(1.0);
            imageViewAchievementsShadow.setScaleY(1.0);
        });

        //----------(Start Button Action)----------
        imageViewStart.setOnMouseEntered(e_Entered_Start -> {
            // Zoom-in the image when the mouse hovers over it
            imageViewStart.setScaleX(1.1);
            imageViewStart.setScaleY(1.1);
            imageViewStartShadow.setScaleX(1.1);
            imageViewStartShadow.setScaleY(1.1);

            imageViewStart.setOnMouseClicked(e_Clicked_Start -> {
                //GO to level interface
//                levels.setLevels(getLevels());
                primaryStage.setScene(levels.start(primaryStage));

            });
        });
        imageViewStart.setOnMouseExited(e_Exited_Start -> {
            // Restore the original size when the mouse leaves the image
            imageViewStart.setScaleX(1.0);
            imageViewStart.setScaleY(1.0);
            imageViewStartShadow.setScaleX(1.0);
            imageViewStartShadow.setScaleY(1.0);
        });

        //----------(Profile Button Action)----------
        imageViewProfile.setOnMouseEntered(e_Entered_Profile -> {
            // Zoom-in the image when the mouse hovers over it
            imageViewProfile.setScaleX(1.2);
            imageViewProfile.setScaleY(1.2);
            imageViewProfileShadow.setScaleX(1.2);
            imageViewProfileShadow.setScaleY(1.2);

            imageViewProfile.setOnMouseClicked(e_Clicked_Profile -> {
                //GO to prifile interface
                primaryStage.setScene(profile.start(primaryStage));
            });
        });
        imageViewProfile.setOnMouseExited(e_Exited_Profile -> {
            // Restore the original size when the mouse leaves the image
            imageViewProfile.setScaleX(1.0);
            imageViewProfile.setScaleY(1.0);
            imageViewProfileShadow.setScaleX(1.0);
            imageViewProfileShadow.setScaleY(1.0);
        });

        //----------(Power Button Action)----------
        imageViewPower.setOnMouseEntered(e_Entered_Power -> {
            // Zoom-in the image when the mouse hovers over it
            imageViewPower.setScaleX(1.2);
            imageViewPower.setScaleY(1.2);

            imageViewPower.setOnMouseClicked(e_Clicked_Power -> {
//                System.exit(0);
//                GO to lamis interface (LOG IN)
                primaryStage.setScene(logInObjForPowerBt.Interface());
            });
        });
        imageViewPower.setOnMouseExited(e_Exited_Power -> {
            // Restore the original size when the mouse leaves the image
            imageViewPower.setScaleX(1.0);
            imageViewPower.setScaleY(1.0);
        });
        return scene;
    }

}
