package com.lana.penguinwaddle.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.HashMap;

public class AssetsManager {
    public static TextureAtlas textureAtlas1;
    public static TextureAtlas textureAtlas2;
    public static TextureAtlas textureAtlas3;

    private static HashMap<String, TextureRegion> texturesMap = new HashMap<>();
    private static HashMap<String, Animation> animationMap = new HashMap<>();

    private static BitmapFont smallFont;
    private static BitmapFont largeFont;
    private static BitmapFont smallestFontDark;
    private static BitmapFont smallestFontLight;

    public AssetsManager(){

    }

    public static void loadAssets(){
        textureAtlas1 = new TextureAtlas(Constants.PENGUIN_ATLAS_PATH);
        textureAtlas2 = new TextureAtlas(Constants.OBSTACLES_ATLAS_PATH);
        textureAtlas3 = new TextureAtlas(Constants.BUTTON_LABEL_ATLAS_PATH);

        //TextureRegion
        texturesMap.put(Constants.PENGUIN_HOPPING_ASSETS_ID, textureAtlas1.findRegion("penguin_hop"));
        texturesMap.put(Constants.PENGUIN_STOP_ASSETS_ID, textureAtlas1.findRegion("penguin_stop"));
        texturesMap.put(Constants.PENGUIN_TUMBLE_ASSETS_ID, textureAtlas1.findRegion("penguin_tumble_crop"));
        texturesMap.put(Constants.BUTTON_INFO_ASSET_ID, textureAtlas3.findRegion("info_button"));
        texturesMap.put(Constants.BUTTON_LEADERBOARD_ASSET_ID, textureAtlas3.findRegion("leaderboard_button"));
        texturesMap.put(Constants.BUTTON_MENU_ASSET_ID, textureAtlas3.findRegion("menu_button"));
        texturesMap.put(Constants.BUTTON_PLAY_ASSET_ID, textureAtlas3.findRegion("play_button"));
        texturesMap.put(Constants.BUTTON_REPLAY_ASSET_ID, textureAtlas3.findRegion("replay_button"));
        texturesMap.put(Constants.BUTTON_PAUSE_ASSET_ID, textureAtlas3.findRegion("pause_button"));
        texturesMap.put(Constants.BUTTON_BACK_ASSET_ID, textureAtlas3.findRegion("back_button"));
        texturesMap.put(Constants.LABEL_MENU_TITLE_ID, textureAtlas3.findRegion("menu_label"));
        texturesMap.put(Constants.LABEL_GAME_OVER_ID, textureAtlas3.findRegion("game_over_label"));

        //Animation
        animationMap.put(Constants.PENGUIN_RUNNING_ASSETS_ID, createAnimation(textureAtlas1, Constants.PENGUIN_RUNNING_ANIMATION_FRAMES));
        animationMap.put(Constants.PENGUIN_TUMBLE_ASSETS_ID, createAnimation(textureAtlas1, Constants.PENGUIN_TUMBLING_ANIMATION_FRAMES));
        animationMap.put(Constants.OBSTACLE_FLY_ASSETS_ID, createAnimation(textureAtlas2, Constants.SEAGULL_ANIMATION_FRAMES));
        animationMap.put(Constants.OBSTACLE_CLOUD_ASSETS_ID, createAnimation(textureAtlas2, Constants.CLOUD_FRAMES));
        animationMap.put(Constants.OBSTACLE_GROUND_ASSETS_ID, createAnimation(textureAtlas2, Constants.SNOWBALL_ANIMATION_FRAMES));
        animationMap.put(Constants.OBSTACLE_RAIN_ASSETS_ID, createAnimation(textureAtlas2, Constants.RAIN_FRAMES));

        //Fonts
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.FONT));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 36;
        smallFont = generator.generateFont(parameter);
        smallFont.setColor(1f, 1f, 1f, 1f);
        parameter.size = 72;
        largeFont = generator.generateFont(parameter);
        largeFont.setColor(.21f, .22f, .21f, 1f);
        parameter.size = 25;
        smallestFontDark = generator.generateFont(parameter);
        smallestFontDark.setColor(.21f, .22f, .21f, 1f);
        parameter.size = 25;
        smallestFontLight = generator.generateFont(parameter);
        smallestFontLight.setColor(1f, 1f, 1f, 1f);
        generator.dispose();
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

    public static BitmapFont getSmallFont() {
        return smallFont;
    }

    public static BitmapFont getLargeFont() {
        return largeFont;
    }

    public static BitmapFont getSmallestFontDark() {
        return smallestFontDark;
    }

    public static BitmapFont getSmallestFontLight() {
        return smallestFontLight;
    }
}
