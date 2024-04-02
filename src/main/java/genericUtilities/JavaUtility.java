package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of java specific generic utility
 * @author 91831
 *
 */
public class JavaUtility {
	/**
	 * This method will generate the system date in required format
	 * @return
	 */
  public String getDate() {
	  Date d = new Date();//we can also do this by using LocaldateTime class and its methods
	  SimpleDateFormat f = new SimpleDateFormat("dd-MM-yy hh-mm-ss");
	  String date= f.format(d);
	  return date;
	  
  }
	
}
