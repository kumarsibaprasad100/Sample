package com.pet.triviaapp.view.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.pet.triviaapp.R;
import com.pet.triviaapp.model.AddDataClass;
import com.pet.triviaapp.model.QuestionModel;
import com.pet.triviaapp.view.fragments.Summary;

import java.util.ArrayList;


public class QuizScreen2 extends Fragment implements View.OnClickListener {
    Context context;
    private String ans1;
    QuestionModel questionModel;
    private ArrayList<String> qlist = new ArrayList<>();
    private ArrayList<String> olist2 = new ArrayList<>();
    private CheckBox o1, o2, o3, o4;
    private TextView tv_qs;
    TextView next;
    String username,qes1;
    Toolbar toolbar;

    public QuizScreen2(Context context, String ans1, String name, String q1) {
        this.context = context;
        this.ans1 = ans1;
        this.username=name;
        this.qes1=q1;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz_screen2, container, false);
        questionModel = AddDataClass.addData();
        qlist = questionModel.getQuestionlists();
        olist2 = questionModel.getOptionslists2();
        tv_qs = view.findViewById(R.id.tv_question);
        toolbar=view.findViewById(R.id.toolbar);
        toolbar.setTitle("Game 1");
        o1 = view.findViewById(R.id.option1);
        o2 = view.findViewById(R.id.option2);
        o3 = view.findViewById(R.id.option3);
        o4 = view.findViewById(R.id.option4);
        next = view.findViewById(R.id.next);
        next.setOnClickListener(this::onClick);

        for (int i = 0; i < olist2.size(); i++) {
            o1.setText(olist2.get(0));
            o2.setText(olist2.get(1));
            o3.setText(olist2.get(2));
            o4.setText(olist2.get(3));
        }

        for (int i = 0; i < qlist.size(); i++) {
            tv_qs.setText(qlist.get(1));
        }
        return view;
    }


    @Override
    public void onClick(View v) {
        String ans2 = "";
        if (o1.isChecked()) {
            ans2 = o1.getText().toString();
        }
        if (o2.isChecked()) {
            ans2 = ans2  + ","+o2.getText().toString();
        }
        if (o3.isChecked()) {
            ans2 = ans2  + ","+o3.getText().toString();
        }
        if (o4.isChecked()) {
            ans2 = ans2  + ","+o4.getText().toString();
        }

        if (!o1.isChecked()){
            ans2=ans2.substring(1);
        }

        if (ans2.isEmpty()){
            Toast.makeText(context, "Please Select Your Answer", Toast.LENGTH_SHORT).show();
        }else {
            String s=tv_qs.getText().toString();
            Summary summary = new Summary(getContext(), ans1,ans2,username,qes1,s);
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, summary);
            fragmentTransaction.commit();
        }

    }
}