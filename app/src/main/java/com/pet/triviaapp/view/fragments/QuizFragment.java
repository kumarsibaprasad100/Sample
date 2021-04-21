package com.pet.triviaapp.view.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.pet.triviaapp.R;
import com.pet.triviaapp.model.AddDataClass;
import com.pet.triviaapp.model.QuestionModel;

import java.util.ArrayList;


public class QuizFragment extends Fragment implements View.OnClickListener {
    QuestionModel questionModel;
    private TextView tv_qs;
    ArrayList<String> qlist = new ArrayList<>();
    ArrayList<String> olist1 = new ArrayList<>();
    ArrayList<String> olist2 = new ArrayList<>();
    private RadioGroup radioGroup1;
    private RadioButton o1, o2, o3, o4;
    private TextView next;
    private String ans1;
   private String name;
   Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        tv_qs = view.findViewById(R.id.tv_question);
        radioGroup1 = view.findViewById(R.id.radio_group);
        next = view.findViewById(R.id.next);
        toolbar=view.findViewById(R.id.toolbar);
        toolbar.setTitle("Game 1");
        next.setOnClickListener(this::onClick);
        next.setVisibility(View.INVISIBLE);
        questionModel = AddDataClass.addData();
        qlist = questionModel.getQuestionlists();
        olist1 = questionModel.getOptionslists1();
        olist2 = questionModel.getOptionslists2();
        o1 = view.findViewById(R.id.option1);
        o2 = view.findViewById(R.id.option2);
        o3 = view.findViewById(R.id.option3);
        o4 = view.findViewById(R.id.option4);
        Bundle bundle=this.getArguments();
        name=bundle.getString("UserName","");


        for (int i = 0; i < olist1.size(); i++) {
            o1.setText(olist1.get(0));
            o2.setText(olist1.get(1));
            o3.setText(olist1.get(2));
            o4.setText(olist1.get(3));
        }

        for (int i = 0; i < qlist.size(); i++) {
            tv_qs.setText(qlist.get(0));
        }

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = view.findViewById(checkedId);
                ans1 = rb.getText().toString();
                next.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        String q1= tv_qs.getText().toString();
        QuizScreen2 quizScreen2 = new QuizScreen2(getContext(), ans1,name,q1);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, quizScreen2);
        fragmentTransaction.commit();

    }


}