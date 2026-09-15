package Arrays_;
import java.util.*;

/*
* Given an array of size N. The task is to rotate array by D elements where D ≤ N.
*
* Time complexity = 0(n)
* Space complexity = 0(1)
* */


public class Problem_1_Rotate_Array {

    public static void reverse(int start, int end, int[] arr){
        while(start < end){
            int temp = arr[end];
            arr[end--] = arr[start];
            arr[start++] = temp;
        }
    }

    public static void main(String args[]) {

        int[] arr ={1,2,3,4,5,6};
        int d = 2;
        int n = arr.length;
        reverse(0,d-1,arr);
        reverse(d,n-1,arr);
        reverse(0,n-1,arr);

        Arrays.stream(arr).forEach(System.out::println);

    }


}
