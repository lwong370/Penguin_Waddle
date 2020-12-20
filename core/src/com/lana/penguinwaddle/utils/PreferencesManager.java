package com.lana.penguinwaddle.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Manages preferences that store values with key-value pairs.
 * @author Lana
 */
public class PreferencesManager {
    private static PreferencesManager instance;
    private Preferences preferences;

    public PreferencesManager() {
        preferences = Gdx.app.getPreferences(Constants.PREFERENCE_NAME);
    }

    public static PreferencesManager getInstance(){
        if(instance == null){
            instance = new PreferencesManager();
        }
        return instance;
    }

    public void writeScoreToPreferences(String key, int value){
        preferences.putInteger(key, value);
        preferences.flush();
    }

    public Integer readFromPreferences(String key){
        return preferences.getInteger(key);
    }

    public void clearPreferences(){
        preferences.clear();
        preferences.flush();
    }
}
