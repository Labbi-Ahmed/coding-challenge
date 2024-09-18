package com.code_challenging.scriptesExecutionPlan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ScriptExecutionPlannerTest {

    @Test
    public void testGetExecutionOrder() {
        // Define test data
        VulnerabilityScript script1 = new VulnerabilityScript(1, Arrays.asList(2, 3));
        VulnerabilityScript script2 = new VulnerabilityScript(2, Arrays.asList());
        VulnerabilityScript script3 = new VulnerabilityScript(3, Arrays.asList(2));
        VulnerabilityScript script4 = new VulnerabilityScript(4, Arrays.asList(1));

        List<VulnerabilityScript> scripts = Arrays.asList(script1, script2, script3, script4);

        // Expected execution order (could be any valid topological order)
        List<Integer> expectedOrder = Arrays.asList(2, 3, 1, 4);  // One valid topological sort

        // Get the execution order
        ResponseExecutionOrder response =new ExecutionPlan().getExecutionOrder(scripts);

        // Assert the result
        System.out.println(response.toString());
        assertEquals(expectedOrder, response.getOrder(), "The execution order is incorrect.");
    }

    @Test
    public void testGetExecutionOrderWithNoDependencies() {
        // Define test data
        VulnerabilityScript script1 = new VulnerabilityScript(1, Arrays.asList());
        VulnerabilityScript script2 = new VulnerabilityScript(2, Arrays.asList());
        VulnerabilityScript script3 = new VulnerabilityScript(3, Arrays.asList());

        List<VulnerabilityScript> scripts = Arrays.asList(script1, script2, script3);

        // Expected execution order (order may vary)
        List<Integer> expectedOrder = Arrays.asList(1, 2, 3);  // Any order is valid

        // Get the execution order
        ResponseExecutionOrder response = new ExecutionPlan().getExecutionOrder(scripts);

        // Assert the result
        System.out.println(response.toString());
        assertEquals(expectedOrder, response.getOrder(), "The execution order is incorrect.");
    }

    @Test
    public void testGetExecutionOrderWithCyclicDependency() {
        // Define test data with a cyclic dependency
        VulnerabilityScript script1 = new VulnerabilityScript(1, Arrays.asList(2));
        VulnerabilityScript script2 = new VulnerabilityScript(2, Arrays.asList(1));  // Cyclic dependency

        List<VulnerabilityScript> scripts = Arrays.asList(script1, script2);

        // Assert that the exception is thrown for cyclic dependencies

        ResponseExecutionOrder response = new ExecutionPlan().getExecutionOrder(scripts);
        System.out.println(response.toString());
        assertEquals("Cyclic dependency presents", response.getError());

    }
}

