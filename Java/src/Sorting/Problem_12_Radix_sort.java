package Sorting;

import java.util.Arrays;

public class Problem_12_Radix_sort {

    public static int[] count_sort(int[] arr,int maxSize,int exponent){

        //counting the elements in a seperate array
        int[] countArr = new int[maxSize];
        for(int i=0;i<arr.length;i++){
            countArr[(arr[i]/exponent)%10]++;
        }

        //prefix sum logic
        for(int i=1;i<countArr.length;i++){
            countArr[i] = countArr[i] + countArr[i-1];
        }
        //System.out.println(Arrays.toString(countArr));

        //creating the resultant array
        int[] resultArr = new int[arr.length];

        //traverse and add the resultant values to new array
        for(int i=arr.length - 1;i>= 0;i--){
            resultArr[countArr[(arr[i]/exponent)%10]-1]= arr[i];
            countArr[(arr[i]/exponent)%10]--;
        }
        return resultArr;
    }


    public static void main(String[] args) {
        int[] arr={113,456,134,123,119,945};
        int max_value = 945;
        for(int exponent=1;max_value/exponent > 0;exponent*=10){
             arr = count_sort(arr,10,exponent);
            System.out.println(Arrays.toString(arr));

        }
        System.out.println(Arrays.toString(arr));
    }
}
