package com.dee.test1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
public class TestNGjava2 {
@Test(priority = 1)
	
	public void TestMethod0() {
	  System.out.println("TestMethod0");
}
	@Test(priority = 4)
	
	public void TestMethod1() {
	  System.out.println("TestMethod1");
}
	@Test(priority = 2)
	
	public void TestMethod2() {
		  System.out.println("TestMethod2");
	}
	
	@Test(priority = 3)
	public void TestMethod3() {
		  System.out.println("TestMethod3");
	}
	@Test(priority = 0)
	public void TestMethod4() {
		  System.out.println("TestMethod4");
	}

}
