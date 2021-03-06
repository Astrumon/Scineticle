package com.kpi.scineticle.model.subsystemOfDataBase.patents;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;

import java.io.Serializable;

@Entity(tableName = "patent_table")
public class Patent extends ScientWork implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String authors;

    private String namePatentOwner;

    private String name;

    private String country;

    private String number;

    private String date;

    private String userLogin;

    private int newest;

    public int getNewest() {
        return newest;
    }

    public void setNewest(int newest) {
        this.newest = newest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patent() {
        super.setTypeOfWork("Патент");
    }

    public Patent(String authors, String namePatentOwner, String name, String country, String number, String date) {
        this.authors = authors;
        this.namePatentOwner = namePatentOwner;
        this.name = name;
        this.country = country;
        this.number = number;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Patent{" +
                ", authors='" + authors + '\'' +
                ", namePatentOwner='" + namePatentOwner + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", number='" + number + '\'' +
                ", date='" + date + '\'' +
                ", userLogin=" + userLogin +
                '}';
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getNamePatentOwner() {
        return namePatentOwner;
    }

    public void setNamePatentOwner(String namePatentOwner) {
        this.namePatentOwner = namePatentOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public boolean isValidAuthors() {
        return mTextValidator.validateAuthorsName(authors);
    }

    public boolean isValidNamePatentOwner() {
        return mTextValidator.validateName(namePatentOwner);
    }

    public boolean isValidName() {
        return mTextValidator.validateName(name);
    }

    public boolean isValidCountry() {
        return mTextValidator.validateCity(country);
    }

    public boolean isValidNumber() {
        return mTextValidator.validateNumber(number);
    }

    public boolean isValidDate() {
        return mTextValidator.validateDate(date);
    }

}
