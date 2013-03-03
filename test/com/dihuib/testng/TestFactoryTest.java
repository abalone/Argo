/**
 * 
 */
package com.dihuib.testng;

import org.testng.annotations.Test;

/**
 * @author Dihui Bao 
 *
 */
public class TestFactoryTest {
	
	private int param;

	public TestFactoryTest(int param) {
		this.param = param;
	}
	
	@Test
	public void testFactory() {
		System.out.println(param);
	}
	

}
