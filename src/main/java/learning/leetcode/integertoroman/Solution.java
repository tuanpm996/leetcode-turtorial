package learning.leetcode.integertoroman;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        //https://leetcode.com/problems/integer-to-roman/
    }
    public static String convertIntToRoman(int num) {
        List<Integer> integerList = new ArrayList<>();
        int currentNumber = num;
        while (currentNumber > 0) {
            int divided = currentNumber / 10;
            integerList.add(currentNumber - divided * 10);
            currentNumber = divided;
        }
        Collections.reverse(integerList);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < integerList.size(); i++) {
            Integer integer = integerList.get(i);
            switch (integerList.size() - i) {
                case 4:
                    str.append("M".repeat(integer));
                    break;
                case 3:
                    str.append(getRomanNumeral("C", "D", "M", integer));
                    break;
                case 2:
                    str.append(getRomanNumeral("X", "L", "C", integer));
                    break;
                case 1:
                    str.append(getRomanNumeral("I", "V", "X", integer));
                    break;
            }
        }
        return str.toString();

    }

    private static CharSequence getRomanNumeral(String oneStr, String fiveStr, String tenStr, int number) {
        if (number < 4) {
            return oneStr.repeat(number);
        }
        if (number == 4) {
            return oneStr + fiveStr;
        }
        if (number == 5) {
            return fiveStr;
        }
        if (number < 9) {
            return fiveStr.concat(oneStr.repeat((number - 5)));
        }
        if (number == 9) {
            return oneStr + tenStr;
        }
        return "";
    }
}

