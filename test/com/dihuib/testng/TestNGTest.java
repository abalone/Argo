package com.dihuib.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Test(groups={"classGroup"})
public class TestNGTest {

	/* part 1 ---group */
	@Test(groups = {"group1","group2","group3.x"})
	public void method1() {
		System.out.println("method 1");
	}
	
	@Test(groups = {"group1","group2"})
	public void method2() {
		System.out.println("method 2");
	}

	@Test(groups= {"group2","group3.y"})
	public void method3() {
		System.out.println("method 3");
	}
	
	/* part 2 --- paramterize*/
	
	@Parameters( {"param1"})
	@Test
	public void p1(@Optional("default param 1") String param1) {
		System.out.println(param1);
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest");
	}
	
	
	/* @DataProvider */
	@DataProvider(name = "dataprovider1" /*dataProviderClass = DataProvider.class*/)
	public Object[][] createData1() {
		return new Object[][] {
				{"A", new Integer(28)},
				{"B", new Integer(34)}
		};
	}
	
	@Test(dataProvider ="dataprovider1")
	public void testDataProvider(String d1, Integer d2) {
		System.out.println(d1 + ":" + d2);
	}
	
	/* dependency */
	@Test(dependsOnMethods ={"test2"})
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test(dependsOnMethods = {"test3"})
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test
	public void test3() {
		System.out.println("Test3");
	}


}
