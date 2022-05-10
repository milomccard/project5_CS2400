import java.util.*;

public class Graph<T> implements GraphInterface<T> {

  private boolean[][] edges;//adjacency matrix
  private T[] labels;//label array
  private boolean[] visitedBFT;//array of visited indicies, used for BFT

  /**
   * Constructor
   * @param n the number of vertices
   */
  public Graph(int n){
    
    edges = new boolean[n][n];
    labels = (T[]) new Object[n];
    visitedBFT = new boolean[n];
  }
  
  /**
  * Accepts the number of the vertex and returns the object held in the memory location
  * @param vertex is the integer value of a specific vertex
  * @retruns T an object held in a specific memory location
  **/
  @Override
  public T getLabel(int vertex) {
      return labels[vertex];
  }

  /**
  * Accepts two vertex position and tests to see if there exists an edge between the two
  * @param source is the beginning vertex
  * @param target is the vertex that would be arrived at 
  * @returns boolean returns a boolean to indicate whether there is an edge
  **/
  @Override
  public boolean isEdge(int source, int target) {
      return edges[source][target];
  }

  /**
  * Accepts two vertecies and creates an edge in the desired implementation of the graph
  * @param source is the beginning vertex
  * @param target is the vertex that would be arrived at 
  * @returns void
  **/
  @Override
  public void addEdge(int source, int target) {
      edges[source][target] = true; 
  }

  /**
  * Accepts a vertex and returns an array holding all of its neighbors
  * @param vertex a vertex whose neighbors we want returned
  * @returns an array with the vertecies that neighbor the parameter vertex
  **/
  @Override
  public int[] neighbors(int vertex) {
      int i;
      int count = 0;
      int[] answer;

      for (i = 0; i < labels.length; i++){
          if (edges[vertex][i])
              count++;
      }
      answer = new int[count];
      count = 0;
      for (i = 0; i < labels.length; i++){
          if(edges[vertex][i])
              answer[count++] = i;
      }

      return answer;
  }

  /**
  * Accepts two verticies and removes the edge between them
  * @param source a vertex to start at
  * @param target a vertex to end at
  **/
  @Override
  public void removeEdge(int source, int target) {
      edges[source][target] = false;
  }

  /**
  * Accepts a vertex and an object to assign to it
  * @param vertex a vertex in the graph
  * @param newLabel an object to be stored in vertex
  **/
  @Override
  public void setLabel(int vertex, T newLabel) {
      labels[vertex] = newLabel;
  }

  /**
   * Returns the number of vertices
   * @return the number of vertices
   */
  @Override
  public int size() {
      return labels.length;
  }

  /**
   * Returns the first index of a vertice that is both 
   * "unvisited" and an edge of the input.  Used for BFT.
   * @param vertex the vertex from which the returned vertice has an edge
   * @return an unvisited vertice if found, otherwise -1
   */
  public int bftHelper(int vertex)//this helper verifies if a vertex is unvisited AND has a connection 
  {
      for(int i=0;i<edges[0].length;i++)
          if(visitedBFT[i]==false && edges[vertex][i])
            return i;
      return -1;
  }

  /**
   * Accepts a label of a vertex and prints the
   * BFT order starting from that vertex
   * @param origin the label of the vertex to start from
   */
  public void breadthFirstTraversal(T origin) 
   {
       int startIndex = Arrays.asList(labels).indexOf(origin);//gets index of "origin"
       Queue<Integer> queue = new LinkedList<>(); //creates a queue
       int nextIndex; //an index counter
       Arrays.fill(visitedBFT, false);//reset visited array to all "false"

       System.out.println("Breadth First Traversal - starting from vertex \"" + labels[startIndex] + "\":");
       visitedBFT[startIndex]=true;//starting from index of "origin"
       System.out.print(labels[startIndex]);//print "origin"
       queue.add(startIndex);//add visited index to queue
       
       while(!queue.isEmpty())
       {
           int currIndex=queue.poll();//pop head of queue
           while((nextIndex = bftHelper(currIndex))!=-1)//while the next index is "unvisited"
           {
               visitedBFT[nextIndex]=true;//mark visited index as true in visited array
               System.out.print(" " + labels[nextIndex]);//print out the visited label
               queue.add(nextIndex);//add the next index to queue
           }
       }

       System.out.println();
   }


   /**
    * Accepts the index of a vertex and an array tracking "visited" vertices
    * Returns the first index of a connected, unvisited neighbor
    * @param vertex the vertex from which to search for a neighbor
    * @param visited the array tracking "visited" vertices
    * @return the first index of an "unvisited" neighbor if found, otherwise -1
    */
    public int dftHelper(int vertex, boolean[] visited) {//this helper tries to find an unvisited neighbor and returns the first one
   
    for (int i = 0; i < edges[vertex].length; i++) {
        if (edges[vertex][i] && visited[i] == false)
            return i;
    }
    return -1;
    }



    /**
    * Accepts a label of a vertex and prints the
    * DFT order starting from that vertex
    * @param origin the label of the vertex to start from
    */
    public void depthFirstTraversal(T origin) {
    
    int startIndex = Arrays.asList(labels).indexOf(origin);//finds index of "origin"
    int n = edges.length;
    boolean visitedDFT[] = new boolean[n];//create visited array to track visited vertices
    System.out.println("Depth First Traversal - starting from vertex \"" + labels[startIndex] + "\":");

    Arrays.fill(visitedDFT, false);//reset visited array to all "false"
   
    Stack<Integer> stack = new Stack();//create a stack
   
    visitedDFT[startIndex]= true;//set starting index as "visited"
    System.out.print(labels[startIndex]);//print label of starting index
    stack.push(startIndex);//push it to stack

    while (!stack.isEmpty()) {
        int neighbor = dftHelper(stack.peek(),visitedDFT);//try to find an adjacent vertex
        if (neighbor == -1) {//can't find unvisited neighbor, pop stack
            stack.pop();
        } else {//found unvisited neighbor
            visitedDFT[neighbor] = true;//set index of neighbor to "visited"
            System.out.print(" "+ labels[neighbor]);//print it
            stack.push(neighbor);//push to stack
        }
    }

    System.out.println();
}

/**
 * Prints the adjacency matrix as a list of
 * vertices and their connections
 */
public void printConnections() {
    for (int i = 0; i < edges.length; i++) {
        for (int j = 0; j < edges[i].length; j++) {
            if (edges[i][j])
                System.out.println("\t" + labels[i] + " -> "+ labels[j]);
        }
        System.out.println();
    }
}

}
