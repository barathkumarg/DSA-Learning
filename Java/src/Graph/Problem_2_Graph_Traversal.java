package Graph;

/**
 Graph Traversal with the Adjacency list implementation
 Time and Space complexity: 0(V + E)

 * */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import static Graph.Problem_1_Graph_adjanency_list.createAdjList;
import static Graph.Problem_1_Graph_adjanency_list.printAdjList;

public class Problem_2_Graph_Traversal {


    public static void graphBFS(ArrayList<ArrayList<Integer>> adj){
        /**
         Breadth First search implementation
         * **/

        // Considering the Vertex as the index starts from 0
        // Creating the Visited Node or vertex array
        boolean[] visitedVertex = new boolean[adj.size()];

        //Creating the Queue to traverse
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0); //marks the first node to be inserted

        //iterated in the queue till empty, add its adjacency list elements
        while(!queue.isEmpty()){
            int element = queue.poll();

            // Do the addition if the element not visited
            if(!visitedVertex[element]){
                System.out.print(element +" -> ");
                visitedVertex[element] = true;
                //add the adjacency list to the queue
                for (int index_u=0; index_u<adj.get(element).size(); index_u++){
                    queue.add(adj.get(element).get(index_u));
                }

            }

        }
    }

    public static void graphDFS(ArrayList<ArrayList<Integer>> adj, boolean[] visitedVertex, int vertex){
        /**
         Depth First Traversal implementation, using the recursion technique
         **/
        visitedVertex[vertex] = true; // mark and print the vertex
        System.out.print(vertex + " -> ");

        //Use the iterator
        Iterator<Integer> edges = adj.get(vertex).iterator();
        while(edges.hasNext()){
            // iterate
            int edge = edges.next();
            if(!visitedVertex[edge])
                graphDFS(adj,visitedVertex,edge); //recursive call to find its depth
        }

    }

    public static void main(String[] args) {

        // Creating the 5 Vertex
        int Vertex = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(Vertex);
        createAdjList(adj, Vertex); // call from the Graph_adjanency class
        printAdjList(adj);
        System.out.println("-----------------------------------");
        System.out.println("Breadth First Traversal");
        graphBFS(adj);
        System.out.println();

        //Depth first search, pass the visited node list prior (since recursion used)
        boolean[] visitedVertex = new boolean[adj.size()];
        int vertex = 0;
        System.out.println("Depth First Traversal");
        graphDFS(adj, visitedVertex, vertex);


    }


}
