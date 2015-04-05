/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alic Jiang
 */
public class PersonTest {

	/**
	 * Test of setFirstName and getFirstName method, of class Person.
	 */
	@Test
	public void testFirstName() {
		System.out.println("setFirstName");
		String first = "first";
		Person instance = new Person();
		instance.setFirstName(first);
		// TODO review the generated test code and remove the default call to fail.
		assertEquals("first", instance.getFirstName());
	}

	/**
	 * Test of setLastName and getLastName method, of class Person.
	 */
	@Test
	public void testSetLastName() {
		System.out.println("setLastName");
		String last = "last";
		Person instance = new Person();
		instance.setLastName(last);
		// TODO review the generated test code and remove the default call to fail.
		assertEquals("last", instance.getLastName());
	}

	/**
	 * Test of compareTo method, of class Person.
	 */
	@Test
	public void testCompareTo() {
		System.out.println("compareTo");
		String that = "";
		Person instance = new Person();
		int expResult = 0;
		int result = instance.compareTo(that);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toString method, of class Person.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Person instance = new Person("Luke", "Skywalker");
		String expResult = "Luke Skywalker";
		String result = instance.toString();
		assertEquals(expResult, result);
	}
	
}
