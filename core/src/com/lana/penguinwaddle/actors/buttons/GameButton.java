package com.lana.penguinwaddle.actors.buttons;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.lana.penguinwaddle.utils.AssetsManager;

/**
 * Parent class for all other buttons to extend from.
 * @author Lana
 */
public abstract class GameButton extends Button{
    protected Rectangle bounds;
    private Skin skin;

    /**
     * Constructs a new game button.
     * @param bounds Position and size of rectangle containing the button actor.
     */
    public GameButton(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
        skin = new Skin();
        skin.addRegions(AssetsManager.getInstance().textureAtlas3);
        loadTextureRegion();
        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touched();
                loadTextureRegion();
                return true;
            }
        });
    }

    /**
    Loads the texture region on to the button once we get the texture region for a certain button.
    */
    private void loadTextureRegion(){
        ButtonStyle style = new ButtonStyle();
        style.up = skin.getDrawable(getRegionName());
        setStyle(style);
    }

    /**Executed if the button is pressed.*/
    public abstract void touched();

    /**
   Returns the String name associated with the specified button texture region from the texture packer file.
    */
    protected abstract String getRegionName();
}
