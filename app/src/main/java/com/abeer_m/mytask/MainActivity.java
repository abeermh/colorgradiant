package com.abeer_m.mytask;



import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar colorSeekBar;
    ImageView redimg;
    ImageView blueimg;
    String url;
    Button visitforum;
    Button notnow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changecolors();

    }
    public void changecolors(){
        colorSeekBar=(SeekBar)findViewById(R.id.seekbar);
        redimg=(ImageView)findViewById(R.id.redimg);
        blueimg=(ImageView)findViewById(R.id.blueimg);
        colorSeekBar.setMax(255);

        colorSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    //red color :226, 62, 56
                    //blue color :77, 113, 182
                    int lower = Color.rgb(Math.abs(progress-226), Math.abs(progress-62), Math.abs(progress-56));
                    int lower2 = Color.rgb(Math.abs(progress-77), Math.abs(progress-113), Math.abs(progress-182));
                    redimg.setBackgroundColor(lower);
                    blueimg.setBackgroundColor(lower2);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                 }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void showdialog(){
        url="https://macdiscussions.udacity.com/t/training-task-3-for-students-who-completed-the-user-input-part/102430";
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog);
        dialog.show();
        visitforum=(Button)dialog.findViewById(R.id.visitforum);
        notnow=(Button)dialog.findViewById(R.id.notnow);
        visitforum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url)));
            }
        });
        notnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        showdialog();
        return super.onOptionsItemSelected(item);
    }

 }
