package com.example.rick.dummygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.rick.dummygame.GameViews.MainScreen;
import com.example.rick.dummygame.assets.Hero;

public class MainActivity extends AndroidGame {
    @Override
    public Screen getInitScreen() {
        //Initialize the assets you will be working with on your screens here.
        //It is better to have all of them loaded, until you have performance problems then, umm,yeah
        //We will have to figure that out :')
        Hero.avatar = getGraphics().newImage(R.drawable.rick,Graphics.ImageFormat.ARGB8888,getResources());

        //The method is going to
        return new MainScreen(this);
    }

    @Override
    protected void onDestroy() {
        //Let's make life easy on your device and get rid of the memo we dont use
        //because Android system does not do that always.
        super.onDestroy();
        Hero.avatar.dispose();
    }
}
