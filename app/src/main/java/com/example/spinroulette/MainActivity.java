package com.example.spinroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    addName an;

    boolean btnRotation = true;
    int intNumber = 6;
    long lngDegrees = 0;
    SharedPreferences sharedPreferences;

    ImageView selected, imageRoulette;

    Button btnStart;

    ArrayList<String> arrayList;

    ListView listView;

    Integer[] number = new Integer[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(1024);
        requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        an = new addName();

        btnStart = (Button) findViewById(R.id.btnStart);
//        btnUp = (Button) findViewById(R.id.btnAdd);
//        btnDown = (Button) findViewById(R.id.btnKurang);

        selected = (ImageView) findViewById(R.id.imgSelected);
        imageRoulette = (ImageView) findViewById(R.id.roulette);

        listView = findViewById(R.id.lsNama);

        arrayList = new ArrayList<>();

        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.intNumber = this.sharedPreferences.getInt("INT_NUMBER", 6);
        setImageRoulette(this.intNumber);

    }

    @Override
    public void onAnimationStart(Animation animation) {
        this.btnRotation = false;
        btnStart.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
//         Toast toast = Toast.makeText(this, ""+String.valueOf((int)(((double)this.intNumber)
//            -Math.floor(((double)this.lngDegrees)/(360.0d / ((double)this.intNumber))))),0);
//         toast.setGravity(49, 0, 0);
//         toast.show();
        String nomor = String.valueOf((int)(((double)this.intNumber)
                -Math.floor(((double)this.lngDegrees)/(360.0d / ((double)this.intNumber)))));

        int no = Integer.parseInt(nomor);

        if(number[no-1] == null){
            arrayList.add(an.nm[no-1]);
            number[no-1] = no;
        }else {
            spin();
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

         this.btnRotation = true;
         btnStart.setVisibility(View.VISIBLE);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void onClickButtonRotation(View v){
        spin();
    }

    public void spin(){
//        if(this.btnRotation){
            int run = new Random().nextInt(360) + 3600;
            RotateAnimation rotateAnimation = new RotateAnimation((float)this.lngDegrees, (float)
                    (this.lngDegrees + ((long)run)),1,0.5f,1,0.5f);

            this.lngDegrees = (this.lngDegrees + ((long)run)) % 360;
            rotateAnimation.setDuration((long)run);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new DecelerateInterpolator());
            rotateAnimation.setAnimationListener(this);
            imageRoulette.setAnimation(rotateAnimation);
            imageRoulette.startAnimation(rotateAnimation);

//        }
    }

//    public void buttonUp(View v){
//        if(this.intNumber < 10){
//            this.intNumber++;
//            setImageRoulette(this.intNumber);
//            btnDown.setVisibility(0);
//            SharedPreferences.Editor editor= this.sharedPreferences.edit();
//            editor.putInt("INT_NUMBER", this.intNumber);
//            editor.commit();
//        }
//        if (this.intNumber == 10){
//            btnUp.setVisibility(View.INVISIBLE);
//        }
//    }

//    public void buttonDown(View v){
//        if (this.intNumber > 2){
//            intNumber--;
//            setImageRoulette(this.intNumber);
//            btnUp.setVisibility(View.VISIBLE);
//
//            SharedPreferences.Editor editor = this.sharedPreferences.edit();
//            editor.putInt("INT_NUMBER", this.intNumber);
//            editor.commit();
//        }
//        if(this.intNumber > 2){
//            btnDown.setVisibility(View.INVISIBLE);
//        }
//    }

    private void setImageRoulette(int myNumber){
        switch (myNumber){
            case 1 :
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.spinner_2));
                return;
            case 2 :
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.spinner_3));
                return;
            case 3 :
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.spinner_4));
                return;
            case 4 :
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.spinner_5));
                return;
            case 5 :
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.spinner_6));
                return;
            case 6 :
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.spinner_7));
                return;
        }
    }
}
