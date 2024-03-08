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



public class Task1 {
    
    //0-> RedStack1
    //1->RedStack2
    //2->Greenstack1
    //3->Greenstack2
    //4->Bluestack1
    //5->Bluestack2
    
     private double[] X_Position= new double[6];
     private double[] Y_Position= new double[6];

    
    private int isFinishTask1 = 0;
    private Timeline timeline ;
    private Button CancelErrorButton = new Button();
    private Button BackToScreenButton = new Button();
    private Stage stage;
    private TimeAndcoins TCT;  // TCT ->Time and coins and tree
    Start_Interface startLv1 ;
    Task1(Stage stage,TimeAndcoins TCT,Start_Interface startObjectFromLv){
       this.stage= stage ;
       this.startLv1 =startObjectFromLv;
       this.TCT=TCT;

    }
    


  


     public Scene Task1() {
 //------------------------------------------------------------  
//------------------------------------------------------------   
//left :         
        ImageView Rectangleframe1 = new ImageView(new Image("file:BunyanImages/Murooj/Rectangleframe.png"));
        Rectangleframe1.setFitHeight(100);
        Rectangleframe1.setFitWidth(200);
        
        ImageView Rectangleframe2 =new ImageView(new Image("file:BunyanImages/Murooj/Rectangleframe.png"));
        Rectangleframe2.setFitHeight(100);
        Rectangleframe2.setFitWidth(200);
        
        ImageView Rectangleframe3 = new ImageView(new Image("file:BunyanImages/Murooj/Rectangleframe.png"));
        Rectangleframe3.setFitHeight(100);
        Rectangleframe3.setFitWidth(200);
        
        ImageView Rectangleframe4 = new ImageView(new Image("file:BunyanImages/Murooj/Rectangleframe.png"));
        Rectangleframe4.setFitHeight(100);
        Rectangleframe4.setFitWidth(200);
                 
        ImageView Rectangleframe5 = new ImageView(new Image("file:BunyanImages/Murooj/Rectangleframe.png"));
        Rectangleframe5.setFitHeight(100);
        Rectangleframe5.setFitWidth(200);
        
        ImageView Rectangleframe6 = new ImageView(new Image("file:BunyanImages/Murooj/Rectangleframe.png"));
        Rectangleframe6.setFitHeight(100);
        Rectangleframe6.setFitWidth(200);
        
        VBox Box_Rectangleframe = new VBox(2,Rectangleframe1 ,Rectangleframe2,Rectangleframe3,Rectangleframe4,Rectangleframe5,Rectangleframe6);
        Box_Rectangleframe.setTranslateX(140);
        Box_Rectangleframe.setTranslateY(45);


        
        
        
       //------------------------------------------------------------
        Rectangle RED1 = new Rectangle(145, 45);RED1.setArcWidth(50); RED1.setArcHeight(50);
        RED1.setFill(Color.rgb(210,146,188));
        
        Rectangle RED2 = new Rectangle(145, 45);RED2.setArcWidth(50); RED2.setArcHeight(50);
        RED2.setFill(Color.rgb(210,146,188));
       
        Rectangle Green1 = new Rectangle(145, 45);Green1.setArcWidth(50); Green1.setArcHeight(50);
        Green1.setFill(Color.rgb(212,221,135));
        
        Rectangle Green2 = new Rectangle(145, 45);Green2.setArcWidth(50); Green2.setArcHeight(50);
        Green2.setFill(Color.rgb(212,221,135));
        
        Rectangle Blue1 = new Rectangle(145, 45);Blue1.setArcWidth(50); Blue1.setArcHeight(50);
        Blue1.setFill(Color.rgb(59,183,209));
       
        Rectangle Blue2 = new Rectangle(145, 45);Blue2.setArcWidth(50); Blue2.setArcHeight(50);
        Blue2.setFill(Color.rgb(59,183,209));
        //------------------------------------------------------------
        
        Label LabelGreen1 =new Label("Green");
        LabelGreen1.setTextFill(Color.rgb(212,221,135));
        LabelGreen1.setFont(Font.font("Valoon", 25));
        
        Label LabelRED2 = new Label("Green");
        LabelRED2.setTextFill(Color.rgb(210, 146, 188));
        LabelRED2.setFont(Font.font("Valoon", 25));
        
        Label LabelBlue1 =new Label("Blue");
        LabelBlue1.setTextFill(Color.rgb(59,183,209));
        LabelBlue1.setFont(Font.font("Valoon", 25));
        
        Label LabelBlue2 = new Label("RED");
        LabelBlue2.setTextFill(Color.rgb(59, 183, 209));
        LabelBlue2.setFont(Font.font("Valoon", 25));
        
        
        Label LabelRED1 = new Label("Blue");
        LabelRED1.setTextFill(Color.rgb(210, 146, 188));
        LabelRED1.setFont(Font.font("Valoon", 25));

      

        Label LabelGreen2 = new Label("RED");
        LabelGreen2.setTextFill(Color.rgb(212, 221, 135));
        LabelGreen2.setFont(Font.font("Valoon", 25));
        //------------------------------------------------------------
       
         StackPane REDstack2 = new StackPane(RED2, LabelBlue1);
         StackPane Greenstack1 = new StackPane(Green1, LabelBlue2);
        
        StackPane REDstack1 = new StackPane(RED1, LabelGreen1);
        StackPane Bluestack2 = new StackPane(Blue2, LabelGreen2);
      
    
        StackPane Bluestack1 = new StackPane(Blue1, LabelRED2);
        StackPane Greenstack2 = new StackPane(Green2, LabelRED1);
        
        
      

        VBox Box_frame = new VBox(57, REDstack1, Greenstack1, Bluestack1, REDstack2, Greenstack2, Bluestack2);
        Box_frame.setTranslateX(140);
        Box_frame.setTranslateY(80);
        


        //------------------------------------------------------------ 
        StackPane Leftstack = new StackPane(Box_Rectangleframe, Box_frame);
        Leftstack.setAlignment(Pos.TOP_CENTER);
        
        
   
//------------------------------------------------------------
//------------------------------------------------------------
//Center :
        //THE BACK RECTANGLE OF THE GAME :
        Rectangle BasicRectangle_T1 = new Rectangle(900, 500);
        BasicRectangle_T1.setArcWidth(50);
        BasicRectangle_T1.setArcHeight(80);
        BasicRectangle_T1.setFill(Color.rgb(221,239,218,0.5));
        BasicRectangle_T1.setTranslateX(-84);
        //------------------------------------------------------------
        //TASK LABAL DESIGN LAYERS  : 
        ImageView WoodenLabelFrame_T1 = new ImageView(new Image("file:BunyanImages/Murooj/WoodenLabelFrame.png"));
        WoodenLabelFrame_T1.setFitHeight(150);
        WoodenLabelFrame_T1.setFitWidth(900);
        Label Task1 = new Label("Place each rectangle in the appropriate box : ");
        Task1.setFont(Font.font("Valoon", 26));
        Rectangle RLabelFrame_T1 = new Rectangle(650, 35);
        RLabelFrame_T1.setArcWidth(50);
        RLabelFrame_T1.setArcHeight(80);
        RLabelFrame_T1.setFill(Color.rgb(236, 163, 50));
        StackPane TaskStack_1 = new StackPane(WoodenLabelFrame_T1, RLabelFrame_T1, Task1);
        TaskStack_1.setTranslateX(-80);
        TaskStack_1.setTranslateY(-270);
       //------------------------------------------------------------
       
         
        ImageView woodenBox1 = new ImageView(new Image("file:BunyanImages/Murooj/woodenBox.png"));
        ImageView woodenBox2 = new ImageView(new Image("file:BunyanImages/Murooj/woodenBox.png"));
        ImageView woodenBox3 =new ImageView(new Image("file:BunyanImages/Murooj/woodenBox.png"));
        //------------------------------------------------------------
        Label BlueBoxLabel = new Label("Blue box");
        BlueBoxLabel.setTextFill(Color.rgb(59,183,209));
        BlueBoxLabel.setFont(Font.font("Valoon", 20));
        
        Label GreenBoxLabel = new Label("Green box");
        GreenBoxLabel.setTextFill(Color.rgb(108,121,5));
        GreenBoxLabel.setFont(Font.font("Valoon", 20));
        
        Label REDBoxLabel = new Label("RED box");
        REDBoxLabel.setTextFill(Color.rgb(210, 146, 188));
        REDBoxLabel.setFont(Font.font("Valoon", 20));
        

        HBox woodenBoxs = new HBox(-200, woodenBox1, woodenBox2, woodenBox3);
        woodenBoxs.setTranslateX(0);
        woodenBoxs.setTranslateY(140);
        
        HBox BoxLabel = new HBox(220, BlueBoxLabel, GreenBoxLabel, REDBoxLabel);
        BoxLabel.setTranslateX(200);
        BoxLabel.setTranslateY(490);
//---------------------------------------------------------  


       //These rectangles define the area where the user can drop the objects he has dragged
        Rectangle TransparentRectangle2 = new Rectangle(40, 40);
        TransparentRectangle2.setFill(Color.TRANSPARENT);
        TransparentRectangle2.setTranslateY(-90);

        Rectangle TransparentRectangle3 = new Rectangle(40, 40);
        TransparentRectangle3.setFill(Color.TRANSPARENT);
        TransparentRectangle3.setTranslateY(-90);
         TransparentRectangle3.setTranslateX(200);
         
         
        Rectangle TransparentRectangle1 = new Rectangle(50, 42);
        TransparentRectangle1.setFill(Color.TRANSPARENT);
        TransparentRectangle1.setTranslateY(-148);
        TransparentRectangle1.setTranslateX(-400);
//-----------------------------------------------------------
        StackPane Centerstack = new StackPane(BasicRectangle_T1,TaskStack_1,woodenBoxs,BoxLabel);
Centerstack.getChildren().addAll(TransparentRectangle2,TransparentRectangle3,TransparentRectangle1);
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
        RightBox.setPadding(new Insets(30, 0, 0, -150));
//------------------------------------------------------------
//------------------------------------------------------------

        SubScene SubErrorScreen  = new SubScene(SubScreenError(), 800, 600);
        SubErrorScreen.setFill(Color.TRANSPARENT);
        SubErrorScreen.setTranslateX(-10);
        //Activate preventing the sub-screen from appearing except after a specific event
        SubErrorScreen.setVisible(false);
 //----------------------------------------------------------
 //---------------------------------------------------------- 
        SubScene CompletionScreen  = new SubScene(subScreenStack (), 800, 600);
        CompletionScreen.setFill(Color.TRANSPARENT);
        CompletionScreen.setTranslateX(-10);
        //Activate preventing the sub-screen from appearing except after a specific event
        CompletionScreen.setVisible(false);
//------------------------------------------------------------
//------------------------------------------------------------

        //    contain: If true, the image will be scaled to fit within the specified width and height while maintaining its aspect ratio. If false, the image may be cropped to fit.(ensures that the entire image is visible within the container,possibly leaving empty space, )
        //    cover: If true, the image will be scaled to cover the entire specified width and height while maintaining its aspect ratio. This may result in parts of the image being clipped.( ensures that the entire container is covered by the image, potentially clipping parts of the image)
        //  false,  auto: If true, the background size will be automatically determined based on the other parameters. If false, the size will be fixed to the specified width and height.
        //  false repeatX: If true, the image will be repeated horizontally if it doesn't cover the full width. If false, it won't be repeated horizontally.


        Image SceneBackground = new Image("file:BunyanImages/Murooj/background2.jpg");
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));
//------------------------------------------------------------
//------------------------------------------------------------
         BorderPane root = new BorderPane();
         root.setBackground(background);
         root.setCenter(Centerstack);
         root.setLeft(Leftstack);
         root.setBottom(BottombuttonsBox);
         root.setRight(RightBox);

    
