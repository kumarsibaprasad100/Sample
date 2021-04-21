package com.pet.triviaapp.model;

import java.util.ArrayList;

public class AddDataClass {
    static String q1 = "Who is the Best Cricketer in the World ? ";
    static String q2 = "What are the colors in the Indian National flag ? ";
    static ArrayList<String> questionalList = new ArrayList<>();
    static ArrayList<String> optionList1 = new ArrayList<>();
    static ArrayList<String> optionList2 = new ArrayList<>();
    static QuestionModel questionModel;


    public static QuestionModel addData() {
        questionalList.add(q1);
        questionalList.add(q2);
        optionList1.add("Sachin Tendulkar");
        optionList1.add("Virat Kohli");
        optionList1.add("Adam Gilchirst");
        optionList1.add("Jacques Kallis");

        optionList2.add("White");
        optionList2.add("Yellow");
        optionList2.add("Orange");
        optionList2.add("Green");
        questionModel = new QuestionModel(questionalList,optionList1,optionList2);
        return questionModel;

    }
}
