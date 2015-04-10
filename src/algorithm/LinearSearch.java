/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithm;
import Model.Person;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Alic Jiang
 */
public class LinearSearch {
	public static Person[] search (Person[] data, String input) {
		Stack<Person> stack = new Stack();
		input = input.toLowerCase();
		int len = input.length();
		System.out.println(len);
		for (Person person : data) {
			String fn = person.getFirstName().toLowerCase();
			String ln = person.getLastName().toLowerCase();
			System.out.println(fn + " " + ln);
//			if (fn.length() < len || ln.length() < len) {
//				System.out.println("continue");
//				continue;
//			}
			// if the name is shorter than the input, make it null, otherwise compare its substring
			if( (fn.length() < len ? (input) == null : fn.substring(0,len).equals(input))
				||
				(ln.length() < len ? (input) == null : ln.substring(0,len).equals(input)))
				stack.push(person);
		}
		Person[] result = new Person[stack.size()];
		for(int i=0; i<result.length; i++) {
			result[i] = stack.pop();
		}
		return result;
	} 
	
	public static void main (String[] args) {
		Person[] data = {new Person("sol", "Allender")};
		Person[] result = search(data, "allen");
		System.out.println(Arrays.toString(result));
	}
}
