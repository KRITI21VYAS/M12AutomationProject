package Practice;

public class GenericMethodsPractice {

	public static void main(String[] args) //caller method
	{
	 int sum= add(2,3); // now this method is returning the sum , now called method use that in any way. like we are adding 20 .
      int x=sum +20;
      System.out.println(x);
      
      int y=sub(40,20);
      System.out.println(y);
	}
	
	public  static int add(int a , int b)//called method
	{
		int c = a+b; //agar hum is c ko print karenge through print statement toh caller method ko print nahi chaiye tab bhi print he hoga , print ki jagh we can return the value of c to caller method so that called method use that c value in the way it wants
		return c; //return the output to caller
	}
	
	public static int sub(int a , int b) {
		int c = a-b;
		return c;
	}

}
