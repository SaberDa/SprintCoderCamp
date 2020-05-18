package com.chasen.p11to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int x = 0; x < len-2; x++){
            if(x == 0 || nums[x] != nums[x-1]){
                int low = x+1;
                int high = len -1;
                while (low < high){
                    int threesum = nums[low] + nums[high] + nums[x];
                    if(threesum < target){
                        low += 1;
                    }
                    if(threesum > target){
                        high -= 1;
                    }
                    if(threesum == target){
                        List<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(nums[x]);
                        triplet.add(nums[low]);
                        triplet.add(nums[high]);
                        ans.add(triplet);
                        // remove duplicated item
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++; high--;
                    }
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length -3; i++){
            if(i ==0 || nums[i] != nums[i-1]){
                int fixItem = nums[i];
                int [] ary = new int[nums.length-i-1];
                for(int j=0,k=i+1;j<ary.length;j++){
                    ary[j] = nums[k++];
                }
                int threeTarget = target - fixItem;
                List<List<Integer>> ans = threeSum(ary,threeTarget);
                if(ans.size() != 0){
                    for (List<Integer> item:ans) {
                        item.add(nums[i]);
                        res.add(item);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {-1,-5,-5,-3,2,5,0,4};
        System.out.println(fourSum(nums,0));
    }
}
