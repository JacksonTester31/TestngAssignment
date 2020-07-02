package pkg;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTest extends Calculator {

	Calculator ob = new Calculator();
	
	@Test(groups = {"Alpha","Beta"})
	public void AssertAllmethods() {
		Assert.assertEquals(20,ob.add(10, 10));
		Reporter.log("AssertEqualsPassed", true);
	
		Assert.assertTrue(ob.mul(10, 2)==ob.sub(30, 10));
		Reporter.log("AssertTruePassed", true);
		
		Assert.assertFalse(ob.divInt(10, 2)<ob.exp(2, 2));
		Reporter.log("AssertFalsePassed", true);
		
		Assert.assertNotEquals(ob.mod(20, 2), ob.inverse(11));
		Reporter.log("AssertNotequalsPassed", true);
		
		Assert.assertEquals(-10, ob.negate(10));
		Reporter.log("AssertEqualsPassed on a negative comaprison", false);
		System.out.println("assert-threadid"+Thread.currentThread().getId());
		
		}
	
	 @DataProvider(name = "data-provider")
	    public Object[][] dataProviderMethod() {
		 return new Object[][] {{3 ,3},{10,2}};
	 }
	 
	    @Test(dataProvider = "data-provider",groups = {"Beta"})
	    public void DataProviderMethod(int a, int b) {
	    	if(a==3){
	       Assert.assertEquals(6, ob.add(a, b));
	    	}
	    	else {
	    		Assert.assertEquals(12, ob.add(a, b));
	    	}
	       Assert.assertTrue(ob.mul(a, b)>ob.sub(a, b));
	       Assert.assertNotEquals(ob.divReal(a, b), ob.exp(a, b));
	       Assert.assertFalse(ob.divInt(a, b)==ob.mod(a, b));
	       ob.divReal(a, b);
	       ob.negate(a);
          ob.inverse(a);
	    }
	    
	    
	    @Test(groups = {"Alpha"})
	    @Parameters({"val1","val2"})
	    public void Parameter_method(int var1, int var2) {
	    	System.out.println("**Calculator Operations Using Parameters**");
	    	System.out.println("Addition of two numbers is :"+ob.add(var1, var2));
	    	System.out.println("Substitution of two numbers is:"+ob.sub(var1, var2));
	    	System.out.println("Multiplication of two numbers is:"+ob.mul(var1, var2));
	    	System.out.println("Divisionof two numbers is:"+ob.divInt(var1, var2));
	    	System.out.println("Inverse of a number is :"+ob.inverse(var1));
	    	System.out.println("Negate of a number is:"+ob.negate(var2));
	    	System.out.println("Exponential operation for given two numbers is:"+ob.exp(var1, var2));
	    	System.out.println("Modulus operation for given two numbers is:"+ob.mod(var1, var2));
	    	
	    	System.out.println("param-threadid"+Thread.currentThread().getId());
	    }
	    
	    @Test(groups= {"Gamma"})
	    public void gamma_method() {
	    	System.out.println("Excluded method");
	    }
	    
	    
}