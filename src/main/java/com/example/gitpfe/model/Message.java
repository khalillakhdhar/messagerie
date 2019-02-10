/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gitpfe.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name = "Message")
@EntityListeners(AuditingEntityListener.class)



/**
 *
 * @author khalil
 */
public class Message {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
       private String text,date;
       @NotBlank
       private String emeteur;
       @NotBlank
       private String recepteur;
       

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public String getEmeteur() {
        return emeteur;
    }

    public String getRecepteur() {
        return recepteur;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmeteur(String emeteur) {
        this.emeteur = emeteur;
    }

    public void setRecepteur(String recepteur) {
        this.recepteur = recepteur;
    }
       
    
}
