package com.lana.penguinwaddle.actors.buttons;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.lana.penguinwaddle.utils.AssetsManager;


public abstract class GameButton extends Button{
    protected Rectangle bounds;
    private Skin skin;

    public GameButton(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
        skin = new Skin();
        skin.addRegions(AssetsManager.textureAtlas1);
        loadTextureRegion();
        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("touched");
                touched();
                loadTextureRegion();
                return true;
            }
        });
    }

    private void loadTextureRegion(){
        ButtonStyle style = new ButtonStyle();
        style.up = skin.getDrawable(getRegionName());
        setStyle(style);
    }

    public abstract void touched();

    protected abstract String getRegionName();
}
