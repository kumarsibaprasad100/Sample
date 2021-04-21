package com.pet.triviaapp.presenter;

import android.content.Context;
import android.util.Log;

import com.pet.triviaapp.database.DatabaseHelper;
import com.pet.triviaapp.intractor.SummaryInteractor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SummaryPresenter implements SummaryInteractor.SgetDatapresenter {
    SummaryInteractor.SummaryFragmentView summaryFragmentView;
    Context context;

    public SummaryPresenter(Context context, SummaryInteractor.SummaryFragmentView summary) {
        this.context=context;
        this.summaryFragmentView=summary;
    }

    @Override
    public void insertData(String userName, StringBuffer sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM yyyy HH:mm:ss", Locale.getDefault());
        String date = simpleDateFormat.format(new Date());
        Log.i("TAG", "onClick: " + date + sb);
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        databaseHelper.insertIntoTriviaTable(userName, date, sb);
        databaseHelper.close();
        summaryFragmentView.alldataView(context);
    }
}
