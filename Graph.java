import java.io.*; 
import java.util.*; 
import java.util.Scanner;
import java.util.LinkedList;
// This class represents a directed graph using adjacency list representation 
class Graph{ 

    private int V;   // No. of vertices 

    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
    // Constructor 
    @SuppressWarnings("unchecked") 
	
    Graph(int v){ 
        V = v; 
        adj = new LinkedList[v]; //creation of linked list
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
	
    //Function to add an edge into the graph 
    void addEdge(int v, int w){ 
        adj[v].add(w);  // Add w to v's list. 
    }
	
    // A function used by DFS 
    void DFSUtil(int v,boolean visited[]){ 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()){ 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
	
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v){ 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    } 
	
	
    public static void main(String args[]) { 
	Scanner input = new Scanner(System.in);
        int numberOfEdges = input.nextInt();
		int ve = input.nextInt();
		Graph g = new Graph(ve); 
		for (int i = 0; i < numberOfEdges; i++) {
			int left = input.nextInt();
			int right = input.nextInt();
        g.addEdge(left,right); 
        }
        System.out.println("Following is Depth First Traversal "+ "(starting from vertex 0)"); 
  
        g.DFS(0); 
    } 
} 