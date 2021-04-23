package com.atguigu.exer;

/**
 * TODO
 *
 * @author JClearLove
 * @date 2021/04/15 14:10
 */
public enum Advice {
    /**
     * agree
     */
    AGREE("agree"), DISAGREE("disagree");


    private final String advice;

    Advice(String advice) {
        this.advice = advice;
    }

    public String getAdvice() {
        return advice;
    }
}
