package com.lana.penguinwaddle.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.lana.penguinwaddle.actors.Background;
import com.lana.penguinwaddle.actors.buttons.PlayButton;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class MenuStage extends Stage {
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private Background bkgrd;
    private PlayButton playButton;

    private OrthographicCamera camera;

    public MenuStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        addWorldComponents();
        setUpStartButton();
        setUpCamera();
    }

    private void setUpStartButton(){
        Rectangle playButtonBounds = new Rectangle(getCamera().viewportWidth * 3 / 16,
                getCamera().viewportHeight / 4, getCamera().viewportWidth / 4,
                getCamera().viewportWidth / 4);
        playButton = new PlayButton(playButtonBounds, new GamePlayButtonListener());
        addActor(playButton);
    }

    private void addWorldComponents(){
        bkgrd = new Background(Constants.MENU_BACKGROUND_IMAGE_PATH);
        addActor(bkgrd);
    }

    private void setUpCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth, camera.viewportHeight, 0f);
        camera.update();
    }

    private void onGameStart(){
        GameManager.getInstance().setGameState(GameState.PLAY);
    }

    private class GamePlayButtonListener implements PlayButton.PlayButtonListener{
        @Override
        public void onPlay() {
            clear();
            onGameStart();
        }
    }
}
