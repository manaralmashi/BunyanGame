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
//PlayerID int(10) not null auto_increment,
//fname varchar(50) not null,
//lname varchar(50) not null,
//PlayerEmail varchar(50) not null unique,
//PlayerPass varchar(50) not null,
//playerQues varchar(50) not null,
//playerAns varchar(50) not null,
//avatar varchar(2),

@Entity
public class Player implements java.io.Serializable {
    @Id
    @Column(name = "PlayerID")
    private int PlayerID;

    @Column(name = "fname")
    private String fname;
    
    @Column(name = "lname")
    private String lname;
    
    @Column(name = "PlayerEmail")
    private String PlayerEmail;
    
    @Column(name = "PlayerPass")
    private String PlayerPass;
    
    @Column(name = "playerQues")
    private String playerQues;
    
    @Column(name = "playerAns")
    private String playerAns;
    
    @Column(name = "avatar")
    private String avatar;

    public Player() {
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int PlayerID) {
        this.PlayerID = PlayerID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPlayerEmail() {
        return PlayerEmail;
    }

    public void setPlayerEmail(String PlayerEmail) {
        this.PlayerEmail = PlayerEmail;
    }

    public String getPlayerPass() {
        return PlayerPass;
    }

    public void setPlayerPass(String PlayerPass) {
        this.PlayerPass = PlayerPass;
    }

    public String getPlayerQues() {
        return playerQues;
    }

    public void setPlayerQues(String playerQues) {
        this.playerQues = playerQues;
    }

    public String getPlayerAns() {
        return playerAns;
    }

    public void setPlayerAns(String playerAns) {
        this.playerAns = playerAns;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    
}