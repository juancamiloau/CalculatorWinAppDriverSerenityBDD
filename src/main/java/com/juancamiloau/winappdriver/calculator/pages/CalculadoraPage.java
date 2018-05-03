package com.juancamiloau.winappdriver.calculator.pages;

import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://app.kometsales.com/sign-in/login.do")
public class CalculadoraPage extends PageObject {

	@FindBy(xpath = "//*[@AutomationId = 'num1Button']")
	private WebElement Uno;

	@FindBy(xpath = "//*[@AutomationId = 'num2Button']")
	private WebElementFacade Dos;

	@FindBy(xpath = "//*[@AutomationId = 'num3Button']")
	private WebElementFacade Tres;

	@FindBy(xpath = "//*[@AutomationId = 'num4Button']")
	private WebElementFacade Cuatro;

	@FindBy(xpath = "//*[@AutomationId = 'num5Button']")
	private WebElement Cinco;

	@FindBy(xpath = "//*[@AutomationId = 'CalculatorResults']")
	private WebElement Resultado;

	@FindBy(xpath = "//*[@AutomationId='equalButton']")
	private WebElement Igual;

	@FindBy(xpath = "//*[@AutomationId = 'plusButton']")
	private WebElementFacade Sumar;

	public void clickUno() throws InterruptedException {
		Uno.click();
	}

	public void clickDos() {
		Dos.click();
	}

	public void clickTres() {
		Tres.click();
	}

	public void clickCuatro() {
		Cuatro.click();
	}

	public void clickCinco() {
		Cinco.click();
		// getDriver().findElement(By.name("Cinco"));
	}

	public void clickSumar() {
		Sumar.click();
	}

	public String capturarResultado() {
		Igual.click();
		Serenity.takeScreenshot();

		return Resultado.getText();
	}

}