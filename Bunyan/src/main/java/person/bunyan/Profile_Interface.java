/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author manaralmashi
 */
public class Profile_Interface {

    private Start_Interface startObj_P = null;
    
    public ImageView selectedImageView;
    public Label selectedName;
    private Label selectedID = null;
    public Image[] AvatarImages;
    public Label[] AvatarNames;
    public int currentAvatarIndex = 0;
    public int currentAvatarNameIndex = 0;

    public boolean isFirstDisplay = true;

    public Label playerFirstName;
    public Label playerLastName;
    public Label playerEmail;
    public Label playerPassword;

    private List<avatars> avatarList = null;

    
    public Start_Interface getStartObj_P() {
        return startObj_P;
    }

    public void setStartObj_P(Start_Interface startObj_S) {
        this.startObj_P = startObj_S;
    }
    
    
    public Scene start(Stage primaryStage) {
        //---------------------------------------------------( Objects from classes )---------------------------------------------------  
        startObj_P = startObj_P.getStart_S();
        if (startObj_P != null) {
            startObj_P.setProfile(this);
        } else {
            System.out.println("startObj_P is null. Cannot set Profile_Interface in Start_Interface.");
        }

        //------------------------------DBDBDBDBDBDBDBDBDB------------------------------------
        //retrive avatars list
        Session session = HibernateUtil.getSessionFactory().openSession();

//        List<avatars> avatarList = null;
        String queryStr = "from avatars";
        Query query = session.createQuery(queryStr);
        avatarList = query.list();

        session.close();

        System.out.println("avatar list size: " + avatarList.size());

        for (int i = 0; i < avatarList.size(); i++) {
            avatars avt = avatarList.get(i);
            System.out.println(avt.getAvatarImageID() + " " + avt.getAvatarName());
        }

//        //get student by ID and update thier name
//        session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        avatars Supdate = null;
//        String sid = "M2";
//        Supdate = (avatars) session.get(avatars.class, sid);
//        Supdate.setAvatarName("Lucy");
//        session.update(Supdate);
//        tx.commit();
//        session.close();
//        System.out.println("Student " + sid + " was updated by: " + Supdate.getAvatarName());
        //----------------------------------------------------------( Colors )----------------------------------------------------------
        Color myColorLightYellow = Color.rgb(247, 215, 92);
        Color myColorWhiteSuger = Color.rgb(254, 251, 236);
        Color myColorDarkRed = Color.rgb(93, 15, 41);

        //----------------------------------------------------------( Images )---------------------------------------------------------- 
        // images for buttons
        Image imageNextBt = new Image("file:BunyanImages/Manar/next.png");
        ImageView imageViewNextBt = new ImageView(imageNextBt);
        imageViewNextBt.setFitHeight(75);
        imageViewNextBt.setFitWidth(75);

        Image imagePrevBt = new Image("file:BunyanImages/Manar/previous.png");
        ImageView imageViewPrevBt = new ImageView(imagePrevBt);
        imageViewPrevBt.setFitHeight(75);
        imageViewPrevBt.setFitWidth(75);

        Image imageSaveBt = new Image("file:BunyanImages/Manar/save.png");
        ImageView imageViewSaveBt = new ImageView(imageSaveBt);
        imageViewSaveBt.setFitHeight(87);
        imageViewSaveBt.setFitWidth(117);

        Image imageCloseBt = new Image("file:BunyanImages/Manar/close.png");
        ImageView imageViewCloseBt = new ImageView(imageCloseBt);
        imageViewCloseBt.setFitHeight(87);
        imageViewCloseBt.setFitWidth(97);

        Image imageWoodButton = new Image("file:BunyanImages/Manar/button.png");
        ImageView imageViewWoodButton1 = new ImageView(imageWoodButton);
        imageViewWoodButton1.setFitHeight(87);
        imageViewWoodButton1.setFitWidth(117);
        ImageView imageViewWoodButton2 = new ImageView(imageWoodButton);
        imageViewWoodButton2.setFitHeight(87);
        imageViewWoodButton2.setFitWidth(117);

        //White background images
        Image imageWhiteBackground = new Image("file:BunyanImages/Manar/WhiteBackground.png");
        ImageView imageViewWhiteBackground = new ImageView(imageWhiteBackground);
        imageViewWhiteBackground.setFitHeight(340);
        imageViewWhiteBackground.setFitWidth(912);
        imageViewWhiteBackground.setOpacity(0.4);

        //wood text image
        Image imageWoodText = new Image("file:BunyanImages/Manar/woodText.png");

        ImageView imageViewWoodText1 = new ImageView(imageWoodText);
        imageViewWoodText1.setFitHeight(70);
        imageViewWoodText1.setFitWidth(613);

        ImageView imageViewWoodText2 = new ImageView(imageWoodText);
        imageViewWoodText2.setFitHeight(70);
        imageViewWoodText2.setFitWidth(613);

        ImageView imageViewWoodText3 = new ImageView(imageWoodText);
        imageViewWoodText3.setFitHeight(70);
        imageViewWoodText3.setFitWidth(613);

        ImageView imageViewWoodText4 = new ImageView(imageWoodText);
        imageViewWoodText4.setFitHeight(70);
        imageViewWoodText4.setFitWidth(613);

        //-------------------------------------------------------( About images )------------------------------------------------------
        // Create ImageView for the selected image
        selectedImageView = new ImageView();
        selectedImageView.setFitWidth(278);
        selectedImageView.setFitHeight(200);

        //-------------------------------------------------------( Fonts )------------------------------------------------------
        // Load the TTF font file
        //Font.loadFont(getClass().getResourceAsStream("file:///Users/manaralmashi/Downloads/starborn.ttf"), 12);
        Font fontStarborn = Font.font("starborn", FontWeight.BOLD, 24);
        Font fontValoon = Font.font("valoon", FontWeight.BOLD, 30);
        Font fontValoonLarge = Font.font("valoon", FontWeight.BOLD, 35);
        Font fontComicSansMS = Font.font("Comic Sans MS", 15);

        //-------------------------------------------------------( Layouts )------------------------------------------------------
        
        //----------------------( CENTER )----------------------
        selectedID = new Label();

        selectedName = new Label();
        selectedName.setFont(fontStarborn);
        selectedName.setStyle("-fx-text-fill: #" + myColorLightYellow.toString().substring(2, 8) + ";");

        Image AvImg0 = null, AvImg1 = null, AvImg2 = null, AvImg3 = null, AvImg4 = null, AvImg5 = null, AvImg6 = null;
        Label AN0 = null, AN1 = null, AN2 = null, AN3 = null, AN4 = null, AN5 = null, AN6 = null;
        
        for (avatars x : avatarList) {
            if ("U0".equals(x.getAvatarImageID())) {
                AN0 = new Label(x.getAvatarName());
                AvImg0 = new Image("file:BunyanImages/Manar/avatar0.png");
            }
            if ("F1".equals(x.getAvatarImageID())) {
                AN1 = new Label(x.getAvatarName());
                AvImg1 = new Image("file:BunyanImages/Manar/avatar1.png");
            }
            if ("M1".equals(x.getAvatarImageID())) {
                AN2 = new Label(x.getAvatarName());
                AvImg2 = new Image("file:BunyanImages/Manar/avatar2.png");
            }
            if ("F2".equals(x.getAvatarImageID())) {
                AN3 = new Label(x.getAvatarName());
                AvImg3 = new Image("file:BunyanImages/Manar/avatar3.png");
            }
            if ("M2".equals(x.getAvatarImageID())) {
                AN4 = new Label(x.getAvatarName());
                AvImg4 = new Image("file:BunyanImages/Manar/avatar4.png");
            }
            if ("F3".equals(x.getAvatarImageID())) {
                AN5 = new Label(x.getAvatarName());
                AvImg5 = new Image("file:BunyanImages/Manar/avatar5.png");
            }
            if ("M3".equals(x.getAvatarImageID())) {
                AN6 = new Label(x.getAvatarName());
                AvImg6 = new Image("file:BunyanImages/Manar/avatar6.png");
            }
//            else {
//                System.out.println("I AM HERE IN ELSE ( STATEMENT: for (avatars x : avatarList){} )");
//            }
        }
        // Create labels for avatar names
        AvatarNames = new Label[]{
            AN0, AN1, AN2, AN3, AN4, AN5, AN6
        };
        // Create Images for avatar images
        AvatarImages = new Image[]{
            AvImg0, AvImg1, AvImg2, AvImg3, AvImg4, AvImg5, AvImg6
        };

        //Creating HBox that contains (Navigation buttons- prev & next).
        HBox hBoxNavigationButtons = new HBox(300);
        hBoxNavigationButtons.getChildren().addAll(imageViewPrevBt, imageViewNextBt);
        hBoxNavigationButtons.setAlignment(Pos.TOP_CENTER);
        hBoxNavigationButtons.setPadding(new Insets(100, 0, 0, 0));

        //Creating VBox that contains (Avatar Name, Avatar image).
        VBox vBoxAvatar = new VBox();
        vBoxAvatar.getChildren().addAll(selectedName, selectedImageView);
        vBoxAvatar.setAlignment(Pos.TOP_CENTER);
        vBoxAvatar.setSpacing(10);
        vBoxAvatar.setPadding(new Insets(15, 0, 0, 0));

        //Creating StackPane that contains (Avatar setting- Hbox & Vbox) in the center of borderPane.
        StackPane stackForAvatarOnCenter = new StackPane();
        stackForAvatarOnCenter.getChildren().addAll(vBoxAvatar, hBoxNavigationButtons);
        stackForAvatarOnCenter.setAlignment(Pos.CENTER);
//        stackForAvatarOnCenter.setStyle("-fx-background-color: rgba(200, 216, 230, 0.5);");

        //----------------------( BOTTOM )----------------------
        playerFirstName = new Label();
        playerFirstName.setFont(fontComicSansMS);
        playerFirstName.setStyle("-fx-text-fill: #" + myColorWhiteSuger.toString().substring(2, 8) + ";");
        playerFirstName.setText(startObj_P.getPlayer().getFname());
        
        playerLastName = new Label();
        playerLastName.setFont(fontComicSansMS);
        playerLastName.setStyle("-fx-text-fill: #" + myColorWhiteSuger.toString().substring(2, 8) + ";");
        playerLastName.setText(startObj_P.getPlayer().getLname());
        
        playerEmail = new Label();
        playerEmail.setFont(fontComicSansMS);
        playerEmail.setStyle("-fx-text-fill: #" + myColorWhiteSuger.toString().substring(2, 8) + ";");
        playerEmail.setText(startObj_P.getPlayer().getPlayerEmail());
        
        playerPassword = new Label();
        playerPassword.setFont(fontComicSansMS);
        playerPassword.setStyle("-fx-text-fill: #" + myColorWhiteSuger.toString().substring(2, 8) + ";");
        playerPassword.setText(startObj_P.getPlayer().getPlayerPass());

        
        //Creating StackPanes that contains (WoodText image & player information).
        StackPane stackForFirstName = new StackPane();
        stackForFirstName.getChildren().addAll(imageViewWoodText1, playerFirstName);
        StackPane stackForLastName = new StackPane();
        stackForLastName.getChildren().addAll(imageViewWoodText2, playerLastName);
        StackPane stackForEmail = new StackPane();
        stackForEmail.getChildren().addAll(imageViewWoodText3, playerEmail);
        StackPane stackForPassword = new StackPane();
        stackForPassword.getChildren().addAll(imageViewWoodText4, playerPassword);

        //Creating Labels desc.
        Label firstNameLabel = new Label("First Name:");
        firstNameLabel.setFont(fontValoon);
        firstNameLabel.setStyle("-fx-text-fill: #" + myColorDarkRed.toString().substring(2, 8) + ";");

        Label lastNameLabel = new Label("Last Name:");
        lastNameLabel.setFont(fontValoon);
        lastNameLabel.setStyle("-fx-text-fill: #" + myColorDarkRed.toString().substring(2, 8) + ";");

        Label emailLabel = new Label("E-mail:");
        emailLabel.setFont(fontValoon);
        emailLabel.setStyle("-fx-text-fill: #" + myColorDarkRed.toString().substring(2, 8) + ";");

        Label PasswordLabel = new Label("Password:");
        PasswordLabel.setFont(fontValoon);
        PasswordLabel.setStyle("-fx-text-fill: #" + myColorDarkRed.toString().substring(2, 8) + ";");

        //Creating GridPane that contains (Labels & stackPanes).
        GridPane gridPlayerInformation = new GridPane();
        gridPlayerInformation.setGridLinesVisible(false);
        gridPlayerInformation.setVgap(10);
        gridPlayerInformation.setHgap(20);
        gridPlayerInformation.setAlignment(Pos.CENTER);

//        imageViewWoodText
        //Add all UI controls to the GridPane
        gridPlayerInformation.add(firstNameLabel, 0, 0);
        gridPlayerInformation.add(stackForFirstName, 1, 0);
        gridPlayerInformation.add(lastNameLabel, 0, 1);
        gridPlayerInformation.add(stackForLastName, 1, 1);
        gridPlayerInformation.add(emailLabel, 0, 2);
        gridPlayerInformation.add(stackForEmail, 1, 2);
        gridPlayerInformation.add(PasswordLabel, 0, 3);
        gridPlayerInformation.add(stackForPassword, 1, 3);
//        gridPlayerInformation.setStyle("-fx-background-color: rgba(173, 216, 230, 0.5);");

        //Creating StackPane that contains (WhiteBackground image & GridPane) in the bottom of borderPane.
        StackPane stackPlayerInfo_Background = new StackPane();
        stackPlayerInfo_Background.getChildren().addAll(imageViewWhiteBackground, gridPlayerInformation);
        stackPlayerInfo_Background.setAlignment(Pos.CENTER);
        stackPlayerInfo_Background.setPadding(new Insets(0, 0, 100, 0));

        //----------------------( RIGHT )----------------------
        Label editLabel = new Label("EDIT");
        editLabel.setFont(fontValoonLarge);
        editLabel.setStyle("-fx-text-fill: #" + myColorWhiteSuger.toString().substring(2, 8) + ";");
        editLabel.setAlignment(Pos.CENTER);

        //Creating StackPane that contains (Wood Button & Edit Label).
        StackPane stackEditBt = new StackPane();
        stackEditBt.getChildren().addAll(imageViewWoodButton2, editLabel);

        Label massageEditLabel = new Label("You can ONLY edit the\n\bAVATAR IMAGE!\b\n,then press the SAVE button");
        massageEditLabel.setFont(fontComicSansMS);
        massageEditLabel.setStyle("-fx-text-fill: #" + myColorWhiteSuger.toString().substring(2, 8) + ";");
        massageEditLabel.setAlignment(Pos.CENTER);
        massageEditLabel.setTextAlignment(TextAlignment.CENTER);

        //Creating VBox that contains (stackEditBt, massageEditLabel, imageViewSaveBt) in the right of borderPane.
        VBox vBoxEditBt = new VBox(30);
        vBoxEditBt.getChildren().addAll(stackEditBt, massageEditLabel, imageViewSaveBt);
        vBoxEditBt.setPadding(new Insets(40, 20, 0, 50));
        vBoxEditBt.setAlignment(Pos.TOP_CENTER);
//        vBoxEditBt.setStyle("-fx-background-color: rgba(200, 200, 200, 0.5);");

        //----------------------( LEFT )----------------------
        //Creating StackPane that contains (Wood Button & Close Button).
        StackPane stackCloseBt = new StackPane();
        stackCloseBt.getChildren().addAll(imageViewWoodButton1, imageViewCloseBt);

        //Creating VBox that contains (stackCloseBt) in the left of borderPane.
        VBox vBoxCloseBt = new VBox();
        vBoxCloseBt.getChildren().add(stackCloseBt);
        vBoxCloseBt.setPadding(new Insets(40, 50, 0, 20));
//        vBoxCloseBt.setStyle("-fx-background-color: rgba(173, 116, 130, 0.5);");

        //-------------------------------------------------------( the MAIN ROOT )------------------------------------------------------
        Image SceneBackground = new Image("file:BunyanImages/Manar/ProfileInterfaceBackground.jpg");
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));

        //Creating BorderPane that contains the ALL the layouts
        BorderPane borderRoot = new BorderPane();
        borderRoot.setPadding(new Insets(5, 5, 5, 5));
        borderRoot.setBackground(background);

        borderRoot.setCenter(stackForAvatarOnCenter);
        borderRoot.setBottom(stackPlayerInfo_Background);
        borderRoot.setRight(vBoxEditBt);
        borderRoot.setLeft(vBoxCloseBt);

        //-------------------------------------------------------( Scene & Stage )------------------------------------------------------
        //Creating a scene object 
        Scene scene = new Scene(borderRoot, 1500, 800);
        //setting color to the scene
        scene.setFill(Color.LIGHTSTEELBLUE);
        //Setting title to the Stage 
        primaryStage.setTitle("interface (3)_Profile");
        //Adding scene to the stage
        primaryStage.setScene(scene);
        //Displaying the contents of the stage
        primaryStage.show();

        // Display the first image
        updateSelectedImage();
        updateSelectedName();
        updateSelectedID();

        imageViewPrevBt.setVisible(false);
        imageViewNextBt.setVisible(false);
        imageViewSaveBt.setVisible(false);
        massageEditLabel.setVisible(false);

        //-------------------------------------------------------( Actions or Events )------------------------------------------------------
        //----------(EDIT Button Action)----------
        editLabel.setOnMouseEntered(e_Entered_editBt -> {
            // Zoom-in the image when the mouse hovers over it
            editLabel.setScaleX(1.2);
            editLabel.setScaleY(1.2);
            imageViewWoodButton2.setScaleX(1.2);
            imageViewWoodButton2.setScaleY(1.2);

            editLabel.setOnMouseClicked(e_Clicked_edit -> {
                imageViewPrevBt.setVisible(true);
                imageViewNextBt.setVisible(true);
                imageViewSaveBt.setVisible(true);
                massageEditLabel.setVisible(true);
            });
        });
        editLabel.setOnMouseExited(e_Exited_editBt -> {
            // Restore the original size when the mouse leaves the image
            editLabel.setScaleX(1.0);
            editLabel.setScaleY(1.0);
            imageViewWoodButton2.setScaleX(1.0);
            imageViewWoodButton2.setScaleY(1.0);
        });

        //----------(PREVIOUS Button Action)----------
        imageViewPrevBt.setOnMouseEntered(e_Entered_PrevBt -> {
            // Zoom-in the image when the mouse hovers over it
            imageViewPrevBt.setScaleX(1.2);
            imageViewPrevBt.setScaleY(1.2);

            imageViewPrevBt.setOnMouseClicked(e_Clicked_PrevBt -> {
                navigate(-1);
            });
        });
        imageViewPrevBt.setOnMouseExited(e_Exited_PrevBt -> {
            // Restore the original size when the mouse leaves the image
            imageViewPrevBt.setScaleX(1.0);
            imageViewPrevBt.setScaleY(1.0);
        });

        //----------(NEXT Button Action)----------
        imageViewNextBt.setOnMouseEntered(e_Entered_NextBt -> {
            // Zoom-in the image when the mouse hovers over it
            imageViewNextBt.setScaleX(1.2);
            imageViewNextBt.setScaleY(1.2);

            imageViewNextBt.setOnMouseClicked(e_Clicked_NextBt -> {
                navigate(1);
            });
        });
        imageViewNextBt.setOnMouseExited(e_Exited_NextBt -> {
            // Restore the original size when the mouse leaves the image
            imageViewNextBt.setScaleX(1.0);
            imageViewNextBt.setScaleY(1.0);
        });

        //----------(SAVE Button Action)----------
        imageViewSaveBt.setOnMouseEntered(e_Entered_SaveBt -> {
            // Zoom-in the image when the mouse hovers over it
            imageViewSaveBt.setScaleX(1.2);
            imageViewSaveBt.setScaleY(1.2);

            imageViewSaveBt.setOnMouseClicked(e_Clicked_SaveBt -> {
                
                confirmSelection();
                massageEditLabel.setText("Your avatar image has been\n saved successfully");
                imageViewPrevBt.setVisible(false);
                imageViewNextBt.setVisible(false);
                imageViewSaveBt.setVisible(false);
                massageEditLabel.setVisible(false);
            });
        });
        imageViewSaveBt.setOnMouseExited(e_Exited_SaveBt -> {
            // Restore the original size when the mouse leaves the image
            imageViewSaveBt.setScaleX(1.0);
            imageViewSaveBt.setScaleY(1.0);
        });

        //----------(CLOSE Button Action)----------
        imageViewCloseBt.setOnMouseEntered(e_Entered_CloseBt -> {
            // Zoom-in the image when the mouse hovers over it
            imageViewCloseBt.setScaleX(1.2);
            imageViewCloseBt.setScaleY(1.2);
            imageViewWoodButton1.setScaleX(1.2);
            imageViewWoodButton1.setScaleY(1.2);

            imageViewCloseBt.setOnMouseClicked(e_Clicked_CloseBt -> {
                //GO to Start interface
                primaryStage.setScene(startObj_P.start(primaryStage));
            });
        });
        imageViewCloseBt.setOnMouseExited(e_Exited_CloseBt -> {
            // Restore the original size when the mouse leaves the image
            imageViewCloseBt.setScaleX(1.0);
            imageViewCloseBt.setScaleY(1.0);
            imageViewWoodButton1.setScaleX(1.0);
            imageViewWoodButton1.setScaleY(1.0);
        });
        return scene;
    }

    public void navigate(int offset) {
        currentAvatarIndex += offset;
        currentAvatarNameIndex += offset;

        // Ensure the index stays within bounds
        if (currentAvatarIndex < 0) {
            currentAvatarIndex = 0;
            currentAvatarNameIndex = 0;
        } else if (currentAvatarIndex >= AvatarImages.length) {
            currentAvatarIndex = AvatarImages.length - 1;
            currentAvatarNameIndex = AvatarNames.length - 1;
        }

        // Update the displayed image
        updateSelectedImage();
        updateSelectedName();
        updateSelectedID();

    }

    public void updateSelectedImage() {
        if (currentAvatarIndex >= 0 && currentAvatarIndex < AvatarImages.length) {
            Image selectedImage = AvatarImages[currentAvatarIndex];
            selectedImageView.setImage(selectedImage);
        }
    }

    public void updateSelectedName() {

        if (currentAvatarNameIndex >= 0 && currentAvatarNameIndex < AvatarNames.length) {
            //Change avatar name:
            selectedName.setText(AvatarNames[currentAvatarNameIndex].getText());
                System.out.println("selectedName.getText() : " + selectedName.getText());
                System.out.println("currentAvatarNameIndex : " + currentAvatarNameIndex);
        }
    }

    public void updateSelectedID() {
        //set selectedID to update player avatarID
            switch (currentAvatarNameIndex) {
                case 0:
                    selectedID.setText("U0");
                    break;
                case 1:
                    selectedID.setText("F1");
                    break;
                case 2:
                    selectedID.setText("M1");
                    break;
                case 3:
                    selectedID.setText("F2");
                    break;
                case 4:
                    selectedID.setText("M2");
                    break;
                case 5:
                    selectedID.setText("F3");
                    break;
                case 6:
                    selectedID.setText("M3");
                    break;
                default:
                    System.out.println("!!!!!!!!! IAM HERE IN DEFAULT \"switch (currentAvatarNameIndex)\" !!!!!!!");
                    throw new AssertionError();
            }
            System.out.println("selectedID : " + selectedID.getText());
    }

    public void confirmSelection() {
        // Perform actions when the user confirms the selection
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        
        Player P = (Player) session.get(Player.class,startObj_P.getPlayer().getPlayerID() );
        P.setAvatar(selectedID.getText());
        session.update(P);
        tx.commit();
        session.close();
     
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Selected image: " + AvatarImages[currentAvatarIndex].getUrl());
        System.out.println("Avatar ID: " + selectedID.getText());
        System.out.println("Avatar Name: " + avatarList.get(currentAvatarIndex).getAvatarImageID());
        System.out.println("currentAvatarIndex: " + currentAvatarIndex);
        System.out.println("currentAvatarNameIndex: " + currentAvatarNameIndex);
        System.out.println("-----------------------------------------------------------------");
    }

    public void setAvatars() {

    }
    //-------------------------------------------------------( Getters & Setters )------------------------------------------------------
    public List<avatars> getAvatarList() {
        return avatarList;
    }

    public void setAvatarList(List<avatars> avatarList) {
        this.avatarList = avatarList;
    }

    public Label getSelectedID() {
        return selectedID;
    }

    public void setSelectedID(Label selectedID) {
        this.selectedID = selectedID;
    }    }

    