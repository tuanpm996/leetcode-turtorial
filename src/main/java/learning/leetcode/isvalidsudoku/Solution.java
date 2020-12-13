package learning.leetcode.isvalidsudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
//https://leetcode.com/problems/valid-sudoku/
        char[][] ints = new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        boolean validSudoku = isValidSudoku(ints);
        System.out.println("is valid: " + validSudoku);

    }

    public static boolean isValidSudoku(char[][] board) {
        return isValidLines(board) && isValidRows(board) && isValidSubBoxes(board);
    }

    private static boolean isValidSubBoxes(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> characters = new HashSet<>();
                for (int a = i; a < i + 3; a += 1) {
                    for (int b = j; b < j + 3; b += 1) {
                        if (!characters.contains(board[a][b])) {
                            characters.add(board[a][b]);
                        } else {
                            if (board[a][b] != '.') {
                                return false;
                            }
                        }
                    }
                }

            }
        }
        return true;
    }

    private static boolean isValidRows(char[][] board) {
        for (int i = 0; i < 9; i++) { // for row
            Set<Character> characters = new HashSet<>();
            for (char[] line : board) {
                if (!characters.contains(line[i])) {
                    characters.add(line[i]);
                } else {
                    if (line[i] != '.') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValidLines(char[][] board) {
        for (char[] line : board) {
            Set<Character> characters = new HashSet<>();
            for (char c : line) {
                if (!characters.contains(c)) {
                    characters.add(c);
                } else {
                    if (c != '.') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
