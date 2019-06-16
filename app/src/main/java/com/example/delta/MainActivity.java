package com.example.delta;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submit;
    Button ScoreBoard;
    EditText guess;
    EditText input;
    TextView result;
    View v;
    RelativeLayout col;
    int c = 0;
    int d = 0;
    int e = 0;
    int f;
    int m;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        Intent intent = getIntent();
        if(intent.getExtras() != null) {
            int p = intent.getExtras ().getInt ( "p", 0 );
            int q= intent.getExtras ().getInt ( "q", 0 );
            d = d + q;
            e = d + p;

            v = this.getWindow ().getDecorView ();
            submit = (Button) findViewById ( R.id.b1 );
            ScoreBoard = (Button) findViewById ( R.id.b3 );
            col = (RelativeLayout) findViewById ( R.id.rel );
            input = (EditText) findViewById ( R.id.et1 );
            guess = (EditText) findViewById ( R.id.et2 );
            result = (TextView) findViewById ( R.id.tv4 );

            submit.setOnClickListener ( new View.OnClickListener () {

                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    int a = Integer.parseInt ( input.getText ().toString () );
                    int b = Integer.parseInt ( guess.getText ().toString () );
                    if( a < 0 ) {
                        result.setText ( "enter number between 1 to 100 in input" );
                    }
                    if( a == 0 ) {
                        result.setText ( "enter number between 1 to 100 in input" );
                    }
                    if( a > 100 ) {
                        result.setText ( "enter number between 1 to 100 in input" );
                    }
                    if( b < 0 ) {
                        result.setText ( "enter number between 1 to 100 in guess" );
                    }
                    if( b == 0 ) {
                        result.setText ( "enter number between 1 to 100 in guess" );
                    }
                    if( b > 100 ) {
                        result.setText ( "enter number between 1 to 100 in guess" );
                    }
                    if( ( a > 0 ) && ( a < 101 ) ) {
                        if( ( b > 0 ) && ( b < 101 ) ) {
                            c = c + 1;
                            if( c < 6 ) {
                                if( a == b ) {
                                    result.setText ( "correct guess, you have passed the Test.Check scoreboard and try again" );
                                    d = d + 1;
                                    c = 6;
                                    int k = getResources ().getColor ( R.color.Darkgreen );
                                    col.setBackgroundColor ( k );
                                }
                                if( b > a ) {
                                    m = b - a;
                                    if( ( m < 10 ) && ( m > 0 ) ) {
                                        int k = getResources ().getColor ( R.color.LimeGreen );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is little more than the correct age" );
                                    }
                                    else if( ( m > 10 ) && ( m < 20 ) ) {
                                        int k = getResources ().getColor ( R.color.LawnGreen );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is more than the correct age" );
                                    }
                                    else if( ( m < 30 ) && ( m > 20 ) ) {
                                        int k = getResources ().getColor ( R.color.Lightcoral );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is higher than correct age" );
                                    }
                                    else if( ( m < 40 ) && ( m > 30 ) ) {
                                        int k = getResources ().getColor ( R.color.Crimson );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is very higher than the correct age" );
                                    }
                                    else if( m > 40 ) {
                                        int k = getResources ().getColor ( R.color.Darkred );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is extremely higher than the correct age" );
                                    }
                                }
                                if( a > b ) {
                                    n = a - b;
                                    if( ( n < 10 ) && ( n > 0 ) ) {
                                        int k = getResources ().getColor ( R.color.LimeGreen );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is little lesser than the correct age" );
                                    }
                                    else if( ( n > 10 ) && ( n < 20 ) ) {
                                        int k = getResources ().getColor ( R.color.LawnGreen );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is lesser than the correct age" );
                                    }
                                    else if( ( n < 30 ) && ( n > 20 ) ) {
                                        int k = getResources ().getColor ( R.color.Lightcoral );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is lower than the correct age" );
                                    }
                                    else if( ( n < 40 ) && ( n > 30 ) ) {
                                        int k = getResources ().getColor ( R.color.Crimson );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is very lower than the correct age" );
                                    }
                                    else if( n > 40 ) {
                                        int k = getResources ().getColor ( R.color.Darkred );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is extremely lower than the correct age" );
                                    }
                                }
                            }
                            if( c == 6 ) {
                                e = e + 1;
                            } if(c>6) {
                                result.setText ( "you have exceeded your number of turns, click refresh to restart the activity" );
                            }
                            f = e - d;
                        }
                    }
                }
            } );
            ScoreBoard.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent t = new Intent ( MainActivity.this, ScoreActivity.class );
                    t.putExtra ( "l", f );
                    t.putExtra ( "w", d );
                    startActivity ( t );
                }
            } );
        }
        if(intent.getExtras() == null) {
            v = this.getWindow ().getDecorView ();
            submit = (Button) findViewById ( R.id.b1 );
            ScoreBoard = (Button) findViewById ( R.id.b3 );
            col = (RelativeLayout) findViewById ( R.id.rel );
            input = (EditText) findViewById ( R.id.et1 );
            guess = (EditText) findViewById ( R.id.et2 );
            result = (TextView) findViewById ( R.id.tv4 );

            submit.setOnClickListener ( new View.OnClickListener () {

                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    int a = Integer.parseInt ( input.getText ().toString () );
                    int b = Integer.parseInt ( guess.getText ().toString () );
                    if( a < 0 ) {
                        result.setText ( "enter number between 1 to 100 in input" );
                    }
                    if( a == 0 ) {
                        result.setText ( "enter number between 1 to 100 in input" );
                    }
                    if( a > 100 ) {
                        result.setText ( "enter number between 1 to 100 in input" );
                    }
                    if( b < 0 ) {
                        result.setText ( "enter number between 1 to 100 in guess" );
                    }
                    if( b == 0 ) {
                        result.setText ( "enter number between 1 to 100 in guess" );
                    }
                    if( b > 100 ) {
                        result.setText ( "enter number between 1 to 100 in guess" );
                    }
                    if( ( a > 0 ) && ( a < 101 ) ) {
                        if( ( b > 0 ) && ( b < 101 ) ) {
                            c = c + 1;
                            if( c < 6 ) {
                                if( a == b ) {
                                    result.setText ( "correct guess, you have passed the test.Press refresh to start a new test");
                                    d = d + 1;
                                    c = 6;
                                    int k = getResources ().getColor ( R.color.Darkgreen );
                                    col.setBackgroundColor ( k );
                                }
                                if( b > a ) {
                                    m = b - a;
                                    if( ( m < 10 ) && ( m > 0 ) ) {
                                        int k = getResources ().getColor ( R.color.LimeGreen );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is little more than the correct age" );
                                    } else if( ( m > 10 ) && ( m < 20 ) ) {
                                        int k = getResources ().getColor ( R.color.LawnGreen );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is more than the correct age" );
                                    } else if( ( m < 30 ) && ( m > 20 ) ) {
                                        int k = getResources ().getColor ( R.color.Lightcoral );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is higher than correct age" );
                                    } else if( ( m < 40 ) && ( m > 30 ) ) {
                                        int k = getResources ().getColor ( R.color.Crimson );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is very higher than the correct age" );
                                    } else if( m > 40 ) {
                                        int k = getResources ().getColor ( R.color.Darkred );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is extremely higher than the correct age" );
                                    }
                                }
                                if( a > b ) {
                                    n = a - b;
                                    if( ( n < 10 ) && ( n > 0 ) ) {
                                        int k = getResources ().getColor ( R.color.LimeGreen );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is little lesser than the correct age" );
                                    } else if( ( n > 10 ) && ( n < 20 ) ) {
                                        int k = getResources ().getColor ( R.color.LawnGreen );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is lesser than the correct age" );
                                    } else if( ( n < 30 ) && ( n > 20 ) ) {
                                        int k = getResources ().getColor ( R.color.Lightcoral );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is lower than the correct age" );
                                    } else if( ( n < 40 ) && ( n > 30 ) ) {
                                        int k = getResources ().getColor ( R.color.Crimson );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is very lower than the correct age" );
                                    } else if( n > 40 ) {
                                        int k = getResources ().getColor ( R.color.Darkred );
                                        col.setBackgroundColor ( k );
                                        result.setText ( "guess is extremely lower than the correct age" );
                                    }
                                }
                            }
                            if( c == 6 )
                            {
                                e = e + 1;
                            }
                            if(c>6) {
                                result.setText ( "you have exceeded your number of turns, click the scoreboard and try again " );
                            }
                            f = e - d;
                        }
                    }
                }
            });
            ScoreBoard.setOnClickListener( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent t = new Intent ( MainActivity.this,ScoreActivity.class );
                    t.putExtra("l",f);
                    t.putExtra("w",d);
                    startActivity ( t );
                }
            });

        }
    }
}