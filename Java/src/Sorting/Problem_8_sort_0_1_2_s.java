package Sorting;

import java.util.Arrays;

/**
 Given an array of 0s, 1s, and 2s. Arrange the array elements such that all 0s come first, followed by all the 1s and then, all the 2s.

 Note: Do not use the inbuilt sort function.


 Example 1:

 Input: N = 5, arr[] = {0, 2, 1, 2, 0}
 Output: 0 0 1 2 2

 Time complexity : O(n)
 Space complexity: O(1)
 */



public class Problem_8_sort_0_1_2_s {
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void segragate012(int arr[], int N){
        // Your Code Here
        int start = 0;
        int mid = 0;
        int end = N-1;

        while(mid<=end){

            if(arr[mid]==0){
                swap(arr,start,mid);
                start++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr,mid,end);
                end--;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {2,2,0,0,1,1};
        segragate012(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
