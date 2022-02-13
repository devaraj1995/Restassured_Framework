package GenericUtility;

import java.util.Random;

/**
 * This class contains java specific generic methods
 * @author Devaraj kg
 *
 */

public class JavaUtility {
	
	  /**
	   * this method will generate a random value for every run
	   * @return
	   */
    public int getRandomNum()
    {
  	  Random ran = new Random();
  	  int randomnum = ran.nextInt(100);
  	  return randomnum;
    }
	

}
