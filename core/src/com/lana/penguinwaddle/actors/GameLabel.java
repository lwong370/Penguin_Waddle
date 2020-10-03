package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.lana.penguinwaddle.utils.AssetsManager;

public class GameLabel extends Actor {
    private Rectangle bounds;
    private String textureName;

    public GameLabel(Rectangle bounds, String textureName) {
        this.bounds = bounds;
        this.textureName = textureName;
        setWidth(bounds.width);
        setHeight(bounds.height);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(AssetsManager.getInstance().getTextureRegion(textureName), bounds.x, bounds.y, bounds.width, bounds.height);
    }
}
