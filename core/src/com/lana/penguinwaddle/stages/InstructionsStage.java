package com.lana.penguinwaddle.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.lana.penguinwaddle.actors.Background;
import com.lana.penguinwaddle.actors.DrawnGameLabel;
import com.lana.penguinwaddle.actors.buttons.BackButton;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class InstructionsStage extends Stage {
    public static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    public static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private OrthographicCamera camera;

    private Background bkgrd;
    private BackButton backButton;

    public InstructionsStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        addWorldComponents();
        setUpBackButton();
        setUpInstructions();
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

    private void setUpInstructions(){
        float width = getCamera().viewportHeight / 2;
        float xLeft = getCamera().viewportWidth / 4 - width / 2;
        float xRight = getCamera().viewportWidth * 3 / 4 - width / 2;
        float y = getCamera().viewportHeight / 4;
        Rectangle leftTutorialBounds = new Rectangle(xLeft, y, width,
                width);
        Rectangle rightTutorialBounds = new Rectangle(xRight, y, width,
                width);
        Rectangle centerTutorialBounds = new Rectangle((xRight-xLeft)-width/2, y, width, width);

        addActor(new DrawnGameLabel(leftTutorialBounds, Constants.INSTRUCT_ROLL));
        addActor(new DrawnGameLabel(centerTutorialBounds, Constants.INSTRUCT_EVADE));
        addActor(new DrawnGameLabel(rightTutorialBounds, Constants.INSTRUCT_JUMP));
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
