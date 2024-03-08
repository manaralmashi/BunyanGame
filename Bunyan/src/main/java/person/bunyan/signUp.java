/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

/**
 *
 * @author لميس
 */
import java.util.List;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class signUp extends Registeration {

    private Label validateFName = new Label("");// to display whether the name is accepted or not
    private Label validateLName = new Label("");// to display whether the name is accepted or not
    private Label labelFname, labelLname; // label describe the textfild
    private TextField textFname, textLname; //take names from the user
    private ComboBox<String> boxQues; // display list of questions
    private Stage stage; // set the stage
    
    // constructors -------------------------------------------------------------------------------------

    public signUp() {
        super();

    }

    public signUp(Stage stage) {
        this.stage = stage;
    }

    //----------------------------------------------------------------------------------------------------
    public Scene Interface() {
        // SET the background to the root ----------------------------------------------------------------
        root = new BorderPane();
        root.setBackground(background);
        // -----------------------------------------------------------------------------------------------
        // The board behind the text 
        board = new ImageView("file:BunyanImages/Lamis/board2.png");
        board.setFitHeight(600);
        board.setFitWidth(1200);
        board.setEffect(new DropShadow(10, 5, 5, Color.BLACK));
        //-------------------------------------------------------------------------------------
        // Formatting and designing the format of labels and textfields 
        textFname = new TextField();
        textFname.setMinWidth(225);
        textFname.setMinHeight(40);
        textFname.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ;-fx-prompt-text-fill: white; -fx-text-fill: white");
        textFname.setFont(Font.font("valoon", 15));
        textFname.setPromptText("Enter Your First Name");
        // add the text field to the label content
        labelFname = new Label("First Name: ", textFname);
        labelFname.setTextFill(Color.WHITE);
        labelFname.setFont(Font.font("valoon", 25));
        labelFname.setContentDisplay(ContentDisplay.RIGHT);
        labelFname.setGraphicTextGap(5);
        //-------------------------------------------------------------------------------------
        textLname = new TextField();
        textLname.setMinWidth(225);
        textLname.setMinHeight(40);
        textLname.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ; -fx-prompt-text-fill: white; -fx-text-fill: white");
        textLname.setFont(Font.font("valoon", 15));
        textLname.setPromptText("Enter Your Last Name");
        // add the text field to the label content
        labelLname = new Label("Last Name: ", textLname);
        labelLname.setTextFill(Color.WHITE);
        labelLname.setFont(Font.font("valoon", 25));
        labelLname.setContentDisplay(ContentDisplay.RIGHT);
        labelLname.setGraphicTextGap(5);
        // ------------------------------------------------------------------------------------
        textEmail = new TextField();
        textEmail.setMinWidth(250);
        textEmail.setMinHeight(40);
        textEmail.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ; -fx-prompt-text-fill: white; -fx-text-fill: white");
        textEmail.setFont(Font.font("valoon", 15));
        textEmail.setPromptText("Ex: Bynuan@gmail.com");
        // add the text field to the label content
        labelEmail = new Label("E-mail: ", textEmail);
        labelEmail.setTextFill(Color.WHITE);
        labelEmail.setFont(Font.font("valoon", 25));
        labelEmail.setContentDisplay(ContentDisplay.RIGHT);
        labelEmail.setGraphicTextGap(45);
        // -------------------------------------------------------------------------------------
        pass = new PasswordField();
        pass.setMinWidth(250);
        pass.setMinHeight(40);
        pass.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ; -fx-prompt-text-fill: white; -fx-text-fill: white");
        pass.setFont(Font.font("valoon", 15));
        pass.setPromptText("contain number and letters");
        // add the text field to the label content
        labelPass = new Label("Password: ", pass);
        labelPass.setTextFill(Color.WHITE);
        labelPass.setFont(Font.font("valoon", 25));
        labelPass.setContentDisplay(ContentDisplay.RIGHT);
        labelPass.setGraphicTextGap(5);

        textAns = new TextField();
        textAns.setMinWidth(225);
        textAns.setMinHeight(40);
        textAns.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ; -fx-prompt-text-fill: white; -fx-text-fill: white");
        textAns.setFont(Font.font("valoon", 15));
        textAns.setPromptText("Enter Your Answer");
        // add the text field to the label content
        labelAns = new Label("Answer: ", textAns);
        labelAns.setTextFill(Color.WHITE);
        labelAns.setFont(Font.font("valoon", 25));
        labelAns.setContentDisplay(ContentDisplay.RIGHT);
        labelAns.setGraphicTextGap(5);
        //----------------------------------------------------------------------------------------------

        Label lbHint = new Label("to recover your password:");
        lbHint.setTextFill(Color.WHITESMOKE);
        lbHint.setFont(Font.font("valoon", 25));
        //----------------------------------------------------------------------------------------------
        Label lbSign = new Label("Sign UP: ");
        lbSign.setFont(Font.font("Starborn", 80));
        lbSign.setTextFill(Color.WHITE);

        // --------------------------------------------------------------------------------------
        // Formatting and designing the format of combobox 
        String[] ques = {"your favorite teacher", "your favorite sport", "your favorite food", "your favorite subject"};
        boxQues = new ComboBox<>();
        boxQues.setStyle("-fx-background-color: rgba(141, 74, 87,0.8); -fx-background-radius: 20 ; -fx-font-family:valoon; -fx-font-size:20;");
        // cell factory to define the color or foems of the current cell, this can not be done by applying CSS rules
        boxQues.setCellFactory(param
                -> new ComboBoxListCell<String>() {
            {
                setTextFill(Color.WHITE);
                setBackground(new Background(new BackgroundFill(Color.rgb(141, 74, 87, 0.9), null, null)));
            }
        });
        boxQues.setMinSize(250, 40);
        boxQues.setEditable(true);
        boxQues.setValue("your favorite teacher");
        boxQues.setVisibleRowCount(4);
        boxQues.getItems().addAll(ques);
        boxQues.setEditable(false);
        // add the ComboBox to the label content --------------------------------------------------------
        Label labelQues = new Label("Choose:", boxQues);
        labelQues.setTextFill(Color.WHITE);
        labelQues.setFont(Font.font("valoon", 25));
        labelQues.setContentDisplay(ContentDisplay.RIGHT);
        // ----------------------------------------------------------------------------------------------

        // arrange the format, and set the label to assist user with input ------------------------------
        validateFName = new Label("", labelFname);
        validateFName.setContentDisplay(ContentDisplay.TOP);
        validateFName.setTextFill(Color.ROSYBROWN);
        validateFName.setFont(Font.font("valoon", 20));

        validateLName = new Label("", labelLname);
        validateLName.setContentDisplay(ContentDisplay.TOP);
        validateLName.setTextFill(Color.ROSYBROWN);
        validateLName.setFont(Font.font("valoon", 20));

        validateEmail = new Label("", labelEmail);
        validateEmail.setContentDisplay(ContentDisplay.TOP);
        validateEmail.setTextFill(Color.ROSYBROWN);
        validateEmail.setFont(Font.font("valoon", 20));

        validatePass = new Label("", labelPass);
        validatePass.setContentDisplay(ContentDisplay.TOP);
        validatePass.setTextFill(Color.ROSYBROWN);
        validatePass.setFont(Font.font("valoon", 15));

        validateAns = new Label("", labelAns);
        validateAns.setContentDisplay(ContentDisplay.TOP);
        validateAns.setTextFill(Color.ROSYBROWN);
        validateAns.setFont(Font.font("valoon", 15));

        grid.add(validateFName, 0, 0);
        grid.add(validateLName, 1, 0);
        grid.add(validateEmail, 0, 1);
        grid.add(validatePass, 0, 2);
        grid.add(lbHint, 0, 3);
        grid.add(labelQues, 0, 4);
        grid.add(validateAns, 1, 4);
        grid.setHgap(10);
        grid.setVgap(40);
        grid.setAlignment(Pos.CENTER);
        // to add the grid above the board ------------------------------------------------------------
        StackPane stack = new StackPane(board, grid);
        //---------------------------------------------------------------------------------------------
        // add them to hbox to be in the same level ---------------------------------------------------
        boxForButtons = new HBox(200);
        boxForButtons.setPadding(new Insets(0, 0, 25, 0));
        boxForButtons.setAlignment(Pos.TOP_LEFT);
        boxForButtons.getChildren().addAll(backArc, checklb);
        boxForButtons.setLayoutY(-20);
        // ACTIONS -------------------------------------------------------------------------------------
        // KeyTyped Action:
        // key Typed -----------------------------------------------------------------------------------
        textFname.setOnKeyTyped(e -> {

            if (validateFName()) {
                textFname.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ;-fx-prompt-text-fill: white; -fx-text-fill: white");

            } else {
                textFname.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ;-fx-prompt-text-fill: white; -fx-text-fill: red; ");
            }

        });

        textLname.setOnKeyTyped(e -> {
            if (validateLName()) {
                textLname.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ;-fx-prompt-text-fill: white; -fx-text-fill: white");

            } else {
                textLname.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ;-fx-prompt-text-fill: white; -fx-text-fill: red");
            }
        }
        );

        textEmail.setOnKeyTyped(e -> {
            if (validateEmail()) {
                textEmail.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ;-fx-prompt-text-fill: white; -fx-text-fill: white");

            } else {
                textEmail.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ;-fx-prompt-text-fill: white; -fx-text-fill: red");
            }
        });

        pass.setOnKeyTyped(e -> {
            if (validatePass()) {
                pass.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ;-fx-prompt-text-fill: white; -fx-text-fill: white");

            } else {
                pass.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ;-fx-prompt-text-fill: white; -fx-text-fill: red");
            }
        });

        textAns.setOnKeyTyped(e -> {
            if (validateAns()) {
                textAns.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ;-fx-prompt-text-fill: white; -fx-text-fill: white");

            } else {
                textAns.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 20 ;-fx-prompt-text-fill: white; -fx-text-fill: red");
            }
        });
        // key pressed
        textFname.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (textFname.getText() == "" || !validateFName()) {
                    Shake(textFname);

                }
            }

        });
        // --------------------------------------------
        textLname.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (textLname.getText() == "" || !validateLName()) {
                    Shake(textLname);

                }
            }

        });
        // ---------------------------------------------
        textEmail.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (textEmail.getText() == "" || !validateEmail()) {
                    Shake(textEmail);

                }
            }

        });
        // ---------------------------------------------
        pass.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (pass.getText() == "" || !validatePass()) {
                    Shake(pass);

                }
            }

        });
        // ---------------------------------------------
        textAns.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (textAns.getText() == "" || !validateAns()) {
                    Shake(textAns);

                }
            }

        });
        // ---------------------------------------------

        // Mouse Action -----------------------------------------------------------------------------
        textFname.setOnMouseEntered(e -> {
            textFname.setScaleX(1.1);
            textFname.setScaleY(1.1);

        });
        textFname.setOnMouseExited(e -> {
            textFname.setScaleX(1.0);
            textFname.setScaleY(1.0);

        });
        // ------------------------------------------
        textLname.setOnMouseEntered(e -> {
            textLname.setScaleX(1.1);
            textLname.setScaleY(1.1);

        });
        textLname.setOnMouseExited(e -> {
            textLname.setScaleX(1.0);
            textLname.setScaleY(1.0);

        });
        // -------------------------------------------
        textEmail.setOnMouseEntered(e -> {
            textEmail.setScaleX(1.1);
            textEmail.setScaleY(1.1);

        });
        textEmail.setOnMouseExited(e -> {
            textEmail.setScaleX(1.0);
            textEmail.setScaleY(1.0);

        });
        // -------------------------------------------
        pass.setOnMouseEntered(e -> {
            pass.setScaleX(1.1);
            pass.setScaleY(1.1);

        });
        pass.setOnMouseExited(e -> {
            pass.setScaleX(1.0);
            pass.setScaleY(1.0);

        });
        // -------------------------------------------
        textAns.setOnMouseEntered(e -> {
            textAns.setScaleX(1.1);
            textAns.setScaleY(1.1);

        });
        textAns.setOnMouseExited(e -> {
            textAns.setScaleX(1.0);
            textAns.setScaleY(1.0);

        });
        // --------------------------------------------- 

        check.setOnMouseEntered(e -> {
            check.setScaleX(1.15);
            check.setScaleY(1.15);
        });
        check.setOnMouseExited(e -> {
            check.setScaleX(1.0);
            check.setScaleY(1.0);
        });

