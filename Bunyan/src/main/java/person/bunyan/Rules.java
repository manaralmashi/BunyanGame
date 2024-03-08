/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;


import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;
//--------------------------
import javafx.animation.*;
import javafx.scene.effect.BoxBlur;
import javafx.util.Duration;

public class Rules {

    private Stage stage;
    private TimeAndcoins time;
    MovingTimeCounter movingTimeCounter = new MovingTimeCounter();
    Levels_Interface levels;
      Start_Interface startLv1 ;

  
       Rules(Stage stage,TimeAndcoins TCT,Start_Interface startObjectFromLv){
       this.stage= stage ;
       this.time = TCT;
       this.startLv1 =startObjectFromLv;
    }
       public Scene Rules(int i) {
     
//------------------------------------------------------------  
//------------------------------------------------------------   
//Bottom :        
        ImageView BackroundRadioButton1 = new ImageView (new Image("file:BunyanImages/Murooj/BackroundRadioButton.png"));
        BackroundRadioButton1.setFitHeight(50);
        BackroundRadioButton1.setFitWidth(50);
        
        ImageView BackroundRadioButton2 = new ImageView (new Image("file:BunyanImages/Murooj/BackroundRadioButton.png"));
        BackroundRadioButton2.setFitHeight(50);
        BackroundRadioButton2.setFitWidth(50);
        
        ImageView BackroundRadioButton3 = new ImageView (new Image("file:BunyanImages/Murooj/BackroundRadioButton.png"));
        BackroundRadioButton3.setFitHeight(50);
        BackroundRadioButton3.setFitWidth(50);
        
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton Task1RadioButton = new RadioButton();
        RadioButton Task2RadioButton = new RadioButton();
        RadioButton Task3RadioButton = new RadioButton();
        
        Label Task1Label = new Label(" Task 1 ");
        Label Task2Label = new Label(" Task 2 ");
        Label Task3Label = new Label(" Task 3 ");
        
        Task1Label.setFont(Font.font("Valoon", 20));
        Task2Label.setFont(Font.font("Valoon", 20));
        Task3Label.setFont(Font.font("Valoon", 20));
        
        Task1Label.setTextFill(Color.rgb(255, 242, 204));
        Task2Label.setTextFill(Color.rgb(255, 242, 204));
        Task3Label.setTextFill(Color.rgb(255, 242, 204));
        
        Task1RadioButton.setToggleGroup(toggleGroup);
        Task2RadioButton.setToggleGroup(toggleGroup);
        Task3RadioButton.setToggleGroup(toggleGroup);
        
        HBox TasksLabelBox  = new HBox(60, Task1Label, Task2Label, Task3Label);
        TasksLabelBox.setTranslateY(12);
        
        HBox BackroundRadioButtonBox = new HBox(95, BackroundRadioButton1, BackroundRadioButton2, BackroundRadioButton3);
        HBox RadioButtonBox = new HBox(127, Task1RadioButton, Task2RadioButton, Task3RadioButton);
        RadioButtonBox.setTranslateX(15);
        RadioButtonBox.setTranslateY(15);
        StackPane TaskRadioButtonStack = new StackPane(BackroundRadioButtonBox, RadioButtonBox);
        TaskRadioButtonStack.setTranslateX(10);
        VBox BottomBox = new VBox(-20, TaskRadioButtonStack, TasksLabelBox);
        BottomBox.setTranslateY(-100);
        BottomBox.setTranslateX(550);

        
        NodeSize(Task1RadioButton);
        NodeSize(Task2RadioButton);
        NodeSize(Task3RadioButton);
//------------------------------------------------------------
//------------------------------------------------------------
//CENTER :
      
        //THE BACK RECTANGLE OF THE GAME :
        Rectangle BasicRectangle = new Rectangle(900, 500);
        BasicRectangle.setArcWidth(50);
        BasicRectangle.setArcHeight(80);
        BasicRectangle.setFill(Color.rgb(221,239,218,0.5));
        BasicRectangle.setTranslateX( 150);
        BasicRectangle.setTranslateY( 300);

        //------------------------------------------------------------
        //TASK LABAL DESIGN LAYERS  :
        ImageView WoodenFrameForRulse = new ImageView(new Image("file:BunyanImages/Murooj/WoodenLabelFrame.png"));
        WoodenFrameForRulse.setFitHeight(200);
        WoodenFrameForRulse.setFitWidth(500);
        WoodenFrameForRulse.setTranslateX(130);
        WoodenFrameForRulse.setTranslateY(50);
        
        Rectangle BackRectangleOfLabel = new Rectangle(350, 65);
        BackRectangleOfLabel.setArcWidth(50);
        BackRectangleOfLabel.setArcHeight(80);
        BackRectangleOfLabel.setTranslateX(130);
        BackRectangleOfLabel.setTranslateY(45);
        BackRectangleOfLabel.setFill(Color.rgb(236, 163, 50));
        
        
        
        Label RulsLabel = new Label("     RULES      ");
        RulsLabel.setFont(Font.font("Valoon", 50));
        RulsLabel.setTranslateX(135);
        RulsLabel.setTranslateY(52);
        
     

        Label RequiredLabel = new Label("Required : ");
        RequiredLabel.setFont(Font.font("Starborn", 30));
        RequiredLabel.setTextFill(Color.rgb(89, 18, 5));
        
        
        Label RequiredDescription = new Label();
        RequiredDescription.setFont(Font.font("Valoon", 30));

        Label HeaderRules = new Label();
        HeaderRules.setFont(Font.font("Starborn", 30));
        HeaderRules.setTextFill(Color.rgb(89, 18, 5));
        
        Label TaskRules1 = new Label();
        TaskRules1.setFont(Font.font("Valoon", 30));
        
        Label TaskRules2 = new Label();
        TaskRules2.setFont(Font.font("Valoon", 30));

        VBox TaskRulesBox = new VBox(5, RequiredLabel, RequiredDescription, HeaderRules, TaskRules1, TaskRules2);
        TaskRulesBox.setTranslateY(560);
        TaskRulesBox.setTranslateX(500);
        
        StackPane CenterBox = new StackPane(BasicRectangle, WoodenFrameForRulse, BackRectangleOfLabel, RulsLabel);
        CenterBox.setTranslateX(-80);
        CenterBox.setTranslateY(-270);
//------------------------------------------------------------
//------------------------------------------------------------   
       
    Task1RadioButton.setOnAction(event -> {
            CenterBox.getChildren().remove(TaskRulesBox);
            RulsLabel.setText(" TASK 1 :");
            RequiredDescription.setText("Match the rectangle with the box assigned to it");
            HeaderRules.setText("Matching by : ");
            TaskRules1.setText("the color of the word written on the rectangle");
            TaskRules1.setTextFill(Color.rgb(27, 144, 96));
            TaskRules2.setText("not the color of the rectangle \n"
                    + "or the color written on the rectangle.");

            TaskRulesBox.setVisible(true);

            CenterBox.getChildren().add(TaskRulesBox);
        });

        Task2RadioButton.setOnAction(event -> {
            CenterBox.getChildren().remove(TaskRulesBox);
            RulsLabel.setText(" TASK 2 :");
            RequiredDescription.setText("Use the keyboard buttons to reach \n the end of the maze");
            HeaderRules.setText("Conditions of movement: ");
            TaskRules1.setText("Use the up button to move down\n"
                    + "And the down button to move up\n"
                    + "And the right button to move left\n"
                    + "And the left button to move right");
            TaskRules1.setTextFill(Color.rgb(27, 144, 96));
            TaskRules2.setText("");

            TaskRulesBox.setVisible(true);
            CenterBox.getChildren().add(TaskRulesBox);
        });
       

        Task3RadioButton.setOnAction(event -> {
        CenterBox.getChildren().remove(TaskRulesBox);
            RulsLabel.setText(" TASK 3 :");
            RequiredDescription.setText("Draw and color the shape that will appear on the \n screen by choosing from the buttons shown");
            HeaderRules.setText("Conditions of Draw and coloring: ");
            TaskRules1.setText("Draw the same shape in the same order as  \n the layers and shapes placed in them up");
         
            TaskRules2.setText("But color in the opposite way to \n the colors of the displayed layers");
            TaskRules2.setTextFill(Color.rgb(27, 144, 96));
            TaskRulesBox.setVisible(true);
            CenterBox.getChildren().add(TaskRulesBox);
        });     
       
       
//------------------------------------------------------------
//------------------------------------------------------------
//RIGHT:
    

         Rectangle TimeRectangle =new Rectangle(130, 30);
        TimeRectangle.setArcWidth(50);
        TimeRectangle.setArcHeight(50);
        TimeRectangle.setFill(Color.rgb(236, 163, 50,0.7));
        ImageView Time = new ImageView(new Image("file:BunyanImages/Murooj/Time.png"));
        Time.setFitHeight(50);
        Time.setFitWidth(50);
        Time.setTranslateX(40);
        Label TimeLabel = movingTimeCounter.getLabel();
        TimeLabel.setTranslateX(-20);
        TimeLabel.setFont(Font.font("Valoon", 22));
        StackPane Timestack = new StackPane(TimeRectangle, TimeLabel,Time);
             
        Timestack.setTranslateX(-10);
        Timestack.setTranslateY(-345);
        
 //------------------------------------------------------------
//------------------------------------------------------------
      
          
 ///SUB-SCENE(Time is over) :
       
        //Details of a sub-screen that appears to the user when the Time is over:
        ImageView MessageBackground = new ImageView(new Image("file:BunyanImages/Murooj/MessageBackground.png"));
        MessageBackground.setFitHeight(520);
        MessageBackground.setFitWidth(720);
        
        ImageView watchimage = new ImageView (new Image("file:BunyanImages/Murooj/watchimage.png"));
        watchimage.setFitHeight(220);
        watchimage.setFitWidth(250);
        watchimage.setTranslateY(-200);
        watchimage.setTranslateX(20);

        //------------------------------------------------

        
        Label TimeisOver = new Label(" Time is over! ");
        TimeisOver.setTextFill(Color.rgb(255, 242, 204));
        TimeisOver.setFont(Font.font("Valoon", 60));
        TimeisOver.setTranslateY(-35);

        Label TimeisOverShade = new Label(" Time is over! ");
        TimeisOverShade.setTextFill(Color.rgb(27, 144, 96));
        TimeisOverShade.setFont(Font.font("Valoon", 60));
        TimeisOverShade.setTranslateY(-40);
        
        Label TimeOutMessage = new Label("If you want to return to the rules\n page, your coins will be deducted");
        TimeOutMessage.setTextFill(Color.rgb(237, 237, 237));
        TimeOutMessage.setFont(Font.font("Valoon", 20));
        TimeOutMessage.setTranslateY(30);

        ImageView BackgroundOfButton = new ImageView(new Image("file:BunyanImages/Murooj/BackgroundOfButton.png"));
        BackgroundOfButton.setFitHeight(140);
        BackgroundOfButton.setFitWidth(260);
        BackgroundOfButton.setTranslateX(20);
        BackgroundOfButton.setTranslateY(220);
        
        StackPane TaskMessage2stack = new StackPane(TimeisOverShade,TimeisOver,TimeOutMessage,BackgroundOfButton);
        
//--------------------------------------

        ImageView MovingToLevel = new ImageView(new Image("file:BunyanImages/Murooj/NextIcon.png"));
        MovingToLevel.setFitHeight(100);
        MovingToLevel.setFitWidth(100);
        //-------------------------------------
        Button MovingToLevelButton = new Button();
        MovingToLevelButton.setGraphic(MovingToLevel);
        MovingToLevelButton.setStyle("-fx-background-color: transparent;");
        MovingToLevelButton.setTranslateX(92);
        MovingToLevelButton.setTranslateY(218);
        NodeSize(MovingToLevelButton);
      
        //--------------------------------------
        
        ImageView BackToRules = new ImageView(new Image("file:BunyanImages/Murooj/NextIcon.png"));
        BackToRules.setFitHeight(100);
        BackToRules.setFitWidth(100);
        BackToRules.setRotate(-180);
        //-------------------------------------
        Button BackToRulesButton = new Button();
        BackToRulesButton.setGraphic(BackToRules);
        BackToRulesButton.setStyle("-fx-background-color: transparent;");
        BackToRulesButton.setTranslateX(-50);
        BackToRulesButton.setTranslateY(224);
        NodeSize(BackToRulesButton);
        //--------------------------------------
        StackPane subScreenStack_Timeout = new StackPane(MessageBackground,watchimage,TaskMessage2stack,MovingToLevelButton,BackToRulesButton);
        subScreenStack_Timeout.setStyle("-fx-background-color: transparent;");

        SubScene subTimeoutScreen  = new SubScene(subScreenStack_Timeout, 800, 600);
        subTimeoutScreen.setFill(Color.TRANSPARENT);
        subTimeoutScreen.setTranslateX(-10);
        //Activate preventing the sub-screen from appearing except after a specific event
        subTimeoutScreen.setVisible(false);
      

                 
//------------------------------------------------------------
//------------------------------------------------------------
// SCENE BACKGROUND : 
         Image SceneBackground = new Image("file:BunyanImages/Murooj/background1.jpg");
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));
//------------------------------------------------------------
//------------------------------------------------------------
// Root pane 
        BorderPane root = new BorderPane();
        root.setBackground(background);
        root.setCenter(CenterBox);
        root.setBottom(BottomBox);
        root.setRight(Timestack);
    
