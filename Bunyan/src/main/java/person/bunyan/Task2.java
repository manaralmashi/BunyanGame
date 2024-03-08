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
import static javafx.scene.input.KeyCode.*;


import javafx.util.Duration;



public class Task2 {
   private Button BackToScreenButton = new Button();
   private Timeline timeline;
   private  TranslateTransition jumpTransition;
   private Stage stage;
  private TimeAndcoins TCT;  // TCT ->Time and coins and tree
   
    Start_Interface startLv1 ;
    Task2(Stage stage,TimeAndcoins TCT,Start_Interface startObjectFromLv){
       this.stage= stage ;
       this.startLv1 =startObjectFromLv;
       this.TCT=TCT;

    }
    
    
     public Scene Task2() {
             
//------------------------------------------------------------  
//------------------------------------------------------------   
//LEFT :         
        ImageView ImageOfEngineer = new ImageView(new Image("file:BunyanImages/Murooj/ImageOfEngineer.png"));
        ImageOfEngineer.setFitHeight(450);
        ImageOfEngineer.setFitWidth(192);
        ImageOfEngineer.setTranslateX(150);
        ImageOfEngineer.setTranslateY(350);

        jumpTransition = new TranslateTransition(Duration.seconds(1), ImageOfEngineer);
        jumpTransition.setByY(-10);
        jumpTransition.setCycleCount(TranslateTransition.INDEFINITE);
        jumpTransition.setAutoReverse(true);
        jumpTransition.play();
        ImageOfEngineer.setTranslateY(350);
      
//------------------------------------------------------------
//------------------------------------------------------------
//CENTER :
      
        //THE BACK RECTANGLE OF THE GAME :
        Rectangle BasicRectangle_T2 = new Rectangle(900, 500);
        BasicRectangle_T2.setArcWidth(50);
        BasicRectangle_T2.setArcHeight(80);
        BasicRectangle_T2.setFill(Color.rgb(221,239,218,0.5));
         BasicRectangle_T2.setTranslateX(-10);
        //------------------------------------------------------------
        //TASK LABAL DESIGN LAYERS  : 
       ImageView WoodenLabelFrame_T2 = new ImageView(new Image("file:BunyanImages/Murooj/WoodenLabelFrame.png"));
        WoodenLabelFrame_T2.setFitHeight(150);
        WoodenLabelFrame_T2.setFitWidth(900);
        Label Task2 = new Label("     Help the engineer get home      ");
        Task2.setFont(Font.font("Valoon", 32));
        Rectangle RLabelFrame_T2 = new Rectangle(650, 35);
        RLabelFrame_T2.setArcWidth(50);
        RLabelFrame_T2.setArcHeight(80);
        RLabelFrame_T2.setFill(Color.rgb(236, 163, 50));
        StackPane TaskStack_2 = new StackPane(WoodenLabelFrame_T2, RLabelFrame_T2, Task2);
        TaskStack_2.setTranslateX(-10);
        TaskStack_2.setTranslateY(-270);

       //------------------------------------------------------------
       //A TOW-DIMENSIONAL MATRIX FOR DESIGNING A MAZE GAME (zero is an open path, one is a closed path) :
        int[][] MazeMatrix = {
            {1, 0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 1, 0, 1}};


        GridPane mazeGrid = new GridPane();
        mazeGrid.setAlignment(Pos.CENTER);
        mazeGrid.setTranslateX(-80);
        //Draw colored rectangles according to the path type (open or closed) based on the previous matrix
        //y ->Columns , x -> Rows
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                
                Rectangle Road = new Rectangle(75, 45); //Rectangles representing tiles
                //Color the start tile and end tile yellow
                if((y==4 & x==0)||((y==3 & x==8))){
                  Road.setFill( Color.rgb(236,163,50)); }
                //to Color the open path tile light green and the blocked path tile dark green
                 else{
                    if (MazeMatrix [y][x] == 1){Road.setFill(Color.rgb(16,57,4));}//is a closed path
                    else {Road.setFill(Color.rgb(207,202,54));}//is a open path
                }
               
              //To add rectangles to the grid
                mazeGrid.add(Road, x, y);
            } 
        }
        //------------------------------------------------------------
        ImageView house = new ImageView(new Image("file:BunyanImages/Murooj/house.png"));
        house.setFitHeight(200);
        house.setFitWidth(200);
        house.setTranslateX(350);
        house.setTranslateY(-40);
        StackPane Centerstack = new StackPane(BasicRectangle_T2,TaskStack_2,mazeGrid,house);
