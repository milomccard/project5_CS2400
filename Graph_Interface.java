/**
 * Graph_Interface
 */
public interface Graph_Interface<T> {

    public T getLabel(int vertex);

    public boolean isEdge(int source, int target);

    public void addEdge(int source, int target);

    public int[] neighbors(int vertex);

    public void removeEdge(int source, int target);

    public void setLabel(int vetex, T newLabel);

    public int size();
}