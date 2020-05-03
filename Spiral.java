public class Spiral {
    static final int N = 10;

    static void show(int[][] mtx) {
        for (int[] row : mtx) {
            for (int el : row) {
                System.out.printf("%3d ", el);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int counter = 1, start = counter;
        int[][] mtx = new int[N][N];

        Direction horizontal = new Direction();
        Direction vertical = new Direction();

        while (counter < start + N * N) {
            for (int i = vertical.min; i <= vertical.max; i++) {
                mtx[i][horizontal.min] = counter;
                counter++;
            }
            horizontal.min++;
            for (int i = horizontal.min; i <= horizontal.max; i++) {
                mtx[vertical.max][i] = counter;
                counter++;
            }
            vertical.max--;
            for (int i = vertical.max; i >= vertical.min; i--) {
                mtx[i][horizontal.max] = counter;
                counter++;
            }
            horizontal.max--;
            for (int i = vertical.max; i >= horizontal.min; i--) {
                mtx[vertical.min][i] = counter;
                counter++;
            }
            vertical.min++;
        }
        show(mtx);
        System.out.println();
    }

    static class Direction {
        int min;
        int max;

        public Direction() {
            this.min = 0;
            this.max = N - 1;
        }
    }
}