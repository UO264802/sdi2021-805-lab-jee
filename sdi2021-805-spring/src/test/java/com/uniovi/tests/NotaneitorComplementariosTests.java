package com.uniovi.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_TeacherRegisterView;
import com.uniovi.tests.pageobjects.PO_View;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotaneitorComplementariosTests {
	// En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas)):
	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	static String Geckdriver024 = "C:\\Users\\moise\\Documents\\RepoSDI\\PL-SDI-Sesion5-material\\geckodriver024win64.exe";

	// Común a Windows y a MACOSX
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@BeforeClass
	static public void begin() {
	}

	@AfterClass
	static public void end() {
		driver.quit();
	}

	@Test
	public void PR01() {
		PO_View.loginInitialization(driver, "99999988F", "Notas del usuario");

		PO_View.checkElement(driver, "//li[contains(@id, 'teachers-menu')]/a", 0);
		PO_View.checkElement(driver, "//a[contains(@href, 'teacher/add')]", 0);

		PO_TeacherRegisterView.fillForm(driver, "77777777O", "Pepe", "Pepito", "Ayudante");
		PO_View.checkElement(driver, "text", "Profesores");

		PO_View.checkElement(driver, "//li[contains(@id, 'teachers-menu')]/a", 0);
		PO_View.checkElement(driver, "//a[contains(@href, 'teacher/add')]", 0);

		PO_TeacherRegisterView.fillForm(driver, "77777777R", "", "Pepito", "");
		PO_View.checkElement(driver, "text", "Añadir profesor");

		PO_HomeView.clickOption(driver, "/logout", "text", "Registrate");

		PO_View.loginInitialization(driver, "99999977E", "Notas del usuario");

		PO_View.checkElement(driver, "//li[contains(@id, 'teachers-menu')]/a", 0);

		List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@href, '/teacher/add')]"));
		assertTrue(elements.isEmpty());
	}
}