//------------------------------------------------------------
//------------------------------------------------------------
//BOTTOM:
        ImageView PreviousIcon = new ImageView(new Image("file:BunyanImages/Murooj/PreviousIcon.png"));
        ImageView NextIcon = new ImageView(new Image("file:BunyanImages/Murooj/NextIcon.png"));
        PreviousIcon.setFitHeight(90);
        PreviousIcon.setFitWidth(90);
        NextIcon.setFitHeight(90);
        NextIcon.setFitWidth(90);
        
        Button PreviousButton = new Button();
        PreviousButton.setGraphic(PreviousIcon);
        PreviousButton.setStyle("-fx-background-color: transparent;");
        
        Button NextButton = new Button();
        NextButton.setGraphic(NextIcon);
        NextButton.setStyle("-fx-background-color: transparent;");
        NextButton.setDisable(true);

        NodeSize(PreviousButton);
        NodeSize(NextButton);
        
        HBox BottombuttonsBox = new HBox(PreviousButton, NextButton);
        BottombuttonsBox.setPadding(new Insets(-200, 0, 0, 700));
//------------------------------------------------------------
//------------------------------------------------------------
//RIGHT:
        Rectangle CoinRectangle = new Rectangle(130, 30);
        CoinRectangle.setArcWidth(50);
        CoinRectangle.setArcHeight(50);
        CoinRectangle.setFill(Color.rgb(236, 163, 50,0.7));

             ImageView Coin = new ImageView(new Image("file:BunyanImages/Murooj/Coin.png"));
        Coin.setFitHeight(50);
        Coin.setFitWidth(50);
        Coin.setTranslateX(40);
         Label CoinLabel = TCT.coinsCounter.getLabel();
        CoinLabel.setTranslateX(-10);
        CoinLabel.setFont(Font.font("Valoon", 22));
        StackPane Coinstack= new StackPane(CoinRectangle, CoinLabel,Coin);

        //------------------------------------------------------------
        Rectangle TimeRectangle =new Rectangle(130, 30);
        TimeRectangle.setArcWidth(50);
        TimeRectangle.setArcHeight(50);
        TimeRectangle.setFill(Color.rgb(236, 163, 50,0.7));
        TimeRectangle.setFill(Color.rgb(236, 163, 50,0.7));
        ImageView Time = new ImageView(new Image("file:BunyanImages/Murooj/Time.png"));
        Time.setFitHeight(50);
        Time.setFitWidth(50);
        Time.setTranslateX(40);
       Label TimeLabel = TCT.movingTimeCounter.getLabel();
         TimeLabel.setTranslateX(-20);
        TimeLabel.setFont(Font.font("Valoon", 22));
        StackPane Timestack = new StackPane(TimeRectangle, TimeLabel,Time);
       //------------------------------------------------------------
        Rectangle TreeRectangle =new Rectangle(130, 30);
        TreeRectangle.setArcWidth(50);
        TreeRectangle.setArcHeight(50);
        TreeRectangle.setFill(Color.rgb(236, 163, 50,0.7));
        ImageView Tree = new ImageView(new Image("file:BunyanImages/Murooj/Tree.png"));
        Tree.setFitHeight(50);
        Tree.setFitWidth(50);
        Tree.setTranslateX(40);
        Label TreeLabel = TCT.TreeCounter.getLabel();
        TreeLabel.setTranslateX(-20);
        TreeLabel.setFont(Font.font("Valoon", 22));
        StackPane Treestack = new StackPane(TreeRectangle, TreeLabel,Tree);
       //------------------------------------------------------------
        
        VBox RightBox = new VBox(15,Coinstack,Timestack,Treestack);
        RightBox.setPadding(new Insets(30, 10, 0, 0));
       
//------------------------------------------------------------
//------------------------------------------------------------
       
        SubScene CompletionScreen  = new SubScene( CompletionScreen (), 800, 600);  
        CompletionScreen.setFill(Color.TRANSPARENT);
        CompletionScreen.setTranslateX(-10);
        //Activate preventing the sub-screen from appearing except after a specific event
        CompletionScreen.setVisible(false);
   
