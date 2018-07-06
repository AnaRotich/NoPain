package com.example.hp.nopain.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hp.nopain.R;

public class MyWorkouts extends AppCompatActivity {

    private TextView MyWorkouts;
    private Button PastWorkouts;
    private Button AddWrokouts;
    private Button WorkoutSessions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_workouts);


        MyWorkouts = findViewById(R.id.MyWorkouts);
        PastWorkouts = findViewById(R.id.PastWorkouts);
        WorkoutSessions = findViewById(R.id.WorkoutSessions);
        AddWrokouts = findViewById(R.id.AddWorkouts);

        PastWorkouts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent pastWorkout = new Intent(MyWorkouts.this, com.example.hp.nopain.fragment.PastWorkouts.class);
                startActivity(pastWorkout);
            }
        });


        AddWrokouts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent addWorkout = new Intent(MyWorkouts.this,AddWorkouts.class);
                startActivity(addWorkout);
            }
        });

        WorkoutSessions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent workoutSession = new Intent(MyWorkouts.this, com.example.hp.nopain.fragment.WorkoutSessions.class);
                startActivity(workoutSession);
            }
        });



    }
}
