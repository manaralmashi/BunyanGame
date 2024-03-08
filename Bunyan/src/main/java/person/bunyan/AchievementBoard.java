/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

/**
 *
 * @author msms1
 */
public class AchievementBoard {
    private String name;
    private String levels;
    private String coins;
    private String time;

    public AchievementBoard() {
    }

    public AchievementBoard(String name, String levels, String coins, String time) {
        this.name = name;
        this.levels = levels;
        this.coins = coins;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

   

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}