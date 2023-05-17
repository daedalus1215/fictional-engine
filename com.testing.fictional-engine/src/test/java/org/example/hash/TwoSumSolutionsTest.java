package org.example.hash;

import org.example.hash.TwoSumSolutions;
import org.junit.Assert;
import org.junit.Test;

public class TwoSumSolutionsTest {

    @Test
    void twoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        Assert.assertEquals(new int[]{3, 1}, TwoSumSolutions.twoSum(nums, target));
    }
}