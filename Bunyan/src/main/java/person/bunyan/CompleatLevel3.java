/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CompleatLevel3 {
      private Stage stage;
      private int totaltree1 = 0;   // لحساب النقاط
      private int totalcoins1 = 0;   // لحساب الكوينز

    Start_Interface startLv3 ;
    CompleatLevel3(Stage stage, Start_Interface startLv3 ,int tree,int coins) {
        this.stage = stage;
        this.startLv3 = startLv3;
        this.totaltree1 = tree;
        this.totalcoins1 = coins;
                
    }


    public Scene Compleat(){
                
         Label  coins = new Label(totalcoins1+"");
        Label  tree = new Label(totaltree1+""); 
        
        coins.setStyle("-fx-font-family: 'Valoon'; -fx-font-size: 15;");
        coins.setTranslateX(585);
        coins.setTranslateY(345);
        
        tree.setStyle("-fx-font-family: 'Valoon'; -fx-font-size: 15;");
        tree.setTranslateX(700);
        tree.setTranslateY(345);
        
        Group root = new Group();
        StackPane stackPane = new StackPane();
        StackPane stackPane1 = new StackPane();


           
        Image image = new Image("file:BunyanImages/Shahad/Interface6.jpg");//background
        
        Image image1 = new Image("file:BunyanImages/Shahad/req (1).png");//req
                
        Image image2 = new Image("file:BunyanImages/Shahad/dollar.png");//DOLAR
        
        Image image3 = new Image("file:BunyanImages/Shahad/tree.png");//TREE
        
        Image image4 = new Image("file:BunyanImages/Shahad/ans.png");//REQQ1    
        
        Image image6 = new Image("file:BunyanImages/Shahad/Woodenbuttons5.png");//home

        
        
   

        ImageView imageView = new ImageView(image);       
        imageView.setPreserveRatio(false); // إذا كنت تريد الحفاظ على نسب الصورة، استخدم true
        imageView.setSmooth(true); // لتحسين جودة الصورة عند التمديد
        
        ImageView imageView1 = new ImageView(image1);
        imageView.setSmooth(true); // لتحسين جودة الصورة عند التمديد
        imageView1.setFitWidth(270);
        imageView1.setFitHeight(200);
        
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(25);
        imageView2.setFitHeight(25);
        imageView2.setTranslateX(16);
        
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(25);
        imageView3.setFitHeight(25);
        imageView3.setTranslateX(16);
        
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitWidth(75);
        imageView4.setFitHeight(50);
        imageView4.setPreserveRatio(false); // إذا كنت تريد الحفاظ على نسب الصورة، استخدم true
        imageView4.setSmooth(true); // لتحسين جودة الصورة عند التمديد
        
        ImageView imageView5 = new ImageView(image4);
        imageView5.setFitWidth(75);
        imageView5.setFitHeight(50);
        imageView5.setPreserveRatio(false); // إذا كنت تريد الحفاظ على نسب الصورة، استخدم true
        imageView5.setSmooth(true); // لتحسين جودة الصورة عند التمديد
        
        
        stackPane.getChildren().addAll(imageView4, imageView2);
        stackPane1.getChildren().addAll(imageView5, imageView3);
        
        ImageView imageView6 = new ImageView(image6);
        imageView6.setFitWidth(80);
        imageView6.setFitHeight(80);
        
        HBox hbox = new HBox(30);
        hbox.setPadding(new Insets(330,0,0,570));
        hbox.getChildren().addAll(stackPane, stackPane1);
        
      

        VBox vbox = new VBox(0);
        vbox.setPadding(new Insets(220,0,0,520));
        vbox.getChildren().addAll(imageView1);
        
        
        
        Label labels = new Label("LEVEL 3");
        labels.setStyle("-fx-font-family: 'Valoon';-fx-font-size: 24; -fx-text-fill: white;"); // تخصيص الخط ولون النص
        labels.setTranslateX(615);
        labels.setTranslateY(250);
        
        Label labels1 = new Label(" COMPLETED !");
        labels1.setStyle("-fx-font-family: 'Valoon'; -fx-font-size: 24; -fx-text-fill: white;"); // تخصيص الخط ولون النص
        labels1.setTranslateX(575);
        labels1.setTranslateY(290);
        
        Button home = new Button();
       home.setStyle("-fx-background-color: rgba(255, 255, 255, 0.0);"); 
       home.setGraphic(imageView6);
        
        home.setOnAction(event -> {
            startLv3.getLevels().setTotalCoins(totalcoins1);
            startLv3.getLevels().setTotalTrees(totaltree1);
            startLv3.getLevels().updateCurrentLevelIndex(3);
            stage.setScene(startLv3.getLevels().start(stage));
        });
        VBox vbox1 = new VBox(0);
        vbox1.setPadding(new Insets(470,0,0,620));
        vbox1.getChildren().addAll(home);
        
        root.getChildren().addAll(imageView,vbox,labels,labels1,hbox,vbox1,coins,tree);
        
        Scene scene = new Scene(root, 1500, 800);
       
        // الحصول على شاشة الحاسوب الرئيسية
              
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
//     
//        stage.setScene(scene);
        
        return scene;
       
    }

}