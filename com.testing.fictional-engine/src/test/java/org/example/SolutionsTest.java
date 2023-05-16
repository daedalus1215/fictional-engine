package org.example;

import org.junit.Assert;
import org.junit.Test;

public class SolutionsTest {

    @Test
    void twoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        Assert.assertEquals(new int[]{3, 1}, Solutions.twoSum(nums, target));
    }
}