//---------------------------------------------------------------------------------
//BLUE BOX ُEVENT(drag-and-drop) :
//-----------------------------------
        
        REDstack2.setOnMousePressed(event -> {
            X_Position[1] = event.getSceneX();
            Y_Position[1] = event.getSceneY();
        });
        REDstack2.setOnMouseDragged(event -> {
            REDstack2.setTranslateX(event.getSceneX() - X_Position[1]);
            REDstack2.setTranslateY(event.getSceneY() - Y_Position[1]);
        });
        
        REDstack2.setOnMouseReleased (event -> { 
            VerifyPosition(REDstack2,TransparentRectangle1,root,SubErrorScreen,CompletionScreen); 
        });
 //-----------------------------------       
         Greenstack1.setOnMousePressed(event -> {
            X_Position[2] = event.getSceneX();
            Y_Position[2] = event.getSceneY();
        });

        Greenstack1.setOnMouseDragged(event -> {
            Greenstack1.setTranslateX(event.getSceneX() - X_Position[2]);
            Greenstack1.setTranslateY(event.getSceneY() - Y_Position[2]);
        });
        
         Greenstack1.setOnMouseReleased (event -> {
            VerifyPosition(Greenstack1,TransparentRectangle1,root,SubErrorScreen,CompletionScreen);
        });
