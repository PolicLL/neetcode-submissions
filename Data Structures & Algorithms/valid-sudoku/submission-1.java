class Solution {

    private static String numbers = "123456789";

    public boolean isValidSudoku(char[][] board) {
        char[] testArr = new char[board.length];


        for (int i = 0; i < board.length; ++i) {
            testArr = board[i];
            if (!areUnique(testArr)) {
                return false;
            }
        }

        for (int i = 0; i < board.length; ++i) {
            if(!areUnique(copyColumn(board, i))) return false;
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                int tempI = i;
                int tempJ = j;
                if (!isRectangleUnique(board, tempI, tempJ)) {
                    return false;
                }
            }
        } 

        return true;
    }

    private boolean isRectangleUnique(char[][] board, int x, int y) {
        System.out.println("x " + x + " y " + y);
        int endX = x + 3;
        int endY = y + 3;
        System.out.println("endX " + endX + " endY " + endY);
        char[] testArr = new char[9];
        int counter = 0;

        for(int i = x; i < endX; ++i) {
            for(int j = y; j < endY; ++j) {
                System.out.println("VAL: " + board[i][j] + " i : " + i + " j " + j);
                testArr[counter++] = board[i][j];
            }
        }

        System.out.println();

        for(char c : testArr) {
            System.out.print(c + " ");
        }

        System.out.println();

        return areUnique(testArr) ? true : false;
    }

    private boolean areUnique(char[] input) {
        Map<Character, Boolean> map = new HashMap<>();
        for(char c : input) {
            if (numbers.indexOf(c) == -1) {
                continue;
            }
            if (map.containsKey(c))
                return false;
            map.put(c, true);
        }

        return true;
    }

    private char[] copyColumn(char[][] board, int column) {
        char[] copy = new char[board.length];
        for (int i = 0; i < board.length; ++i) {
            copy[i] = board[i][column];
        }

        return copy;
    }
}
