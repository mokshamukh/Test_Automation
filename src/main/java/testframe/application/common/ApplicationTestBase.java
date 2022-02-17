package testframe.application.common;

import testframe.application.commercialcenter.businessflow.AdminTest;
import testframe.application.commercialcenter.businessflow.CorporateTest;
import testframe.application.epp.businessflow.EppTest;
import testframe.application.premier.businessflow.PremierTestSet1;
import testframe.application.premier.businessflow.PremierTestSet2;



public class ApplicationTestBase {
	
	public AdminTest admintest = new AdminTest();
	public CorporateTest corporatetest = new CorporateTest();
	public EppTest epptest = new EppTest();
	public PremierTestSet2 premiertestset2 = new PremierTestSet2();
	public PremierTestSet1 premiertestset1 = new PremierTestSet1();

}
