/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

/**
 *
 * @author msms-
 */
import java.util.List;
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
import static javafx.application.Application.launch;
import javafx.scene.effect.BoxBlur;
import javafx.util.Duration;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EndOFLevel1 {

    private Stage stage;
    private TimeAndcoins TCT;

    Start_Interface startLv1;

    EndOFLevel1(Stage stage, TimeAndcoins TCT, Start_Interface startLv1) {
        this.stage = stage;
        this.TCT = TCT;
        this.startLv1 = startLv1;
    }

    public Scene EndOFLevel3() {
        //Draw a ray consisting of 8 lines
        // Determine the starting point
        double startX = 150;
        double startY = 150;
        double Length = 2000;//ray Length
        StackPane raysStack = new StackPane();

        Line[] rays = new Line[8];
        //Fill the Array with lines spaced 45 degrees apart :
        for (int i = 0; i < rays.length; i++) {
            double angle = Math.toRadians(45 * i);
            double endX = startX + Length * Math.cos(angle);
            double endY = startY - Length * Math.sin(angle);
            rays[i] = new Line(startX, startY, endX, endY);
            if (i % 2 == 0) {
                rays[i].setStroke(Color.rgb(255, 239, 189, 0.4));
            } else {
                rays[i].setStroke(Color.rgb(188, 200, 62, 0.3));
            }
            rays[i].setStrokeWidth(100);
            //Adding Lines to the stack
            raysStack.getChildren().add(rays[i]);
        }

        //Rotating the stack consisting of the line :
        RotateTransition rotateRays = new RotateTransition(Duration.seconds(2), raysStack);
        rotateRays.setByAngle(360);
        rotateRays.setCycleCount(RotateTransition.INDEFINITE);
        rotateRays.setAutoReverse(false);
        rotateRays.play();

        raysStack.setVisible(false);
//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------  
        //SUB-SCENE :

        ImageView background1completion = new ImageView(new Image("file:BunyanImages/Murooj/taskcompletion.png"));
        background1completion.setFitHeight(520);
        background1completion.setFitWidth(720);

        ImageView background2completion = new ImageView(new Image("file:BunyanImages/Murooj/background1completion.png"));
        background2completion.setFitHeight(400);
        background2completion.setFitWidth(600);

        ImageView StarsBackground = new ImageView(new Image("file:BunyanImages/Murooj/StarsBackground.png"));
        StarsBackground.setFitHeight(150);
        StarsBackground.setFitWidth(500);
        StarsBackground.setTranslateY(-220);

        ImageView Stars1 = new ImageView(new Image("file:BunyanImages/Murooj/Stars.png"));
        Stars1.setFitHeight(98);
        Stars1.setFitWidth(108);
        Stars1.setTranslateX(-1);
        Stars1.setTranslateY(-419);

        ImageView Stars2 = new ImageView(new Image("file:BunyanImages/Murooj/Stars.png"));
        Stars2.setFitHeight(98);
        Stars2.setFitWidth(108);
        Stars2.setTranslateX(-159);
        Stars2.setTranslateY(-420);

        ImageView Stars3 = new ImageView(new Image("file:BunyanImages/Murooj/Stars.png"));
        Stars3.setFitHeight(98);
        Stars3.setFitWidth(108);
        Stars3.setTranslateX(159);
        Stars3.setTranslateY(-420);

        StackPane StarSstack = new StackPane(StarsBackground, Stars1, Stars2, Stars3);

        Label LEVEL3Labal = new Label("    LEVEL 1 ");
        LEVEL3Labal.setTextFill(Color.rgb(132, 60, 12));
        LEVEL3Labal.setFont(Font.font("Valoon", 60));
        LEVEL3Labal.setAlignment(Pos.CENTER);

        Label CompletedLabbel = new Label("COMPLETED !");
        CompletedLabbel.setTextFill(Color.rgb(197, 90, 17));
        CompletedLabbel.setFont(Font.font("Valoon", 60));
        CompletedLabbel.setAlignment(Pos.CENTER);

        VBox labelstack = new VBox(5, LEVEL3Labal, CompletedLabbel);
        labelstack.setTranslateX(192);
        labelstack.setTranslateY(180);

        ImageView tree = new ImageView(new Image("file:BunyanImages/Murooj/totaltree.png"));
        tree.setFitHeight(110);
        tree.setFitWidth(200);
        tree.setTranslateY(-13);

        ImageView doller = new ImageView(new Image("file:BunyanImages/Murooj/totaldoller.png"));
        doller.setFitHeight(100);
        doller.setFitWidth(200);

        ImageView Levelpageicon = new ImageView(new Image("file:BunyanImages/Murooj/HomeIcon.png"));
        Levelpageicon.setFitHeight(80);
        Levelpageicon.setFitWidth(80);

        Button ToleveinterfaceButton = new Button();
        ToleveinterfaceButton.setTranslateX(151);
        ToleveinterfaceButton.setGraphic(Levelpageicon);
        ToleveinterfaceButton.setStyle("-fx-background-color: transparent;");

        ToleveinterfaceButton.setOnMouseEntered(event -> {
            ToleveinterfaceButton.setScaleX(1.2);
            ToleveinterfaceButton.setScaleY(1.2);
        });

        ToleveinterfaceButton.setOnMouseExited(event -> {
            ToleveinterfaceButton.setScaleX(1.0);
            ToleveinterfaceButton.setScaleY(1.0);
        });

        ToleveinterfaceButton.setOnAction(event -> {
            startLv1.getLevels().setTotalCoins(TCT.getCoins());
            startLv1.getLevels().setTotalTrees(TCT.getTree());
            startLv1.getLevels().setTotalTime(TCT.minutes, TCT.ScoundCounter);
            startLv1.getLevels().updateCurrentLevelIndex(1);
            /////////////////////database//////////////
            
       startLv1.getLevels().setTotalTime(TCT.minutes, TCT.ScoundCounter);

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            String queryHQL = "from Achievement where PlayerID = :id";
            Query query = session.createQuery(queryHQL);
            query.setParameter("id", startLv1.getProfile().getStartObj_P().getPlayer().getPlayerID());
            Achievement a = (Achievement) query.uniqueResult();

            if (a == null) {

                a = new Achievement(startLv1.getProfile().getStartObj_P().getPlayer().getPlayerID(), startLv1.getLevels().getCurrentLevelIndex(), startLv1.getLevels().getTotalTime(), TCT.getCoins());
                tx = session.beginTransaction();
                session.save(a);
                tx.commit();
            } else {
                // If the achievement exists, update its values
                tx = session.beginTransaction();
                String updateQueryHQL = "UPDATE Achievement SET levelNum = :lv, totalTime = :t, numberOfCoins = :coins WHERE PlayerID = :id";
                Query updateQuery = session.createQuery(updateQueryHQL);
                updateQuery.setParameter("lv", startLv1.getLevels().getCurrentLevelIndex());
                updateQuery.setParameter("t", startLv1.getLevels().getTotalTime());
                updateQuery.setParameter("coins", TCT.getCoins());
                updateQuery.setParameter("id", a.getPlayerID());
                int result = updateQuery.executeUpdate();
                tx.commit();
            }

 session.close();
            //////////////////////////////////////////        String queryStr = "from Achievement  ";
            stage.setScene(startLv1.getLevels().start(stage));

        });

        Label CoinLabel = TCT.coinsCounter.getLabel();
        CoinLabel.setTranslateX(-30);
        CoinLabel.setFont(Font.font("Valoon", 45));
        CoinLabel.setTextFill(Color.rgb(255, 242, 204));

        Label treeLabel = TCT.TreeCounter.getLabel();
        treeLabel.setTranslateX(-20);
        treeLabel.setFont(Font.font("Valoon", 45));
        treeLabel.setTextFill(Color.rgb(255, 242, 204));

        StackPane d = new StackPane(doller, CoinLabel);
        StackPane t = new StackPane(tree, treeLabel);

        HBox icon = new HBox(d, t);

        VBox box = new VBox(-20, icon, ToleveinterfaceButton);

        box.setTranslateX(188);
        box.setTranslateY(340);
//-------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------
        StackPane subScreenStack = new StackPane(background1completion, background2completion, StarSstack, labelstack, box);
        subScreenStack.setStyle("-fx-background-color: transparent;");
        SubScene CompletionScreen = new SubScene(subScreenStack, 800, 600);
        CompletionScreen.setFill(Color.TRANSPARENT);
        CompletionScreen.setTranslateX(-10);
        //Activate preventing the sub-screen from appearing except after a specific event
        CompletionScreen.setVisible(false);

//-------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------
// SCENE BACKGROUND : 
        Image SceneBackground = new Image("file:BunyanImages/Murooj/background1.jpg");
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));

//-------------------------------------------------
        BorderPane root = new BorderPane();
        BoxBlur blur = new BoxBlur(5, 5, 3);
        root.setEffect(blur);
        root.setCenter(raysStack);
        root.setBackground(background);

        StackPane rootstack = new StackPane(root, CompletionScreen);
//---------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------
        Scene scene = new Scene(rootstack, 1500, 800);

//---------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------
// Home screen timer
//Half a second after the screen appears, the following event will be executed :
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
            raysStack.setVisible(true);//Show Rays
            CompletionScreen.setVisible(true); //show CompletionScreen (sub-Screen)
        }));
        timeline.play();//Run the time line

        TranslateStars(Stars1);
        TranslateStars(Stars2);
        TranslateStars(Stars3);

        return scene;

    }

    private void TranslateStars(ImageView stars) {

        TranslateTransition transition = new TranslateTransition(Duration.seconds(3), stars);
        transition.setToY(-219);//The location where the image will be moved
        transition.play();
        //The position where the image will settle after the time and event have ended
        transition.setOnFinished(event -> {
            stars.setTranslateY(-219);

        });
    }

}
