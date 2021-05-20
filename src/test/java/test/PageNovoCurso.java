package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageNovoCurso {
	
	@FindBy(id="add-course-icon")
	private WebElement botaoAddCurso;
	
	@FindBy(id="input-post-course-name")
	private WebElement txtNomeCurso;
	
	@FindBy(id="submit-post-course-btn")
	private WebElement botaoEnviar;


	public void criaCurso(String curso) {
		botaoAddCurso.click();
		txtNomeCurso.sendKeys(curso);
		botaoEnviar.click();		
	}

}
