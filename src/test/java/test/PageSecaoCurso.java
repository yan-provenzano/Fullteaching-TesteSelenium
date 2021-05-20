package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageSecaoCurso {
	
	@FindBy(id="add-session-icon")
	private WebElement botaoAddSecao;
	
	@FindBy(id="input-post-title")
	private WebElement txtNomeSecao;
	
	@FindBy(id="input-post-comment")
	private WebElement txtDescricao;
	
	@FindBy(id="input-post-date")
	private WebElement txtData;
	
	@FindBy(id="input-post-time")
	private WebElement txtHora;
	
	@FindBy(id="post-modal-btn")
	private WebElement botaoEnviar;


	public void criaSecaoCurso(String secao, String descricao, String data, String hora) {
		botaoAddSecao.click();
		txtNomeSecao.sendKeys(secao);
		txtDescricao.sendKeys(descricao);
		txtData.sendKeys(data);
		txtHora.sendKeys(hora);
		botaoEnviar.click();
	}

}
