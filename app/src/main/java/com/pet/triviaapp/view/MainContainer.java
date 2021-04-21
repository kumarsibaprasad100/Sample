package com.pet.triviaapp.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.pet.triviaapp.R;
import com.pet.triviaapp.view.fragments.UserFragment;

public class MainContainer extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_container);
        UserFragment userFragment=new UserFragment(getApplicationContext());
        loadfragment(userFragment);

    }

   private void loadfragment(UserFragment userFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, userFragment).setCustomAnimations(R.anim.enter, R.anim.exit).commit();
    }


}
