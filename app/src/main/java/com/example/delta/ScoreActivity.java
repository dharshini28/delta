package com.example.delta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private TextView wins;
    private TextView loses;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_score );

        Intent intent = getIntent();
        final int w = intent.getExtras().getInt("w");
        final int l = intent.getExtras().getInt("l");

        wins = (TextView) findViewById ( R.id.tv5 );
        loses = (TextView) findViewById ( R.id.tv7 );
        back= (Button)findViewById ( R.id.b4 );

        wins.setText (""+w);
        SharedPreferences settings = getSharedPreferences("w", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("w",w);
        editor.apply();

        loses.setText (""+l);
        SharedPreferences setting = getSharedPreferences("l", Context.MODE_PRIVATE);
        SharedPreferences.Editor edi = setting.edit();
        edi.putInt("l",l);
        edi.apply();

        back.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent t = new Intent ( ScoreActivity.this,MainActivity.class );
                t.putExtra("p",l);
                t.putExtra("q",w);
                startActivity ( t );
            }
        });
    }
}