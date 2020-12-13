package learning.leetcode.isvalidsudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
//https://leetcode.com/problems/valid-sudoku/
        char[][] ints = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '7'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean validSudoku = isValidSudoku(ints);
        System.out.println("is valid: " + validSudoku);

    }

    public static boolean isValidSudoku(char[][] board) {
        if (isValidLines(board) && isValidRows(board) && isValidSubBoxes(board)) {
            return true;
        }
        return false;
    }

    private static boolean isValidSubBoxes(char[][] board) {
        return false;
    }

    private static boolean isValidRows(char[][] board) {
        for(int i = 0; i < 9; i++) {
            board[i]
        }
        return false;
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
