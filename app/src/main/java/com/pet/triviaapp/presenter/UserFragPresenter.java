package com.pet.triviaapp.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.pet.triviaapp.intractor.UserIntractor;
import com.pet.triviaapp.view.fragments.UserFragment;

public class UserFragPresenter implements UserIntractor.Userpresenter {
    Context context;
    UserIntractor.UserFragmentView userFragmentView;

    public UserFragPresenter(Context context, UserIntractor.UserFragmentView  userFragmentView) {
        this.context = context;
        this.userFragmentView=userFragmentView;
    }

    @Override
    public void getUserName(EditText tv_username) {
        String user;
        if (TextUtils.isEmpty(tv_username.getText().toString())){
            tv_username.setError("please fill your Name");
        }else {
            user=tv_username.getText().toString();
            userFragmentView.usernameView(user);
        }
    }
}
