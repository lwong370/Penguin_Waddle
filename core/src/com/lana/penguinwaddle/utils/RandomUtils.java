package com.lana.penguinwaddle.utils;

import com.lana.penguinwaddle.enums.ObstacleType;

import java.util.Random;

public class RandomUtils {
    public static ObstacleType getRandomObstacleType(){
        RandomEnum<ObstacleType> randomEnum = new RandomEnum<ObstacleType>(ObstacleType.class);
        return randomEnum.random();
    }

    private static class RandomEnum<E extends Enum>{
        private static final Random RAND = new Random();
        private final E[] values;

        private RandomEnum(Class<E> token){
            values = token.getEnumConstants();
        }

        public E random(){
            return values[RAND.nextInt(values.length)];
        }
    }
}
