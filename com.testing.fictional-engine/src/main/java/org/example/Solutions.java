package org.example;

import java.util.HashMap;

public class Solutions {
    public static void main(String[] args) {

    }

    public static int[] nestedLoopedTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

}