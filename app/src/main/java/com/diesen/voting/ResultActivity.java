package com.diesen.voting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    private View layout;
    private TextView view_result;
    private TextView view_question;
    private Intent it;

    private int num_yes;
    private String txt_question;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Log.v("DEBUG","test2");

        it = getIntent();
        num_yes = it.getIntExtra("yes_count", 0);
        txt_question = it.getStringExtra("question");

        layout = findViewById(R.id.layout_result);
        layout.setOnClickListener(this);

        view_question = findViewById(R.id.textQuestion);
        view_question.setText(txt_question);

        view_result = findViewById(R.id.textResult);
        view_result.setText(String.format(getString(R.string.txt_result),num_yes));
    }


    @Override
    public void onClick(View v) {
        Log.v("DEBUG","test");
        finish();
    }
}
