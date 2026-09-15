package Hashing;

/**

 Open chaining implementation

 Example: hashIndex = key % noOfBuckets
 Insert: Move to the bucket corresponding to the above-calculated hash index and insert the new node at the end of the list.
 Delete: To delete a node from hash table, calculate the hash index for the key, move to the bucket corresponding to
 the calculated hash index, and search the list in the current bucket to find and remove the node with the given key (if found).

 ==========================  Result  ================================
 Search : O(1+(n/m))
 Delete : O(1+(n/m))
 where n =  Total elements in hash table
 m = Size of hash table
 Here n/m is the Load Factor.
 Load Factor (∝) must be as small as possible.
 If load factor increases,then possibility of collision increases.
 Load factor is trade of space and time .
 Assume , uniform distribution of keys ,
 Expected chain length : O(∝)
 Expected time to search : O( 1 + ∝ )
 Expected time to insert/ delete :  O( 1 + ∝ )


 **/

import java.util.ArrayList;
import java.util.LinkedList;

class Hash{

    //defining the hash table with linked list
    ArrayList<LinkedList<Integer>> HashTable;
    int RANGE;

    public Hash(int range){
        this.HashTable = new ArrayList<LinkedList<Integer>>();
        this.RANGE =  range;

        //adding the linked llist
        for(int i=0;i<this.RANGE;i++){
            HashTable.add(new LinkedList<Integer>());
        }
    }

    //adding the element to the hash table
    public void add(int element){
        int hashValue = element % RANGE;
        HashTable.get(hashValue).add(element);
    }

    //Displays the hash value
    public void display(){
        for(int i=0;i<this.RANGE;i++){
            System.out.println(this.HashTable.get(i).toString());
        }
    }

    //remove the element in the hash tale
    public void remove(int element){
        int hashValue = element % this.RANGE;
        this.HashTable.get(hashValue).remove((Integer) element);

    }

}


public class Problem_1_Chanining_technique_hash {

    public static void main(String[] args) {
        Hash hash = new Hash(10);
        hash.add(12);
        hash.add(22);
        hash.add(23);
        hash.display();
        hash.remove(23);
        hash.display();
    }


}