//-----------------------------------  
//---------------------------------------------------------------------------------
//Green BOX ُEVENT(drag-and-drop) 
//-----------------------------------
 
     
          // Set up the event handlers for drag-and-drop
        Bluestack2.setOnMousePressed(event -> {
            X_Position[5] = event.getSceneX();
            Y_Position[5] = event.getSceneY();
        });
        Bluestack2.setOnMouseDragged(event -> {
            Bluestack2.setTranslateX(event.getSceneX() - X_Position[5]);
            Bluestack2.setTranslateY(event.getSceneY() - Y_Position[5]);
        });
        
        Bluestack2.setOnMouseReleased (event -> { 
            VerifyPosition(Bluestack2,TransparentRectangle2,root,SubErrorScreen,CompletionScreen); 
        });
 //-----------------------------------       
         REDstack1.setOnMousePressed(event -> {
             X_Position[0] = event.getSceneX();
             Y_Position[0] = event.getSceneY();
        });

        REDstack1.setOnMouseDragged(event -> {
            REDstack1.setTranslateX(event.getSceneX() -  X_Position[0]);
            REDstack1.setTranslateY(event.getSceneY() -  Y_Position[0]);
        });
        
         REDstack1.setOnMouseReleased (event -> {
          VerifyPosition(REDstack1,TransparentRectangle2,root,SubErrorScreen,CompletionScreen);
        });