//        next.setOnMouseEntered(e->{
//            scale.pause();
//            next.setScaleX(1.15);
//            next.setScaleY(1.15);
//        });
//        next.setOnMouseExited(e->{
//            next.setScaleX(1.0);
//            next.setScaleY(1.0);
//        });
//        back.setOnMouseEntered(e->{
//            back.setScaleX(1.15);
//            back.setScaleY(1.15);
//        });
//        back.setOnMouseExited(e->{
//            back.setScaleX(1.0);
//            back.setScaleY(1.0);
//        });
        // Set OnAction -------------------------------------------------------------------------------
        check.setOnAction(e -> {
            if (!cheak()) {
                checklb.setText("please enter a valid inputs");
            } else {

                if (DBstore()) {
                    checklb.setText("Welcome " + textFname.getText() + " !!"); ///// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!111
//                    next.setDisable(false);
//                    Scale(next);
                } else {
                    Shake(textEmail);
                    checklb.setText("please enter a valid inputs");

                }
            }

        });

        back.setOnAction(e -> {
            stage.setScene(new logIn(stage).Interface());
        });

        // ---------------------------------------------------------------------------------------------
        // Add all the above to the root ---------------------------------------------------------------
        root.setCenter(stack);
        root.setTop(lbSign);
        root.setBottom(boxForButtons);
        root.setAlignment(lbSign, Pos.CENTER);

        Scene scene = new Scene(root, 1500, 800);
        return scene;
    }

    // verifies that the first name entry is correct ---------------------------------------------------
    public boolean validateFName() {
        //1-  does not contain spaces 
        if (validate.ContainSpaces(textFname.getText())) {
            validateFName.setText("");
            validateFName.setText("Spaces, NOT ALLOWED");
            return false;        
            // 2-  not too long, it should be 50 at most
        } else if (!validate.validLen(textFname.getText())) {
            validateFName.setText("");
            validateFName.setText("TOO Long!!");
            return false;
            //3-  does not contain Spical charcter   
        } else if (!validate.ContainSpicalChar(textFname.getText())) {
            validateFName.setText("");
            validateFName.setText("special char,Not allowed!!");
            return false;
        } else {
            // if everything is correct
            validateFName.setText("");
            return true;
        }
    }

    // verifies that the last name entry is correct -------------------------------------------------------
    public boolean validateLName() {
        //1-  does not contain spaces 
        if (validate.ContainSpaces(textLname.getText())) {
            validateLName.setText("");
            validateLName.setText("Spaces, NOT ALLOWED");
            return false;
            // 2-  not too long, it should be 50 at most
        } else if (!validate.validLen(textLname.getText())) {
            validateLName.setText("");
            validateLName.setText("TOO Long!!");
            return false;
            //3-  does not contain Spical charcter   
        } else if (!validate.ContainSpicalChar(textLname.getText())) {
            validateLName.setText("");
            validateLName.setText("special char,Not allowed!!");
            return false;
        } else {
            // if everything is correct
            validateLName.setText("");
            return true;
        }
    }

    // to ensure that all fields are entered correctly --------------------------------
    public boolean cheak() {
        boolean check = true;
        if (!validateFName() || textFname.getText() == "") {
            Shake(textFname);
            check = false;
        }
        if (!validateLName() || textLname.getText() == "") {
            Shake(textLname);
            check = false;
        }
        if (!validateEmail() || textEmail.getText() == "") {
            Shake(textEmail);
            check = false;

        }
        if (!validatePass() || pass.getText() == "") {
            Shake(pass);
            check = false;
        }
        if (!validateAns() || textAns.getText() == "") {
            Shake(textAns);
            check = false;

        }

        return check;
    }

    // it stores the data in the data base and if it correct returns true,if there is an error it returns false
    public boolean DBstore() {
        boolean reg = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        // Check if the player already exists
        String q = "from Player where PlayerEmail = :email";
        Query query = session.createQuery(q);
        query.setParameter("email", textEmail.getText());

        player = (Player) query.uniqueResult();

        if (player == null) {
            // player does not exist, so save the player information
            player = new Player();
            player.setFname(textFname.getText());
            player.setLname(textLname.getText());
            player.setPlayerEmail(textEmail.getText());
            player.setPlayerPass(pass.getText());
            player.setPlayerQues(boxQues.getValue());
            player.setPlayerAns(textAns.getText());
            player.setAvatar("U0");
            session.save(player);
            reg = true;

        } else {
            // player already exists
            validateEmail.setText("User already registered!");
        }

        t.commit();
        session.close();
        return reg;
    }

    // setters and getters --------------------------------------------------------------------------
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
