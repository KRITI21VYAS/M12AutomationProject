package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion
{
   @Test
   public void hardassert() {
	  String s1="hi";
	  String s2="bye";
	  String s3="bye";
	 // Assert.assertEquals(s1, s2);//Script failed
	 // Assert.assertTrue(s2.contains(s3));//passed
	 Assert.assertTrue(s1.contains(s2));//failed
   }
}
