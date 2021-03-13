package com.audio.helpblind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_DURATION = 2400;

    //animation variables
    private Animation topAnimation, bottomAnimation;
    private ImageView logoImage;
    private TextView logoText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // adding animations
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_bottom_animation);
//        bottomAnimation = AnimationUtils.loadLayoutAnimation(this, R.anim.splash_bottom_animation);

        // setting the views
        logoImage = this.findViewById(R.id.splashLogo);
        logoText = this.findViewById(R.id.splashText);

        // adding the animation to views
        logoImage.setAnimation(topAnimation);
        logoText.setAnimation(bottomAnimation);

        // opening other activity
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DURATION);
    }

    @Override
    protected void onDestroy() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onDestroy();
    }
}