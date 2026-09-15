package Graph;

/**
 Problem: Find the shortest path for unweighted graph
 Implementation: Breadth First Traversal Technique

 Time Complexity : O(V + E)
 Auxiliary Space: O(V)
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Method imported from Graph Adjanency list
import static Graph.Problem_1_Graph_adjanency_list.addEdge;

public class Problem_3_Shortest_path_unweight_graph {


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
        /*
    (1)---(0)---(7)---(6)
     |     |    / \     |
     |     |  /     \   |
    (2)   (3)---(4)---(5)
    */

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 0, 7);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);

    }

    public static int[] findShortestPath(ArrayList<ArrayList<Integer>> adj, int Vertex){
        /**
         Method the find the shortest path between source and destination
         **/
        //Initialize the visited array
        boolean[] visited = new boolean[Vertex];

        //Initialize the distance array
        int[] distance = new int[Vertex];

        //Initialize the Queue to track BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // Add the source
        visited[0] = true;

        //Iterate over the vertex till queue becomes empty
        while(!queue.isEmpty()) {
            int u_index = queue.poll();
                for (int v_index = 0; v_index < adj.get(u_index).size(); v_index++) {
                    if(!visited[adj.get(u_index).get(v_index)]) {
                        visited[adj.get(u_index).get(v_index)] = true;
                        distance[adj.get(u_index).get(v_index)] = distance[u_index] + 1;
                        queue.add(adj.get(u_index).get(v_index));
                }
            }

        }

        return distance;

    }

    public static void main(String[] args) {

        int Vertex = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(Vertex);

        //Create the vertex
        createAdjList(adj,Vertex);

        // Print the Adjancency Matrix
        printAdjList(adj);



        int[] distance = findShortestPath(adj,Vertex);
        System.out.println(Arrays.toString(distance));
    }


}
