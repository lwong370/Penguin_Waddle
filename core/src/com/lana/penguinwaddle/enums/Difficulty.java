package com.lana.penguinwaddle.enums;

import com.badlogic.gdx.math.Vector2;
import com.lana.penguinwaddle.utils.Constants;

public enum Difficulty {
    DIFFICULTY_1(1, Constants.OBSTACLE_LINEAR_VELOCITY, Constants.RUNNER_GRAVITY_SCALE, Constants.RUNNER_LINEAR_JUMP_IMPULSE, 2),
    DIFFICULTY_2(2, new Vector2(-10f, 0f), Constants.RUNNER_GRAVITY_SCALE, Constants.RUNNER_LINEAR_JUMP_IMPULSE, 3),
    DIFFICULTY_3(3, new Vector2(-10.5f, 0f), Constants.RUNNER_GRAVITY_SCALE, Constants.RUNNER_LINEAR_JUMP_IMPULSE, 4),
    DIFFICULTY_4(4, new Vector2(-11f, 0f), Constants.RUNNER_GRAVITY_SCALE , Constants.RUNNER_LINEAR_JUMP_IMPULSE, 5),
    DIFFICULTY_5(5, new Vector2(-11.5f, 0f), Constants.RUNNER_GRAVITY_SCALE , Constants.RUNNER_LINEAR_JUMP_IMPULSE, 6),
    DIFFICULTY_6(6, new Vector2(-12f, 0f), Constants.RUNNER_GRAVITY_SCALE , Constants.RUNNER_LINEAR_JUMP_IMPULSE, 7),
    DIFFICULTY_7(7, new Vector2(-12.5f, 0f), Constants.RUNNER_GRAVITY_SCALE , Constants.RUNNER_LINEAR_JUMP_IMPULSE, 8),
    DIFFICULTY_8(8, new Vector2(-13f, 0f), Constants.RUNNER_GRAVITY_SCALE , Constants.RUNNER_LINEAR_JUMP_IMPULSE, 9),
    DIFFICULTY_9(9, new Vector2(-13.5f, 0f), Constants.RUNNER_GRAVITY_SCALE , Constants.RUNNER_LINEAR_JUMP_IMPULSE, 10),
    DIFFICULTY_10(10, new Vector2(-14f, 0f), Constants.RUNNER_GRAVITY_SCALE , Constants.RUNNER_LINEAR_JUMP_IMPULSE, 11),
    DIFFICULTY_11(10, new Vector2(-14.5f, 0f), Constants.RUNNER_GRAVITY_SCALE , Constants.RUNNER_LINEAR_JUMP_IMPULSE, 12);

    private int level;
    private Vector2 obstacleLinearVelocity;
    private float runnerGravityScale;
    private Vector2 runnerJumpingLinearImpulse;
    private int scoreMultiplier;

    Difficulty(int level, Vector2 obstacleLinearVelocity, float runnerGravityScale, Vector2 runnerJumpingLinearImpulse, int scoreMultiplier) {
        this.level = level;
        this.obstacleLinearVelocity = obstacleLinearVelocity;
        this.runnerGravityScale = runnerGravityScale;
        this.runnerJumpingLinearImpulse = runnerJumpingLinearImpulse;
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
}
