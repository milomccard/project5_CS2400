public class Graph<T> implements Graph_Interface<T> {

    private boolean[][] edges;
    private T[] labels;

    public Graph(int n){
        edges = new boolean[n][n];
        labels = (T[]) new Object[n];
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
    
}
