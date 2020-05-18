package com.chasen.Sword;

public class Find {
    public static boolean Find(int target, int [][] array) {
        // 1. set the top right item
        int col = array[0].length -1;
        int row = 0;
        while (true){
            // 2. judge the index
            if(row >= array[0].length || col < 0)
                return false;
            // 3. get current value of array[row][col]
            int current = array[row][col];
            if(current == target)
                return true;
            else {
                if(current > target)
                    col--;
                if(current < target)
                    row++;
            }
        }
    }

    public static void main(String[] args) {
        int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(1,array));
    }
}
