/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

import javax.persistence.*;


/**
 *
 * @author msms1
 */

//achievementID INT(10) NOT NULL AUTO_INCREMENT,
//playerID INT(6),
//levelNum INT(1) ,
//totalTime String(20),
//numberOfCoins INT(4) 


@Entity
public class Achievement implements java.io.Serializable {
    @Id
    @Column(name = "achievementID")
    private int achievementID;

    @Column(name = "playerID")
    private int playerID;

    @Column(name = "levelNum")
    private int levelNum;

    @Column(name = "totalTime")
    private String totalTime;

    @Column(name = "numberOfCoins")
    private int numberOfCoins;

    public Achievement() {
    }

    public Achievement(int playerID,int levelNum,String totalTime, int numberOfCoins) {
        this.playerID = playerID;
        this.levelNum = levelNum;
        this.totalTime = totalTime;
        this.numberOfCoins = numberOfCoins;
    }

    public int getAchievementID() {
        return achievementID;
    }

    public void setAchievementID(int achievementID) {
        this.achievementID = achievementID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    
    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    public void setNumberOfCoins(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }   
      
}