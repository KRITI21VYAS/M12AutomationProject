package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice
{
  @Test(retryAnalyzer=genericUtilities.RetryAnalyserImplementation.class)
  public void retryAnalyze() 
  {
	  Assert.fail();
	  System.out.println("hello");
  }
}
