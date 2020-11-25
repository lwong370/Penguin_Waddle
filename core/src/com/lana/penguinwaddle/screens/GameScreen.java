package com.lana.penguinwaddle.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.lana.penguinwaddle.PenguinWaddle;
import com.lana.penguinwaddle.stages.GameStage;
import com.lana.penguinwaddle.utils.GameManager;

public class GameScreen implements Screen {

    private PenguinWaddle game;
    private GameStage gameStage;

    private InputMultiplexer multiplexer;

    private Music bkgrdMusic;

    public GameScreen(PenguinWaddle game){
        this.game = game;
        gameStage = new GameStage();
        multiplexer = new InputMultiplexer();

        bkgrdMusic = Gdx.audio.newMusic(Gdx.files.internal("bensound-dreams_trimmed.mp3"));
        bkgrdMusic.setLooping(true);
        bkgrdMusic.setVolume(.5f);
    }

    @Override
    public void show() {
        multiplexer.addProcessor(gameStage);
        Gdx.input.setInputProcessor(multiplexer);
        Gdx.graphics.setContinuousRendering(true);
        bkgrdMusic.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameStage.draw();
        gameStage.act(delta);

        switch (GameManager.getInstance().getGameState()){
            case GAME_OVER:
                game.setScreen(new GameOverScreen(game));
                bkgrdMusic.dispose();
                break;
            case PAUSED:
                bkgrdMusic.pause();
                break;
            case PLAY:
                bkgrdMusic.play();
                break;
            default:
                break;
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        gameStage.dispose();
    }

}
