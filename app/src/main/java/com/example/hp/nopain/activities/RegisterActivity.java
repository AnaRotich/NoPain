package com.example.hp.nopain.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.nopain.R;
import com.example.hp.nopain.api.APIService;
import com.example.hp.nopain.api.APIUrl;
import com.example.hp.nopain.helper.SharedPrefManager;
import com.example.hp.nopain.models.User;
import com.example.hp.nopain.models.result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private EditText firstname;
    private EditText lastname;
    private EditText username;
    private EditText email;
    private EditText password;

    private Button submit;
    private Button loginLink;

    public static final String ROOT_URL = "http://simplifiedcoding.16mb.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        submit = findViewById(R.id.submit);
        loginLink = findViewById(R.id.loginLink);

        loginLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent loginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == submit){
                    userRegister();
                }
            }
        });
    }

    private void userRegister() {


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();



        String firstName = firstname.getText().toString().trim();
        String lastName = lastname.getText().toString().trim();
        String userName = username.getText().toString().trim();
        String emails = email.getText().toString().trim();
        String passwd = password.getText().toString().trim();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);


        User user = new User(firstName, lastName, userName, emails, passwd);


        Call<result> call = service.createUser(
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword()
        );

        call.enqueue(new Callback<result>() {
            @Override
            public void onResponse(Call<result> call, Response<result> response) {

                progressDialog.dismiss();


                Toast.makeText(RegisterActivity.this,  response.body().getMessage(), Toast.LENGTH_LONG).show();

                if (!response.body().getError()) {

                    finish();
                    SharedPrefManager.getInstance(RegisterActivity.this).userLogin(response.body().getUser());
                    startActivity(new Intent(RegisterActivity.this, Users.class));
                }
            }

            @Override
            public void onFailure(Call<result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}


