package Hashing;

import java.util.HashMap;

/**
 Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
 k = 4
 Output: 3 4 4 3

 Explanation:
 First window is {1, 2, 1, 3}, count of distinct numbers is 3
 Second window is {2, 1, 3, 4} count of distinct numbers is 4
 Third window is {1, 3, 4, 2} count of distinct numbers is 4
 Fourth window is {3, 4, 2, 3} count of distinct numbers is 3

 ========================================  Result =====================================
 Complexity Analysis:
 Time complexity O(n). A single traversal of the array is required.
 Space Complexity O(n). Since the hashmap requires linear space.
 */
public class Problem_5_count_distinct_element_in_range {

    public static void find_distinct_count_range(int[] arr,int range){
        HashMap<Integer,Integer> hashmap = new HashMap<>();

        for(int i=0;i<range;i++){
            hashmap.put(arr[i], hashmap.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(hashmap.size());

        for(int i=range;i<arr.length;i++){

            if (hashmap.get(arr[i-range]) == 1) hashmap.remove(arr[i - range]);
            else hashmap.put(arr[i-range], hashmap.get(arr[i-range]) -1);

            hashmap.put(arr[i], hashmap.getOrDefault(arr[i], 0) + 1);
            System.out.println(hashmap.size());
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
        int range = 4;
        find_distinct_count_range(arr,range);
    }
}
