package com.pet.triviaapp.view.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pet.triviaapp.R;
import com.pet.triviaapp.adapter.TriviaListadapter;
import com.pet.triviaapp.intractor.Historyintractor;
import com.pet.triviaapp.model.TriviaList;
import com.pet.triviaapp.presenter.HistoryPresenter;

import java.util.ArrayList;


public class History extends Fragment implements Historyintractor.HistoryFragmentView {
    private RecyclerView recyclerView;
    Context context;
    private TextView noresult;
    private TriviaListadapter trivialistAdapter;
    private Toolbar toolbar;
    HistoryPresenter historyPresenter;

    public History(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        toolbar=view.findViewById(R.id.toolbar);
        toolbar.setTitle("History");
        noresult=view.findViewById(R.id.noresult);
        historyPresenter=new HistoryPresenter(context,History.this);
        historyPresenter.sqldata();

        return view;
    }

    @Override
    public void getSqlData(ArrayList<TriviaList> triviaLists) {
        if (trivialistAdapter==null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            trivialistAdapter = new TriviaListadapter(context, triviaLists);
            recyclerView.setAdapter(trivialistAdapter);
            noresult.setVisibility(View.INVISIBLE);
        }else{
            noresult.setVisibility(View.VISIBLE);
        }
    }
}