//-----------------------------------       
//---------------------------------------------------------------------------------
//RED BOX ُEVENT(drag-and-drop) :
//-----------------------------------
        // Set up the event handlers for drag-and-drop
        Bluestack1.setOnMousePressed(event -> {
            X_Position[4] = event.getSceneX();
            Y_Position[4] = event.getSceneY();
        });
        Bluestack1.setOnMouseDragged(event -> {
            Bluestack1.setTranslateX(event.getSceneX() - X_Position[4]);
            Bluestack1.setTranslateY(event.getSceneY() - Y_Position[4]);
        });
        
        Bluestack1.setOnMouseReleased (event -> { 
            VerifyPosition(Bluestack1,TransparentRectangle3,root,SubErrorScreen,CompletionScreen); 
        });
 //-----------------------------------       
         Greenstack2.setOnMousePressed(event -> {
            X_Position[3] = event.getSceneX();
            Y_Position[3] = event.getSceneY();
        });

        Greenstack2.setOnMouseDragged(event -> {
            Greenstack2.setTranslateX(event.getSceneX() - X_Position[3]);
            Greenstack2.setTranslateY(event.getSceneY() - Y_Position[3]);
        });
        
         Greenstack2.setOnMouseReleased (event -> {
           VerifyPosition(Greenstack2,TransparentRectangle3,root,SubErrorScreen,CompletionScreen);
        });
//-----------------------------------       
//---------------------------------------------------------------------------------
        //This event occurs when the button is pressed, the sub-screen closes and the main screen returns
    CancelErrorButton.setOnAction(event -> {
            SubErrorScreen.setVisible(false);
            root.setEffect(null);
            TCT.timeline.play();
        });
    BackToScreenButton .setOnAction(event -> {
        
            CompletionScreen.setVisible(false);
            root.setEffect(null);
            NextButton.setDisable(false);
            PreviousButton .setDisable(true);
          
              
             
        });
    
         NodeSize(BackToScreenButton);
         NodeSize(CancelErrorButton);


    
    
        NodeSize(REDstack1);
        NodeSize(REDstack2);
        NodeSize(Greenstack1);
        NodeSize(Greenstack2);
        NodeSize(Bluestack1);
        NodeSize(Bluestack2);
 
    
   StackPane rootStackPane = new StackPane(root, SubErrorScreen,CompletionScreen);
    
