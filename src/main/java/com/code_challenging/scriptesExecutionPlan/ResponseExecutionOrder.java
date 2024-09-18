package com.code_challenging.scriptesExecutionPlan;

import java.util.ArrayList;
import java.util.List;

public class ResponseExecutionOrder {
    private List<Integer> order = new ArrayList<>();
    private String error = "";
    public ResponseExecutionOrder() {
    }

    public ResponseExecutionOrder(String error){
        this.error = error;
    }

    public ResponseExecutionOrder(List<Integer> order){
        this.order = order;
    }

    public ResponseExecutionOrder(List<Integer> order, String error){
        this.order = order;
        this.error = error;
    }

    public List<Integer> getOrder() {
        return order;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "ResponseExecutionOrder{" +
                "order=" + order +
                ", error='" + error + '\'' +
                '}';
    }
}
