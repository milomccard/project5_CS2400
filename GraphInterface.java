public interface GraphInterface<T> {

  /**
  * Accepts the number of the vertex and returns the object held in the memory location
  * @param vertex is the integer value of a specific vertex
  * @retruns T an object held in a specific memory location
  **/
  public T getLabel(int vertex);

  /**
  * Accepts two vertex position and tests to see if there exists an edge between the two
  * @param source is the beginning vertex
  * @param target is the vertex that would be arrived at 
  * @returns boolean returns a boolean to indicate whether there is an edge
  **/
  public boolean isEdge(int source, int target);
  
  /**
  * Accepts two vertecies and creates an edge in the desired implementation of the graph
  * @param source is the beginning vertex
  * @param target is the vertex that would be arrived at 
  * @returns void
  **/
  public void addEdge(int source, int target);

  /**
  * Accepts a vertex and returns an array holding all of its neighbors
  * @param vertex a vertex whose neighbors we want returned
  * @returns an array with the vertecies that neighbor the parameter vertex
  **/
  public int[] neighbors(int vertex);

  public void removeEdge(int source, int target);

  public void setLabel(int vetex, T newLabel);

  public int size();
}
