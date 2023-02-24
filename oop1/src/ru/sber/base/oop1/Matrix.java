package ru.sber.base.oop1;

public class Matrix {
    private double[][] matrix;

    private int rowCount;

    private int columnCount;


    public Matrix(int rowCount, int columnCount) {
        this.matrix = new double[rowCount][columnCount];
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    public void setValue(int row, int column, double value) {
        if (row > 0 && row < rowCount && column > 0 && column < columnCount) {
            matrix[row][column] = value;
        }
    }

    public void add(Matrix other) {
        for (int i = 0; i < other.rowCount; i++) {
            for (int j = 0; j < other.columnCount; j++) {
                matrix[i][j] += other.matrix[i][j];
            }
        }
    }

    public void multiply(double value) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                matrix[i][j] *= value;
            }
        }
    }

    public static void main(String[] args) {
        final int BASE_ROW_COUNT = 11;
        final int BASE_COLUMN_COUNT = 11;
        final int ADDITION_ROW_COUNT = 11;
        final int ADDITION_COLUMN_COUNT = 11;
        int counter = 0;

        Matrix baseMatrix = new Matrix(BASE_ROW_COUNT, BASE_COLUMN_COUNT);
        for (int i = 0; i < BASE_ROW_COUNT; i++) {
            for (int j = 0; j < BASE_COLUMN_COUNT; j++) {
                baseMatrix.setValue(i, j, counter++);
            }
        }
        System.out.println(baseMatrix);
        Matrix additionMatrix = new Matrix(ADDITION_ROW_COUNT, ADDITION_COLUMN_COUNT);
        for (int i = 0; i < ADDITION_ROW_COUNT; i++) {
            for (int j = 0; j < ADDITION_COLUMN_COUNT; j++) {
                additionMatrix.setValue(i, j, counter--);
            }
        }

        baseMatrix
                .add(additionMatrix);

        Matrix multiplyMatrix = new Matrix(3, 3);
        for (int i = 0; i < multiplyMatrix.rowCount; i++) {
            for (int j = 0; j < multiplyMatrix.columnCount; j++) {
                multiplyMatrix.setValue(i, j, --counter);
            }
        }

    }
}