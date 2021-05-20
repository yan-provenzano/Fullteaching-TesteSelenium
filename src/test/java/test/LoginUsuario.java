package test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginUsuario {
	
	protected WebDriver driver;

	@BeforeClass
	public static void configuraDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
	}

	
	@Before
	public void createDriver() {
		driver = new ChromeDriver();
		driver.get("https://localhost:5000");	
	}
	

	@Test
	public void test() throws InterruptedException {
		PageConexaoNaoSegura pageConexaoNaoSegura = PageFactory.initElements(driver, PageConexaoNaoSegura.class);
		pageConexaoNaoSegura.avancaPagina();
		
		WebElement clicaLogin = driver.findElement(By.xpath("//*[@id=\"navigation-bar\"]/div/ul/li[2]/a"));
		clicaLogin.click();
		Thread.sleep(3000);
		
		PageLogin pageLogin = PageFactory.initElements(driver, PageLogin.class);
		pageLogin.logaUsuario("teacher@gmail.com", "pass");

		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		Thread.sleep(3000);
	
		assertTrue("Título da página difere do esperado", driver.getTitle().contentEquals("FullTeaching"));
		Thread.sleep(2000);
	}

	
	@After
	public void quitDriver() {
		driver.quit();
	}
	
	
}
