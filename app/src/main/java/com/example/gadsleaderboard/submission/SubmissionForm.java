package com.example.gadsleaderboard.submission;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gadsleaderboard.ListActivity;
import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.submission.services.RetrofitClient;
import com.google.android.material.textfield.TextInputEditText;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionForm extends AppCompatActivity {

    private ImageView backButton;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private Button submit;
    private EditText githubLink;
    private String lastNameValue;
    private String firstNameValue;
    private String emailValue;
    private String githubLinkValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide action bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_submit);

        //reference elements
        backButton = (ImageView) findViewById(R.id.back_button);
        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText) findViewById(R.id.last_name);
        email = (EditText) findViewById(R.id.email);
        githubLink = (EditText) findViewById(R.id.github_link);
        submit = (Button) findViewById(R.id.final_submission);



        //if you click on submit
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                lastNameValue = lastName.getText().toString();
                firstNameValue = firstName.getText().toString();
                emailValue = email.getText().toString();
                githubLinkValue = githubLink.getText().toString();



                //control inputs
                if( firstNameValue.isEmpty()) {
                    firstName.setError("firstName required");
                    firstName.requestFocus();
                    return;
                }

                if(lastNameValue.isEmpty()) {
                    lastName.setError("firstName required");
                    lastName.requestFocus();
                    return;
                }

                if(githubLinkValue.isEmpty()) {
                    githubLink.setError("firstName required");
                    githubLink.requestFocus();
                    return;
                }

                if(emailValue.isEmpty()) {
                    email.setError("firstName required");
                    email.requestFocus();
                    return;
                }



                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                // Add the buttons
                builder.setMessage("Are you sure?")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                        // after validation step send a network request
                        Call<ResponseBody> call = RetrofitClient.getInstance()
                                .getApi()
                                .submitAssignment(emailValue, firstNameValue, lastNameValue, githubLinkValue);

                        call.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                String resp = response.toString();
                                Toast.makeText(SubmissionForm.this,resp,Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(SubmissionForm.this,t.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {



                    }
                });                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });




        //back to previous page
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SubmissionForm.this, ListActivity.class));
            }
        });
    }
}