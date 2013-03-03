/**
 * 
 */
package com.dihuib.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Dihui Bao 
 *
 */
@RunWith(Parameterized.class)
public class JunitParameterizeTest {
	
	private int value;
	private int square;
	
	public JunitParameterizeTest(int value, int square) {
		this.value = value;
		this.square = square;
	}
	
	@Test
	public void testParameterize() {
		assertEquals((int)Math.pow(value, 2),square);
	}
	
	@Parameters
	public static Collection<?> data() {
		Object[][] data = new Object[][] {{1,1},{2,4},{3,9},{4,16}};
		return Arrays.asList(data);
	}
	
	

}
