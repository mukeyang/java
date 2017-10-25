package leetcode;

import java.util.HashSet;

/**
 * Created by CS on 2017/10/25.
 */
public class _3LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
//        char[] array = s.toCharArray();
        int n = s.length();
        int i=0,j=0,max=0;
        while (i < n & j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max=Math.max(set.size(),max);
            } else set.remove(s.charAt(i++));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("adfsa"));
    }
}
