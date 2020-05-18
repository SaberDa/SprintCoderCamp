package com.chasen.p11to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int abs = Integer.MAX_VALUE;
        int ans = 0;
        for(int x = 0; x < len-2; x++){
            if(x == 0 || nums[x] != nums[x-1]){
                int fix = target - nums[x];
                int low = x+1;
                int high = len -1;
                while (low < high){
                    int twosum = nums[low] + nums[high];
                    if(Math.abs(twosum - fix) < abs) {
                        abs = Math.abs(twosum - fix);
                        ans = twosum + nums[x];
                    }
                    if(twosum < fix)
                        low += 1;
                    if(twosum > fix)
                        high -= 1;
                    if(twosum == fix){
                        return target;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {-1, 2, 1, -4};
        int ans = threeSumClosest(nums,1);
        System.out.println(ans);
    }
}
