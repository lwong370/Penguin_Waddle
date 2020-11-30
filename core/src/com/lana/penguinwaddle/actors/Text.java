package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.lana.penguinwaddle.utils.AssetsManager;

public class Text extends Actor {
    private Rectangle bounds;
    private BitmapFont font;
    private String text;

    public Text(Rectangle bounds, String text){
        this.bounds = bounds;
        this.text = text;
        setWidth(bounds.width);
        setHeight(bounds.height);
        font = AssetsManager.getInstance().getFontSkin().getFont("Subsciber-aXdK");
        font.getData().setScale(((float) 1.05));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.draw(batch, text, bounds.x, bounds.y, bounds.width, Align.center, true);
    }
}
