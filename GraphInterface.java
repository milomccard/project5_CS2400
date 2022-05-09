public interface GraphInterface<T> {

  /**
  * Accepts the number of the vertex and returns the object held in the memory location
  * @param vertex is the integer value of a specific vertex
  * @retruns T an object held in a specific memory location
  **/
  public T getLabel(int vertex);

  public boolean isEdge(int source, int target);
  
  public void addEdge(int source, int target);

  public int[] neighbors(int vertex);

  public void removeEdge(int source, int target);

  public void setLabel(int vetex, T newLabel);

  public int size();
}
