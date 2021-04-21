package com.pet.triviaapp.model;

public class TriviaList {
    String name;
    String date;
    String allData;

 /*   public TriviaList(String name, String date, String allData) {
        this.name = name;
        this.date = date;
        this.allData = allData;
    }*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAllData() {
        return allData;
    }

    public void setAllData(String allData) {
        this.allData = allData;
    }

}
