package bfs;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.javafx.geometry.BoundsUtils;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Fuad
 */
public class BFS {

    private int numberOFnode;
    private LinkedList<Integer> vertex[];

    BFS(int node) {
        numberOFnode = node;
        vertex = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            vertex[i] = new LinkedList();
        }
    }

    void addEdge(int parent, int child) {
        vertex[parent].add(child);
    }

    void traverse(int start, int goal) {
        boolean visited[] = new boolean[numberOFnode];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0) {
            start = queue.poll();
            if (start != goal) {
                System.out.print(start + " ");
                Iterator<Integer> list = vertex[start].listIterator();
                while (list.hasNext()) {
                    int next_node = list.next();
                    if (!visited[next_node]) {
                        visited[next_node] = true;
                        queue.add(next_node);
                    }
                }
            } else {
                System.out.print(start + " ");
                break;
            }
        }

    }

    public static void main(String[] args) {

        BFS vertex = new BFS(10);
        
        vertex.addEdge(0, 1);
        vertex.addEdge(0, 2);
        vertex.addEdge(0, 3);
        vertex.addEdge(1, 4);
        vertex.addEdge(2, 4);
        vertex.addEdge(2, 5);
        vertex.addEdge(2, 6);
        vertex.addEdge(3, 6);
        vertex.addEdge(4, 7);
        vertex.addEdge(5, 7);
        vertex.addEdge(6, 7);
        
        vertex.traverse(0, 7);
    }

}
