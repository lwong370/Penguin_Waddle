package com.lana.penguinwaddle.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lana.penguinwaddle.actors.Ground;
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

    private final float TIME_STEP = 1/300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;
    //Temp
    private Box2DDebugRenderer renderer;

    public GameStage() {
//        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
//                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        setUpWorldComponents();
        setUpGesture();
        //Temp
        renderer = new Box2DDebugRenderer();
        setUpCamera();
    }

    private void setUpWorldComponents(){
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        ground = new Ground(WorldUtils.createGround(world));
        penguin = new Penguin(WorldUtils.createPenguin(world));

        addActor(ground);
        addActor(penguin);
    }

    private void setUpCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
        camera.update();
    }

    private void setUpGesture(){
        Gdx.input.setInputProcessor(new DirectionGestureDetector(new DirectionGestureDetector.DirectionListener() {
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
                penguin.tumble();
            }
        }));
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        accumulator += delta;

        while(accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }
    }

    @Override
    public void draw() {
        super.draw();
        renderer.render(world, camera.combined);
    }

    @Override
    public void beginContact(Contact contact) {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if((BodyUtils.bodyIsPenguin(a) && BodyUtils.bodyIsGround(b)) ||
                (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsPenguin(b))){
            penguin.land();
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


//    private void translateScreenToWorldCoordinates(int x, int y) {
//        getCamera().unproject(touchPoint.set(x, y, 0));
//    }

}
