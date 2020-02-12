package listeners;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

//@Ignore
@Test(groups= {"Alltests.group"})
public class TestNGGroupsDemo {

	
	@Test (groups = {"sanity"},dependsOnMethods= {"test2"})
	@Parameters({"MyName"})	
	public void test1(@Optional String Name) {
		System.out.println("this is test1");
		System.out.println("My Name is : "+ Name);
		
	}

	@Test (groups = {"sanity"},invocationCount =2,threadPoolSize =3)
	public void test2() {
		System.out.println("this is test2");	
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
	}

	@Test (groups = {"smoke"},retryAnalyzer = listeners.RetryAnalyser.class)
	public void test3() {
		System.out.println("this is test3");	
		
		Assert.assertTrue(4<2);
	}
	@Test (groups = {"smoke","regression"},priority=-2,retryAnalyzer = listeners.RetryAnalyser.class)
	public void test4() {
		System.out.println("this is test4");
		Assert.assertFalse(3>2);
		
	}

	@Test (groups = {"regression"},priority=0)
	public void test5() {
		System.out.println("this is test5");
		
	}



}
