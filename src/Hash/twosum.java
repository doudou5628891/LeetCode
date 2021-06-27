package Hash;

import java.util.*;


public class twosum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[1]=i;
                result[0]=map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testData = {2,7,11,15};
        int[] result = new int[2];
        result = twoSum(testData,9);
        System.out.print(Arrays.toString(result));
    }
}
