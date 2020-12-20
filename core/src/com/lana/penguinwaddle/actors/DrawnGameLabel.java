package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.lana.penguinwaddle.utils.AssetsManager;

/**
 * Actor for hand-drawn labels.
 * @author Lana
 */
public class DrawnGameLabel extends DrawnAsset {
    private Rectangle bounds;

    public DrawnGameLabel(Rectangle bounds, String textureName) {
        super(textureName);
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(AssetsManager.getInstance().getTextureRegion(textureName), bounds.x, bounds.y, bounds.width, bounds.height);
    }
}
