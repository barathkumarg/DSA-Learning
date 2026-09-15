package Hashing;

/**
 Linear probing is a collision-handling technique in hashing. Linear probing says that whenever a collision occurs, search for the immediate next position.

 Given an array of integers and a hash table size. Fill the array elements into a hash table using Linear Probing to handle collisions. Duplicate elements must
 be mapped to the same position in the hash table while colliding elements must be mapped to the [(value+1)%hashSize] position.

 Input:
 hashSize = 10
 sizeOfArray = 4
 Array[] = {4,14,24,44}
 Output:
 -1 -1 -1 -1 4 14 24 44 -1 -1

 =====================  Result =========================
 Expected Time Complexity: O(N)
 Expected Auxiliary Space: O(N)

 **/


import java.util.Arrays;

public class Problem_2_Open_addressing_linear {


    public static int[] linearProbing(int hash_size, int arr[], int sizeOfArray) {
        int[] hashTable = new int[hash_size];
        for (int i = 0; i < hash_size; i++) {
            hashTable[i] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int hashValue = element % hash_size;
            int count = 0;
            while (hashTable[hashValue] != -1 && count < hash_size) {
                //handling the duplicate cases, break the loop if already the element present in it
                if(hashTable[hashValue] == element) break;

                //increment the hashValue
                hashValue = (hashValue + 1) % hash_size;
                count++;
            }

            if (count < hash_size) {
                hashTable[hashValue] = element;
            }
            // If count equals hash_size, there's no space left in the hash table for this element.
            // You can choose to handle such cases differently, e.g., by resizing the hash table.
            // For simplicity, we ignore such cases here.
        }

        return hashTable;
    }

    public static void main(String[] args) {
        int[] arr = {4,14,24,44};
        System.out.println(Arrays.toString(linearProbing(10,arr,arr.length)));
    }
}
