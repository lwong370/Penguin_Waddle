package com.lana.penguinwaddle.utils;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class AssetsManager {
    public static TextureAtlas textureAtlas1;
    public static TextureAtlas textureAtlas2;
    private static HashMap<String, TextureRegion> texturesMap = new HashMap<>();
    private static HashMap<String, Animation> animationMap = new HashMap<>();

    public AssetsManager(){

    }

    public static void loadAssets(){
        textureAtlas1 = new TextureAtlas(Constants.PENGUIN_ATLAS_PATH);

        texturesMap.put(Constants.PENGUIN_HOPPING_ASSETS_ID, textureAtlas1.findRegion("penguin_hop"));
        texturesMap.put(Constants.PENGUIN_STOP_ASSETS_ID, textureAtlas1.findRegion("penguin_stop"));
        texturesMap.put(Constants.PENGUIN_TUMBLE_ASSETS_ID, textureAtlas1.findRegion("penguin_tumble_crop"));

        animationMap.put(Constants.PENGUIN_RUNNING_ASSETS_ID, createAnimation(textureAtlas1, Constants.PENGUIN_RUNNING_ANIMATION_FRAMES));
        animationMap.put(Constants.PENGUIN_TUMBLE_ASSETS_ID, createAnimation(textureAtlas1, Constants.PENGUIN_TUMBLING_ANIMATION_FRAMES));
    }

    private static Animation createAnimation(TextureAtlas atlas, String[] regionsArray){
        float frameDuration = 0.4f;
        TextureRegion[] textureRegions = new TextureRegion[regionsArray.length];
        for(int i = 0; i < regionsArray.length; i++){
            textureRegions[i] = atlas.findRegion(regionsArray[i]);
        }
        if(regionsArray.equals(Constants.PENGUIN_TUMBLING_ANIMATION_FRAMES)){
            frameDuration = 0.1f;
        }
        return new Animation(frameDuration, textureRegions);
    }

    public static TextureRegion getTextureRegion(String key){
        return texturesMap.get(key);
    }

    public static Animation getAnimation(String key){
        return animationMap.get(key);
    }
}
