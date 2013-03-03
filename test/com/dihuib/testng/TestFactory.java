/**
 * 
 */
package com.dihuib.testng;

import org.testng.annotations.Factory;

/**
 * @author Dihui Bao 
 *
 */
public class TestFactory {
	@Factory
	public Object[] createInstances ()  {
		Object[] result = new Object[10];
		for(int i=0; i<10;i++) {
			result[i] = new TestFactoryTest(i);
		}
		
		return result;
	}
}