//------------------------------------------------------------
     Scene scene = new Scene(rootStackPane, 1500, 800);
 
     
  

         PreviousButton.setOnAction(event -> {
             stage.setScene(new Rules(stage,TCT,startLv1).Rules(1));
             TCT.setCoins(-5);
               TCT.setTree(TCT.getCoins());
         });

         NextButton.setOnAction(event -> {
             
             stage.setScene(new Task2(stage, TCT,startLv1).Task2());
             TCT.timeline.play();
          
         });

     
           return scene;
           
       }
     
    private void VerifyPosition(StackPane stackPane,Rectangle Tran,BorderPane root,SubScene ErrorScreen,SubScene CompletionScreen) {
    //If the stack matches the correct position, it is fixed in place and its movement is disabled :
     if (stackPane.getBoundsInParent().intersects(Tran.getBoundsInParent())) {
        stackPane.setDisable(true); // Disable further dragging
          isFinishTask1++;
    
          if(isFinishTask1==6){
            //1] The main game screen is blurred
              TCT.setCoins(20);
              TCT.setTree(TCT.getCoins());
            
              BoxBlur blur = new BoxBlur(10, 10, 3);
              root.setEffect(blur);
            //2]The user sub-screen is displayed 
            CompletionScreen.setVisible(true); 
             TCT.timeline.stop();
             TCT.setTotalGameTime(TCT.getTimeCounter());
             timeline.play();
          }

    } 
   //If the stapler does not match the correct position, the stapler is returned to its original position
    else {
        stackPane.setTranslateX(0);
        stackPane.setTranslateY(0);
             //1] The main game screen is blurred
              BoxBlur blur = new BoxBlur(10, 10, 3);
              root.setEffect(blur);
            //2]The user sub-screen is displayed 
            ErrorScreen.setVisible(true);
            TCT.timeline.stop();
            TCT.setTotalGameTime(TCT.getTimeCounter());
    }
}
    
     private StackPane subScreenStack () { 
        //Details of a sub-screen that appears to the user when the task is solved correctly :
       
        ImageView task1completion = new ImageView (new Image("file:BunyanImages/Murooj/taskcompletion.png"));
        task1completion.setFitHeight(520);
        task1completion.setFitWidth(720);
        
                
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
         
        Label TaskMessage1 = new Label("   You have completed \n the First Task of the\n           level 1");
        TaskMessage1.setTextFill(Color.rgb(27, 144, 96));
        TaskMessage1.setFont(Font.font("Starborn", 25));
        TaskMessage1.setTranslateY(20);

        Label TaskMessage1Shade = new Label("   You have completed \n the First Task of the\n           level 1");
        TaskMessage1Shade.setTextFill(Color.rgb(201, 201, 201));
        TaskMessage1Shade.setFont(Font.font("Starborn", 25));
        TaskMessage1Shade.setTranslateY(16);

        Label FirstTask = new Label("First Task ");
        FirstTask.setTextFill(Color.rgb(89, 18, 5));
        FirstTask.setFont(Font.font("Starborn", 25));
        FirstTask.setTranslateY(17);
        FirstTask.setTranslateX(-24);
        
       
        ImageView BackToScreenImagone = new ImageView(new Image("file:BunyanImages/Murooj/BackToScreenImagone.png"));
        BackToScreenImagone.setFitHeight(110);
        BackToScreenImagone.setFitWidth(110);
        BackToScreenImagone.setTranslateX(320);
        BackToScreenImagone.setTranslateY(13);
        
        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setStyle("-fx-accent: green;"); 
        progressBar.setTranslateY(-3);
        progressBar.setTranslateX(2);
        progressBar.setPrefWidth(365);
        progressBar.setPrefHeight(18);
       
        ImageView progressBarimge =  new ImageView(new Image("file:BunyanImages/Murooj/progressBarimge.png"));
        progressBarimge.setFitHeight(50);
        progressBarimge.setFitWidth(400);

       StackPane progressBarstack = new StackPane(progressBarimge, progressBar);
       progressBarstack.setTranslateY(170);
        
        Duration duration = Duration.seconds(4);
         timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 0.0)),
                new KeyFrame(duration, new KeyValue(progressBar.progressProperty(), 0.3))
        );

        StackPane TaskMessage1stack = new StackPane(Beam, TaskMessage1Shade, TaskMessage1, FirstTask,BackToScreenImagone,progressBarstack);

        //--------------------------------------
        
        ImageView BackToScreenImag1 = new ImageView(new Image("file:BunyanImages/Murooj/NextIcon.png"));
        BackToScreenImag1.setFitHeight(90);
        BackToScreenImag1.setFitWidth(90);
        
         BackToScreenButton.setGraphic(BackToScreenImag1);
        BackToScreenButton.setStyle("-fx-background-color: transparent;");
        BackToScreenButton.setTranslateX(320);
        BackToScreenButton.setTranslateY(13);
        

    
        //--------------------------------------
        StackPane subScreenStack = new StackPane(task1completion,Barstack,TaskMessage1stack,BackToScreenButton);
        subScreenStack.setStyle("-fx-background-color: transparent;");
         return subScreenStack;
}

     private StackPane SubScreenError () { 
  ///SUB-SCENE(Error) :
       
        //Details of a sub-screen that appears to the user when the task is solved correctly :
        ImageView MessageBackground = new ImageView(new Image("file:BunyanImages/Murooj/MessageBackground.png"));
        MessageBackground.setFitHeight(520);
        MessageBackground.setFitWidth(720);
        
        ImageView XimageShade = new ImageView(new Image("file:BunyanImages/Murooj/XimageShade.png"));
        XimageShade.setFitHeight(200);
        XimageShade.setFitWidth(250);
        XimageShade.setTranslateY(-200);
        XimageShade.setTranslateX(20);

        ImageView Ximage = new ImageView(new Image("file:BunyanImages/Murooj/Ximage.png"));
        Ximage.setFitHeight(180);
        Ximage.setFitWidth(220);
        Ximage.setTranslateY(-200);
        Ximage.setTranslateX(19);
          
  
        StackPane Xstack = new StackPane(XimageShade,Ximage);
        
        ScaleTransition MoveXstack = new ScaleTransition(Duration.seconds(1), Xstack);
        // To set an amount to increase the size of the shape
        MoveXstack.setByX(0.05);
     
        // To Set the iteration to be continuous
        MoveXstack.setCycleCount(ScaleTransition.INDEFINITE);
        // To restart the iteration
        MoveXstack.setAutoReverse(true);
        // Start iteration
        MoveXstack.play();
        
        //-------------------------------------

        
        Label ErrorMessage = new Label("  Wrong matching \n       try again ! ");
        ErrorMessage.setTextFill(Color.rgb(255, 242, 204));
        ErrorMessage.setFont(Font.font("Valoon", 60));
        ErrorMessage.setTranslateY(20);

        Label ErrorMessageShade = new Label("  Wrong matching \n       try again ! ");
        ErrorMessageShade.setTextFill(Color.rgb(27, 144, 96));
        ErrorMessageShade.setFont(Font.font("Valoon", 60));
        ErrorMessageShade.setTranslateY(15);

        ImageView BackToScreenImagSecond = new ImageView(new Image("file:BunyanImages/Murooj/BackToScreenImagone.png"));
        BackToScreenImagSecond.setFitHeight(110);
        BackToScreenImagSecond.setFitWidth(110);
        BackToScreenImagSecond.setTranslateX(285);
        BackToScreenImagSecond.setTranslateY(200);
        
        StackPane TaskMessage2stack = new StackPane(ErrorMessageShade,ErrorMessage,BackToScreenImagSecond);
        //--------------------------------------
        ImageView BackToScreenImag = new ImageView(new Image("file:BunyanImages/Murooj/NextIcon.png"));
        BackToScreenImag.setFitHeight(90);
        BackToScreenImag.setFitWidth(90);
        //-------------------------------------
  
        CancelErrorButton.setGraphic(BackToScreenImag);
        CancelErrorButton.setStyle("-fx-background-color: transparent;");
        CancelErrorButton.setTranslateX(285);
        CancelErrorButton.setTranslateY(200);
        //--------------------------------------
        StackPane subScreenStack_Error = new StackPane(MessageBackground,Xstack,TaskMessage2stack,CancelErrorButton);
        subScreenStack_Error.setStyle("-fx-background-color: transparent;");

         
         
         
         return subScreenStack_Error;
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
  
}
