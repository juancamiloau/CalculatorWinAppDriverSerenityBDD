package com.juancamiloau.winappdriver.calculator.drivers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import net.thucydides.core.webdriver.DriverSource;

public class WindowsDriverProvided implements DriverSource {
	private static final int sizeOfIntInHalfBytes = 8;
	private static final int numberOfBitsInAHalfByte = 4;
	private static final int halfByte = 0x0F;
	private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };

	@Override
	public WebDriver newDriver() {
		try {
			WebDriver driver;

			Properties prop = new Properties();

			InputStream inputStrem = new FileInputStream("./serenity.properties");

			prop.load(inputStrem);

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", prop.getProperty("windriver.deviceName"));
			capabilities.setCapability("app", "Root");
			driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
			String ventanaid = driver.findElement(By.name("Calculadora")).getAttribute("NativeWindowHandle");

			ventanaid = decToHex(Integer.parseInt(ventanaid));
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("appTopLevelWindow", ventanaid);
			driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);

			return driver;

		} catch (Exception e) {
			System.out.println("mio " + e.getMessage());
			throw new Error(e);

		}

	}

	public String decToHex(int dec) {
		StringBuilder hexBuilder = new StringBuilder(sizeOfIntInHalfBytes);
		hexBuilder.setLength(sizeOfIntInHalfBytes);
		for (int i = sizeOfIntInHalfBytes - 1; i >= 0; --i) {
			int j = dec & halfByte;
			hexBuilder.setCharAt(i, hexDigits[j]);
			dec >>= numberOfBitsInAHalfByte;
		}
		return hexBuilder.toString();
	}

	@Override
	public boolean takesScreenshots() {
		// TODO Auto-generated method stub
		return true;
	}

}
