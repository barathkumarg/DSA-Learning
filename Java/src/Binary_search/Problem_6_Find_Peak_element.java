package Binary_search;

/*

Given an 0-indexed array of integers arr[] of size n, find its peak element. An element is considered to be peak if it's value is greater than or equal to the values of its adjacent elements (if they exist). The array is guaranteed to be in ascending order before the peak element and in descending order after it.

Note: The output will be 1 if the index returned by your function is correct; otherwise, it will be 0.

Example 1:

Input:
n = 3
arr[] = {1, 2, 3}
Peak Element's Index: 2
Output: 1
Explanation:
If the index returned is 2, then the output printed will be 1.
Since arr[2] = 3 is greater than its adjacent elements, and
there is no element after it, we can consider it as a peak
element. No other index satisfies the same property.

<==========================   result    ====================================>
Time complexity : 0(n)
*
* */
public class Problem_6_Find_Peak_element {

    public static int peakElement(int[] arr,int n)
    {

        int left = 0;
        int right = n-1;

        while(right>=left){

            int mid = (left + right) / 2;

            if((mid==0 || arr[mid -1] <= arr[mid]) &&
                    (mid==n-1||arr[mid+1] <= arr[mid])){
                return mid;
            }

            else if(mid>0 && arr[mid] <= arr[mid - 1]){
                right = mid - 1;
            }
            else{
                left = mid +1;
            }

        }
        return -1;


    }

    public static void main(String[] args) {
        int[] arr ={1,2,1,3,4};
        System.out.println(peakElement(arr, arr.length));
    }

}
