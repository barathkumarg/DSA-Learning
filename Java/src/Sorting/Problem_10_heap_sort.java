package Sorting;
/*
Time Complexity:

Time complexity of heapify is O(N*LogN). Time complexity of createAndBuildHeap() is O(N) and overall time complexity of Heap Sort is

O(N*LogN)

Space complexity = 0(1)
* */


import java.util.Arrays;

public class Problem_10_heap_sort {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapify(int[] arr,int max_element_position,int n){
        int actualPosition = max_element_position;
        int left_position = (2 * max_element_position) + 1;
        int right_position = (2 * max_element_position) + 2;

        if(n>left_position && arr[left_position] > arr[max_element_position]) max_element_position = left_position;

        if(n>right_position && arr[right_position] > arr[max_element_position]) max_element_position = right_position;

        if(max_element_position!=actualPosition){
            swap(arr,max_element_position,actualPosition);
            heapify(arr,max_element_position,n);
        }


    }

    public static void main(String[] args) {
        int[] arr = {10,3,4,1,7,9};
        int n = arr.length;
        for(int i=n/2-1;i>=0;i--){ //call the heapify function since from the internal parent nodes.
            heapify(arr,i,n);
        }
        System.out.println(Arrays.toString(arr)); //heap sort sorted one


        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end

            swap(arr,0, i);
            System.out.print(" " + arr[i]);

            // call max heapify on the reduced heap
            heapify(arr, 0, i);
        }
    }
}
