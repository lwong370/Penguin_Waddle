package com.lana.penguinwaddle.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class ScorePreferencesManager {
    private static ScorePreferencesManager instance;
    private Preferences preferences;

    public ScorePreferencesManager() {
        preferences = Gdx.app.getPreferences(Constants.SCORE_PREFERENCE_NAME);
    }

    public static ScorePreferencesManager getInstance(){
        if(instance == null){
            instance = new ScorePreferencesManager();
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
