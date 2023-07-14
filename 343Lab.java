// C343 Fall 2021
//
// a simple implementation for graphs with adjacency lists

// Lab 10 starter file

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class AdjGraph implements Graph {

    // is it a directed graph (true or false) :
    private boolean digraph;

    private int totalNodes;
    // all the nodes in the graph:
    private Vector<String> nodeList;

    private int totalEdges;
    // all the adjacency lists, one for each node in the graph:
    private Vector<LinkedList<Integer>> adjList;

    // all the weights of the edges, one for each node in the graph:
    private Vector<LinkedList<Integer>> adjWeight;

    // every visited node:
    private Vector<Boolean> visited;

    // list of nodes pre-visit:
    private Vector<Integer> nodeEnum;

    public AdjGraph() {
        init();
    }

    public AdjGraph(boolean ifdigraph) {
        init();
        digraph = ifdigraph;
    }

    public void init() {
        nodeList = new Vector<String>();
        adjList = new Vector<LinkedList<Integer>>();
        adjWeight = new Vector<LinkedList<Integer>>();
        visited = new Vector<Boolean>();
        nodeEnum = new Vector<Integer>();
        totalNodes = totalEdges = 0;
        digraph = false;
    }

    // set vertices:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            adjWeight.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes++;
        }
    }

    // add a vertex:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
        adjWeight.add(new LinkedList<Integer>());
        totalNodes++;
    }

    public int getNode(String node) {
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.elementAt(i).equals(node)) return i;
        }
        return -1;
    }

    // return the number of vertices:
    public int length() {
        return nodeList.size();
    }

    // add edge from v1 to v2:
    public void setEdge(int v1, int v2, int weight) {
        LinkedList<Integer> tmp = adjList.elementAt(v1);
        if (adjList.elementAt(v1).contains(v2) == false) {
            tmp.add(v2);
            adjList.set(v1, tmp);
            totalEdges++;
            LinkedList<Integer> tmp2 = adjWeight.elementAt(v1);
            tmp2.add(weight);
            adjWeight.set(v1, tmp2);
        }
    }

    public void setEdge(String v1, String v2, int weight) {
        if ((getNode(v1) != -1) && (getNode(v2) != -1)) {
            // add edge from v1 to v2:
            setEdge(getNode(v1), getNode(v2), weight);
            // for undirected graphs, add edge from v2 to v1 as well:
            if (digraph == false) {
                setEdge(getNode(v2), getNode(v1), weight);
            }
        }
    }

    // keep track whether a vertex has been visited or not,
    //    for graph traversal purposes:
    public void setVisited(int v) {
        visited.set(v, true);
        nodeEnum.add(v);
    }

    public boolean ifVisited(int v) {
        return visited.get(v);
    }


    public LinkedList<Integer> getNeighbors(int v) {
        return adjList.get(v);
    }

    public int getWeight(int v, int u) {
        LinkedList<Integer> tmp = getNeighbors(v);
        LinkedList<Integer> weight = adjWeight.get(v);
        if (tmp.contains(u)) {
            return weight.get(tmp.indexOf(u));
        } else {
            return Integer.MAX_VALUE;
        }
    }


    // clean up before traversing the graph:
    public void clearWalk() {
        nodeEnum.clear();
        for (int i = 0; i < nodeList.size(); i++)
            visited.set(i, false);
    }

    public void walk(String method) {
        clearWalk();
        // traverse the graph:
        for (int i = 0; i < nodeList.size(); i++) {
            if (ifVisited(i) == false) {
                if (method.equals("BFS")) {
                    BFS(i);      // i is the start node
                } else if (method.equals("DFS")) {
                    DFS(i); // i is the start node
                } else {
                    System.out.println("unrecognized traversal order: " + method);
                    System.exit(0);
                }
            }
        }
        System.out.println(method + ":");
        displayEnum();
    }

    // Lab 10 TODO:
    //
    // write your method topologicalSortWithQueue() here.
    //

    public void topologicalSortWithQueue(AdjGraph G) {
        Queue<Integer> Q = new LinkedList<Integer>();
        LinkedList<Integer> L = new LinkedList<Integer>();

        int[] NodeCount = new int[totalNodes];
        int x;
        for (x = 0; x < totalNodes; x++) {
            NodeCount[x] = 0; } // Initialize
        for (x = 0; x < totalNodes; x++) {
            for( int i: this.getNeighbors(x))// Process every edge
                NodeCount[i]++;            // Add to v's prereq count

        }
        for (x=0; x<totalNodes; x++) {   // Initialize Queue
            if (NodeCount[x] == 0) {              // V has no prerequisites
                Q.add(x);
            }
        }
        while (Q.size() > 0) {          // Process the vertices
            x= (Integer)Q.remove();
            L.add(x);       // PreVisit for Vertex V
            for (int i=0; i< this.getNeighbors(x).size(); i++) {
                NodeCount[this.getNeighbors(x).get(i)]--;// One less prerequisite
                if (NodeCount[this.getNeighbors(x).get(i)] == 0) {     // This vertex is now free
                    Q.add(i);
                }
            }
        }
        System.out.println(L);
    }


    public void DFS(int v) {
        setVisited(v);
        LinkedList<Integer> neighbors = adjList.elementAt(v);
        for (int i = 0; i < neighbors.size(); i++) {
            int v1 = neighbors.get(i);
            if (ifVisited(v1) == false) {
                DFS(v1);
            }
        }
    }

    public void BFS(int s) {
        ArrayList<Integer> toVisit = new ArrayList<Integer>();
        toVisit.add(s);
        while (toVisit.size() > 0) {
            int v = toVisit.remove(0);   // first-in, first-visit
            setVisited(v);
            LinkedList<Integer> neighbors = adjList.elementAt(v);
            for (int i = 0; i < neighbors.size(); i++) {
                int v1 = neighbors.get(i);
                if ((ifVisited(v1) == false) && (toVisit.contains(v1) == false)) {
                    toVisit.add(v1);
                }
            }
        }
    }

    public void display() {
        System.out.println("total nodes: " + totalNodes);
        System.out.println("total edges: " + totalEdges);
    }

    public void displayEnum() {
        for (int i = 0; i < nodeEnum.size(); i++) {
            System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        AdjGraph g1 = new AdjGraph(true);
        String[] nodes1 = {"A", "B", "C", "D", "E"};
        g1.setVertices(nodes1);
        g1.setEdge("A", "B", 3);
        g1.setEdge("B", "C", 2);
        g1.setEdge("C", "D", 5);
        g1.setEdge("A", "E", 20);
        g1.setEdge("C","E",10);
        g1.topologicalSortWithQueue(g1);
        System.out.println();
        //second example: g2
        AdjGraph g2 = new AdjGraph(true);
        String[] nodes2 = {"a", "b", "c", "d", "e", "f"};
        g2.setVertices(nodes2);
        g2.setEdge("a", "b", 9);
        g2.setEdge("a", "f", 5);
        g2.setEdge("a", "e", 3);
        g2.setEdge("b", "c", 5);
        g2.setEdge("b", "f", 4);
        g2.setEdge("c", "d", 2);
        g2.setEdge("c", "f", 8);
        g2.setEdge("d", "f", 7);
        g2.setEdge("d", "e", 1);
        g2.setEdge("e", "f", 5);
        g2.topologicalSortWithQueue(g2);
        System.out.println();
        AdjGraph g3 = new AdjGraph(true);
        String[] nodes3 = {"a", "b", "c", "d", "e", "f","q"};
        g3.setVertices(nodes3);
        g3.setEdge("b", "f", 4);
        g3.setEdge("c", "d", 2);
        g3.setEdge("c", "e", 8);
        g3.setEdge("d", "f", 2);
        g3.setEdge("f", "e", 1);
        g3.setEdge("e", "f", 7);
        g3.setEdge("q", "b", 9);
        g3.setEdge("q", "f", 17);
        g3.setEdge("q", "e", 3);
        g3.setEdge("b", "c", 5);

        g3.topologicalSortWithQueue(g3);
        System.out.println();

    }


    // Lab 10 TODO:

    // write your new main() method here:

    /*public static void main(String args[]) {
        AdjGraph g1 = new AdjGraph();
        String[] nodes2 = {"a", "b", "c", "d", "e", "f"};
        g1.setVertices(nodes2);
        g1.addEdge("a", "", 8);
        g1.addEdge("", "", 3);
        g1.addEdge("", "", 8);
        g1.addEdge("", "", 3);
        g1.addEdge("", "", 8);
        g1.addEdge("", "", 3);
        g1.addEdge("", "", 8);
        g1.addEdge("", "", 3);
        System.out.pritnln(topologicalSortWithQueue().g1);
        AdjGraph g2 = new AdjGraph(true);
        String[] nodes3 = {"g", "h", "i", "j", "k", "l"};
        g2.setVertices(nodes3);
        g2.setEdge("a", "b", 9);
        g2.setEdge("a", "f", 5);
        g2.setEdge("a", "e", 3);
        g2.setEdge("b", "c", 5);
        g2.setEdge("b", "f", 4);
        g2.setEdge("c", "d", 2);
        g2.setEdge("c", "f", 8);
        g2.setEdge("d", "f", 7);
        g2.setEdge("d", "e", 1);
        g2.setEdge("e", "f", 5);
        System.out.println(g2.topologicalSortWithQueue());
    */
} // end of class AdjGraph
