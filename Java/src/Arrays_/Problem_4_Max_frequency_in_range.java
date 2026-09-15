package Arrays_;


import java.util.Arrays;

public class Problem_4_Max_frequency_in_range {

    //Function to find the length of longest subarray of even and odd numbers.
    public static int maxEvenOdd(int arr[], int n)
    {
        int current = 1;
        int result = 0;


        for(int i=1;i<n;i++){

            if(arr[i] % 2 != arr[i-1] % 2){
                current++;
            }
            else{

                result = Math.max(result,current);
                current = 1;

            }



        }
        return result;
    }

    public static void main(String[] args) {
        int L[] = {10,12,14,7,8};
        int R[] = {15,8,5,4};
        System.out.println(maxEvenOdd(L,4));
    }





}
