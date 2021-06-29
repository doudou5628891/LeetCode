package Hash;
import java.util.*;
public class fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int first = 0; first < n; first++) {
            if(first>0&&nums[first]==nums[first-1])continue;

            for (int second = first+1; second < n; second++) {
                if(second>first+1&&nums[second]==nums[second-1])continue;

                for (int third = second+1; third < n; third++) {
                    if(third>second+1&&nums[third]==nums[third-1])continue;
                    int fourth = n-1;

                    while(third<fourth){
                        if(third==fourth)break;
                        if (target- nums[first] - nums[second] -nums[third] == nums[fourth]){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[first]);
                            temp.add(nums[second]);
                            temp.add(nums[third]);
                            temp.add(nums[fourth]);
                            result.add(temp);
                            break;
                        }
                        fourth--;
                    }
                }
            }
        }

        return result;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i - 1] == nums[i])continue; //去重
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j])continue;

                int left = j + 1;   //设置第二个指针右边为起点
                int right = nums.length - 1;    //设置第四个指针在最后一位
                while (right > left) {  //保证不交叉
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;    //合数比目标大 尾部指针左移
                    } else if (sum < target) {
                        left++;     //合数比目标小 头部指针右移
                    } else { //最后一种情况就是等于 => 找到了 符合条件的集合
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right])); // 哦直接调用Arrays中的静态方法，return new ArrayList<>(a);
                        // 去重的部分 第一行 若左右还没重合 检查右的前一个跟现在的右一不一样 一样那就左移一下
                        // 同理 若左右还没重合 检查左的后一个跟现在的右一不一样 一样那就右移一下
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        //去重后 左右中间移一下
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] testData = {-2,-1,-1,1,1,2,2};
        List<List<Integer>> result = new ArrayList<>();

        result = fourSum(testData,0);
        System.out.print(result);
    }
}
