package com.pet.triviaapp.intractor;

import android.widget.EditText;

public interface UserIntractor {

   interface Userpresenter{
       void getUserName(EditText tv_username);
   }

   interface  UserFragmentView{
       void usernameView(String user);
   }
}
