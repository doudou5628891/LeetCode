package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class binary_search {
    public static int binary_search(int[] nums, int target) {
        int head = 0;
        int tail = nums.length-1;
        int mid = (head+tail)/2;
        if (nums.length==1&&target==nums[0]){
            return 0;
        }
        for (int i=0;i<nums.length/2;i++){
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[tail]==target){
                return tail;
            }
            else if(nums[head]==target){
                return head;
            }
            else if(tail == head){
                return -1;
            }
            else if(nums[mid]>target){
                tail = mid;
                mid = (head+tail)/2;
            }
            else {
                head = mid;
                mid = (head+tail)/2;
            }
        }
        return -1;
    }
    /*
    >>1 替代 /2
    左闭右闭区间
     */
    public static int binary_search_official(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] testData = {2,5};
        int result = binary_search_official(testData, 5);
        System.out.print(result);
    }
    //关于程序的内存消耗 依旧没有概念
}
