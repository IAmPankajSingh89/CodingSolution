import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleTest {
	
	//I don't have knowledge in MS-Test
	
	
	  private String param = "";
	  
	  public SimpleTest(String param)
	  
	  { this.param=param; }
	 
	 
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class executed");
	}
	
	@Test(dataProvider = "Mutliplevalues")
	public void testMethod(String param)
	{
		System.out.println("Value is: " + param);
	}
	
	@DataProvider(name = "Mutliplevalues")
	public static Object[] fruits()
	{
		return new Object[]  {"Apple","Banana","Orange"};
	}

}
