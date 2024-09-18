package com.code_challenging.scriptesExecutionPlan;

import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class ExecutionPlan {

    public ResponseExecutionOrder getExecutionOrder(List<VulnerabilityScript>  scripts){
        Map<Integer, ArrayList<Integer>> adjacentList = new HashMap<>(); // convert input as graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        ArrayList<Integer> executionOrder = new ArrayList<>(); // store the execution order and return

        /*
        * Convert your input as a graph.
        * where every script_id is a node
        * */
        for(VulnerabilityScript script : scripts ){
            List<Integer> dependencies = script.getDependencies();
            /*
             * every script has its dependency so that will be the inDegree of the node
             * That means this script must execute after dependencies execution
             */
//            System.out.println(script.getScriptId() + "---> "+dependencies.size());
            inDegree.put(script.getScriptId(), dependencies.size());
            /*
             * graph representation of the input
             *
             */
            for(Integer dependency : dependencies) {
                adjacentList.putIfAbsent(dependency, new ArrayList<>());
                adjacentList.get(dependency).add(script.getScriptId());
            }
        }

        /*Execution order calculate using BFS manner */

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()){
            int currentScripts = queue.poll();
            executionOrder.add(currentScripts);
            if(adjacentList.containsKey(currentScripts)){
                for(Integer dependent : adjacentList.get(currentScripts)){
                    inDegree.put(dependent,inDegree.get(dependent)-1);
                    if(inDegree.get(dependent) == 0 ){
                        queue.add(dependent);
                    }
                }
            }
        }

        if(scripts.size() != executionOrder.size()){
            return new ResponseExecutionOrder(executionOrder,"Cyclic dependency presents");
        }


        return new ResponseExecutionOrder(executionOrder);
    }
}
