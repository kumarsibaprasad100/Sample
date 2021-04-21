package com.pet.triviaapp.intractor;

import com.pet.triviaapp.model.TriviaList;

import java.util.ArrayList;

public interface Historyintractor {
    interface HistoryDatapresenter{
        void sqldata();
    }

    interface  HistoryFragmentView{
        void getSqlData(ArrayList<TriviaList> triviaLists);
    }
}
