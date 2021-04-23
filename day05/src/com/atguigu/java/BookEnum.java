package com.atguigu.java;

/**
 * TODO
 *
 * @author JClearLove
 * @date 2021/04/15 13:54
 */
public enum BookEnum implements Read {
    /**
     *
     */
    YUWEN("语文课") {
        @Override
        public void readBook() {
            super.readBook();
        }
    }, MATH("数学课"), HISTORY("历史课");

    private final String desc;

    BookEnum(String desc) {
        this.desc = desc;
    }

    @Override
    public void readBook() {
        System.out.println("读书了");
    }
}

interface Read {
    void readBook();
}
