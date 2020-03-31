package v1ch06.staticInnerClass;

class ArrayAlg {
    /**
     * A pair of floating-point numbers
     *
     * 计算数组中最小值和最大值的问题。
     * 当然， 可以编写两个方法， 一个方法用于计算最小值， 另一个方法用于计算最大值。在调用
     * 这两个方法的时候，数组被遍历两次。如果只遍历数组一次， 并能够同时计算出最小值和最
     * 大值，那么就可以大大地提高效率了
     */
    public static class Pair {
        private double first;
        private double second;

        /**
         * Constructs a pair from two floating-point numbers
         *
         * @param f the first number
         * @param s the second number
         */
        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        /**
         * Returns the first number of the pair
         *
         * @return the first number
         */
        public double getFirst() {
            return first;
        }

        /**
         * Returns the second number of the pair
         *
         * @return the second number
         */
        public double getSecond() {
            return second;
        }
    }

    /**
     * Computes both the minimum and the maximum of an array
     *
     * @param values an array of floating-point numbers
     * @return a pair whose first element is the minimum and whose second element
     * is the maximum
     */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
        }
        return new Pair(min, max);
    }
}
