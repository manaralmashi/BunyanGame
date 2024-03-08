/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;


/**
 *
 * @author لميس
 */
import javafx.stage.Stage;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ForgetPass extends Registeration {

    private Label labelQues;
    private TextField textQues;
    private Stage stage;

    public ForgetPass(Stage stage) {
        this.stage = stage;
    }

    public Scene Interface() {
        // SET the background to the root ---------------------------------------------------------------
        root = new BorderPane();
        root.setBackground(background);
        // ----------------------------------------------------------------------------------------------
        // The board behind the text 
        board = new ImageView("file:BunyanImages/Lamis/boardLog.png");
        board.setFitHeight(580);
        board.setFitWidth(900);
        board.setEffect(new DropShadow(10, 5, 5, Color.BLACK));
        //-----------------------------------------------------------------------------------------------
        // Formatting and designing the format of labels and textfields
        textEmail = new TextField();
        textEmail.setMinWidth(300);
        textEmail.setMinHeight(40);
        textEmail.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;");
        textEmail.setFont(Font.font("valoon", 15));
        textEmail.setPromptText("Ex: Bynuan@gmail.com");
        textEmail.setEffect(new DropShadow(10, 8, 8, Color.BROWN));
        // add the text field to the label content
        labelEmail = new Label("     E-mail:     ", textEmail);
        labelEmail.setTextFill(Color.WHITE);
        labelEmail.setFont(Font.font("valoon", 40));
        labelEmail.setContentDisplay(ContentDisplay.BOTTOM);

        textQues = new TextField();
        textQues.setMinWidth(450);
        textQues.setMinHeight(50);
        textQues.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;");
        textQues.setFont(Font.font("valoon", 25));
        textQues.setDisable(true);
        textQues.setAlignment(Pos.CENTER);
        
        // add the text field to the label content
        labelQues = new Label("Question: ", textQues);
        labelQues.setTextFill(Color.WHITE);
        labelQues.setFont(Font.font("valoon", 25));
        labelQues.setContentDisplay(ContentDisplay.BOTTOM);
        labelQues.setGraphicTextGap(5);

        textAns = new TextField();
        textAns.setMinWidth(300);
        textAns.setMinHeight(40);
        textAns.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;");
        textAns.setFont(Font.font("valoon", 15));
        textAns.setPromptText("Enter Your Answer");
        textAns.setDisable(true);
        // add the text field to the label content
        labelAns = new Label("Answer: ", textAns);
        labelAns.setTextFill(Color.WHITE);
        labelAns.setFont(Font.font("valoon", 25));
        labelAns.setContentDisplay(ContentDisplay.BOTTOM);
        labelAns.setGraphicTextGap(5);

        // arrange the format, and set the label to assist user with input -------------------------------
        validateEmail = new Label("you should enter your email, and prss Enter key", labelEmail);
        validateEmail.setContentDisplay(ContentDisplay.TOP);
        validateEmail.setTextFill(Color.BISQUE);
        validateEmail.setFont(Font.font("valoon", 20));

        validateAns = new Label("", labelAns);
        validateAns.setContentDisplay(ContentDisplay.TOP);
        validateAns.setTextFill(Color.ROSYBROWN);
        validateAns.setFont(Font.font("valoon", 15));
        // -----------------------------------------------------------------------------------------------
        // transparent rectangles, only to fix the shape 
        Rectangle rec1 = new Rectangle(100, 20);
        rec1.setFill(Color.TRANSPARENT);
        HBox arrange = new HBox(rec1, labelQues);
        arrange.setAlignment(Pos.CENTER);
        arrange.setMinWidth(400);

        Rectangle rec2 = new Rectangle(100, 20);
        rec2.setFill(Color.TRANSPARENT);
        HBox arrange2 = new HBox(rec2, validateAns);
        arrange2.setAlignment(Pos.CENTER);
        arrange2.setMinWidth(400);

        Rectangle rec3 = new Rectangle(100, 20);
        rec3.setFill(Color.TRANSPARENT);
        HBox arrange3 = new HBox(rec3, validateEmail);
        arrange3.setAlignment(Pos.CENTER);
        arrange3.setMinWidth(400);
        // add them to the grid 
        grid.add(arrange3, 0, 0);
        grid.add(arrange, 0, 1);
        grid.add(arrange2, 0, 2);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(30);
        grid.setAlignment(Pos.CENTER);
        // to add the grid above the board ------------------------------
        StackPane stack = new StackPane(board, grid);
        root.setCenter(stack);
        // -----------------------------------------------------------------------------------------------------------------
        // add them to hbox to be in the same level
        HBox boxForButtons = new HBox(220);
        boxForButtons.setPadding(new Insets(0, 0, 25, 0));
        boxForButtons.setAlignment(Pos.TOP_LEFT);
        boxForButtons.getChildren().addAll(backArc, checklb);
        root.setBottom(boxForButtons);

        // Actions 
        // Mouse Events ---------------------------------------------------------------------------------------------------
        textEmail.setOnMouseEntered(e -> {
            textEmail.setScaleX(1.1);
            textEmail.setScaleY(1.1);
        });
        textEmail.setOnMouseExited(e -> {
            textEmail.setScaleX(1.0);
            textEmail.setScaleY(1.0);

        });

        textAns.setOnMouseEntered(e -> {
            textAns.setScaleX(1.1);
            textAns.setScaleY(1.1);

        });
        textAns.setOnMouseExited(e -> {
            textAns.setScaleX(1.0);
            textAns.setScaleY(1.0);

        });
        check.setOnMouseEntered(e -> {
            check.setScaleX(1.1);
            check.setScaleY(1.1);

        });
        check.setOnMouseExited(e -> {
            check.setScaleX(1.0);
            check.setScaleY(1.0);

        });

        // ----------------------------------------------------------------------------------------------------------------
        // KeyBoard Actions -----------------------------------------------------------------------------------------------
        textAns.setOnKeyTyped(e -> {
            if (validateAns()) {
                textAns.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;");

            } else {
                textAns.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;-fx-text-fill:red");
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
        textEmail.setOnKeyTyped(e -> {
            if (validateEmail()) {
                textEmail.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;");

            } else {
                textEmail.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;-fx-text-fill:red");
            }
        });

        textEmail.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (textEmail.getText() == "" || !validateEmail()) {
                    Shake(textEmail);
                } else {
                    if (retrieve()) {
                        textAns.setDisable(false);
                        textEmail.setDisable(true);
                    }
                }
            }

        });

//        textEmail.setOnKeyReleased(e->{
//         if (e.getCode() == KeyCode.ENTER) {
//                if (textEmail.getText() == "" || !validateEmail()) {
//                    Shake(textEmail);
//                } else {
//
//                    if (getEmail()) {
//                        getQues();
//                        textAns.setDisable(false);
//                        textEmail.setDisable(true);
//                    } else {
//                        Shake(textEmail);
//                         validateEmail.setText("Not Found");
//                        
//                    }
//                }
//            }
//                
//        });

        // ----------------------------------------------------------------------------------------
        // ON action ------------------------------------------------------------------------------
        check.setOnAction(e -> {

            if (!cheak()) {
                checklb.setText("please enter a valid inputs");
            } else {

                if(retrieve()){
                    if (!validateAns() || textAns.getText() == "") {
                        Shake(textAns);
                    }

                    else {if (Anscheck()) {
                    checklb.setText("");
                    checklb.setText("Welcome " + player.getFname() + " your pass:\n" + player.getPlayerPass()); // FROM DATABASE
                    checklb.setTextAlignment(TextAlignment.CENTER);
//                    next.setDisable(false);
                    textAns.setDisable(true);
//                    Scale(next); //---------------------------------------------------------------
                }}
                }
            }
            
        });

        back.setOnAction(e -> {
            stage.setScene(new logIn(stage).Interface());
        });

        Scene scene = new Scene(root, 1500, 800);
        return scene;

    }

    // to ensure that all fields are entered correctly --------------------------------
    public boolean cheak() {
        boolean check = true;
        if (!validateEmail() || textEmail.getText() == "") {
            Shake(textEmail);
            check = false;
        }
        

        return check;
    }
    // overrise, just to add a label when the textfield is empty

    public boolean validateEmail() {

        if (validate.ContainSpaces(textEmail.getText())) {
            validateEmail.setText("");
            validateEmail.setText("  Spaces, NOT ALLOWED");
            return false;
        } else if (textEmail.getText().equals("")) {
            validateEmail.setText("you should enter your email, and prss Enter key");
            return false;
        } else if (!validate.validLen(textEmail.getText())) {
            validateEmail.setText("");
            validateEmail.setText("  TOO Long!!");
            return false;
        } else if (!validate.ContainSpicalChar(textEmail.getText())) {
            validateEmail.setText("");
            validateEmail.setText("special char,Not allowed!!");
            return false;
        } else if (!validate.validEmailFormat(textEmail.getText())) {
            validateEmail.setText("  must be in email format");
            return false;
        } else {
            validateEmail.setText("");
            return true;
        }
    }

    // get the player information from the database if it is exists and return true, else return false
    public boolean retrieve() {
        boolean ret = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        // Check if the user already exists
        String q = "from Player where PlayerEmail = :email";
        Query query = session.createQuery(q);
        query.setParameter("email", textEmail.getText());
        
        player = (Player) query.uniqueResult();
        if (!(player == null)) {
            // player does exist, so return the player information
            textQues.setText(player.getPlayerQues());
            textAns.setDisable(false);
            textEmail.setDisable(true);
            ret = true;
        } else {
            // player not found 
            Shake(textEmail);
            validateEmail.setText("Email not found");
            checklb.setText("doesn't exist");
        }
        return ret;
    }

    // check if the answer equal the stored one, will return true,else false
    public boolean Anscheck() {
        boolean ch = false;
        if (player.getPlayerAns().equals(textAns.getText())) {
            ch = true;
        } else if (textAns.getText().equals("")) {
            checklb.setText("");
        } else {
            checklb.setText("you can register if you want");
            validateAns.setText("your answer is incorrect!");
            Shake(textAns);

        }

        return ch;
    }

    // setters and getters ---------------------------------------------------------------------
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
