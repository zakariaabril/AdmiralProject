package com.example.admiral.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employer")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String profession;

    private Date date_emb;
    private String status;
    private String username;
    private String password;

    @OneToMany(mappedBy = "employer")
    private List<FeuilleDeTemps> feuillesDeTemps;

    public Employer() {
    }

    public Employer(Long id, String nom, String prenom, String profession, Date date_emb, String status, String username, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.profession = profession;
        this.date_emb = date_emb;
        this.status = status;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getDate_emb() {
        return date_emb;
    }

    public void setDate_emb(Date date_emb) {
        this.date_emb = date_emb;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<FeuilleDeTemps> getFeuillesDeTemps() {
        return feuillesDeTemps;
    }

    public void setFeuillesDeTemps(List<FeuilleDeTemps> feuillesDeTemps) {
        this.feuillesDeTemps = feuillesDeTemps;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", profession='" + profession + '\'' +
                ", date_emb=" + date_emb +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", feuillesDeTemps=" + feuillesDeTemps +
                '}';
    }
}
