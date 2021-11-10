package testframe.application.commercialcenter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;


/**
 * PageNage : CommercialCenter_Corporate_FuturePayment
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_FuturePayment extends CommonLibrary{

	public Corporate_FuturePayment(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
}
