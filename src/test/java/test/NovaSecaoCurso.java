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

public class NovaSecaoCurso {

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
		WebElement clicaLogin = driver.findElement(By.xpath("//*[@id=\"navigation-bar\"]/div/ul/li[2]/a"));
		clicaLogin.click();
		Thread.sleep(3000);
		
		PageLogin pageLogin = PageFactory.initElements(driver, PageLogin.class);
		pageLogin.logaUsuario("teacher@gmail.com", "pass");
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		WebElement clicaCurso = driver.findElement(By.xpath("//*[@id=\"course-list\"]/li[2]/div/div[2]/span"));
		clicaCurso.click();
		Thread.sleep(3000);
		
		WebElement clicaSecao = driver.findElement(By.xpath("//*[@id=\"sessions-tab-icon\"]"));
		clicaSecao.click();
		Thread.sleep(3000);
		
		PageSecaoCurso pageSecaoCurso = PageFactory.initElements(driver, PageSecaoCurso.class);
		pageSecaoCurso.criaSecaoCurso("Aula Selenium","Aprendendo nova ferramenta de teste","31/08/2020", "18h30");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		assertTrue("URL da página difere da esperada", driver.getCurrentUrl().contentEquals("https://localhost:5000/courses/55/1"));	
		
		Thread.sleep(2000); 
	}

	
	@After
	public void quitDriver() {
		driver.quit();
	}

}
