package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class isAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] record = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//        }
        for (char c : s.toCharArray()){
            record[c-'a']+=1;
        }
        for (char c : t.toCharArray()){
            record[c-'a']-=1;
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i]!=0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s,t);
        System.out.print(result);
    }
}
