public class Driver {
    public static void main(String args[]){

    }

    public static QueueInterface<T> breadthFirst(T origin){
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<T>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();

        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexQueue.enqueue(originVertex);

        while (neighbors.hasNext()){
            VetexInterface<T> frontVertex = vertexQueue.dequeue();

            Iterator<VertexInterface<T>> neighbors =
                                            frontVertex.getNeighborIterator();
            
            while (neighbors.hasNext()){
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited()){
                    nextNeighbor.visit():
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                }
            }
        }
        return traversalOrder;
        }

    public static T depthFirst(){

    }
}
