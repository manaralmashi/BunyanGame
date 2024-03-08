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


public class StartLevel1 {
  
      Button StartButton = new Button();
      private Stage stage;
      TimeAndcoins TCt =new TimeAndcoins();

      Start_Interface startLv1 ;

  
       StartLevel1(Stage stage,Start_Interface startObjectFromLv){
       this.stage= stage ;
       this.startLv1 = startObjectFromLv;
    }
       
     StartLevel1(Stage stage){
       this.stage= stage ;
       //this.levels=levels;
    }
       
        
       

    public Scene startlevel1() {
      
        //CENTER :

        //------------------------------------------------------------
        //TASK LABAL DESIGN LAYERS  : 
        ImageView WoodenFrameForLEVEL1 = new ImageView(new Image("file:BunyanImages/Murooj/WoodenFrameForLEVEL1.png"));
        WoodenFrameForLEVEL1.setFitHeight(300);
        WoodenFrameForLEVEL1.setFitWidth(700);
        WoodenFrameForLEVEL1.setTranslateX(0);
        WoodenFrameForLEVEL1.setTranslateY(-50);
        Label LEVEL3Label = new Label("LEVEL 1");
        LEVEL3Label.setFont(Font.font("Valoon", 100));
        LEVEL3Label.setTranslateY(-50);
        LEVEL3Label.setTextFill(Color.rgb(255, 242, 204));
        
        StackPane Centerstack = new StackPane(WoodenFrameForLEVEL1, LEVEL3Label);
        
        //Bottom :
        ImageView WoodenFrameForStarting = new ImageView(new Image("file:BunyanImages/Murooj/WoodenFrameForStarting.png"));
        WoodenFrameForStarting.setFitHeight(350);
        WoodenFrameForStarting.setFitWidth(350);
        WoodenFrameForStarting.setTranslateX(0);
        WoodenFrameForStarting.setTranslateY(-50); 
        
        ImageView StartingIcon = new ImageView(new Image("file:BunyanImages/Murooj/StartingIcon.png"));
        StartingIcon.setFitHeight(250);
        StartingIcon.setFitWidth(250);
        StartingIcon.setTranslateX(10);
        StartingIcon.setTranslateY(-50); 
        
        
        StackPane StartingIconstack = new StackPane(WoodenFrameForStarting,StartButton);
        
         
        ImageView HomeIcon = new ImageView(new Image("file:BunyanImages/Murooj/HomeIcon.png"));
        HomeIcon.setFitHeight(140);
        HomeIcon.setFitWidth(140);
        HomeIcon.setTranslateY(60); 
        
        Button HomeButton = new Button();
        HomeButton.setGraphic(HomeIcon);
        HomeButton.setStyle("-fx-background-color: transparent;");
   
        
        ImageView AchievementsIcon = new ImageView(new Image("file:BunyanImages/Murooj/AchievementsIcon.png"));
        AchievementsIcon.setFitHeight(130);
        AchievementsIcon.setFitWidth(125);
        AchievementsIcon.setTranslateY(65); 
           AchievementsIcon.setTranslateX(10); 
           
       Button AchievementsButton = new Button();
        AchievementsButton.setGraphic(AchievementsIcon);
        AchievementsButton.setStyle("-fx-background-color: transparent;");
        MoveButton(HomeButton);
        MoveButton(AchievementsButton);
        
        
        HBox ButtonsiconBox=new HBox(HomeButton,StartingIconstack,AchievementsButton);
        ButtonsiconBox.setAlignment(Pos.CENTER);
    // SCENE BACKGROUND : 
      Image SceneBackground = new Image("file:BunyanImages/Murooj/background1.jpg");
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));
//-----------------------------------------------------------
//------------------------------------------------------------

        ScaleTransition MoveStartingIcon = new ScaleTransition(Duration.seconds(1), StartingIcon);
        // To set an amount to increase the size of the shape
        MoveStartingIcon.setByX(0.1);
        MoveStartingIcon.setByY(0.1);
        // To Set the iteration to be continuous
        MoveStartingIcon.setCycleCount(ScaleTransition.INDEFINITE);
        // To restart the iteration
        MoveStartingIcon.setAutoReverse(true);
        // Start iteration
        MoveStartingIcon.play();
//-------------------------------------------------------------
//------------------------------------------------------------
// Root pane 
        BorderPane root = new BorderPane();
        root.setBackground(background);
        root.setCenter(Centerstack);
        root.setBottom(ButtonsiconBox);
//-------------------------------------------------------------
//------------------------------------------------------------
        Scene scene = new Scene(root, 1500, 800);
        
        HomeButton.setOnAction(event -> {

            stage.setScene(startLv1.getLevels().start(stage));
        });
        AchievementsButton.setOnAction(event -> {
            stage.setScene(startLv1.getAchievementGUI().achievementInterface());
//            stage.setScene(new Rules(stage, TCt, levels).Rules(0));
        });

        StartButton.setGraphic(StartingIcon);
        StartButton.setStyle("-fx-background-color: transparent;");
        StartButton.setOnAction(event -> {

            stage.setScene(new Rules(stage, TCt, startLv1).Rules(0));
        });

        return scene;
    }

        private void MoveButton(Button button) {        
     button.setOnMouseEntered(event -> {
            button.setScaleX(1.2);
            button.setScaleY(1.2);
        });

        button.setOnMouseExited(event -> {
            button.setScaleX(1.0);
            button.setScaleY(1.0);
        });   
     
      }

  
    
  
}
