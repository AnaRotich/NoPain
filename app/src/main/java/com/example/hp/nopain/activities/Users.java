package com.example.hp.nopain.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hp.nopain.GoogleMapsNearbyPlaces.MapsActivity;
import com.example.hp.nopain.R;
import com.example.hp.nopain.fragment.Instructors;

public class Users extends AppCompatActivity {

    private TextView Welcome;
    private Button MyProfile;
    private Button MyWorkouts;
    private Button GymInstructors;
    private Button GymLocations;

    public Users(int Id, String userName, String email) {
    }

    public Users() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);


        Welcome = findViewById(R.id.Welcome);
        MyProfile = findViewById(R.id.MyProfile);
        MyWorkouts = findViewById(R.id.MyWorkouts);
        GymInstructors = findViewById(R.id.GymInstructors);
        GymLocations = findViewById(R.id.GymLocations);

        MyProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Users.this,Profile.class);
                startActivity(intent);
            }
        });

        MyWorkouts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent workoutsIntent = new Intent(Users.this,MyWorkouts.class);
                startActivity(workoutsIntent);
            }
        });

        GymInstructors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent instructors = new Intent(Users.this,Instructors.class);
                startActivity(instructors);
            }
        });

        GymLocations.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent locationIntent = new Intent(Users.this,MapsActivity.class);
                startActivity(locationIntent);
            }
        });




    }
}
