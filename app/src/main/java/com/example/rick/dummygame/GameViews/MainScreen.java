package com.example.rick.dummygame.GameViews;

import android.util.Log;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.rick.dummygame.Sprites.Rick;
import com.example.rick.dummygame.assets.Hero;

public class MainScreen extends Screen {
    private final String TAG = "MainScreen: ";
    private Rick rick1;
    private Rick rick2;
    public MainScreen(Game game) {
        //This is gonna handle other stuff for you under the hood.We will see more of that next time.
        super(game);

        //Now that your Sprite is Ready, let's initialize it and control where we are going to put it
        rick1 = new Rick(game,Hero.avatar,game.getScreenHeight()/2,game.getScreenWidth()/2,100,100);
        rick2 = new Rick(game,Hero.avatar,0,0,100,100);
        //Now that everything is good let's add the Sprite to the list that we have.
        addSprite(rick1);
        addSprite(rick2);

        Log.d(TAG, "Constructor Called");

    }

    @Override
    public void render(float deltaTime) {
        //With each time you interact with rick, we want to re Render it. Cz one face is just not enough.
        //We get the graphics which is like a wizard that will do what ever he knows. press ctr+space to see
        //other stuff that it can do.
        Graphics g = game.getGraphics();
        //Redrawing Rick multiple times
        /*Uncomment this line and see what happens */g.drawARGB(255,0,0,0);

    }

    @Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
        if(rick1.contain(rick2.getX(),rick2.getY())){
            Hero.voice.play(1);
        }
    }

    @Override
    public void pause() {
        dispose();
    }

    @Override
    public void resume() {

    }

    //The handle dragging is activated anytime you drag on your screen.
    /*@Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
        Hero.voice.play(1);
    }*/

    @Override
    public void dispose() {
        super.dispose();
        System.gc();
    }

    @Override
    public void backButton() {
        pause();
    }
}
