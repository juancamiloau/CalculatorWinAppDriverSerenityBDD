package com.juancamiloau.winappdriver.calculator.features.definitions;

import com.juancamiloau.winappdriver.calculator.steps.CalculadoraSteps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CalculadoraDefinitions {
	@Steps
	CalculadoraSteps calculadoraSteps;
	
	@Before	
	public void iniciarCalculadora() {
		calculadoraSteps.iniciarApp();
	}
	

	@When("^sumo (.*) mas (.*)$")
	public void sumoDosNumeros(int intNumero1, int intNumero2) {
		calculadoraSteps.presionarUno();
		calculadoraSteps.presionarSuma();
		calculadoraSteps.presionarCinco();
	}
	@Then("^el resultado de la suma debe ser (\\d+)$")
	public void el_resultado_de_la_suma_debe_ser(String strResultado) throws Exception {
		calculadoraSteps.verificarResultadoSuma(strResultado);
	}

}
