package com.dihuib.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitBeforeAfterTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass");
	}
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
		
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}

}
