package tree.matrix;

import java.util.ArrayDeque;

public class TheMatrix {
    private static final String NEW_LINE = "\r\n";

    private char[][] matrix;
    private char fillChar;
    private char toBeReplaced;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.toBeReplaced = this.matrix[this.startRow][this.startCol];
    }

    public void solve() {
//        fillMatrixRecursive(startRow, startCol);
        fillMatrixUsingQueue(startRow, startCol);
    }

    private void fillMatrixUsingQueue(int initialRow, int initialCol) {
        ArrayDeque<int[]> coordinates = new ArrayDeque<>();

        coordinates.offer(new int[]{initialRow, initialCol});

        while (!coordinates.isEmpty()) {
            int[] position = coordinates.poll();

            int row = position[0];
            int col = position[1];

            this.matrix[row][col] = this.fillChar;

            if (isInBounds(row + 1, col) && this.matrix[row + 1][col] == this.toBeReplaced) {
                coordinates.offer(new int[]{row + 1, col});
            }

            if (isInBounds(row - 1, col) && this.matrix[row - 1][col] == this.toBeReplaced) {
                coordinates.offer(new int[]{row - 1, col});
            }

            if (isInBounds(row, col + 1) && this.matrix[row][col + 1] == this.toBeReplaced) {
                coordinates.offer(new int[]{row, col + 1});
            }

            if (isInBounds(row, col - 1) && this.matrix[row][col - 1] == this.toBeReplaced) {
                coordinates.offer(new int[]{row, col - 1});
            }

        }
    }

    private void fillMatrixRecursive(int row, int col) {
        if (isOutOfBounds(row, col) || this.matrix[row][col] != this.toBeReplaced) {
            return;
        }

        this.matrix[row][col] = this.fillChar;

        this.fillMatrixRecursive(row + 1, col);
        this.fillMatrixRecursive(row, col + 1);
        this.fillMatrixRecursive(row - 1, col);
        this.fillMatrixRecursive(row, col - 1);
    }

    private boolean isInBounds(int row, int col) {
        return !isOutOfBounds(row, col);
    }

    private boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= this.matrix.length || col < 0 || col >= this.matrix[row].length;
    }

    public String toOutputString() {
        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < this.matrix.length; r++) {
            for (int c = 0; c < this.matrix[r].length; c++) {
                builder.append(this.matrix[r][c]);
            }
            builder.append(NEW_LINE);
        }

        if (builder.length() > 0) {
            builder.setLength(builder.length() - NEW_LINE.length());
        }

        return builder.toString();
    }
}
