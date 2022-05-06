import java.util.*;

public class Graph<T> implements GraphInterface<T> {

  private boolean[][] edges;
  private T[] labels;
  private boolean[] visitedBFT;

  public Graph(int n){
    
    edges = new boolean[n][n];
    labels = (T[]) new Object[n];
    visitedBFT = new boolean[n];
  }
  
  @Override
  public T getLabel(int vertex) {
      return labels[vertex];
  }

  @Override
  public boolean isEdge(int source, int target) {
      return edges[source][target];
  }

  @Override
  public void addEdge(int source, int target) {
      edges[source][target] = true; 
  }

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

  @Override
  public void removeEdge(int source, int target) {
      edges[source][target] = false;
  }

  @Override
  public void setLabel(int vertex, T newLabel) {
      labels[vertex] = newLabel;
  }

  @Override
  public int size() {
      return labels.length;
  }

  public int bftHelper(int vertex)//this helper verifies if a vertex is unvisited AND has a connection 
  {
      for(int i=0;i<edges[0].length;i++)
          if(visitedBFT[i]==false && edges[vertex][i])
            return i;
      return -1;
  }

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


   public int dftHelper(int vertex, boolean[] visited) {//this helper tries to find an unvisited neighbor and returns the first one
   
    for (int i = 0; i < edges[vertex].length; i++) {
        if (edges[vertex][i] && visited[i] == false)
            return i;
    }
    return -1;
    }

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

public void printConnections() {
    for (int i = 0; i < edges.length; i++) {
        //System.out.print(labels[j] + ": ");
        for (int j = 0; j < edges[i].length; j++) {
            if (edges[i][j])
                System.out.println("\t" + labels[i] + " -> "+ labels[j]);
        }
        System.out.println();
    }
}


}