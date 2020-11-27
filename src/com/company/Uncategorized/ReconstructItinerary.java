package com.company.Uncategorized;

import java.util.*;

public class ReconstructItinerary {
    HashMap<String, PriorityQueue<String>> targets=new HashMap<>();
    List<String> route=new LinkedList<>();
    public List<String> findItinerary(String[][] tickets){
        for(String[] ticket:tickets) {

            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        return route;
    }
    public void visit(String src){
        while (targets.containsKey(src) && !targets.get(src).isEmpty()){
            visit(targets.get(src).poll());
        }
        route.add(0,src);
    }
}
