package com.lana.penguinwaddle.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.lana.penguinwaddle.actors.*;
import com.lana.penguinwaddle.actors.buttons.PauseButton;
import com.lana.penguinwaddle.enums.Difficulty;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.*;

public class GameStage extends Stage implements ContactListener {

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private World world;
    private Background bkgrd;
    private Ground ground;
    private Penguin penguin;
    private Obstacle obstacle;
    private Score score;
    private PauseButton pauseButton;
    private PauseButton resumeButton;

    private ScorePreferencesManager scorePreferencesManager = ScorePreferencesManager.getInstance();

    private final float TIME_STEP = 1/300f;
    private float accumulator = 0f;
    private float totalTimePassed;

    private OrthographicCamera camera;

    boolean screenSlideDown;
    float rotateDelay;
    int numFingersTouch = 0;

    public GameStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        onGameStart();
        setUpWorldComponents();
        setUpCamera();
        setUpScore();
    }

    private void setUpWorldComponents(){
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        penguin = new Penguin(WorldUtils.createPenguin(world));
        bkgrd = new Background(Constants.GAME_BACKGROUND_IMAGE_PATH);
        ground = new Ground(WorldUtils.createGround(world));

        addActor(bkgrd);
        addActor(ground);
        addActor(penguin);
        createObstacle();
        setUpPauseButton();
    }

    private void createObstacle(){
        obstacle = new Obstacle(WorldUtils.createObstacle(world));
        obstacle.changeDifficulty(GameManager.getInstance().getDifficulty());
        addActor(obstacle);
    }

    private void setUpCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
        camera.update();
    }

    private void setUpScore(){
        Rectangle bounds = new Rectangle(getCamera().viewportWidth * 47 / 64,
                getCamera().viewportHeight * 57 / 64, getCamera().viewportWidth / 4,
                getCamera().viewportHeight / 8);
        score = new Score(bounds);
        addActor(score);
    }

    private void setUpPauseButton(){
        Rectangle bounds = new Rectangle(getCamera().viewportWidth / 64,
                getCamera().viewportHeight * 13 / 16, getCamera().viewportHeight / 10,
                getCamera().viewportHeight / 10);
        pauseButton = new PauseButton(bounds, new PauseButtonListener());
        addActor(pauseButton);
    }

    private void setUpResumeButton(){
        Rectangle bounds = new Rectangle(getCamera().viewportWidth * 1/3,
                getCamera().viewportHeight / 4, getCamera().viewportWidth / 4,
                getCamera().viewportWidth / 4);
        resumeButton = new PauseButton(bounds, new ResumeButtonListener());
        addActor(resumeButton);
    }

    public DirectionGestureDetector getGameGestureDetector(){
        return new DirectionGestureDetector(new DirectionGestureDetector.DirectionListener() {
            @Override
            public void onLeft() {

            }

            @Override
            public void onRight() {

            }

            @Override
            public void onUp() {
                if(GameManager.getInstance().getGameState() == GameState.PLAY){
                    penguin.hop();
                }
            }

            @Override
            public void onDown() {
                if(GameManager.getInstance().getGameState() == GameState.PLAY){
                    screenSlideDown = true;
                    penguin.tumble();
                    rotateDelay = 0f;
                }
            }
        });
    }



    @Override
    public void act(float delta) {
        super.act(delta);

        if(GameManager.getInstance().getGameState() == GameState.PAUSED){
            return;
        }

        if(GameManager.getInstance().getGameState() == GameState.PLAY){
            totalTimePassed += delta;
            updateDifficulty();
        }

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for (Body body : bodies) {
            updateObstacles(body);
        }

        accumulator += delta;

        while(accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

        if(screenSlideDown){
            if(penguin.isTumbling()){
                rotateDelay += delta;
                if(rotateDelay > 1){
                    penguin.stopTumbling();
                    screenSlideDown = false;
                }
            }
        }

        updatePenguinFrightStopState();
    }

    @Override
    public void beginContact(Contact contact) {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if((BodyUtils.bodyIsPenguin(a) && BodyUtils.bodyIsGround(b)) ||
                (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsPenguin(b))){
            penguin.land();
        } else if((BodyUtils.bodyIsPenguin(a) && BodyUtils.bodyIsObstacle(b)) ||
        (BodyUtils.bodyIsObstacle(a) && BodyUtils.bodyIsPenguin(b))){
            penguin.hit();
            onGameOver();
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        numFingersTouch--;
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        numFingersTouch++;
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }
    public Penguin getPenguin(){
        return penguin;
    }

    private void updateObstacles(Body body){
        if(!BodyUtils.bodyInBounds(body)){
            if(BodyUtils.bodyIsObstacle(body) && !penguin.isHit()){
                createObstacle();
            }
            world.destroyBody(body);
        }
    }

    private void updateDifficulty(){
        if(GameManager.getInstance().isMaxDifficulty()){
            return;
        }

        Difficulty currentDifficulty = GameManager.getInstance().getDifficulty();

        if(totalTimePassed - (8 * currentDifficulty.getLevel()) > 0){
            int nextDifficulty = currentDifficulty.getLevel() + 1;
            String difficultyName = "DIFFICULTY_" + nextDifficulty;
            GameManager.getInstance().setDifficulty(Difficulty.valueOf(difficultyName));

            penguin.changeDifficulty(GameManager.getInstance().getDifficulty());
            score.setMultiplier(GameManager.getInstance().getDifficulty().getScoreMultiplier());
        }
    }

    private void onGameStart(){
        GameManager.getInstance().setGameState(GameState.PLAY);
        GameManager.getInstance().resetDifficulty();
        totalTimePassed = 0;
    }

    private void onGameOver(){
        GameManager.getInstance().setGameState(GameState.GAME_OVER);
        scorePreferencesManager.writeScoreToPreferences(Constants.CURRENT_SCORE_KEY, score.getScore());
        GameManager.getInstance().saveScore(score.getScore());
    }

    private void onGamePause(){
        GameManager.getInstance().setGameState(GameState.PAUSED);
        bkgrd.setStop(true);
        ground.setStop(true);
        setUpResumeButton();
        pauseButton.remove();
    }

    private void onGameResumed(){
        GameManager.getInstance().setGameState(GameState.PLAY);
        setUpPauseButton();
        resumeButton.remove();
    }

    private void updatePenguinFrightStopState(){
        if(numFingersTouch == 2){
            penguin.frightStop();
            if(penguin.isFrightStopped()){
                bkgrd.setStop(true);
                ground.setStop(true);
            }
        }

        if(!Gdx.input.isTouched()){
            numFingersTouch = 0;
            penguin.undoFrightStop();
            bkgrd.setStop(false);
            ground.setStop(false);
        }
    }

    private class PauseButtonListener implements PauseButton.PauseButtonListener{
        @Override
        public void onClicked() {
            onGamePause();
        }
    }

    private class ResumeButtonListener implements PauseButton.PauseButtonListener{
        @Override
        public void onClicked() {
            onGameResumed();
        }
    }
}
