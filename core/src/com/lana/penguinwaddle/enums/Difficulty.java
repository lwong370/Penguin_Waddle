package com.lana.penguinwaddle.enums;

import com.badlogic.gdx.math.Vector2;
import com.lana.penguinwaddle.utils.Constants;

public enum Difficulty {
    DIFFICULTY_1(1, Constants.OBSTACLE_LINEAR_VELOCITY, Constants.RUNNER_GRAVITY_SCALE, Constants.RUNNER_LINEAR_JUMP_IMPULSE, 1.6,2),
    DIFFICULTY_2(2, new Vector2(-10f, 0f), Constants.RUNNER_GRAVITY_SCALE, Constants.RUNNER_LINEAR_JUMP_IMPULSE, 1.5,2),
    DIFFICULTY_3(3, new Vector2(-10.5f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.1f, new Vector2(0, 102f), 1.5,3),
    DIFFICULTY_4(4, new Vector2(-11f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.1f, new Vector2(0, 102f), 1.5,3),
    DIFFICULTY_5(5, new Vector2(-11.5f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.1f , new Vector2(0, 102f), 1.5,4),
    DIFFICULTY_6(6, new Vector2(-12f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.2f, new Vector2(0, 102f), 1.25,4),
    DIFFICULTY_7(7, new Vector2(-12.5f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.2f, new Vector2(0, 102f), 1.25,5),
    DIFFICULTY_8(8, new Vector2(-13f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.2f, new Vector2(0, 100f), 1.25,5),
    DIFFICULTY_9(9, new Vector2(-13.5f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.2f, new Vector2(0, 100f), 1.25,6),
    DIFFICULTY_10(10, new Vector2(-14f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.3f, new Vector2(0, 100f), 1,6),
    DIFFICULTY_11(11, new Vector2(-14.5f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.3f, new Vector2(0, 100f), 1,7),
    DIFFICULTY_12(12, new Vector2(-15f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.3f, new Vector2(0, 98f), 0.75,7),
    DIFFICULTY_13(13, new Vector2(-15.5f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.4f, new Vector2(0, 96f), 0.75,8);

    private int level;
    private Vector2 obstacleLinearVelocity;
    private float runnerGravityScale;
    private Vector2 runnerJumpingLinearImpulse;
    private double rollTime;
    private int scoreMultiplier;

    Difficulty(int level, Vector2 obstacleLinearVelocity, float runnerGravityScale, Vector2 runnerJumpingLinearImpulse, double rollTime, int scoreMultiplier) {
        this.level = level;
        this.obstacleLinearVelocity = obstacleLinearVelocity;
        this.runnerGravityScale = runnerGravityScale;
        this.runnerJumpingLinearImpulse = runnerJumpingLinearImpulse;
        this.rollTime = rollTime;
        this.scoreMultiplier = scoreMultiplier;
    }

    public int getLevel() {
        return level;
    }

    public Vector2 getObstacleLinearVelocity() {
        return obstacleLinearVelocity;
    }

    public float getRunnerGravityScale() {
        return runnerGravityScale;
    }

    public Vector2 getRunnerJumpingLinearImpulse() {
        return runnerJumpingLinearImpulse;
    }

    public int getScoreMultiplier() {
        return scoreMultiplier;
    }

    public double getRollTime() {
        return rollTime;
    }
}
