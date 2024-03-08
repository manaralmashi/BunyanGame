/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;


/**
 *
 * @author rahaf
 */
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author rahaf
 */

public class Level2 {


       Start_Interface startLv2 ;
       Level2(Stage stage,Start_Interface startLv2){
       this.primaryStage= stage ;
       this.startLv2=startLv2;
    }
       
    public int getCorrect_guesses() {
        return correct_guesses;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }

 
    
    String[] questions = {"13 + 14 = ?","15 × 3 = ?","121 ÷ 11 = ?","169 ÷ ? = 13","8 + ? = 13","(2 + 5) × 7 + 1 = ?","30 ÷ 5 + 1 = ?", "196 ÷ 14 + 1 = ?","270 ÷ 9 + 5 × 4 = ?","10 + 5 × 7 - 13 = ?"};
    String[][] options = {{"37","27","26"},{"45","35","40"},{"12","11","21"},{"13","16","9"},{"5","6","7"},{"56","50","30"},{"7","5","6"},{"14","13","15"},{"50","40","30"},{"92","32","52"}};
    String[] answers = {"27","45","11","13","5","50","7","15","50","32"};
    String answer;
    int index;
    private int correct_guesses=0;
    private int correctans=0;
    private int numTree=0;
    int total_questions = questions.length;
    Label q = new Label();
    Button ch1= new Button();
    Button ch2 = new Button();
    Button ch3 = new Button();
    StackPane stackPane1 = new StackPane();
    StackPane stackPane2 = new StackPane();
    StackPane stackPane3 = new StackPane();
    Label a1 = new Label();
    Label a2 = new Label();
    Label a3 = new Label();
    Timeline pause;
    Label coines;
    Label trees;
    Button start;
    Timeline startTimer = new Timeline();
    Label time;
    Label treeLabel;
    Label coinesLabel;
    long startTime;
    private long minutes;
    private long seconds;
    private boolean isComplete = false;
    Stage primaryStage;
   