//------------------------------------------------------------
//------------------------------------------------------------
// SCENE BACKGROUND : 
         Image SceneBackground = new Image("file:BunyanImages/Murooj/background2.jpg");
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));
//------------------------------------------------------------
//------------------------------------------------------------
// Root pane 
        BorderPane root = new BorderPane();
        root.setBackground(background);
        root.setCenter(Centerstack);
        root.setLeft(ImageOfEngineer);
        root.setBottom(BottombuttonsBox);
        root.setRight(RightBox);
    
//------------------------------------------------------------
//------------------------------------------------------------
//This event occurs when the button is pressed, the sub-screen closes and the main screen returns
    BackToScreenButton.setOnAction(event -> {
            CompletionScreen.setVisible(false);
            root.setEffect(null);
             NextButton.setDisable(false);
               PreviousButton .setDisable(true);
        });
    
   StackPane rootStackPane = new StackPane(root, CompletionScreen);
     Scene scene = new Scene(rootStackPane, 1500, 800);
      
 //------------------------------------------------------------
//------------------------------------------------------------

    
       move(0, 4, mazeGrid, MazeMatrix ,CompletionScreen,root); 
       
         PreviousButton.setOnAction(event -> {
             stage.setScene(new Rules(stage, TCT,startLv1).Rules(2));
             TCT.setCoins(-5);
             TCT.setTree(TCT.getCoins());
         });

         NextButton.setOnAction(event -> {
             stage.setScene(new Task3(stage, TCT,startLv1).Task3());
             TCT.timeline.play();
         });
        
           return scene;
           
       }
     
     private void move(int x, int y, GridPane PlayermoveGrid, int[][] maze,SubScene CompletionScreen,BorderPane root ) {
       //This circle will represent the player :  
        Circle player =new Circle(20,Color.rgb(196,84,74));
        player.setTranslateX(15);
        //This line changes the position of the circle (the player) according to the X and Y changes resulting from pressing the keyboard buttons
        PlayermoveGrid.add(player, x, y);
        //In this event, the value of X and Y will be updated according to the button that the player presses
        //(Differing direction of movement opposite the pressed button is the basic idea of the game)
        PlayermoveGrid.setOnKeyPressed(event -> {
            int newX = x;
            int newY = y;

            switch (event.getCode()) {
                case DOWN:
                 // 1]If the UP button is pressed, it will go Down, meaning the Y value will increase
                    newY =  y - 1;
                    break;
                case UP:
                  // 2] If the Down button is pressed, it will go up, meaning the Y value will decrease
                    newY =  y + 1;
                    break;
                case RIGHT:
                    //3] If the RIGHT button is pressed, it will go Left, meaning the X value will decrease
                    newX =  x - 1;
                    break;
                case LEFT:
                    //4] If the Left button is pressed, it will go RIGHT, meaning the X value will increase
                    newX =  x + 1;
                    break;
            }
            //to verify that the square to which the player will go is considered an open path. If verified, the values update
            if (maze[newY][newX] != 1) {
                PlayermoveGrid.getChildren().remove(player);
                move(newX, newY, PlayermoveGrid, maze,CompletionScreen,root);
            }
            //When the player reaches the final rectangle :
             if (newX == 8 && newY ==  3) {
           jumpTransition.stop();
            TCT.setCoins(20);
             TCT.setTree(TCT.getCoins());
            // 1] The main game screen is blurred
              BoxBlur blur = new BoxBlur(10, 10, 3);
              root.setEffect(blur);
            //2]The user sub-screen is displayed 
            CompletionScreen.setVisible(true);
              timeline.play();
             TCT.timeline.stop();
             TCT.setTotalGameTime(TCT.getTimeCounter());
        }
    });

        PlayermoveGrid.requestFocus();
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
     
     
    private StackPane CompletionScreen () { 
   
        //SUB-SCENE :
       
        //Details of a sub-screen that appears to the user when the task is solved correctly :
       ImageView task2completion = new ImageView(new Image("file:BunyanImages/Murooj/taskcompletion.png"));
        task2completion.setFitHeight(520);
        task2completion.setFitWidth(720);
        
        ImageView Bar = new ImageView(new Image("file:BunyanImages/Murooj/Bar.png"));
        Bar.setFitHeight(150);
        Bar.setFitWidth(570);
        Bar.setTranslateY(-200);
        
        Label GoodJobLabal = new Label("Good Job ! ");
        GoodJobLabal.setTextFill(Color.rgb(132, 60, 12));
        GoodJobLabal.setFont(Font.font("Valoon", 75));
        GoodJobLabal.setTranslateX(20);
        GoodJobLabal.setTranslateY(-197);
         
        Label GoodJobShade = new Label("Good Job ! ");
        GoodJobShade.setTextFill(Color.rgb(197, 90, 17));
        GoodJobShade.setFont(Font.font("Valoon", 75));
        GoodJobShade.setTranslateX(20);
        GoodJobShade.setTranslateY(-190);
         
          
        StackPane Barstack = new StackPane(Bar,GoodJobShade,GoodJobLabal);
        ScaleTransition MoveBarstack = new ScaleTransition(Duration.seconds(1), Barstack);
        MoveBarstack.setByX(0.1);
        MoveBarstack.setCycleCount(ScaleTransition.INDEFINITE);
        MoveBarstack.setAutoReverse(true);
        MoveBarstack.play();
        //-------------------------------------
         ImageView Beam = new ImageView(new Image("file:BunyanImages/Murooj/Beam.png"));
        Beam.setFitHeight(240);
        Beam.setFitWidth(600);
        Beam.setTranslateY(30);
         ScaleTransition MoveBeam = new ScaleTransition(Duration.seconds(1.5), Beam);
         MoveBeam.setByX(0.03);
         MoveBeam.setCycleCount(ScaleTransition.INDEFINITE);
         MoveBeam.setAutoReverse(true);
         MoveBeam.play();
        
        Label TaskMessage2 = new Label("   You have completed \n the Second Task of the\n           level 1");
        TaskMessage2.setTextFill(Color.rgb(27, 144, 96));
        TaskMessage2.setFont(Font.font("Starborn", 25));
        TaskMessage2.setTranslateY(20);

        Label TaskMessage2Shade = new Label("   You have completed \n the Second Task of the\n           level 1");
        TaskMessage2Shade.setTextFill(Color.rgb(201, 201, 201));
        TaskMessage2Shade.setFont(Font.font("Starborn", 25));
        TaskMessage2Shade.setTranslateY(16);

        Label SecondTask = new Label("Second Task ");
        SecondTask.setTextFill(Color.rgb(89, 18, 5));
        SecondTask.setFont(Font.font("Starborn", 25));
        SecondTask.setTranslateY(17);
        SecondTask.setTranslateX(-13);
        
        
        ImageView BackToScreenImagSecond = new ImageView(new Image("file:BunyanImages/Murooj/BackToScreenImagone.png"));
        BackToScreenImagSecond.setFitHeight(110);
        BackToScreenImagSecond.setFitWidth(110);
        BackToScreenImagSecond.setTranslateX(320);
        BackToScreenImagSecond.setTranslateY(13);
        
       ProgressBar progressBar = new ProgressBar(0);
        progressBar.setStyle("-fx-accent: green;"); 
        progressBar.setTranslateY(-3);
        progressBar.setTranslateX(2);
        progressBar.setPrefWidth(365);
        progressBar.setPrefHeight(18);
        
        ImageView progressBarimge = new ImageView(new Image("file:BunyanImages/Murooj/progressBarimge.png"));
        progressBarimge.setFitHeight(50);
        progressBarimge.setFitWidth(400);

       StackPane progressBarstack = new StackPane(progressBarimge, progressBar);
       progressBarstack.setTranslateY(170);
        
        Duration duration = Duration.seconds(4);
         timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 0.3)),
                new KeyFrame(duration, new KeyValue(progressBar.progressProperty(), 0.6))
        );
        StackPane TaskMessage2stack = new StackPane(Beam, TaskMessage2Shade, TaskMessage2, SecondTask,BackToScreenImagSecond,progressBarstack);

        //--------------------------------------
        ImageView BackToScreenImag = new ImageView(new Image("file:BunyanImages/Murooj/NextIcon.png"));
        BackToScreenImag.setFitHeight(90);
        BackToScreenImag.setFitWidth(90);
        
       
        
        //-------------------------------------
       
        BackToScreenButton.setGraphic(BackToScreenImag);
        BackToScreenButton.setStyle("-fx-background-color: transparent;");
        BackToScreenButton.setTranslateX(320);
        BackToScreenButton.setTranslateY(13);

        NodeSize (BackToScreenButton);
        
        //--------------------------------------
        StackPane subScreenStack = new StackPane(task2completion,Barstack,TaskMessage2stack,BackToScreenButton);
        subScreenStack.setStyle("-fx-background-color: transparent;");

       
         
         return subScreenStack;
}   
     
     
     
     
     
     

}
