/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;



import java.util.ArrayList;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author لميس
 */
public class AchievementGUI {
    private Button  back; 
    private ScaleTransition scale;
    private FadeTransition fade;
    private TableView table = new TableView();
    private Stage stage;
    private  Start_Interface startObj_A = null;
    public AchievementGUI() {
    }

    public AchievementGUI(Stage stage) {
        this.stage = stage;
    }
    
    public AchievementGUI(Stage stage,Start_Interface startObj) {
        this.stage = stage;
        this.startObj_A = startObj;
    }
    
    public Scene achievementInterface(){
//        startObj_A = startObj_A.getStart_S();
        if (startObj_A == null) {
            startObj_A.setAchievementGUI(this);
        } else {
            System.out.println("startObj_A is null. Cannot set AchievementGUI in Start_Interface.");
        }
        // SET the background to the root ---------------------------------------------------------------
        BorderPane root = new BorderPane();
        Image SceneBackground = new Image("file:BunyanImages/Lamis/stage.jpg");
        BackgroundSize size = new BackgroundSize(1800, 1000, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));
        root.setBackground(background);
        // -----------------------------------------------------------------------------------------------
        // to form it harmoniously
        Pane pane = new Pane();      
        //------------------------------------------------------------------------------------------------
        // stars wallpaper
        ImageView stars = new ImageView("file:BunyanImages/Lamis/Achev.png");
        stars.setFitHeight(500);
        stars.setFitWidth(600);
        stars.setEffect(new DropShadow(10, 5, 5, Color.BLACK));
        stars.setX(410);
        stars.setY(-65);
        pane.getChildren().add(stars);
        //------------------------------------------------------------------------------------------------
        // stars 
        ImageView starback = new ImageView("file:BunyanImages/Lamis/greenstar.png");
        starback.setFitHeight(80);
        starback.setFitWidth(140);
        //starback.setEffect(new DropShadow(10, 5, 5, Color.BLACK));
        starback.setX(640);
        starback.setY(48);
        Scale(starback);
        pane.getChildren().add(starback);

        ImageView star = new ImageView("file:BunyanImages/Lamis/star.png");
        star.setFitHeight(70);
        star.setFitWidth(130);
        star.setX(645);
        star.setY(53);
        Fade(star);
        pane.getChildren().add(star);
        
        ImageView starback2 = new ImageView("file:BunyanImages/Lamis/greenstar.png");
        starback2.setFitHeight(60);
        starback2.setFitWidth(120);
        //starback2.setEffect(new DropShadow(10, 5, 5, Color.BLACK));
        starback2.setX(528);
        starback2.setY(103);
        Scale(starback2);
        pane.getChildren().add(starback2);
        
        ImageView star2 = new ImageView("file:BunyanImages/Lamis/star.png");
        star2.setFitHeight(50);
        star2.setFitWidth(110);
        star2.setX(533);
        star2.setY(108);
        Fade(star2);
        pane.getChildren().add(star2);

        ImageView starback3 = new ImageView("file:BunyanImages/Lamis/greenstar.png");
        starback3.setFitHeight(60);
        starback3.setFitWidth(120);
       // starback3.setEffect(new DropShadow(10, 5, 5, Color.BLACK));
        starback3.setX(773);
        starback3.setY(102);
        Scale(starback3);
        pane.getChildren().add(starback3);

        ImageView star3 = new ImageView("file:BunyanImages/Lamis/star.png");
        star3.setFitHeight(50);
        star3.setFitWidth(110);
        star3.setX(778);
        star3.setY(107);
        Fade(star3);
        pane.getChildren().add(star3);
        
        ImageView starback4 = new ImageView("file:BunyanImages/Lamis/greenstar.png");
        starback4.setFitHeight(45);
        starback4.setFitWidth(90);
       // starback3.setEffect(new DropShadow(10, 5, 5, Color.BLACK));
        starback4.setX(468);
        starback4.setY(175);
        Scale(starback4);
        pane.getChildren().add(starback4);

        ImageView star4 = new ImageView("file:BunyanImages/Lamis/star.png");
        star4.setFitHeight(35);
        star4.setFitWidth(80);
        star4.setX(473);
        star4.setY(180);
        Fade(star4);
        pane.getChildren().add(star4);
        
        ImageView starback5 = new ImageView("file:BunyanImages/Lamis/greenstar.png");
        starback5.setFitHeight(45);
        starback5.setFitWidth(90);
       // starback3.setEffect(new DropShadow(10, 5, 5, Color.BLACK));
        starback5.setX(862);
        starback5.setY(174);
        Scale(starback5);
        pane.getChildren().add(starback5);

