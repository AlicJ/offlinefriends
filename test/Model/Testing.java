package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import Model.InitData;
import Model.Person;
import algorithm.BST;
import algorithm.BinarySearch;

public class Testing {
	InitData model = new InitData(1000);
	Person[] personsFirst = new Person[1000];
	Person[] personsLast = new Person[1000];
	String[] firstNames = new String[personsFirst.length];
	String[] lastNames = new String[personsLast.length];
	BST<String, Integer> firstNamesBST = new BST<String, Integer> ();
	BST<String, Integer> lastNamesBST = new BST<String, Integer> ();
	
	@Before
	public void setUpBeforeClass() throws Exception {
		model.mergeSortFirst();
		personsFirst = model.getData().clone();
		for(int i=0; i<personsFirst.length; i++){
			firstNames[i]=personsFirst[i].getFirstName();
			firstNamesBST.put(personsFirst[i].getFirstName(), i);
		}
		
		model.mergeSortLast();
		personsLast = model.getData().clone();
		for(int i=0; i<personsLast.length; i++){
			lastNames[i]=personsLast[i].getLastName();
			lastNamesBST.put(personsLast[i].getLastName(), i);
		}
	}

	@Test
	public void test() {
		// Arrays Debug
		System.out.println("DEBUG");
		System.out.println("_______________________________");
		System.out.println(Arrays.toString(firstNames));
		System.out.println(Arrays.toString(lastNames));
		String[] personsFirstString = new String[personsFirst.length];
		String[] personsLastString = new String[personsLast.length];
		for(int i=0; i<personsFirst.length; i++){
			personsFirstString[i]=personsFirst[i].toString();
		}
		for(int i=0; i<personsLast.length; i++){
			personsLastString[i]=personsLast[i].toString();
		}
		System.out.println(Arrays.toString(personsFirstString));
		System.out.println(Arrays.toString(personsLastString));
		
		/**
		 * MERGE SORT
		 */
		
		// Test for Merge Sort
		// Goes though the list and compares each element to the previousW
		for(int i=1; i<personsFirst.length; i++){
			assertTrue(personsFirst[i].compareTo(personsFirst[i-1])>=0);
		}
		for(int i=1; i<personsLast.length; i++){
			assertTrue(personsLast[i].compareToLast(personsLast[i-1])>=0);
		}
		
		/**
		 * BINARY SEARCH
		 */
		System.out.println();
		System.out.println("BINARY SEARCH RESULTS");
		System.out.println("_______________________________");
		//initialize Binary Search for First Names
		ArrayList<Integer> firstNameRanks = new ArrayList<Integer> ();
		Integer rank = -2;		
		String[] temp = firstNames.clone();
		
		//searches for name
		//if name is found, record the rank, and remove the name from temp array
		//repeat until no results
		while(rank!=-1){
			//System.out.println(Arrays.toString(temp));
			rank = BinarySearch.rank("Jon", temp);
			if (rank>=0){
				//System.out.println(rank + " | " + personsFirst[rank]);
				firstNameRanks.add(rank);
				//marks found name as FOUND with "%"
				temp[rank] += "%";
			}
		}
			
		Person[] firstNameResults = new Person[firstNameRanks.size()];
		for (int i=0; i<firstNameRanks.size(); i++){
			firstNameResults[i] = personsFirst[firstNameRanks.get(i)];
		}
		for (int i=0; i<firstNameResults.length; i++){
			System.out.println(firstNameResults[i].toString());
		}
		
		//initialize Binary Search for Last Names
		ArrayList<Integer> lastNameRanks = new ArrayList<Integer> ();
		rank = -2;		
		temp = lastNames.clone();
		
		//searches for name
		//if name is found, record the rank, and remove the name from temp array
		//repeat until no results
		do{
			rank = BinarySearch.rank("Jon", temp);
			if (rank>=0){
				lastNameRanks.add(rank);
				temp[rank] = "";
			}
		} while(rank!=-1);
			
		Person[] lastNameResults = new Person[lastNameRanks.size()];
		for (int i=0; i<lastNameRanks.size(); i++){
			lastNameResults[i] = personsLast[lastNameRanks.get(i)];
		}
		for (int i=0; i<lastNameResults.length; i++){
			System.out.println(lastNameResults[i].toString());
		}
		
		/**
		 *  BINARY SEARCH TREE
		 */
		System.out.println();
		System.out.println("BINARY SEARCH TREE RESULTS");
		System.out.println("_______________________________");
		//initialize Binary Search for First Names
		firstNameRanks = new ArrayList<Integer> ();
		rank = -2;		
		BST tempBST = new BST(firstNamesBST);
		
		//searches for name
		//if name is found, record the rank, and remove the name from temp array
		//repeat until no results
		while(rank != null){
			rank = (Integer) tempBST.get("Jon");
			if (rank != null){
				firstNameRanks.add(rank);
			}
		}
			
		firstNameResults = new Person[firstNameRanks.size()];
		for (int i=0; i<firstNameRanks.size(); i++){
			firstNameResults[i] = personsFirst[firstNameRanks.get(i)];
		}
		for (int i=0; i<firstNameResults.length; i++){
			System.out.println(firstNameResults[i].toString());
		}
		
		//initialize Binary Search for Last Names
		lastNameRanks = new ArrayList<Integer> ();
		rank = -2;		
		tempBST = new BST(lastNamesBST);
		
		//searches for name
		//if name is found, record the rank, and remove the name from temp array
		//repeat until no results
		while(rank != null){
			rank = (Integer) tempBST.get("Jon");
			if (rank != null){
				lastNameRanks.add(rank);
			}
		}
			
		lastNameResults = new Person[lastNameRanks.size()];
		for (int i=0; i<lastNameRanks.size(); i++){
			lastNameResults[i] = personsLast[lastNameRanks.get(i)];
		}
		for (int i=0; i<lastNameResults.length; i++){
			System.out.println(lastNameResults[i].toString());
		}
		
		
	}

}
