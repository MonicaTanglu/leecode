/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 *
 *
 * 键值对字典直接取值省时间
 * **/
/*******别人的优解**********/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> maps = new HashMap();
        int[] data = new int[2];
        for(int i=0,l=nums.length;i<l;i++) {
            int diff = target - nums[i];
            if(maps.containsKey(diff)) {
                data[0] = maps.get(diff);
                data[1] = i;
                break;
            }
            maps.put(nums[i],i);
        }
        return data;
    }
}
/**************我的解法（暴力解法。。。）***************/