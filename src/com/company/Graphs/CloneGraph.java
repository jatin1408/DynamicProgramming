package com.company.Graphs;
import java.util.*;
public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


        public Node cloneGraph(Node node) {
            if(node==null){
                return null;
            }
            Node[] visited=new Node[101];
            Node curr=new Node(node.val);
            visited[node.val]=curr;
            for(Node obj:node.neighbors){
                if(visited[obj.val]==null){
                    Node newNode=new Node(obj.val);
                    dfs(newNode,obj,visited);
                    curr.neighbors.add(visited[obj.val]);
                }
                else{
                    curr.neighbors.add(visited[obj.val]);
                }
            }
            return curr;
        }
        public void dfs(Node newNode,Node present,Node[] visited){
            visited[newNode.val]=newNode;
            for(Node obj:present.neighbors)
            {
                if(visited[obj.val]==null){
                    Node temp=new Node(obj.val);

                    dfs(temp,obj,visited);
                    newNode.neighbors.add(temp);

                }
                else{
                    newNode.neighbors.add(visited[obj.val]);
                }
            }
        }
    }

