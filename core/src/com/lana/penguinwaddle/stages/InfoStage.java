package com.lana.penguinwaddle.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.lana.penguinwaddle.actors.Text;
import com.lana.penguinwaddle.actors.Background;
import com.lana.penguinwaddle.actors.buttons.BackButton;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class InfoStage extends Stage {

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private OrthographicCamera camera;
    private BackButton backButton;
    private Text aboutMeText;
    private Text header;
    private Text credits;
    private Background bkgrd;

    public InfoStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        addWorldComponents();
        setUpBackButton();
        setUpHeader();
        setUpAboutLabel();
        setUpCredits();
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

    private void setUpHeader(){
        float width = getCamera().viewportWidth/2;
        Rectangle bounds = new Rectangle(getCamera().viewportWidth/2- width/2, getCamera().viewportHeight * 7 / 8,
                width, getCamera().viewportHeight*(3/4));
        header = new Text(bounds, Constants.INFO_HEADER);
        addActor(header);
    }

    private void setUpAboutLabel(){
        Rectangle bounds = new Rectangle(0, getCamera().viewportHeight * 7 / 8,
                getCamera().viewportWidth, getCamera().viewportHeight/4);
        aboutMeText = new Text(bounds, Constants.ABOUT_TEXT);
        addActor(aboutMeText);
    }

    private void setUpCredits(){
        String combCredits = "\n\n" + Constants.GDX_CREDIT + "\n" + Constants.ZAPSPLAT_CREDIT + "\n" + Constants.BENSOUND_CREDIT;
        Rectangle bounds = new Rectangle(0, getCamera().viewportHeight /2,
                getCamera().viewportWidth/2, getCamera().viewportHeight/4);
        credits = new Text(bounds, combCredits);
        addActor(credits);
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
