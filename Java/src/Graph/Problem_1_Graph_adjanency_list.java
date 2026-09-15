package Graph;
/**
 Adjacency List: Graph can also be implemented using an array of lists.
 That is every index of the array will contain a complete list.

 Time Complexity: O(n)
 Space Complexity : 0(|E| + |v|)

 while in the Matrix representation

 Time Complexity: 0(1)
 space Complexity : 0(V ^ 2) We predefined all the vertices connection values

 **/
import java.util.ArrayList;

public class Problem_1_Graph_adjanency_list {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u_index, int v_index){
        /**
         Method to add the node connection points in the vertex Matrix
         * **/
        adj.get(u_index).add(v_index);
        adj.get(v_index).add(u_index);
    }

    public static void printAdjList(ArrayList<ArrayList<Integer>> adj){
        /**
         Method to print the adjacency list in the vertex matrix
         **/
        for(int u_index = 0; u_index < adj.size(); u_index++){
            System.out.println("Adjacency list for node "+ u_index);
            for(int v_index = 0; v_index < adj.get(u_index).size(); v_index++){
                System.out.print("-> "+ adj.get(u_index).get(v_index));
            }
            System.out.println();
        }
    }

    public static void createAdjList(ArrayList<ArrayList<Integer>> adj, int Vertex){
        /**
         Helper function which creates the adjacency list for the problem
         **/
        // Adding the sub list, to create matrix
        for (int index = 0; index < Vertex; index++){
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,0,1);
        addEdge(adj,0,4);
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,1,4);
        addEdge(adj,2,3);
        addEdge(adj,3,4);

    }

    public static void main(String[] args) {
        /**
         Main function execution
         * */
        // Creating the 5 Vertex
        int Vertex = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(Vertex);

        createAdjList(adj, Vertex);
        // printing the adjancency list
        printAdjList(adj);

    }





}
