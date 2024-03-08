/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author manaralmashi
 */
@Entity
@Table(name="avatars")
public class avatars implements java.io.Serializable {

    @Id
    @Column(name = "avatarImageID")
    private String avatarImageID;
    
    @Column(name = "avatarName")
    private String avatarName;

    public avatars() {
    }

    public avatars(String avatarImageID, String avatarName) {
        this.avatarImageID = avatarImageID;
        this.avatarName = avatarName;
    }

    public String getAvatarImageID() {
        return avatarImageID;
    }

    public void setAvatarImageID(String avatarImageID) {
        this.avatarImageID = avatarImageID;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }
    
}