        ImageView star5 = new ImageView("file:BunyanImages/Lamis/star.png");
        star5.setFitHeight(35);
        star5.setFitWidth(80);
        star5.setX(867);
        star5.setY(179);
        Fade(star5);
        pane.getChildren().add(star5);
        // --------------------------------------------------------------------------------------------------------------        
        
        TableColumn<AchievementBoard,String> col1 = new TableColumn<>("Player");
        col1.setCellValueFactory(new PropertyValueFactory<AchievementBoard,String>("name"));
        
//                       col1.setCellFactory(param
//                              -> new TableCell() {
//                         {
//                            setBackground(new Background(new BackgroundFill(Color.rgb(234,171,104,0.7), null, null)));
//                           setTextFill(Color.BLACK);
//                          
//                     }
//                });
        
        col1.setCellFactory(column -> {
            return new TableCell<>() {
              
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                         setText(item);
                          //   AchievementBoard a = (AchievementBoard) getTableRow().getItem();
                            setBackground(new Background(new BackgroundFill(Color.rgb(249,216,103,0.9), null, null)));
                            setTextFill(Color.BLACK);
                            setTextFill(Color.GRAY);
                            setAlignment(Pos.CENTER);
                }
            };
        });
        
        TableColumn<AchievementBoard,String> col2 = new TableColumn<>("level");
        col2.setCellValueFactory(new PropertyValueFactory<AchievementBoard,String>("levels"));
        
        col2.setCellFactory(column -> {
            return new TableCell<>() {
              
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                            setText(item);
                           // AchievementBoard a = (AchievementBoard) getTableRow().getItem();
                            setBackground(new Background(new BackgroundFill(Color.rgb(249,216,103,0.9), null, null)));
                            setTextFill(Color.BLACK);
                            setTextFill(Color.GRAY);
                            setAlignment(Pos.CENTER);
                }
            };
        });
        
        TableColumn<AchievementBoard,String> col3 = new TableColumn<>("coins");
        col3.setCellValueFactory(new PropertyValueFactory<AchievementBoard,String>("coins"));
        col3.setCellFactory(column -> {
            return new TableCell<>() {
                
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                            setText(item);
                            AchievementBoard a = (AchievementBoard) getTableRow().getItem();
                            setBackground(new Background(new BackgroundFill(Color.rgb(249,216,103,0.9), null, null)));
                            setTextFill(Color.BLACK);
                            setTextFill(Color.GRAY);
                            setAlignment(Pos.CENTER);
                }
            };
        });
        
        TableColumn<AchievementBoard,String> col4 = new TableColumn<>("time");
        col4.setCellValueFactory(new PropertyValueFactory<AchievementBoard,String>("time"));
        col4.setCellFactory(column -> {
            return new TableCell<>() {
              
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                            setText(item);
                          //  AchievementBoard a = (AchievementBoard) getTableRow().getItem();
                            setBackground(new Background(new BackgroundFill(Color.rgb(249,216,103,0.9), null, null)));
                            //setTextFill(Color.rgb(1,0,0));216,103,0.7)
                            setTextFill(Color.GRAY);
                            setAlignment(Pos.CENTER);
                }
            };
        });
        // add the modified columns to the table
        table.getColumns().addAll(col1,col2,col3,col4);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setLayoutX(485);
        table.setLayoutY(290);
        table.setStyle("-fx-background-color: #ecd49c ; -fx-font-family:valoon; -fx-font-size:20;");
        table.setOpacity(1);
        table.setDisable(true);
        table.setEditable(false);
        
        //table.setMaxHeight(300);
        table.setMaxWidth(480);
        table.setMinHeight(300);
        table.setMinWidth(480);
        
        // to be able to scroll the table ------------------------------------------------------------------
        ScrollPane scroll = new ScrollPane(table);
        
        scroll.setLayoutX(470);
        scroll.setLayoutY(235);
        scroll.setMaxHeight(400);
        scroll.setMaxWidth(498);
        
        scroll.setMinHeight(300);
        scroll.setMinWidth(498);
       // scroll.setEffect(new DropShadow(20, 10, 2, Color.BLACK));
        scroll.setStyle("-fx-background-color: rgb(249,216,103,0.7); ");
        //---------------------------------------------------------------------------------------------------
        // add the cintent to the table from data base
         UpdateContent();
        //---------------------------------------------------------------------------------------------------
        
        pane.getChildren().add(scroll);
        StackPane backArc = new StackPane();
        // bouton formation ---------------------------------------------------------------------------------
        back = new Button();
        ImageView arcLStayle = new ImageView("file:BunyanImages/Lamis/ArcGoldL.png");
        arcLStayle.setFitHeight(120);
        arcLStayle.setFitWidth(320);
        ImageView arcL = new ImageView("file:BunyanImages/Lamis/arcleft.png");
        arcL.setFitHeight(100);
        arcL.setFitWidth(300);
        back.setGraphic(arcL);
        back.setStyle("-fx-background-color: transparent");
        Scale(back);
        backArc.getChildren().addAll(arcLStayle, back);
        HBox boxForBt = new HBox(backArc);
        
        // -------------------------------------------
        // to make the shape look more consistent
        Rectangle rec = new Rectangle(48,10);
        rec.setFill(Color.TRANSPARENT);
        
        // Add all the above to the root 
        root.setCenter(pane);
        root.setBottom(boxForBt);
        root.setLeft(rec);
        // actions 
        back.setOnAction(e->
        {
        stage.setScene(startObj_A.start(stage));
        }
        );
        
        Scene scene = new Scene(root, 1500, 800);
        return scene;
    }
    
    // to add some animation 
    public void Fade(Node node) {
        fade = new FadeTransition(Duration.millis(1000)); // the speed of the stars flashing
        fade.setNode(node); // add the star on which the effect will be placed
        fade.setFromValue(1.0); // from the natural and apparent form
        fade.setToValue(0.2); // to this
        fade.setCycleCount(1000); // number of times to apply the fade
        fade.setAutoReverse(true); // fade slowly
        fade.play();
    }
    // to add some animation 
    public void Scale(Node node) {
        scale = new ScaleTransition(Duration.millis(2000)); // the speed of the button flashing
        scale.setNode(node); // add the button on which the effect will be placed
        scale.setByX(-0.09); 
        scale.setByY(-0.09);
        scale.setCycleCount(100);
        scale.setAutoReverse(true);
        scale.play();
    }
    
    
    private void UpdateContent() { // DataBase
        List<Player> players  = getPlayers();
       
        //---------------------------------------------------------------------------
        List<Achievement> Achievements = getAchev();
        
        
       // List<AchievementBoard> tableboard =  new ArrayList<AchievementBoard>();
        for(int i=0; i<players.size();i++){
            //   System.out.println(p.getFname());
            String name = ((Player)players.get(i)).getFname()+" "+((Player)players.get(i)).getLname();
           // String level = Achievements.get(players.indexOf(p)).toString();
           //((Player)players.get(0)).getFname()
            Integer level = ((Achievement)Achievements.get(i)).getLevelNum();
            Integer coins = ((Achievement)Achievements.get(i)).getNumberOfCoins();
            String time = ((Achievement)Achievements.get(i)).getTotalTime();
            AchievementBoard a = new AchievementBoard(name,level.toString(),coins.toString(),time);
            table.getItems().add(a); 
        }
            

       
    }
    public List<Player> getPlayers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        // Check if the user already exists
        String q = "select p.* from player as p join Achievement as a on p.PlayerID = a.PlayerID order by  levelNum desc , numberOfCoins desc ,totalTime";
        Query<Player> query = session.createSQLQuery(q).addEntity(Player.class);
        //query.setParameter(,));
        // where PlayerID = (select PlayerID from Achievement order by levelNum desc,numberOfCoins desc,totalTime desc)
        List<Player> players = query.getResultList(); //  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 
        if (!(players.isEmpty())) {
            for(Player s:players){
            System.out.println(s.getFname()+" "+s.getLname());}

        } else {
            System.out.print("NOOOOOOOOOOOO player");

        }
        t.commit();
        session.close();
         //List<Player> players = new ArrayList<>();
         return players;
    
    
    
    }

      private List<Achievement> getAchev() {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = session1.beginTransaction();
        // Check if the user already exists
        // where PlayerID = (select PlayerID from Achievement order by levelNum desc,numberOfCoins desc,totalTime desc)
      

        String q1 = "select * from Achievement order by levelNum desc,numberOfCoins desc,totalTime";
        Query<Achievement> query1 = session1.createSQLQuery(q1).addEntity(Achievement.class);
        //query.setParameter(,));
          List<Achievement> Achievements  = query1.getResultList();

        if (!(Achievements.isEmpty())) {
            for(Achievement s:Achievements){
            System.out.println(s.getLevelNum()+" "+s.getTotalTime()+" "+s.getNumberOfCoins());}

        } else {
            System.out.print("NOOOOOOOOOOOO achev");

        }
        t1.commit();
        session1.close();
        // List<Achievement> Achievements  = query1.getResultList();

         return Achievements;
    }
    // setters and getters --------------------------------------------------------------

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Start_Interface getStartObj() {
        return startObj_A;
    }

    public void setStartObj(Start_Interface startObj) {
        this.startObj_A = startObj;
    }
}
