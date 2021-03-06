package com.kpi.scineticle.model.subsystemOfDataBase.book;

import android.icu.text.TimeZoneFormat;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;

import java.io.Serializable;

@Entity(tableName = "book_table")

public class Book extends ScientWork implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String authors;

    private String name;

    private String statement;

    private String place;

    private String year;

    private String part;

    private String publish;

    private String countOfSheets;

    private String userLogin;

    private int newest;

    public Book() {
        super.setTypeOfWork("Книга");
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public int getNewest() {
        return newest;
    }

    public void setNewest(int newest) {
        this.newest = newest;
    }

    public Book(String authors, String name, String statement, String place, String publish, String year, String part, String countOfSheets) {
        this.authors = authors;
        this.name = name;
        this.statement = statement;
        this.place = place;
        this.year = year;
        this.part = part;
        this.countOfSheets = countOfSheets;
        super.setTypeOfWork("Книга");
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getCountOfSheets() {
        return countOfSheets;
    }

    public void setCountOfSheets(String countOfSheets) {
        this.countOfSheets = countOfSheets;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors='" + authors + '\'' +
                ", name='" + name + '\'' +
                ", statement='" + statement + '\'' +
                ", place='" + place + '\'' +
                ", year='" + year + '\'' +
                ", part='" + part + '\'' +
                ", countOfSheets=" + countOfSheets +
                ", userLogin=" + userLogin +
                '}';
    }

    public boolean isValidAuthors() {
        return mTextValidator.validateAuthorsName(authors);
    }

    public boolean isValidName() {
        return mTextValidator.validateName(name);
    }

    public boolean isValidStatement() {
        return mTextValidator.validateStatement(statement);
    }

    public boolean isValidPlace() {
        return mTextValidator.validateStatement(place);
    }

    public boolean isValidYear() {
        return mTextValidator.validateYear(year);
    }

    public boolean isValidSheet() {
        return mTextValidator.validateSheet(countOfSheets);
    }

    public boolean isValidPublish() {
        return mTextValidator.validateName(publish);
    }


}
