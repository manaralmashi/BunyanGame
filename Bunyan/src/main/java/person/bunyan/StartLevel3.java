/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

import javafx.application.Application;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
/**
 *
 * @author shahd
 */
public class StartLevel3 { 
    private Stage stage;
    Start_Interface startLv3 ;
    StartLevel3(Stage stage, Start_Interface startLv3) {
        this.stage = stage;
        this.startLv3 = startLv3;
    }


    public Scene start(){
        Color c = Color.rgb(255, 255, 230, 0.35); 
        Group root = new Group();
        
        Image image = new Image("file:BunyanImages/Shahad/Interface6.jpg");//background
      
        Image image1 = new Image("file:BunyanImages/Shahad/Woodenbuttons5 (1).png"); // Rule 
        
        Image image2 = new Image("file:BunyanImages/Shahad/Woodenbuttons5.png"); // home back
        
        Image image3 = new Image("file:BunyanImages/Shahad/start.png"); // start
        
        Image image4 = new Image("file:BunyanImages/Shahad/levle.png"); // levle

        
             
        ImageView imageView = new ImageView(image);       
        imageView.setPreserveRatio(false); // إذا كنت تريد الحفاظ على نسب الصورة، استخدم true
        imageView.setSmooth(true); // لتحسين جودة الصورة عند التمديد
        
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(80);
        imageView1.setFitHeight(80);
        
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(80);
        imageView2.setFitHeight(80);
        
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(80);
        imageView3.setFitHeight(80);
        
        Button achievement = new Button();
       achievement.setStyle("-fx-background-color: rgba(255, 255, 255, 0.0);"); 
       achievement.setGraphic(imageView1);
        
        achievement.setOnAction(event -> {
            // Handle button click event
           System.out.println(" Button clicked!");
        });
        
        
        Button home = new Button();
       home.setStyle("-fx-background-color: rgba(255, 255, 255, 0.0);"); 
       home.setGraphic(imageView2);
        
        home.setOnAction(event -> {
           stage.setScene(startLv3.getLevels().start(stage));
        });
        
        
        Button start = new Button();
       start.setStyle("-fx-background-color: rgba(255, 255, 255, 0.0);"); 

        start.setGraphic(imageView3);

        start.setOnAction(event -> {
           stage.setScene(new GameLevel3(stage,startLv3).Game());
        });
        
       
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitWidth(250);
        imageView4.setFitHeight(100);
        imageView4.setPreserveRatio(false); // إذا كنت تريد الحفاظ على نسب الصورة، استخدم true
        imageView4.setSmooth(true); // لتحسين جودة الصورة عند التمديد
        
        Label labels = new Label("LEVEL 3");
        labels.setStyle("-fx-font-size: 24; -fx-text-fill: white;"); // تخصيص الخط ولون النص
        labels.setTranslateX(625);
        labels.setTranslateY(135);
        
        // 
        StackPane stackPane1 = new StackPane();
        stackPane1.getChildren().addAll(imageView4,labels);
        
        VBox vbox = new VBox(0); //
        vbox.setPadding(new Insets(100,0,0,540));
        vbox.getChildren().addAll(imageView4);
        
        VBox vbox1 = new VBox(0); 
        vbox1.setPadding(new Insets(300,0,0,620));
        vbox1.getChildren().addAll(start);
        
        HBox hbox = new HBox(250); 
        hbox.setPadding(new Insets(470,0,0,450));
        hbox.getChildren().addAll(home,achievement);
        
        Rectangle rectangle = new Rectangle(450, 100);        
        rectangle.setFill(c);
       
        
        
        
       
        root.getChildren().addAll(imageView,hbox,vbox,vbox1,stackPane1);
      
      
        
        Scene scene = new Scene(root, 1500, 800);
        
        // ربط خصائص fitWidth و fitHeight للـ ImageView بأبعاد الـ Scene
        imageView.fitWidthProperty().bind(scene.widthProperty());
        imageView.fitHeightProperty().bind(scene.heightProperty());
        
//        // الحصول على شاشة الحاسوب الرئيسية
//        Screen screen = Screen.getPrimary();
//        Rectangle2D bounds = screen.getVisualBounds();
//
//        // تعيين حجم النافذة ليكون بحجم الشاشة
//        stage.setX(bounds.getMinX());
//        stage.setY(bounds.getMinY());
//        stage.setWidth(bounds.getWidth());
//        stage.setHeight(bounds.getHeight());

        stage.setScene(scene);
        
        return scene ;
    
    }
}