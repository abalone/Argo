/**
 * 
 */
package com.dihuib.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Dihui Bao 
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({JunitBeforeAfterTest.class, JunitParameterizeTest.class, JunitTimeoutTest.class})
public class JunitSuiteTest {
	//Nothing needed
}
