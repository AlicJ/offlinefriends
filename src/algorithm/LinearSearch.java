/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithm;
import Model.Person;
import java.util.Stack;

/**
 *
 * @author Alic Jiang
 */
public class LinearSearch {
	public static Person[] search (Person[] data, String input) {
		Stack<Person> stack = new Stack();
		input = input.toLowerCase();
		for (Person person : data) {
			String fn = person.getFirstName().toLowerCase();
			String ln = person.getLastName().toLowerCase();
			if(fn.contains(input) || ln.contains(input))
				stack.push(person);
		}
		Person[] result = new Person[stack.size()];
		for(int i=0; i<result.length; i++) {
			result[i] = stack.pop();
		}
		return result;
	} 
}
