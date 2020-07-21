package com.lana.penguinwaddle.utils;

import com.lana.penguinwaddle.enums.GameState;

public class GameManager {
    private static GameManager instance ;

    private GameState gameState;

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
}
