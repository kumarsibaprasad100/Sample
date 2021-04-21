package com.pet.triviaapp.model;

import java.util.ArrayList;

public class QuestionModel {

    private ArrayList<String> Questionlists;
    private ArrayList<String> optionslists1;
    private ArrayList<String> optionslists2;


    public QuestionModel(ArrayList<String> questionlists, ArrayList<String> optionslists1, ArrayList<String> optionslists2) {
        Questionlists = questionlists;
        this.optionslists1 = optionslists1;
        this.optionslists2 = optionslists2;
    }

    public ArrayList<String> getQuestionlists() {
        return Questionlists;
    }

    public void setQuestionlists(ArrayList<String> questionlists) {
        Questionlists = questionlists;
    }

    public ArrayList<String> getOptionslists1() {
        return optionslists1;
    }

    public void setOptionslists1(ArrayList<String> optionslists1) {
        this.optionslists1 = optionslists1;
    }

    public ArrayList<String> getOptionslists2() {
        return optionslists2;
    }

    public void setOptionslists2(ArrayList<String> optionslists2) {
        this.optionslists2 = optionslists2;
    }





}
