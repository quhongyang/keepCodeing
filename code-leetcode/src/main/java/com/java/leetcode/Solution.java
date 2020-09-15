package com.java.leetcode;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.heightChecker(new int[]{1,1,4,4,3,2,1});
    }
    public int heightChecker(int[] heights) {
        int [] arr = new int[101];//申请101个空间，因为1 <= heights[i] <= 100，所以需要的桶可能从1到100
        int sum=0;
        for(int height:heights){
            arr[height]++;
        }
        for(int i=1,j=0;i<arr.length;i++){
            while(arr[i]-->0){//从小位置开始检查当前位置对应的值是否是正确的，如arr[1]=3,也就代表第1个位置，第二个位置，第三个位置都应该是1，
                if(heights[j++]!=i){//开始判断对应的位置上对应的值是否正确，如arr[1]=3，数组heights [0]下标开始存储，因为有三个1（1是最小的）判断第一个位置heights[0]、第二个位置heights[1]、第三个位置heights[2]是否等于1，否sum++
                    sum++;
                }
            }

        }
        return sum;
    }
}
