package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice {
	@Test //(priority=2,invocationCount=3,dependsOnMethods="deleteCustomer")
	public void createCustomer() {
		Assert.fail();
		System.out.println("create");
	}
     
	@Test  (dependsOnMethods="createCustomer")//(priority=-2,threadPoolSize=2)
	public void modifyCustomer() {
		System.out.println("modify");
	}

	
	@Test  //default priority is zero and default value of invocationCount is one and by default threadPoolsize is one 
	public void deleteCustomer() {
		System.out.println("delete");
	}

}
