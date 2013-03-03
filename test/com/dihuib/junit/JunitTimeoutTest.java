/**
 * 
 */
package com.dihuib.junit;

import org.junit.Test;

/**
 * @author Dihui Bao 
 *
 */
public class JunitTimeoutTest {
	
	@Test(timeout=1000)
	public void testTimer() {
		for(;;);
	}

}
