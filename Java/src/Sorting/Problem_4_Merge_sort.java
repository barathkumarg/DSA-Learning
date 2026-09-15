package Sorting;

/*
Time Complexity: Sorting arrays on different machines. Merge Sort is a recursive algorithm and time complexity can be expressed as following recurrence relation.
T(n) = 2T(n/2) + Θ(n)
The above recurrence can be solved either using Recurrence Tree method or Master method. It falls in case II of Master Method and solution of the recurrence is Θ(nLogn).

Time complexity of Merge Sort is Θ(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array in two halves and take linear time to merge two halves.

Auxiliary Space: O(n)

*
* */


import java.util.Arrays;

public class Problem_4_Merge_sort {

    public static void Merge(int[] arr,int left,int mid,int right){

        //creating the seperate arrays
        int left_array_limit = (mid - left) + 1;
        int right_array_limit = (right - mid);

            //left array
            int[] left_array = new int[left_array_limit];
            for(int i=0;i<left_array_limit;i++){
                left_array[i] = arr[left + i];
            }

            //right array
            int[] right_array = new int[right_array_limit];
            for(int i=0;i<right_array_limit;i++){
                right_array[i] = arr[mid+1+i];
            }

        //Merge action
        int i=0; int j=0; int count=left;
        while (i<left_array_limit && j<right_array_limit){
            if(left_array[i]<right_array[j]){
                arr[count++] = left_array[i++];
            }
            else{
                arr[count++]  = right_array[j++];
            }
        }
        while(i<left_array_limit){
            arr[count++] = left_array[i++];
        }
        while(j<right_array_limit){
            arr[count++]  = right_array[j++];

        }


    }

    public static void MergeSort(int []arr,int left,int right){
        if (right>left){
            int mid = left + (right - left) / 2;
            MergeSort(arr,left,mid);
            MergeSort(arr,mid+1,right);
            Merge(arr,left,mid,right);
        }
    }


    public static void main(String[] args) {
        int[] arr = {20,25,19,6,3,1,0};
        MergeSort(arr,0,6);
        System.out.println(Arrays.toString(arr));
    }



}
