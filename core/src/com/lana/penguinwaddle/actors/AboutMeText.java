package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.lana.penguinwaddle.utils.AssetsManager;
import com.lana.penguinwaddle.utils.Constants;

public class AboutMeText extends Actor {
    private Rectangle bounds;
    private BitmapFont font;

    public AboutMeText(Rectangle bounds){
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        font = AssetsManager.getInstance().getSkin().getFont("Subsciber-aXdK");
        font.getData().setScale(((float) 1.05));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.draw(batch, Constants.ABOUT_TEXT, bounds.x, bounds.y, bounds.width, Align.center, true);
    }
}
