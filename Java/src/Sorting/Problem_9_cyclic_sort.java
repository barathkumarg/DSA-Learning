package Sorting;

/*
Time Complexity Analysis:

Worst Case: O(n2)
Average Case: O(n2)
Best Case: O(n2)
Auxiliary Space: O(1)
*/
import java.util.Arrays;

public class Problem_9_cyclic_sort {



    public static void cyclic_sort(int[] arr,int n){

        for(int cyclic_sort=0;cyclic_sort < n-1;cyclic_sort++){ //traverse from 0 to n

            int position = 0;
            int item = arr[cyclic_sort];

            //logic to find the element's correct position
            for(int i=0;i<n;i++){
                if(item > arr[i]) position++;
            }

            //continue if the element present in its original place
            if(position == cyclic_sort) continue;

            //swap logic
            int temp = item;
            item = arr[position];
            arr[position] = temp;


            //solving the cyclic remaining order
            while(cyclic_sort!=position){
                position = cyclic_sort;  //reassign to find the elements

                for(int i=cyclic_sort+1;i<=n;i++){
                    if(item > arr[i]) position++;
                }

                //swap logic
                temp = item;
                item = arr[position];
                arr[position] = temp;

            }

        }

    }

    public static void main(String[] args) {
        int[] arr = {5,1,4,3,3,0,3,5};
        cyclic_sort(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
