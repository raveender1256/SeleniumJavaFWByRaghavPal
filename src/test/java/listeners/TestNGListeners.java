package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListeners implements ITestListener{
	
	public void onTestStart(ITestResult result) {  
		System.out.println("Started the test case  : "+result.getName());  
	}  
	  
	 
	public void onTestSuccess(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Success of test cases and its details are : "+result.getStatus());  
	}  
	  
	
	public void onTestFailure(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getThrowable());  
	}  
	  

	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Skip of test cases and its details are : "+result.getSkipCausedBy());  
	}  
	  
 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	
	public void onStart(ITestContext context) {  
	// TODO Auto-generated method stub  
	}  
	  
	
	public void onFinish(ITestContext context) {  
	// TODO Auto-generated method stub  
	}  
	
	

}
