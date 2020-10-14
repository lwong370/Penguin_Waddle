package com.lana.penguinwaddle.utils;

import com.lana.penguinwaddle.enums.Difficulty;
import com.lana.penguinwaddle.enums.GameState;

public class GameManager {
    private static GameManager instance;

    private GameState gameState;
    private Difficulty difficulty;

    public static GameManager getInstance(){
        if(instance == null){
            instance = new GameManager();
        }
        return instance;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void saveScore(int score){
        if(score > getScoreFromPref("Rank1")){
            for(int i = 5; i > 1; i--){
                //Replace current ranked score into ranked score below.
                ScorePreferencesManager.getInstance().writeScoreToPreferences("Rank" + (i), getScoreFromPref("Rank" + (i-1)));
            }
            //Set Rank1 to new score.
            ScorePreferencesManager.getInstance().writeScoreToPreferences(Constants.RANK_KEY_1, score);
        }else{
            for(int i = 2; i <= 5; i++){
                if(score > getScoreFromPref("Rank" + i) && score < getScoreFromPref("Rank"+(i-1))){
                    for(int j = 5; j > i; j--){
                        //Replace current ranked score into ranked score below.
                        ScorePreferencesManager.getInstance().writeScoreToPreferences("Rank" + (j), getScoreFromPref("Rank" + (j-1)));
                    }
                    //Set ranked score to new score.
                    ScorePreferencesManager.getInstance().writeScoreToPreferences("Rank" + i, score);
                }
            }
        }
    }

    public int getScoreFromPref(String key){
        return ScorePreferencesManager.getInstance().readFromPreferences(key);
    }

    //Game Difficulty//
    public Difficulty getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }

    public boolean isMaxDifficulty(){
        return difficulty == Difficulty.values()[Difficulty.values().length - 1];
    }

    public void resetDifficulty(){
        setDifficulty(Difficulty.values()[0]);
    }
}
