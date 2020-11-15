package com.company.Graphs;


import java.util.*;

public class DijkstatraMinHeap {
    private int dist[];
    private Set<Integer> settled;
    private int V;
    private PriorityQueue<Node> pq;
    List<List<Node>> adj;

    public DijkstatraMinHeap(int v) {
        V = v;
        settled = new HashSet<>();
        pq = new PriorityQueue<>(V,new Node());
        dist = new int[V];

    }

    public void shortest(int source) {

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;
        pq.add(new Node(source, 0));
        while (settled.size() != V && pq.size()!=0) {
            int u = pq.remove().v;
            settled.add(u);
            neighbours(u);
        }
    }

    public void neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node node = adj.get(u).get(i);
            if (!settled.contains(node.v)) {
                edgeDistance = node.cost;
                newDistance = dist[u] + edgeDistance;
                if (newDistance < dist[node.v]) {
                    dist[node.v] = newDistance;
                }
                pq.add(new Node(node.v, dist[node.v]));
            }
        }
    }

    public void create(int[][] graph) {
        adj = new ArrayList<List<Node>>();
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }
        for (int i = 0; i < graph.length; i++) {
            addEdge(graph[i][0], graph[i][1], graph[i][2]);
        }
    }

    public void addEdge(int u, int v, int cost) {
        adj.get(u).add(new Node(v, cost));
    }
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n=5;
        int source=2;
        DijkstatraMinHeap d=new DijkstatraMinHeap(n);
        d.create(times);
        d.shortest(source);
        for(int i=0;i<n;i++){
            System.out.println(d.dist[i]);
        }
    }

}
class Node implements Comparator<Node> {
    int v;
    int cost;
    public Node(){

    }
    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compare(Node o1, Node o2) {
        return o1.cost-o2.cost;
    }
}





