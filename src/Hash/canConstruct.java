package Hash;

import java.util.HashMap;
import java.util.Map;

/*
 一些同学可能想，用数组干啥，都用map完事了，
 其实在本题的情况下，使用map的空间消耗要比数组大一些的，
 因为map要维护红黑树或者哈希表，而且还要做哈希函数，是费时的！
 数据量大的话就能体现出来差别了。
 所以数组更加简单直接有效！
 */
public class canConstruct {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Integer,Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()){
            if(map.containsKey((int)c)){

                map.put((int)c,map.get((int)c)+1);
            }else{
                map.put((int)c,1);
            }
        }
        for (char c : ransomNote.toCharArray()){
            if(map.containsKey((int)c)){
                if(map.get((int)c)==0){
                    return false;
                }
                map.put((int)c,map.get((int)c)-1);
            }else{
                return false;
            }
        }
        return true;
    }
    public static boolean canConstruct_2(String ransomNote, String magazine) {
        int[] arr = new int[26];
        int temp;
        for (int i = 0; i < magazine.length(); i++) {
            temp = magazine.charAt(i)-'a';
            arr[temp]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            temp = ransomNote.charAt(i)-'a';
            if(arr[temp]>0){
                arr[temp]--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean result = canConstruct(ransomNote,magazine);
        System.out.print(result);
    }
}
