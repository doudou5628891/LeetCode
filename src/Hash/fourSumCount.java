package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class fourSumCount {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int temp = 0;
        int res = 0;
        for (int i:nums1) {
            for (int j:nums2) {
                temp = i+j;
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else{
                    map.put(temp,1);
                }
            }
        }
        for (int i:nums3) {
            for (int j:nums4) {
                temp=i+j;
                if(map.containsKey(0-temp)){
                    res+=map.get(0-temp);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] testData1 = {1,2};
        int[] testData2 = {-2,-1};
        int[] testData3 = {-1,2};
        int[] testData4 = {0,2};
        int result =  fourSumCount(testData1,testData2,testData3,testData4);
        System.out.print(result);
    }
}
