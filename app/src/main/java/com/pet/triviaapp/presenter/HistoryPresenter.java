package com.pet.triviaapp.presenter;

import android.content.Context;
import android.database.Cursor;

import com.pet.triviaapp.database.DatabaseHelper;
import com.pet.triviaapp.intractor.Historyintractor;
import com.pet.triviaapp.model.TriviaList;

import java.util.ArrayList;

public class HistoryPresenter implements Historyintractor.HistoryDatapresenter {
    Historyintractor.HistoryFragmentView historyFragmentView;
    Context context;
    private ArrayList<TriviaList> triviaLists = new ArrayList<>();

    public HistoryPresenter(Context context, Historyintractor.HistoryFragmentView history) {
        this.historyFragmentView = history;
        this.context = context;
    }

    @Override
    public void sqldata() {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        Cursor cursor = databaseHelper.getTriviaList();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String username = cursor.getString(cursor.getColumnIndex("userName"));
                String date = cursor.getString(cursor.getColumnIndex("Date"));
                String alldata = cursor.getString(cursor.getColumnIndex("alldata"));
                TriviaList triviaList = new TriviaList();
                triviaList.setName(username);
                triviaList.setDate(date);
                triviaList.setAllData(alldata);
                triviaLists.add(triviaList);
                cursor.moveToNext();
            }
        }
        historyFragmentView.getSqlData(triviaLists);
    }
}
