package com.example.rick.dummygame.Sprites;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;

public class Rick extends Sprite {
    public Rick(Game game, Image image, int x, int y, int height, int width) {
        //Your sprite is gonna draw in the (x,y) coordination with a height and width of your choice.
        super(game, image, x, y, height, width);

        //To make the sprite Draggable.
        // (We will be working on the method names on the next release of the lib. Sorry for now)
        setStatique(false);
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
    }
}
