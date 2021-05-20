package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageLogin {
	
	@FindBy(id="email")
	private WebElement txtEmail;
	
	@FindBy(id="password")
	private WebElement txtSenha;
	
	@FindBy(id="log-in-btn")
	private WebElement botaoLoginFinal;

	

	public void logaUsuario(String email, String senha) {
		txtEmail.sendKeys(email);
		txtSenha.sendKeys(senha);
		botaoLoginFinal.click();
		
	}

}
