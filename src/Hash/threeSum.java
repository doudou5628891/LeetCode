package Hash;

import java.util.*;


public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {
                if (map.containsKey(0 - nums[i] - nums[j])) {
                    HashMap<Integer, Integer> test = new HashMap<>();
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(0 - nums[i] - nums[j]);
                    for (int t : temp) {
                        if (test.containsKey(t)) {
                            test.put(t, test.get(t) + 1);
                        } else {
                            test.put(t, 1);
                        }
                    }

                    boolean judge = false;
                    for (List<Integer> k : result) {
                        int count = 0;
                        HashMap<Integer, Integer> clone = (HashMap<Integer, Integer>) test.clone();
                        for (int g : k) {
                            if (clone.containsKey(g)&&clone.get(g) > 0) {
                                    clone.put(g, clone.get(g) - 1);
                                    count++;
                            }
                            if (count == k.size()) {
                                judge = true;
                                count =0;
                                break;
                            }
                        }
                        if (judge) break;
                    }
                    if (!judge){
                        result.add(temp);
                    }
                }
                map.put(nums[j],0);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] testData = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = new ArrayList<>();

        result = threeSum(testData);
        System.out.print(result);
    }
}
