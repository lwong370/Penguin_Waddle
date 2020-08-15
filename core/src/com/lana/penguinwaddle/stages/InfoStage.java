package com.lana.penguinwaddle.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.lana.penguinwaddle.actors.AboutLabel;
import com.lana.penguinwaddle.actors.Background;
import com.lana.penguinwaddle.actors.buttons.BackButton;
import com.lana.penguinwaddle.actors.buttons.InfoButton;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class InfoStage extends Stage {

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private OrthographicCamera camera;
    private InfoButton infoButton;
    private BackButton backButton;
    private AboutLabel aboutLabel;
    private Background bkgrd;

    public InfoStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        addWorldComponents();
        setUpBackButton();
        setUpAboutLabel();
        setUpCamera();
    }

    private void addWorldComponents(){
        bkgrd = new Background(Constants.WORDLESS_BACKGROUND_IMAGE_PATH);
        addActor(bkgrd);
    }
    private void setUpBackButton(){
        Rectangle bounds = new Rectangle(getCamera().viewportWidth / 22,
                getCamera().viewportHeight * 3/4, getCamera().viewportWidth / 10,
                getCamera().viewportWidth / 10);
        backButton = new BackButton(bounds, new ToMainMenuListener());
        addActor(backButton);
    }

    private void setUpAboutLabel(){
        Rectangle bounds = new Rectangle(0, getCamera().viewportHeight * 7 / 8,
                getCamera().viewportWidth, getCamera().viewportHeight/4);
        aboutLabel = new AboutLabel(bounds);
        addActor(aboutLabel);
    }

    private void setUpCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth, camera.viewportHeight, 0f);
        camera.update();
    }

    private void onGetMainMenu(){
        GameManager.getInstance().setGameState(GameState.MENU);
    }

    private class ToMainMenuListener implements BackButton.BackButtonListener{
        @Override
        public void back() {
            clear();
            onGetMainMenu();
        }
    }
}
