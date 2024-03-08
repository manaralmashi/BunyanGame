/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author Murooj
 */
public class TimeAndcoins {
    
    private long totalGameTime = 0; 
    private long TimeCounter; 
     long ScoundCounter ;
      long minutes ;
    private int coins;
    private int tree;
    private boolean Floor_1_Completed ;
  TimeCounter movingTimeCounter = new TimeCounter();
  coinsCounter coinsCounter=new coinsCounter();
  TreeCounter TreeCounter=new TreeCounter();
 
  Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> movingTimeCounter.updateTime()));

  Timeline coinsline = new Timeline(new KeyFrame(Duration.seconds(0.3), event -> coinsCounter.updatecoins(coins)));
  
  Timeline Treeline = new Timeline(new KeyFrame(Duration.seconds(0.3), event -> TreeCounter.updatetree(tree)));
   
    public void setTotalGameTime(long Time) {
        totalGameTime = Time;
    }

    public void setCoins(int coins) {

        this.coins += coins;
        coinsCounter.updatecoins(this.coins);
    }

    public void setTree(int coins) {
        if (coins < 0) {
            tree = 0;
        } else {
            this.tree = coins / 5;
            TreeCounter.updatetree(tree);
        }
    }

    public void setFloor_1_Completed(boolean Floor_1_Completed) {
        this.Floor_1_Completed = Floor_1_Completed;
    }

    public int getCoins() {
        return coins;
    }

    public long getTotalGameTime() {
        return totalGameTime;
    }

    public long getTimeCounter() {
        return TimeCounter;
    }

    public int getTree() {
        return tree;

    }

    public boolean getFloor_1_Completed() {
        return Floor_1_Completed;
    }


    
    class TimeCounter {
    private Label label = new Label("00:00");
    public Label getLabel() {
        return label;
    }

    public void updateTime() {
        TimeCounter++;
       
       if(ScoundCounter<60){
        ScoundCounter++;}
    
       else if (ScoundCounter>=60){
        ScoundCounter=0 ;
        ScoundCounter++;
    }
  
             minutes = TimeCounter / 60;
            label.setText(String.format("%02d:%02d", minutes,    ScoundCounter));
    }}
  
    class coinsCounter{
   Label label = new Label("0");
    public Label getLabel() {
        return label;
    }
    public void updatecoins(int coins) {
               label.setText(String.format("%d", getCoins()));
           
    }
    }

   class TreeCounter{
   Label label = new Label("0");
    public Label getLabel() {
        return label;
    }
    public void updatetree(int Tree) {
      label.setText(String.format("%d", getTree()));
           
    }
    }

}
