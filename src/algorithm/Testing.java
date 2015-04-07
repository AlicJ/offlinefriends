package algorithm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import Model.InitData;
import Model.Person;

public class Testing {
	InitData model = new InitData(1000);
	Person[] personsFirst = new Person[1000];
	Person[] personsLast = new Person[1000];
	String[] firstNames = new String[personsFirst.length];
	String[] lastNames = new String[personsLast.length];
	
	@Before
	public void setUpBeforeClass() throws Exception {
		model.mergeSort();
		personsFirst = model.getData().clone();
		for(int i=0; i<personsFirst.length; i++){
			firstNames[i]=personsFirst[i].getFirstName();
		}
		
		model.mergeSortLast();
		personsLast = model.getData().clone();
		for(int i=0; i<personsLast.length; i++){
			lastNames[i]=personsLast[i].getLastName();
		}
	}

	@Test
	public void test() {
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
		// Test for Merge Sort
		// Goes though the list and compares each element to the previousW
		for(int i=1; i<personsFirst.length; i++){
			assertTrue(personsFirst[i].compareTo(personsFirst[i-1])>=0);
		}
		for(int i=1; i<personsLast.length; i++){
			assertTrue(personsLast[i].compareToLast(personsLast[i-1])>=0);
		}
		
		//initialize Binary Search for First Names
		ArrayList<Integer> firstNameRanks = new ArrayList<Integer> ();
		int rank = -2;		
		String[] temp = firstNames.clone();
		//searches for name
		//if name is found, record the rank, and remove the name from temp array
		//repeat until no results
		do{
			rank = BinarySearch.rank("John", temp);
			if (rank>=0){
				firstNameRanks.add(rank);
				temp[rank] = "";
			}
		} while(rank!=-1);
			
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
			rank = BinarySearch.rank("John", temp);
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
	}

}
