package com.lana.penguinwaddle.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.lana.penguinwaddle.actors.Background;
import com.lana.penguinwaddle.actors.Ground;
import com.lana.penguinwaddle.actors.Obstacle;
import com.lana.penguinwaddle.actors.Penguin;
import com.lana.penguinwaddle.utils.BodyUtils;
import com.lana.penguinwaddle.utils.DirectionGestureDetector;
import com.lana.penguinwaddle.utils.WorldUtils;

public class GameStage extends Stage implements ContactListener {
    private static final int VIEWPORT_WIDTH = 20;
    private static final int VIEWPORT_HEIGHT = 13;

    private World world;
    private Ground ground;
    private Penguin penguin;
    private Obstacle obstacle;

    private final float TIME_STEP = 1/300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;

    //Temp
//    private Box2DDebugRenderer renderer;

    boolean screenTouched;
    float rotateDelay;

    private InputProcessor inputProcessor1;
    private InputProcessor inputProcessor2;

    public GameStage() {
//        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
//                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        setUpWorldComponents();
        setUpGesture();
        //Temp
//        renderer = new Box2DDebugRenderer();
        setUpCamera();
    }

    private void setUpWorldComponents(){
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        penguin = new Penguin(WorldUtils.createPenguin(world));
        ground = new Ground(WorldUtils.createGround(world));
        createObstacle();

        addActor(new Background());
        addActor(ground);
        addActor(penguin);
    }

    private void createObstacle(){
        obstacle = new Obstacle(WorldUtils.createObstacle(world));
        addActor(obstacle);
    }

    private void setUpCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
        camera.update();
    }

    private void setUpGesture(){
        inputProcessor1 = this;
        inputProcessor2 = new DirectionGestureDetector(new DirectionGestureDetector.DirectionListener() {
            @Override
            public void onLeft() {

            }

            @Override
            public void onRight() {

            }

            @Override
            public void onUp() {
               penguin.hop();
            }

            @Override
            public void onDown() {
                screenTouched = true;
                penguin.tumble();
                rotateDelay = 0f;
            }
        });
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(inputProcessor1);
        inputMultiplexer.addProcessor(inputProcessor2);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for (Body body : bodies) {
            update(body);
        }

        accumulator += delta;

        while(accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

        //Detect screen touching
        if(screenTouched){
            if(penguin.isTumbling()){
                rotateDelay += delta;
                if(rotateDelay > 2){
                    penguin.stopTumbling();
                    screenTouched = false;
                }
            }
        }
    }

//    @Override
//    public void draw() {
//        super.draw();
//        renderer.render(world, camera.combined);
//    }

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
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }

    private void update(Body body){
        if(!BodyUtils.bodyInBounds(body)){
            if(BodyUtils.bodyIsObstacle(body) && !penguin.isHit()){
                createObstacle();
            }
            world.destroyBody(body);
        }
    }

    //    private void translateScreenToWorldCoordinates(int x, int y) {
//        getCamera().unproject(touchPoint.set(x, y, 0));
//    }

}
