package com.example.rick.dummygame.GameViews;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.rick.dummygame.Sprites.Rick;
import com.example.rick.dummygame.assets.Hero;

public class MainScreen extends Screen {

    private Rick rick;
    public MainScreen(Game game) {
        super(game);
        rick = new Rick(game,Hero.avatar,game.getScreenHeight()/2,game.getScreenWidth()/2,100,100);
        addSprite(rick);

    }

    @Override
    public void handleTouchUp(int x, int y, int pointer) {
        super.handleTouchUp(x, y, pointer);
    }

    @Override
    public void handleTouchDown(int x, int y, int pointer) {
        super.handleTouchDown(x, y, pointer);
    }

    @Override
    public void render(float deltaTime) {
        Graphics g = game.getGraphics();
        rick.draw(game);
    }

    @Override
    public void pause() {
        dispose();
    }

    @Override
    public void resume() {

    }

    @Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
    }

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
