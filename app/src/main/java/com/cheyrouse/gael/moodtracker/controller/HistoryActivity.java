package com.cheyrouse.gael.moodtracker.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cheyrouse.gael.moodtracker.R;
import com.cheyrouse.gael.moodtracker.model.Mood;
import com.cheyrouse.gael.moodtracker.model.Prefs;
import com.cheyrouse.gael.moodtracker.view.ItemAdapter;

import java.util.ArrayList;

//it is an activity that allows to manage the history of the application
public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //recovers saved ArrayList to Prefs class
        ArrayList<Mood> list = Prefs.get(this).getMoodStore();

        //To don't display current mood
       if (list.size() > 0){list.remove(list.size() - 1);}

        //if historical don't exist, toast show "You have no history"
        if (list.size() < 1){
            Toast.makeText(this, "Vous n'avez pas encore d'historique", Toast.LENGTH_LONG).show(); }

        //instantiation of recyclerView and use a linearLayoutManager
        RecyclerView recyclerView = findViewById(R.id.activity_history_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //give the list to adapter to display items on it
        ItemAdapter mItemAdapter = new ItemAdapter(list, this);
        recyclerView.setAdapter(mItemAdapter);
    }


}
