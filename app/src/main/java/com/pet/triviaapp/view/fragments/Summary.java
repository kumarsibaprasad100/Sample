package com.pet.triviaapp.view.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pet.triviaapp.R;
import com.pet.triviaapp.intractor.SummaryInteractor;
import com.pet.triviaapp.presenter.SummaryPresenter;


public class Summary extends Fragment implements View.OnClickListener, SummaryInteractor.SummaryFragmentView {
    private TextView name, q1, q2, a1, a2;
    private String qes1, qes2, ans1, ans2, userName;
    private Button finish;
    Context context;
    private StringBuffer sb;
    Toolbar toolbar;
    SummaryPresenter summaryPresenter;

    public Summary(Context context, String ans1, String ans2, String username, String qes1, String s) {
        this.userName = username;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.qes1 = qes1;
        this.qes2 = s;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        name = view.findViewById(R.id.name);
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Summary");
        q1 = view.findViewById(R.id.q1);
        q2 = view.findViewById(R.id.q2);
        a1 = view.findViewById(R.id.a1);
        a2 = view.findViewById(R.id.a2);
        finish = view.findViewById(R.id.finish);
        finish.setOnClickListener(this::onClick);
        name.setText("Hello" + " " + userName);
        q1.setText("Q1: " + qes1);
        a1.setText("Answer: " + ans1);
        q2.setText("Q2: " + qes2);
        a2.setText("Answer: " + ans2);

        sb = new StringBuffer();
        sb.append(q1.getText().toString() + "\n" + a1.getText().toString() + "\n" + q2.getText().toString() + "\n" + a2.getText().toString());
        Log.i("TAG", "onCreateView: " + sb);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        summaryPresenter=new SummaryPresenter(context,Summary.this);
    }

    @Override
    public void onClick(View v) {
        summaryPresenter.insertData(userName,sb);
    }

    @Override
    public void alldataView(Context context) {
        Toast.makeText(context, "Successfully Submited", Toast.LENGTH_SHORT).show();
        UserFragment userFragment = new UserFragment(context);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, userFragment);
        fragmentTransaction.commit();
    }
}