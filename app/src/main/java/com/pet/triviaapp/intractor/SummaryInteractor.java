package com.pet.triviaapp.intractor;

import android.content.Context;

public interface SummaryInteractor {
    interface SgetDatapresenter{
        void insertData(String userName, StringBuffer sb);
    }

    interface  SummaryFragmentView{
        void alldataView(Context context);
    }
}
