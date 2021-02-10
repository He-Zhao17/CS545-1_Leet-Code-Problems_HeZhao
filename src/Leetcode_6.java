/***
 * 6. ZigZag Conversion -------Medium
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *  
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */

//Time > 98.21%
//Memory > 92.66%








public class Leetcode_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return  s;
        } else {
            int numOfGroup = 2*numRows - 2;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                for (int j = i; j < s.length(); j = j + numOfGroup) {
                    if (i == 0 || i == (numRows - 1)) {
                        result.append(s.charAt(j));
                    } else {
                        if ( (j + numOfGroup - i - 1) >= s.length() ){
                            result.append(s.charAt(j));
                            if ( j + 2 * (numRows - i - 1) < s.length()) {
                                result.append(s.charAt(j + 2 * (numRows - i - 1)));
                            }
                        } else {
                            result.append(s.charAt(j));
                            result.append(s.charAt(j + 2 * (numRows - i - 1)));
                        }
                    }
                }
            }
            return result.toString();

        }


    }

    public static void main(String[] args) {
        Leetcode_6 temp = new Leetcode_6();
        String result = temp.convert("ABCDE", 4);
        System.out.println(result);
    }
}
