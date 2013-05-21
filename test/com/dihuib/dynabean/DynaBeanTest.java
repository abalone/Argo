/**
 * 
 */
package com.dihuib.dynabean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaBean;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

/**
 * @author Dihui Bao 
 *
 */
public class DynaBeanTest {
	
	@Test
	public void testPropertyAccess() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Employee employee = new Employee("Dihui", "Bao");
		assertThat((String)PropertyUtils.getSimpleProperty(employee, "firstName"), equalTo("Dihui"));
	}
	
	@Test
	public void testLazyDynaBean() {
		LazyDynaBean lazyDynaBean = new LazyDynaMap();
		lazyDynaBean.set("a", "b");
		assertThat((String)lazyDynaBean.get("a"),equalTo("b"));
		lazyDynaBean.set("list", 3, new Employee("Dihui","Bao"));
		lazyDynaBean.set("list", 2, "Dihui Bao");
		assertThat((Employee)lazyDynaBean.get("list", 3),equalTo(new Employee("Dihui","Bao")));
		assertThat((String)lazyDynaBean.get("list", 2),equalTo("Dihui Bao"));
		assertThat(((List<?>)lazyDynaBean.get("list")).size(),equalTo(4));
		
		lazyDynaBean.set("map", "dihui", new Employee("Dihui","Bao"));
		assertThat((Employee)lazyDynaBean.get("map", "dihui"),equalTo(new Employee("Dihui","Bao")));
		assertThat(((Map<String,?>)lazyDynaBean.get("map")).size(),equalTo(1));
	}
}
