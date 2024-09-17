package com.code_challenging.scriptesExecutionPlan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ScriptesExecutionPlanApplicationTests {

	@Test
	void contextLoads() {
		VulnerabilityScript script1 = new VulnerabilityScript(1, List.of(2,3,5));
		VulnerabilityScript script2 = new VulnerabilityScript(2, List.of(3,5));
		VulnerabilityScript script3 = new VulnerabilityScript(3, List.of(5));
		VulnerabilityScript script4 = new VulnerabilityScript(4, List.of(1));
		VulnerabilityScript script5 = new VulnerabilityScript(5, List.of());
		VulnerabilityScript script6 = new VulnerabilityScript(6, List.of());
		VulnerabilityScript script7 = new VulnerabilityScript(7, List.of(2));

		ExecutionPlan executionPlan = new ExecutionPlan();

		List<Integer> executionOrder = executionPlan.getExecutionOrder(List.of(script1, script2, script3,script4,script5,script6,script7));
		System.out.println(executionOrder.toString());
	}

}
