package com.example.rick.dummygame.GameViews;

import android.util.Log;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.rick.dummygame.Sprites.Morty;
import com.example.rick.dummygame.Sprites.Rick;
import com.example.rick.dummygame.assets.BackGroundMusic;
import com.example.rick.dummygame.assets.Hero;
import com.example.rick.dummygame.assets.Obstacles;

public class MainScreen extends Screen {
    private final String TAG = "MainScreen: ";
    private Rick rick;
    private Morty morty;
    private int mX ;
    private int mY ;
    private int myHack=0; //used to get some time before re-rendering
    public MainScreen(Game game) {
        //This is gonna handle other stuff for you under the hood.We will see more of that next time.
        super(game);
        BackGroundMusic.bg_music.play();
        BackGroundMusic.bg_music.setLooping(true);
        //Now that your Sprite is Ready, let's initialize it and control where we are going to put it
        rick = new Rick(Hero.avatar,game.getScreenHeight()/2,game.getScreenWidth()/2,100,100);
        morty = new Morty(Obstacles.avatar,mX,mY,100,100);
        //Now that everything is good let's add the Sprite to the list that we have.
        addSprite(rick);
        addSprite(morty);

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
        if(myHack==10) {
            mX = (int) Math.floor(Math.random() * g.getWidth());
            mY = (int) Math.floor(Math.random() * g.getHeight());
            morty.setX(mX);
            morty.setY(mY);
            myHack=0;
        }
        myHack++;
        if(rickGotHit()){
            Obstacles.voice.play(1);
        }
    }

    @Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
    }

    @Override
    public void pause() {
        BackGroundMusic.bg_music.pause();
    }

    @Override
    public void resume() {
        BackGroundMusic.bg_music.play();
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

    boolean rickGotHit(){
        if(rick.contain(morty.getX(),morty.getY())) return true;
        return false;
    }
}
