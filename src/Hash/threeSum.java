package Hash;

import java.util.*;


public class threeSum {
    public static List<List<Integer>> threeSum_abortion(int[] nums) {
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
                    Collections.sort(temp);

                    for (int t : temp) {
                        if (test.containsKey(t)) {
                            test.put(t, test.get(t) + 1);
                        } else {
                            test.put(t, 1);
                        }
                    }
                    HashMap<Integer, Integer> inClone = (HashMap<Integer, Integer>) test.clone();
                    int inCount=0;
                    boolean inJudge = false;
                    for(int f:nums){
                        if(inClone.containsKey(f)&&inClone.get(f) > 0){
                            inClone.put(f,inClone.get(f)-1);
                            inCount++;
                        }
                        if (inCount == 3) {
                            inJudge = true;
                            break;
                        }
                    }
                    if(!inJudge)continue;
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
    }//超出时间限制。。。。。
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举a
        for (int first = 0;first<n;++first){
            if(first>0&&nums[first]==nums[first-1])continue;
            int third = n-1;
            int target = -nums[first];
            //枚举b
            for (int second = first+1; second < n; ++second) {
                if (second>first+1&&nums[second]==nums[second-1])continue;
                while (second<third&&nums[second]+nums[third]>target)--third;

                if (second==third)break;
                if (nums[second]+nums[third]==target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] testData = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = new ArrayList<>();

        result = threeSum(testData);
        System.out.print(result);
    }
}
