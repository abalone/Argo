/**
 * 
 */
package com.dihuib.aspectj;

import com.dihuib.aspectj.annotation.Transactional;

/**
 * @author Dihui Bao 
 *
 */
public class OneComponent {
	@Transactional
	public boolean hi(String name) {
		System.out.println(name);
		return true;
	}
	
	@Transactional
	public boolean hihi(String name, String greeting) {
		System.out.println(name + "," + greeting);
		return true;
	}
	
	public static void main(String[] args) {
		
		new OneComponent().hi("Dihui");
		new OneComponent().hihi("Dihui", "hello");
	}

}
