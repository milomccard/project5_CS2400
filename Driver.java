import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]){
        Graph<String> g1 = createGraph();//creates graph based on project guidelines
        runMenu(g1);//executes program which performs BFT and DFT
    }

    /**
     * Creates the graph based on project parameters
     * @return the created graph
     */
    static Graph<String> createGraph(){
        Graph<String> g = new Graph<>(9);

        g.setLabel(0, "A");
        g.setLabel(1, "D");
        g.setLabel(2, "G");
        g.setLabel(3, "B");
        g.setLabel(4, "E");
        g.setLabel(5, "H");
        g.setLabel(6, "C");
        g.setLabel(7, "F");
        g.setLabel(8, "I");

        //add Edges for "A"
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 4);

        //add Edges for "D"
        g.addEdge(1, 2);

        //add Edges for "G"
        g.addEdge(2, 5);

        //add Edges for "B"
        g.addEdge(3, 4);

        //add Edges for "E"
        g.addEdge(4, 5);
        g.addEdge(4, 7);

        //add Edges for "H"
        g.addEdge(5, 8);

        //add Edges for "C"
        g.addEdge(6, 3);

        //add Edges for "F"
        g.addEdge(7, 5);
        g.addEdge(7, 6);

        //add Edges for "I"
        g.addEdge(8, 7);

        return g;
    }

    /**
     * Wrapper for program, menu, BFT and DFT traversals
     */
    static void runMenu(Graph<String> g1){
        String[] vertices = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};//keeps track of labels in graph

        Scanner user = new Scanner(System.in);

        System.out.println("\n\n****** Graph Traversal: Directed Graphs ******");
        System.out.println("\nTraversing the following graph\nwith verticies and adjacencies:\n");
        g1.printConnections();//print adjancecy matrix as vertices and connections
        
        System.out.println("====== Breadth First Traversal ======\n");
        
        int vertex = -1;
        do{
            System.out.print("\nEnter starting vertex, or any non-existing vertex to exit: ");
            String userInput = user.nextLine().toUpperCase();//user enters a vertex 
            vertex = isVertex(userInput, vertices);//checks if vertex is in graph
            if(vertex > -1)//if vertex is in graph, perform BFT from that vertex
                g1.breadthFirstTraversal(userInput);
        }while(vertex > -1);//otherwise, continue

        System.out.println("\n\n\n====== Depth First Traversal ======\n");

        do{
            System.out.print("\nEnter starting vertex, or any non-existing vertex to exit: ");
            String userInput = user.nextLine().toUpperCase();//user enters vertex
            vertex = isVertex(userInput, vertices);//check if vertex is in graph
            if(vertex > -1)//if vertex is in graph, perform DFT
                g1.depthFirstTraversal(userInput);
        }while(vertex > -1);//otherwise, continue


        System.out.println("\nProgram Concluded.");
        user.close();
    }

    static int isVertex(String scan, String[] vertices){
        return Arrays.asList(vertices).indexOf(scan);
    }

    
}
