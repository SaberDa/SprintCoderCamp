package com.chasen.p11to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int x = 0; x < len-2; x++){
            if(nums[x] > 0)
                break;
            if(x == 0 || nums[x] != nums[x-1]){
                int fix = 0 - nums[x];
                int low = x+1;
                int high = len -1;
                while (low < high){
                    int twosum = nums[low] + nums[high];
                    if(twosum < fix)
                        low += 1;
                    if(twosum > fix)
                        high -= 1;
                    if(twosum == fix){
                        List<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(nums[x]);
                        triplet.add(nums[low]);
                        triplet.add(nums[high]);
                        ans.add(triplet);
                        // remove duplicate item
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++; high--;
                    }
                }
            }
        }
        return ans;
    }
    public static List<List<Integer>> threeSum_1(int[] nums) {
        List<int[]> numsList = Arrays.asList(nums);
        List<List<Integer>> threeSum = new ArrayList<List<Integer>>();
        for (int x = 0; x < nums.length; x++) {
            int a = nums[x];
            for (int y = 0; y < nums.length; y++) {
                if (y != x) {
                    int b = nums[y];
                    int c = -(a + b);
                    int z = 0;
                    if(numsList.contains(c)) {
                        z = numsList.indexOf(c);
                        System.out.println(z);
                        if (z != x && z != y) {
                            List<Integer> triplet = new ArrayList<Integer>();
                            triplet.add(nums[x]);
                            triplet.add(nums[y]);
                            triplet.add(nums[z]);
                            threeSum.add(triplet);
                        }
                    }
                }
            }
        }
        return threeSum;
    }



    public static void main(String[] args) {
        int [] nums = {0,0,0,0};
        System.out.println(threeSum(nums));
    }
}
