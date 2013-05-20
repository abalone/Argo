/**
 * 
 */
package com.dihuib.reflect.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Dihui Bao 
 *
 */
public class ReflectProxy {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazzProxy = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		
		System.out.println(clazzProxy.getName());
		
		Constructor[] constructors = clazzProxy.getConstructors();
		
		for(Constructor constractor : constructors) {
			System.out.println(constractor.getName());
		}
		
		for(Method method : clazzProxy.getDeclaredMethods()) {
			System.out.println(method.getName());
			System.out.println(Arrays.asList(method.getParameterTypes()));
		}
		
		Constructor constructor = clazzProxy.getConstructor(InvocationHandler.class);
		
		Collection proxyBuildCollection = (Collection) constructor.newInstance(new InvocationHandler() {
			
			ArrayList target = new ArrayList();

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				System.out.println("before...");
				Object result = method.invoke(target, args);
				System.out.println("after...");
				return result;
			}
			
		});
		
		proxyBuildCollection.clear();
		proxyBuildCollection.add("abc");
		proxyBuildCollection.add("abc");
		
		System.out.println(proxyBuildCollection.size());
		System.out.println(proxyBuildCollection.getClass().getName());
		
		
	}

}
