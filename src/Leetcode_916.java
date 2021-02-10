import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


/***
 * 916. Word Subsets ------Medium
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 *
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 *
 * Now say a word a from A is universal if for every b in B, b is a subset of a. 
 *
 * Return a list of all universal words in A.  You can return the words in any order.
 *
 *  
 *
 * Example 1:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 * Example 2:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * Output: ["apple","google","leetcode"]
 * Example 3:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * Output: ["facebook","google"]
 * Example 4:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * Output: ["google","leetcode"]
 * Example 5:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
 * Output: ["facebook","leetcode"]
 *  
 *
 * Note:
 *
 * 1 <= A.length, B.length <= 10000
 * 1 <= A[i].length, B[i].length <= 10
 * A[i] and B[i] consist only of lowercase letters.
 * All words in A[i] are unique: there isn't i != j with A[i] == A[j].
 */






public class Leetcode_916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        //This is my first method.  => Time: out of range.

//        ArrayList<String> result = new ArrayList<String>();
//        LinkedList<String> orderdB = new LinkedList<String>();
//        outer7:
//        for (int i = 0; i < B.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (B[i].length() <= orderdB.get(j).length()) {
//                    orderdB.add(j, B[i]);
//                    continue outer7;
//                }
//            }
//            orderdB.add(i, B[i]);
//        }
//        ArrayList<Integer> removeList = new ArrayList<Integer>();
//        char[] currentString;
//        ArrayList<Character> compString = new ArrayList<Character>();
//        char[] compStringCharArray;
//        boolean isContained = true;
//        outer2:
//        for (int i = 0; i < B.length - 1; i++) {
//
//            currentString = orderdB.get(i).toCharArray();
//            outer:
//            for (int j = i + 1; j < B.length; j++) {
//                compStringCharArray = orderdB.get(j).toCharArray();
//                compString.clear();
//                for (char k : compStringCharArray) {
//                    compString.add(k);
//                }
//                outer1:
//                for (char key : currentString) {
//                    for (int p = 0; p < compString.size(); p++) {
//                        if (key == compString.get(p)) {
//                            compString.remove(p);
//                            continue outer1;
//                        }
//                    }
//                    continue outer;
//
//                }
//                removeList.add(i);
//                continue outer2;
//            }
//        }
//        outer5:
//        for (String str : A) {
//            compString.clear();
//            compStringCharArray = str.toCharArray();
//            for (char key : compStringCharArray) {
//                compString.add(key);
//            }
//            outer3:
//            for (int i = 0; i < B.length; i++) {
//                if (removeList.contains(i)) {
//                    continue outer3;
//                }
//                compString.clear();
//                compStringCharArray = str.toCharArray();
//                for (char key : compStringCharArray) {
//                    compString.add(key);
//                }
//                currentString = orderdB.get(i).toCharArray();
//                outer4:
//                for (char key : currentString) {
//                    for (int q = 0; q < compString.size(); q++) {
//                        if (key == compString.get(q)) {
//                            compString.remove(q);
//                            continue outer4;
//                        }
//                    }
//                    continue outer5;
//                }
//            }
//            result.add(str);
//        }
//        return result;

        //My second method:
        //Time: 91.61%
        //Memory: 57.79%
        ArrayList<String> result = new ArrayList<String>();
        int[] freq = new int[26];
        int[] maxFreq = new int[26];
        for (String str : B) {
            freq = new int[26];
            for (char letter : str.toCharArray()) {
                freq[letter - 'a'] = freq[letter - 'a'] + 1;
            }
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = freq[i] <= maxFreq[i] ? maxFreq[i] : freq[i];
            }
        }
        outer:
        for (String str : A) {
            freq = new int[26];
            for (char letter : str.toCharArray()) {
                freq[letter - 'a'] = freq[letter - 'a'] + 1;

            }
            for (int i = 0; i < 26; i++) {
                if (maxFreq[i] > freq[i]) {
                    continue outer;
                }
            }
            result.add(str);
        }
        return result;

    }

    public static void main(String[] args) {
        String[] A = {"amazon","apple","facebook","google","leetcode"};
        String[] B = {"lo", "eo"};
        Leetcode_916 temp = new Leetcode_916();
        System.out.println(temp.wordSubsets(A, B));
    }
}
