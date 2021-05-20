package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageConexaoNaoSegura {
	
	@FindBy(id="details-button")
	private WebElement botaoAvancado;
	
	@FindBy(id="proceed-link")
	private WebElement botaoIrLocalhost;
	

	public void avancaPagina() {
		botaoAvancado.click();
		botaoIrLocalhost.click();
		
	}

}