//------------------------------------------------------------
//------------------------------------------------------------
           Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(25), event -> {
               BoxBlur blur = new BoxBlur(10, 10, 3);
               root.setEffect(blur);
               //2]The user sub-screen is displayed 
               subTimeoutScreen.setVisible(true);
           }));
           Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
               movingTimeCounter.updateTime();
           }));
           timeline.setCycleCount(1); //Number of runs time    
           timeline2.setCycleCount(Timeline.INDEFINITE);
           timeline.play();
           timeline2.play();
           movingTimeCounter.setTotalTimeInSeconds(0);

           BackToRulesButton.setOnAction(event -> {
               subTimeoutScreen.setVisible(false);
               root.setEffect(null);
               timeline.setCycleCount(1); //Number of runs time
               timeline.play();
           });
//------------------------------------------------------------
   StackPane rootStackPane = new StackPane(root,subTimeoutScreen);
//------------------------------------------------------------
        Scene scene = new Scene(rootStackPane, 1500, 800);
        BackToRulesButton.setOnAction(event -> {
            stage.setScene(new Rules(stage,time,startLv1).Rules(i));
            time.setCoins(-5);
        });
  
           switch (i) {
               case 0:
               case 1:
                   MovingToLevelButton.setOnAction(event -> {

                       stage.setScene(new Task1(stage, time,startLv1).Task1());
                       time.timeline.setCycleCount(Animation.INDEFINITE);
                       time.timeline.play();

                   });
                   break;
               case 2:
                   MovingToLevelButton.setOnAction(event -> {
                       stage.setScene(new Task2(stage, time,startLv1).Task2());
                       time.timeline.setCycleCount(Animation.INDEFINITE);
                       time.timeline.play();
                   });
                   break;
                   
               case 3:
                 
                   MovingToLevelButton.setOnAction(event -> {
                       stage.setScene(new Task3(stage,time,startLv1).Task3());
                        time.timeline.setCycleCount(Animation.INDEFINITE);
                        time.timeline.play();
                   });
                   break; 
           }
    
  
 //------------------------------------------------------------
//------------------------------------------------------------
  return scene;
    }
    
    //The node size changes at Mouse Entere  and Mouse Exited
    private void NodeSize(Node node) {
        node.setOnMouseEntered(event -> {
            node.setScaleX(1.2);
            node.setScaleY(1.2);
        });

        node.setOnMouseExited(event -> {
            node.setScaleX(1.0);
            node.setScaleY(1.0);
        });

    }

    private long TimeCounter; 
    private long ScoundCounter ;
    class MovingTimeCounter {
    private Label label = new Label("00");
    private long totalTimeInSeconds;
    public Label getLabel() {
        return label;
    }
    public void setTotalTimeInSeconds(long totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }
    
    public void updateTime() {
        long Seconds = totalTimeInSeconds % 60;
        label.setText(String.format("%02d", Seconds));
        if (totalTimeInSeconds <20) {
            totalTimeInSeconds++;
        } 
    }
}
}