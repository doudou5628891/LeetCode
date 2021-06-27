package Hash;/*
两个数组的交集
不能像isAnagram一样 使用数组的哈希方法
因为上个题有数组限制，这一题就没有了限制

此外，HashSet 实现了Set集合    相比普通的Set HashSet引入了HashCode概念
这样可以快速的查找新增元素是否存在集合中
 */

import java.util.*;

public class intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0)
            return new int[0];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //
        for (int i:nums1) {
            set1.add(i);
        }

        for (int i: nums2) {
            if(set1.contains(i)){
                resSet.add(i);
            }
        }
        int[] resArr = new int[resSet.size()];
        int index=0;
        for (int i : resSet){
            resArr[index++]=i;
        }
        return resArr;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.print(Arrays.toString(intersection(nums1,nums2)));
    }
}
/*
那有同学可能问了，遇到哈希问题我直接都用set不就得了，用什么数组啊。
直接使用set 不仅占用空间比数组大，而且速度要比数组慢，set把数值映射到key上都要做hash计算的。
不要小瞧 这个耗时，在数据量大的情况，差距是很明显的。
*/
