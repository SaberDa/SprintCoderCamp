package com.chasen.p21to30;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(i==0 || nums[i] != nums[i-1]){
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
