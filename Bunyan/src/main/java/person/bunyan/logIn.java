/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class logIn extends Registeration {

    private Label defSignlb, signlb, defForgetlb, forgetlb;
    private Stage stage;
    private Button next;
    private Start_Interface startObj = new Start_Interface();
    private StackPane nextArc; // to design the transition botton shape

    // constructors -------------------------------------------------------------------------------------
    logIn() {
        super();
    }

    logIn(Stage stage) {
        super();
        this.stage = stage;
    }

    //---------------------------------------------------------------------------------------------------
    public Scene Interface() {
        // SET the background to the root ---------------------------------------------------------------
        root = new BorderPane();
        root.setBackground(background);
        // -----------------------------------------------------------------------------------------------
        // The board behind the text 
        board = new ImageView("file:BunyanImages/Lamis/boardLog.png");
        board.setFitHeight(580);
        board.setFitWidth(900);
        board.setEffect(new DropShadow(10, 5, 5, Color.BLACK));
        //-----------------------------------------------------------------------------------------------
        // Formatting and designing the format of labels and textfields 
        textEmail = new TextField();
        textEmail.setMinWidth(280);
        textEmail.setMinHeight(40);
        textEmail.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;");
        textEmail.setFont(Font.font("valoon", 15));
        textEmail.setPromptText("Ex: Bynuan@gmail.com");
        textEmail.setEffect(new DropShadow(10, 8, 8, Color.BROWN));
        // add the text field to the label content -------------------------------------------------------
        labelEmail = new Label("       E-mail:     ", textEmail);
        labelEmail.setTextFill(Color.WHITE);
        labelEmail.setFont(Font.font("valoon", 40));
        labelEmail.setContentDisplay(ContentDisplay.RIGHT);
        labelEmail.setGraphicTextGap(45);
        // -----------------------------------------------------------------------------------------------
        pass = new PasswordField();
        pass.setMinWidth(280);
        pass.setMinHeight(40);
        pass.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;");
        pass.setFont(Font.font("valoon", 15));
        pass.setPromptText("contain number and letters");
        pass.setEffect(new DropShadow(10, 8, 8, Color.BROWN));
        // add the text field to the label content
        labelPass = new Label("      Password:    ", pass);
        labelPass.setTextFill(Color.WHITE);
        labelPass.setFont(Font.font("valoon", 40));
        labelPass.setContentDisplay(ContentDisplay.RIGHT);
        labelPass.setGraphicTextGap(5);
        // arrange the format, and set the label to assist user with input -------------------------------
        validatePass = new Label("", labelPass);
        validatePass.setContentDisplay(ContentDisplay.TOP);
        validatePass.setTextFill(Color.BISQUE);
        validatePass.setFont(Font.font("valoon", 20));

        validateEmail = new Label("", labelEmail);
        validateEmail.setContentDisplay(ContentDisplay.TOP);
        validateEmail.setTextFill(Color.BISQUE);
        validateEmail.setFont(Font.font("valoon", 20));
        // -----------------------------------------------------------------------------------------------
        signlb = new Label("Sign Now");
        signlb.setTextFill(Color.BEIGE);
        signlb.setFont(Font.font("Starborn", 25));
        signlb.setUnderline(true);

        defSignlb = new Label("Don't have an account? ", signlb);
        defSignlb.setContentDisplay(ContentDisplay.RIGHT);
        defSignlb.setTextFill(Color.WHITE);
        defSignlb.setFont(Font.font("valoon", 25));

        forgetlb = new Label("retrieve");
        forgetlb.setTextFill(Color.BEIGE);
        forgetlb.setFont(Font.font("Starborn", 25));
        forgetlb.setUnderline(true);
        defForgetlb = new Label("Forget your Password? ", forgetlb);
        defForgetlb.setContentDisplay(ContentDisplay.RIGHT);
        defForgetlb.setTextFill(Color.WHITE);
        defForgetlb.setFont(Font.font("valoon", 25));
        // ------------------------------------------------------------------------------------------------
        // GRID display format ---------------------------------------------------------------------------- 
        ColumnConstraints col = new ColumnConstraints();
        col.setMinWidth(500);
        col.setHalignment(HPos.CENTER);
        grid.getColumnConstraints().add(col);
        grid.add(validateEmail, 0, 0);
        grid.add(validatePass, 0, 1);
        grid.add(defSignlb, 0, 2);
        grid.add(defForgetlb, 0, 3);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(30);
        grid.setAlignment(Pos.CENTER);
        // to add the grid above the board -----------------------------------------------------------------
        StackPane stack = new StackPane(board, grid);
        root.setCenter(stack);

        // -------------------------------------------------------------------------------------------------
        // -------------------------------------------------------------------------------------------------
        nextArc = new StackPane();
        next = new Button();
        Scale(back);
        next.setDisable(true);
        arcRStayle = new ImageView("file:BunyanImages/Lamis/ArcGreenR.png");
        arcRStayle.setFitHeight(120);
        arcRStayle.setFitWidth(320);

        arcR = new ImageView("file:BunyanImages/Lamis/buttonArc.png");
        arcR.setFitHeight(100);
        arcR.setFitWidth(300);
        next.setGraphic(arcR);
        next.setStyle("-fx-background-color: transparent");
        nextArc.getChildren().addAll(arcRStayle, next);
        //--------------------------------------------------------------------------------------------------
        // add them to hbox to be in the same level
        boxForButtons = new HBox(220);
        boxForButtons.setPadding(new Insets(0, 0, 25, 0));
        boxForButtons.setAlignment(Pos.TOP_RIGHT);
        boxForButtons.getChildren().addAll(checklb, nextArc);
        root.setBottom(boxForButtons);
        // Actions -----------------------------------------------------------------------------------------------------------
        // Mouse Events ------------------------------------------------------------------------------------------------------
        signlb.setOnMousePressed(e -> {
            stage.setScene(new signUp(stage).Interface());
        });
        forgetlb.setOnMousePressed(e -> {
            stage.setScene(new ForgetPass(stage).Interface());
        });
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
        signlb.setOnMouseEntered(e -> {
            signlb.setScaleX(1.1);
            signlb.setScaleY(1.1);

        });
        signlb.setOnMouseExited(e -> {
            signlb.setScaleX(1.0);
            signlb.setScaleY(1.0);

        });
        // -------------------------------------------
        forgetlb.setOnMouseEntered(e -> {
            forgetlb.setScaleX(1.1);
            forgetlb.setScaleY(1.1);

        });
        forgetlb.setOnMouseExited(e -> {
            forgetlb.setScaleX(1.0);
            forgetlb.setScaleY(1.0);

        });
        check.setOnMouseEntered(e -> {
            check.setScaleX(1.15);
            check.setScaleY(1.15);
        });
        check.setOnMouseExited(e -> {
            check.setScaleX(1.0);
            check.setScaleY(1.0);
        });

        // ----------------------------------------------------------------------------------------------------------------------
        // KeyBoard Actions -----------------------------------------------------------------------------------------------------
        textEmail.setOnKeyTyped(e -> {
            if (validateEmail()) {
                textEmail.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;");

            } else {
                textEmail.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;-fx-text-fill:red");
            }
        });

        pass.setOnKeyTyped(e -> {
            if (validatePass()) {
                pass.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;");

            } else {
                pass.setStyle("-fx-background-color: white; -fx-background-radius: 20 ; -fx-prompt-text-fill: brown; -fx-border-width:2;-fx-border-color:black;-fx-border-radius:20;-fx-text-fill:red");
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
        //--------------------------------------------------------------------------------------------------------------------
        // ON action ---------------------------------------------------------------------------------------------------------
        check.setOnAction(e -> {

            if (!cheak()) {
                checklb.setText("please enter a valid inputs");
            } else {
                if (DBretrieve()) {
                    checklb.setText("Welcome " + player.getFname() + " !!"); // FROM DATABASE
                    next.setDisable(false);
                    Scale(next);
                }

            }
        });

        next.setOnAction(e -> {
//            startObj = new Start_Interface();
            startObj.setPlayer(player);
            stage.setScene(startObj.start(stage));
        });

        Scene scene = new Scene(root, 1500, 800);
        return scene;
    }

    // to ensure that all fields are entered correctly -----------------------------------------------------------------------
    public boolean cheak() {
        boolean check = true;

        if (!validateEmail() || textEmail.getText() == "") {
            Shake(textEmail);
            check = false;
        }
        if (!validatePass() || pass.getText() == "") {
            Shake(pass);
            check = false;
        }

        return check;
    }

    // -----------------------------------------------------------------------------------------------
    // retrieves data from the databas, returns true if the data is correct and exists, returns false if there is a problem
    public boolean DBretrieve() {
        boolean reg = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        // Check if the user already exists
        try {

            String q = "from Player where PlayerEmail = :email";
            Query query = session.createQuery(q);
            query.setParameter("email", textEmail.getText());

            player = (Player) query.uniqueResult();

            if (!(player == null)) {
                // player does not exist, so save the player information
                if (player.getPlayerPass().equals(pass.getText())) {
                    reg = true;
                } else {
                    checklb.setText("you can recover the password");
                    validatePass.setText("password is incorrect!");
                    Shake(pass);

                }
            } else {
                // player already exists
                Shake(textEmail);
                validateEmail.setText("Email not found");

                checklb.setText("doesn't exist");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            t.commit();
            session.close();
        }
        return reg;
    }

    // setters and getters ------------------------------------------------------------------------------
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Start_Interface getStartObj() {
        return startObj;
    }

}
