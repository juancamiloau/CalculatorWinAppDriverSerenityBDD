package com.juancamiloau.winappdriver.calculator.steps;

import static org.junit.Assert.assertTrue;

import com.juancamiloau.winappdriver.calculator.pages.CalculadoraPage;

import net.thucydides.core.annotations.Step;

public class CalculadoraSteps {
	CalculadoraPage calculadoraPage;
	@Step
	public void presionarUno() {
		try {
			calculadoraPage.clickUno();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Step 
	public void iniciarApp() {
		try {
			calculadoraPage.open();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Step
	public void presionarCinco(){
		calculadoraPage.clickCinco();
	}
	@Step 
	public void presionarSuma(){
		calculadoraPage.clickSumar();
	}
	@Step
	public void verificarResultadoSuma(String strResultado) throws InterruptedException {
		assertTrue(calculadoraPage.capturarResultado().contains(strResultado));
	}
}
