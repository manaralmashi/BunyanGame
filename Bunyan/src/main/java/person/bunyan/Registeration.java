/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;



import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public abstract class Registeration {

    protected Player player; // to get or set players
    protected GridPane grid = new GridPane(); // To organize the form, Use GridPane 
    protected BorderPane root;// orgnize the scene graph
    protected Button back, check; // Buttons well be used
    protected TextValidation validate = new TextValidation(); // to validate user inputs
    protected Label validateFName = new Label(""); // to display whether the name is accepted or not
    protected Label validateLName = new Label(""); // to display whether the name is accepted or not
    protected Label validateEmail = new Label("");
    // to display whether the email is accepted or not
    protected Label validatePass = new Label(""); // to display whether the pass is accepted or not
    protected Label validateAns = new Label(""); // to display whether the ans is accepted or not
    protected Label checklb = new Label(""); // to display whether the inputs is accepted or not
    protected Label labelEmail, labelPass, labelAns; // label describe the textfild
    protected TextField textEmail, pass, textAns; // to take inputs from the user
    protected TranslateTransition transtion; //make some transition
    protected ScaleTransition scale;  //make some transition
    protected StackPane backArc = new StackPane(); // to design the transition botton shape
    protected HBox boxForButtons; //place the botton at the bottom of the screen
    protected ImageView checkBack; // shape design 
    protected ImageView board;// shape design 
    protected ImageView arcRStayle, arcLStayle;// shape design 
    protected ImageView arcR, arcL; // shape design 
    protected Image SceneBackground; // design
    protected BackgroundSize size; // design
    protected Background background; // design

    public Registeration() {
        initialize();
    }

    public void initialize() {
        // set Background  for the scenes -------------------------------------------------------------------------------------------------
        SceneBackground = new Image("file:BunyanImages/Lamis/Interface3.jpg");
        size = new BackgroundSize(1800, 1000, false, false, false, false);
        background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));

        // Formatting and designing the bottons ------------------------------------------------------------------------------------------
        
        backArc = new StackPane();
        back = new Button();
        

        arcLStayle = new ImageView("file:BunyanImages/Lamis/ArcgreenL.png");
        arcLStayle.setFitHeight(120);
        arcLStayle.setFitWidth(320);

        arcL = new ImageView("file:BunyanImages/Lamis/arcleft.png");
        arcL.setFitHeight(100);
        arcL.setFitWidth(300);
        back.setGraphic(arcL);
        back.setStyle("-fx-background-color: transparent");
        backArc.getChildren().addAll(arcLStayle, back);
        // background of the button 
        checkBack = new ImageView("file:BunyanImages/Lamis/check.png");
        checkBack.setFitHeight(100);
        checkBack.setFitWidth(300);
        // check button - verify everythin, format,data in the database --
        check = new Button("Check", checkBack);
        check.setContentDisplay(ContentDisplay.CENTER);
        check.setFont(Font.font("Starborn", 40));
        check.setTextFill(Color.WHITE);
        check.setStyle("-fx-background-color: transparent");
        check.setEffect(new DropShadow(10, 6, 6, Color.BLACK));
        // label displays, after verification ----------------------------
        checklb = new Label("", check);
        checklb.setContentDisplay(ContentDisplay.BOTTOM);
        checklb.setTextFill(Color.BROWN);
        checklb.setFont(Font.font("valoon", 25));
        checklb.setGraphicTextGap(0);
    }
    // validate email input ----------------------------------------------
    public boolean validateEmail() {
        // 1- does not contain spaces
        if (validate.ContainSpaces(textEmail.getText())) {
            validateEmail.setText("");
            validateEmail.setText("  Spaces, NOT ALLOWED");
            return false;
            // 2- if it is empty
        } else if (textEmail.getText().equals("")) {
            validateEmail.setText("");
            return false;
        } // 3-  not too long, it should be 50 at most
        else if (!validate.validLen(textEmail.getText())) {
            validateEmail.setText("");
            validateEmail.setText("  TOO Long!!");
            return false;
            //4-  does not contain Spical charcter
        } else if (!validate.ContainSpicalChar(textEmail.getText())) {
            validateEmail.setText("");
            validateEmail.setText("special char,Not allowed!!");
            return false;
            // 5- should be in email format
        } else if (!validate.validEmailFormat(textEmail.getText())) {
            validateEmail.setText("  must be in email format");
            return false;
        } else {
            validateEmail.setText(""); // if everything is correct 
            return true;
        }
    }

    // validate password input ----------------------------------------------
    public boolean validatePass() {
        // 1- does not contain spaces
        if (validate.ContainSpaces(pass.getText())) {
            validatePass.setText("");
            validatePass.setText("         Spaces, NOT ALLOWED");
            return false;
            // 2- if it is empty
        } else if (pass.getText().equals("")) {
            validatePass.setText("");
            return false;
        } // 3-  not too long, it should be 50 at most
        else if (!validate.validLen(pass.getText())) {
            validatePass.setText("");
            validatePass.setText("         TOO Long!!");
            return false;
            //4-  does not contain Spical charcter
        } else if (!validate.ContainSpicalChar(pass.getText())) {
            validatePass.setText("");
            validatePass.setText("special char,Not allowed!!");
            return false;
            // 5- should be in password format
        } else if (!validate.validPassFormat(pass.getText())) {
            validatePass.setText("begin with a letter,have letters and numbers");
            return false;
        } else {
            validatePass.setText(""); // if everything is correct 
            return true;
        }
    }
    // validate answer input ----------------------------------------------

    public boolean validateAns() {
        // 1- does not contain spaces
        if (validate.ContainSpaces(textAns.getText())) {
            validateAns.setText("");
            validateAns.setText("Spaces, NOT ALLOWED");
            return false;
        // 2- if it is empty 
        } else if(textAns.getText().equals("")){
            validateAns.setText("");
            return false;
        // 3-  not too long, it should be 50 at most
        }else if (!validate.validLen(textAns.getText())) {
            validateAns.setText("");
            validateAns.setText("TOO Long!!");
            return false;
        //4-  does not contain Spical charcter   
        } else if (!validate.ContainSpicalChar(textAns.getText())) {
            validateAns.setText("");
            validateAns.setText("special char,Not allowed!!");
            return false;
        } else {
            validateAns.setText(""); // if everything is correct 
            return true;
        }
    }

    // Effects on the screen, if there is an error in the input -----------
    public void Shake(TextField text) {
        transtion = new TranslateTransition(Duration.millis(50), text);
        transtion.setFromX(0f);
        transtion.setByX(10f);
        transtion.setCycleCount(2);
        transtion.setAutoReverse(true);
        transtion.playFromStart();
    }
    // Effects on the screen -------------------------------------------

    public void Scale(Button btn) {
        scale = new ScaleTransition(Duration.millis(2000));
        scale.setNode(btn);
        scale.setByX(-0.09);
        scale.setByY(-0.09);
        scale.setCycleCount(100);
        scale.setAutoReverse(true);
        scale.play();
    }

    public abstract boolean cheak(); // need it in every subclass, with different implementation

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
    
}
