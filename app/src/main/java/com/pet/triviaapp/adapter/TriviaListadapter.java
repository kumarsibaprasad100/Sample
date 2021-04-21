package com.pet.triviaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pet.triviaapp.R;
import com.pet.triviaapp.model.TriviaList;

import java.util.ArrayList;

public class TriviaListadapter extends RecyclerView.Adapter<TriviaListadapter.MyviewHolder> {
    Context context;
    private ArrayList<TriviaList> triviaLists = new ArrayList<>();

    public TriviaListadapter(Context context, ArrayList<TriviaList> triviaLists) {
        this.context = context;
        this.triviaLists = triviaLists;
    }

    @NonNull
    @Override
    public TriviaListadapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_history, parent, false);
        MyviewHolder myviewHolder = new MyviewHolder(view);
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TriviaListadapter.MyviewHolder holder, int position) {
        holder.cardView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.scale));
        holder.date.setText("Game1 : "+triviaLists.get(position).getDate());
        holder.name.setText("Name : "+triviaLists.get(position).getName());
        holder.alldata.setText(triviaLists.get(position).getAllData());
    }

    @Override
    public int getItemCount() {
        return triviaLists.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView name, date, alldata;
        CardView cardView;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.time);
            alldata = itemView.findViewById(R.id.alldata);
            cardView=itemView.findViewById(R.id.card);
        }
    }
}
