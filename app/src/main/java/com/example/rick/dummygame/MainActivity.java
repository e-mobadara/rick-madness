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
        Hero.avatar = getGraphics().newImage(R.drawable.rick,Graphics.ImageFormat.ARGB8888,getResources());
        return new MainScreen(this);
    }
}
