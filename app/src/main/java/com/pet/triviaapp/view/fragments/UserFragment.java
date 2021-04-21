package com.pet.triviaapp.view.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pet.triviaapp.R;
import com.pet.triviaapp.intractor.UserIntractor;
import com.pet.triviaapp.presenter.UserFragPresenter;

public class UserFragment extends Fragment implements View.OnClickListener,UserIntractor.UserFragmentView {
    private TextView next,history;
    private EditText tv_username;
    UserFragPresenter  userFragPresenter;
    Context context;
    Toolbar toolbar;

    public UserFragment(Context applicationContext) {
        this.context=applicationContext;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.name_screen, container, false);
        next = view.findViewById(R.id.next);
        tv_username=view.findViewById(R.id.user_name);
        history=view.findViewById(R.id.history);
        toolbar=view.findViewById(R.id.toolbar);
        next.setOnClickListener(this::onClick);
        history.setOnClickListener(this::onClick);
        toolbar.setTitle("Registation");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userFragPresenter=new UserFragPresenter(context,UserFragment.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next:
                userFragPresenter.getUserName(tv_username);
                break;
            case R.id.history:
                openHIstory(context);
        }
        

    }

    private void openHIstory(Context context) {
        History history = new History (context);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, history);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void usernameView(String user) {
        QuizFragment quizFragment = new QuizFragment ();
        Bundle bundle = new Bundle();
        Log.i("TAG", "usernameView: "+user);
        bundle.putString("UserName",user );
        quizFragment.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, quizFragment);
        fragmentTransaction.commit();
    }
}