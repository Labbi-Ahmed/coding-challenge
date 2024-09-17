package com.code_challenging.scriptesExecutionPlan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ScriptesExecutionPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScriptesExecutionPlanApplication.class, args);
		VulnerabilityScript script1 = new VulnerabilityScript(1, List.of(2,3,5));
		VulnerabilityScript script2 = new VulnerabilityScript(2, List.of(3,5));
		VulnerabilityScript script3 = new VulnerabilityScript(3, List.of(5));
		VulnerabilityScript script4 = new VulnerabilityScript(4, List.of(1));
		VulnerabilityScript script5 = new VulnerabilityScript(5, List.of());

		ExecutionPlan executionPlan = new ExecutionPlan();

		List<Integer> executionOrder = executionPlan.getExecutionOrder(List.of(script1, script2, script3,script4,script5));
		System.out.println(executionOrder.toString());
	}

}
