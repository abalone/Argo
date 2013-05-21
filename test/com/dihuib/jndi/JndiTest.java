/**
 * 
 */
package com.dihuib.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

/**
 * @author Dihui Bao 
 *
 */
public class JndiTest {
	
	@Test
	public void testJndi() throws NamingException {
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		System.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		System.setProperty(Context.PROVIDER_URL, "jnp://localhost:1099");
		
		InitialContext ic = new InitialContext();
		
        ic.createSubcontext("java:/comp");
        ic.createSubcontext("java:/comp/env");
        ic.createSubcontext("java:/comp/env/jdbc");
        ic.bind("java:/comp/env/jdbc/nameofmyjdbcresource", "datasource");
        
        System.out.println((String)ic.lookup("java:/comp/env/jdbc/nameofmyjdbcresource"));
        
        ic.unbind("java:/comp/env/jdbc/nameofmyjdbcresource");
        

	}
}