    public void setNumTree() {
      numTree=  this.correct_guesses/5;
    }
     
    
  Scene createScene1(){
      correct_guesses=startLv2.getLevels().getTotalCoins();
      numTree=startLv2.getLevels().getTotalTrees();
       Image SceneBackground = new Image("file:BunyanImages/Rahaf/Interface1.jpg");
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size)); 
        StackPane level2 = new StackPane();
        ImageView lev = new ImageView("file:BunyanImages/Rahaf/Woodenbuttons3.png");
        lev.setFitWidth(350);
        lev.setFitHeight(150);
        Label l = new Label("LEVEL 2");
        l.setStyle("-fx-font-family: 'Valoon';-fx-background-color: transparet; -fx-font-size: 50px; -fx-text-fill: white;");
        level2.getChildren().addAll(lev,l);
        level2.setTranslateY(-200);
        ImageView img = new ImageView("file:BunyanImages/Rahaf/homeButton.png");
        img.setFitWidth(80);
        img.setFitHeight(80);
        Button home = new Button();
        home.setGraphic(img);
        home.setTranslateX(-130);
        home.setTranslateY(200);
        home.setStyle("-fx-background-color: transparet;");
        ImageView img1 = new ImageView("file:BunyanImages/Rahaf/achievmentButton.png");
        img1.setFitWidth(80);
        img1.setFitHeight(80);
        ImageView img2 = new ImageView("file:BunyanImages/Rahaf/achievment.png");
        img2.setFitWidth(60);
        img2.setFitHeight(60);
        StackPane achPane = new StackPane();
        achPane.getChildren().addAll(img1,img2);
        Button ach = new Button();
        ach.setGraphic(achPane);
        ach.setTranslateX(130);
        ach.setTranslateY(200);
        ach.setStyle("-fx-background-color: transparet;");
        ImageView startbutton1 = new ImageView("file:BunyanImages/Rahaf/startButton.png");
        startbutton1.setFitWidth(170);
        startbutton1.setFitHeight(170);
        start = new Button();
        start.setGraphic(startbutton1);
        start.setStyle("-fx-background-color: transparet;");
        start.setTranslateY(30);
        start.setOnAction(e -> {startTimer();
        primaryStage.setScene(createScene2());});
        start.setOnMouseEntered(e -> {start.setScaleX(1.15);start.setScaleY(1.15);});
        start.setOnMouseExited(e -> {start.setScaleX(1);start.setScaleY(1);});
        home.setOnAction(e -> {primaryStage.setScene(startLv2.getLevels().start(primaryStage));});
        home.setOnMouseEntered(e -> {home.setScaleX(1.15);home.setScaleY(1.15);});
        home.setOnMouseExited(e -> {home.setScaleX(1);home.setScaleY(1);});
        //hhhhhhhhhhhhhhhheerrrr
        ach.setOnAction(e -> {primaryStage.setScene(startLv2.getAchievementGUI().achievementInterface());});
        ach.setOnMouseEntered(e -> {ach.setScaleX(1.15);ach.setScaleY(1.15);});
        ach.setOnMouseExited(e -> {ach.setScaleX(1);ach.setScaleY(1);});
        StackPane root = new StackPane();
        root.getChildren().addAll(level2,start,home,ach);
        root.setBackground(background);
        Scene scene1 = new Scene(root,1500, 800);
        return scene1;}
    
    Scene createScene2(){
        Image SceneBackground = new Image("file:BunyanImages/Rahaf/Interface2.jpg");
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));
        ImageView mainch = new ImageView("file:BunyanImages/Rahaf/ch10.png");
        mainch.setFitWidth(220);
        mainch.setFitHeight(540);
        mainch.setTranslateX(-450);
        mainch.setTranslateY(60);
        ImageView choice1 = new ImageView(new Image("file:BunyanImages/Rahaf/choice.png"));
        ImageView choice2 = new ImageView(new Image("file:BunyanImages/Rahaf/choice.png"));
        ImageView choice3 = new ImageView(new Image("file:BunyanImages/Rahaf/choice.png"));
        choice1.setFitWidth(340);
        choice1.setFitHeight(100);
        choice2.setFitWidth(340);
        choice2.setFitHeight(100);
        choice3.setFitWidth(340);
        choice3.setFitHeight(100);
        stackPane1.getChildren().addAll(choice1,a1);
        stackPane2.getChildren().addAll(choice2,a2);
        stackPane3.getChildren().addAll(choice3,a3);
        q.setPrefSize(670, 90);
        q.setStyle("-fx-font-family: 'Valoon';-fx-background-color: white; -fx-font-size: 50px; -fx-text-fill: brown;");
        q.setAlignment(Pos.CENTER);
        Label A = new Label("Answer:");
        A.setStyle("-fx-font-family: 'Valoon';-fx-background-color: transparet; -fx-font-size: 50px; -fx-text-fill: white;");
        ch1.setGraphic(stackPane1);
        ch1.setStyle("-fx-background-color: transparet;");
        ch1.setOnMouseEntered(e -> {ch1.setScaleX(1.15);ch1.setScaleY(1.15);});
        ch1.setOnMouseExited(e -> {ch1.setScaleX(1);ch1.setScaleY(1);});
        ch2.setGraphic(stackPane2);
        ch2.setStyle("-fx-background-color: transparet;");
        ch2.setOnMouseEntered(e -> {ch2.setScaleX(1.15);ch2.setScaleY(1.15);});
        ch2.setOnMouseExited(e -> {ch2.setScaleX(1);ch2.setScaleY(1);});
        ch3.setGraphic(stackPane3);
        ch3.setStyle("-fx-background-color: transparet;");
        ch3.setOnMouseEntered(e -> {ch3.setScaleX(1.15);ch3.setScaleY(1.15);});
        ch3.setOnMouseExited(e -> {ch3.setScaleX(1);ch3.setScaleY(1);});
        VBox choice = new VBox(20);
        choice.getChildren().addAll(q,A,ch1,ch2,ch3);
        choice.setAlignment(Pos.CENTER);
        choice.setTranslateX(20);
        choice.setTranslateY(42);
        Image coin = new Image("file:BunyanImages/Rahaf/coins.png");
        ImageView coinicon = new ImageView(coin);
        coinicon.setFitWidth(50);
        coinicon.setFitHeight(50);
        Image tree = new Image("file:BunyanImages/Rahaf/trees.png");
        ImageView treeimg = new ImageView(tree);
        treeimg.setFitWidth(50);
        treeimg.setFitHeight(50);
        Image timeimg = new Image("file:BunyanImages/Rahaf/timer.png");
        ImageView timeimg1 = new ImageView(timeimg);
        timeimg1.setFitWidth(50);
        timeimg1.setFitHeight(50);
        coines = new Label(""+correct_guesses+"   ",coinicon);
        coines.setContentDisplay(ContentDisplay.RIGHT);
        coines.setAlignment(Pos.CENTER_RIGHT);
        coines.setStyle("-fx-background-color: #ffb349;-fx-background-radius: 60; -fx-text-fill: white;-fx-font-family: 'Valoon';-fx-font-size: 30px;");
        coines.setPrefWidth(180);
        trees = new Label(numTree+"",treeimg);
        trees.setAlignment(Pos.CENTER_RIGHT);
        trees.setContentDisplay(ContentDisplay.RIGHT);
        trees.setStyle("-fx-background-color: #ffb349;-fx-background-radius: 60; -fx-text-fill: white;-fx-font-family: 'Valoon';-fx-font-size: 30px;");
        trees.setPrefWidth(180);
        time = new Label("00:00  ",timeimg1);
        time.setContentDisplay(ContentDisplay.RIGHT);
        time.setAlignment(Pos.CENTER_RIGHT);
        time.setStyle("-fx-background-color: #ffb349;-fx-background-radius: 60; -fx-text-fill: white;-fx-font-family: 'Valoon';-fx-font-size: 30px;");
        time.setPrefWidth(180);
        VBox icon = new VBox(20);
        icon.getChildren().addAll(coines,time,trees);
        icon.setTranslateX(1200);
        icon.setTranslateY(70);
        nextQuestion();
        ch1.setOnAction(e -> {SelectedAnswer(e);});
        ch2.setOnAction(e -> {SelectedAnswer(e);});
        ch3.setOnAction(e -> {SelectedAnswer(e);});
        StackPane root = new StackPane();
        root.getChildren().addAll(mainch,icon,choice); 
        root.setBackground(background);
        Scene scene2 = new Scene(root,1500, 800);  
        return scene2;}


    public void nextQuestion(){
           if(index >= total_questions){
               pause.stop(); 
               startTimer.stop();
               primaryStage.setScene(createScene3());
               coinesLabel.setText(correct_guesses+"");
               treeLabel.setText(numTree+"");
               startLv2.getLevels().setTotalCoins(correct_guesses);
               startLv2.getLevels().setTotalTrees(numTree);
           }
           else{
               q.setText("Q"+(index+1)+" : "+questions[index]);
               a1.setStyle("-fx-font-family: 'Valoon';-fx-font-size: 40px; -fx-text-fill: white;");
               a1.setText(options[index][0]);
               a2.setStyle("-fx-font-family: 'Valoon';-fx-font-size: 40px; -fx-text-fill: white;");
               a2.setText(options[index][1]);
               a3.setStyle("-fx-font-family: 'Valoon';-fx-font-size: 40px; -fx-text-fill: white;");
               a3.setText(options[index][2]);   
           }
    }
    
    public void SelectedAnswer(ActionEvent e){
        RotateTransition rotate = new RotateTransition();
        RotateTransition rotate2 = new RotateTransition();
        if(e.getSource() == ch1){
            answer = ((Label)stackPane1.getChildren().get(1)).getText();
            if(answer.equals(answers[index])){
                correct_guesses+=10;
                 correctans+=10;
                setNumTree();
            }  
            else{            rotate.setNode(stackPane1.getChildren().get(0));
            rotate.setDuration(Duration.millis(100));
            rotate.setCycleCount(10);
            rotate.setByAngle(5);
            rotate.setAutoReverse(true);
            rotate.play();  
            
            rotate2.setNode(stackPane1.getChildren().get(0));
            rotate2.setDuration(Duration.millis(100));
            rotate2.setCycleCount(10);
            rotate2.setByAngle(-5);
            rotate2.setAutoReverse(true);
            rotate2.play();}
        }
        
        if(e.getSource() == ch2){
            answer = ((Label)stackPane2.getChildren().get(1)).getText();
            if(answer.equals(answers[index])){
                correct_guesses+=10;
                correctans+=10;
                setNumTree();
            }
            else{
            rotate.setNode(stackPane2.getChildren().get(0));
            rotate.setDuration(Duration.millis(100));
            rotate.setCycleCount(10);
            rotate.setByAngle(5);
            rotate.setAutoReverse(true);
            rotate.play();  
            
            rotate2.setNode(stackPane2.getChildren().get(0));
            rotate2.setDuration(Duration.millis(100));
            rotate2.setCycleCount(10);
            rotate2.setByAngle(-5);
            rotate2.setAutoReverse(true);
            rotate2.play();}
        }
        
        if(e.getSource() == ch3){
            answer = ((Label)stackPane3.getChildren().get(1)).getText();
            if(answer.equals(answers[index])){
                correct_guesses+=10;
                 correctans+=10;
                setNumTree();
            } 
            else{            
            rotate.setNode(stackPane3.getChildren().get(0));
            rotate.setDuration(Duration.millis(100));
            rotate.setCycleCount(10);
            rotate.setByAngle(5);
            rotate.setAutoReverse(true);
            rotate.play();  
            
            rotate2.setNode(stackPane3.getChildren().get(0));
            rotate2.setDuration(Duration.millis(100));
            rotate2.setCycleCount(10);
            rotate2.setByAngle(-5);
            rotate2.setAutoReverse(true);
            rotate2.play();}
        }
    coines.setText(""+correct_guesses+"   ");
    displayAnswer();
    }
    
    public void displayAnswer(){
        
        if(answers[index]!=((Label)stackPane1.getChildren().get(1)).getText()){
            ((Label)stackPane1.getChildren().get(1)).setStyle("-fx-font-family: 'Valoon';-fx-font-size: 40px;-fx-text-fill: 'red';");    
        }
        if(answers[index]!=((Label)stackPane2.getChildren().get(1)).getText()){
            ((Label)stackPane2.getChildren().get(1)).setStyle("-fx-font-family: 'Valoon';-fx-font-size: 40px;-fx-text-fill: 'red';");   
        }
        if(answers[index]!=((Label)stackPane3.getChildren().get(1)).getText()){
            ((Label)stackPane3.getChildren().get(1)).setStyle("-fx-font-family: 'Valoon';-fx-font-size: 40px;-fx-text-fill: 'red';");

        }
        pause = new Timeline(new KeyFrame(Duration.seconds(1),event -> {
            ((Label)stackPane1.getChildren().get(1)).setStyle("-fx-font-family: 'Valoon';-fx-font-size: 40px;-fx-text-fill: white;");
            ((Label)stackPane2.getChildren().get(1)).setStyle("-fx-font-family: 'Valoon';-fx-font-size: 40px;-fx-text-fill: white;");
            ((Label)stackPane3.getChildren().get(1)).setStyle("-fx-font-family: 'Valoon';-fx-font-size: 40px;-fx-text-fill: white;");
            index++;
            nextQuestion();
        }));
        pause.play();
        pause.setCycleCount(0);
        
}

   
    Scene createScene3(){
        Image SceneBackground = new Image("file:BunyanImages/Rahaf/Interface3.jpg");
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));
        ImageView mainch = new ImageView("file:BunyanImages/Rahaf/ch6.png");
        mainch.setFitWidth(220);
        mainch.setFitHeight(540);
        mainch.setTranslateX(-500);
        mainch.setTranslateY(55);
        ImageView bord = new ImageView("file:BunyanImages/Rahaf/wininng border.png");
        bord.setFitWidth(650);
        bord.setFitHeight(500);
        Label l2 = new Label("LEVEL 2");
        l2.setStyle("-fx-font-family: 'Valoon';-fx-font-size: 60px;-fx-text-fill: '#3d5938';");
        l2.setTranslateY(-80);
        Label completed = new Label("COMPLETED !");
        completed.setStyle("-fx-font-family: 'Valoon';-fx-font-size: 60px;-fx-text-fill: white;");
        StackPane root = new StackPane();
        treeLabel = new Label();
        treeLabel.setStyle("-fx-font-family: 'Valoon';-fx-font-size: 30px;-fx-text-fill: white;");
        treeLabel.setTranslateX(-80);
        treeLabel.setTranslateY(102);
        coinesLabel = new Label();
        coinesLabel.setStyle("-fx-font-family: 'Valoon';-fx-font-size: 30px;-fx-text-fill: white;");
        coinesLabel.setTranslateX(165);
        coinesLabel.setTranslateY(100);
        ImageView zeroStar = new ImageView(new Image("file:BunyanImages/Rahaf/zeroStar.png"));
        zeroStar.setTranslateX(-10);
        zeroStar.setTranslateY(-194);
        zeroStar.setFitWidth(520);
        zeroStar.setFitHeight(220);
        zeroStar.setVisible(correctans == 0);
        ImageView oneStar = new ImageView(new Image("file:BunyanImages/Rahaf/oneStar.png"));
        oneStar.setTranslateX(-10);
        oneStar.setTranslateY(-200);
        oneStar.setFitWidth(430);
        oneStar.setFitHeight(200);
        oneStar.setVisible(correctans <= 30 && correctans!=0 );
        ImageView oneAndHalfStar = new ImageView(new Image("file:BunyanImages/Rahaf/oneAndHalfStar.png"));
        oneAndHalfStar.setTranslateX(-10);
        oneAndHalfStar.setTranslateY(-200);
        oneAndHalfStar.setFitWidth(630);
        oneAndHalfStar.setFitHeight(220);
        oneAndHalfStar.setVisible(correctans <=60  && correctans!=0 && correctans>=40 );
        ImageView twoAndHalfStar = new ImageView(new Image("file:BunyanImages/Rahaf/twoAndHalfStars.png"));
        twoAndHalfStar.setTranslateX(5);
        twoAndHalfStar.setTranslateY(-210);
        twoAndHalfStar.setFitWidth(580);
        twoAndHalfStar.setFitHeight(240);
        twoAndHalfStar.setVisible(correctans <=90  && correctans!=0 && correctans>=70);
        ImageView threeStar = new ImageView(new Image("file:BunyanImages/Rahaf/threeStars.png"));
        threeStar.setTranslateX(15.5);
        threeStar.setTranslateY(-200);
        threeStar.setFitWidth(680);
        threeStar.setFitHeight(300);
        threeStar.setVisible(correctans == 100);
        ImageView home = new ImageView(new Image("file:BunyanImages/Rahaf/goHome.png"));
        home.setFitWidth(80);
        home.setFitHeight(80);
        Button homePage = new Button();
        homePage.setGraphic(home);
        home.setTranslateX(270);
        home.setTranslateY(180);
        homePage.setStyle("-fx-background-color: transparet;");
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(home);
        scale.setDuration(Duration.seconds(2));
        scale.setCycleCount(TranslateTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(0.3);
        scale.setByY(0.3);
        scale.setAutoReverse(true);
        scale.play();
        homePage.setOnAction(e -> {
        startLv2.getLevels().updateCurrentLevelIndex(2);
        startLv2.getLevels().setTotalTime(minutes, seconds);
        System.out.println(startLv2.getLevels().getTotalTime());
        /////////print for testing//////////
        System.out.println(startLv2.getProfile().getStartObj_P().getPlayer().getPlayerID());
        ///////////////////database////////////////

        startLv2.getLevels().setTotalTime(minutes, seconds);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();   
        String queryPlease = "UPDATE Achievement SET levelNum = : lv , totalTime = : t ,numberOfCoins = : coins WHERE PlayerID = : id";
        Query query = session.createQuery(queryPlease);
        query.setParameter("lv",startLv2.getLevels().getCurrentLevelIndex() );
        query.setParameter("t", startLv2.getLevels().getTotalTime());
        query.setParameter("coins",correct_guesses);
        query.setParameter("id",startLv2.getProfile().getStartObj_P().getPlayer().getPlayerID());
        int result = query.executeUpdate();
        tx.commit();
        session.close();

        //////////////////////////////////////////
        primaryStage.setScene(startLv2.getLevels().start(primaryStage));
        System.out.println(startLv2.getLevels().getTotalTime()+"  "+startLv2.getLevels().getCurrentLevelIndex()+"  "+startLv2.getLevels().getTotalCoins()+" " +startLv2.getLevels().getTotalTrees());
       });//go home page
        
        root.getChildren().addAll(mainch,bord,zeroStar,oneStar,oneAndHalfStar,twoAndHalfStar,threeStar,l2,completed,homePage,treeLabel,coinesLabel);
       root.setBackground(background);
        Scene scene3 = new Scene(root,1500, 800);
        return scene3;}

    
    void startTimer() {
        startTime = System.currentTimeMillis();
        startTimer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime;

                // Convert elapsed time to minutes and seconds
                minutes = (elapsedTime / 1000) / 60;
                seconds = (elapsedTime / 1000) % 60;

                // Create the time string in mm:ss format
                String formattedTime = String.format("%02d:%02d", minutes, seconds);
                // Update the label text
                time.setText(formattedTime+"  ");
                trees.setText(numTree+"   ");
            }
        }));
        startTimer.setCycleCount(Timeline.INDEFINITE);
        startTimer.play();
    }
  
}
