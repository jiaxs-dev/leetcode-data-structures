package com.leetcode.data.structures.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description
 * @author jiaxiansun
 * @createTime 2021/9/8 14:41
 * @version 1.0
 */
public class ArrayQuestion {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{11, 3, 24}));
    }

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     *
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     *
     */
    public static boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
     * 并且 i 和 j 的差的 绝对值 至多为 k。
     * 示例 1:
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


}
