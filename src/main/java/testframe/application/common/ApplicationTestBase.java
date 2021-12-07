package testframe.application.common;

import testframe.application.commercialcenter.businessflow.AdminTest;
import testframe.application.commercialcenter.businessflow.CorporateTest;
import testframe.application.epp.businessflow.EppTest;
import testframe.application.premier.businessflow.PremierTest;


public class ApplicationTestBase {
	
	public AdminTest admintest = new AdminTest();
	public CorporateTest corporatetest = new CorporateTest();
	public EppTest epptest = new EppTest();
	public PremierTest premiertest = new PremierTest();

}
