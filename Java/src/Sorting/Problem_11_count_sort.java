package Sorting;

import java.util.Arrays;

public class Problem_11_count_sort {

    public static int[] count_sort(int[] arr,int maxSize){

        //counting the elements in a seperate array
        int[] countArr = new int[maxSize];
        for(int i=0;i<arr.length;i++){
            countArr[arr[i]]++;
        }

        //prefix sum logic
        for(int i=1;i<countArr.length;i++){
            countArr[i] = countArr[i] + countArr[i-1];
        }
        System.out.println(Arrays.toString(countArr));

        //creating the resultant array
        int[] resultArr = new int[arr.length];

        //traverse and add the resultant values to new array
        for(int i=0;i< arr.length;i++){
            resultArr[countArr[arr[i]] - 1] = arr[i];
            countArr[arr[i]]--;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] arr = {0,4,0,1,3,6,7,7,8,11,6};
        int maxValue = 12;
        int[] result = count_sort(arr,maxValue);
        System.out.println(Arrays.toString(result));

    }
}
