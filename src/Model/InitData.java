/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import algorithm.Merge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.Arrays;

/**
 *
 * @author Alic Jiang
 */
public class InitData {
	public Person[] personData;
	
	public InitData() {
		initialize(500);
	}
	
	public InitData(int len) {
		initialize(len);
	}
	
	public void initialize(int numOfPerson) {
		// initialize personData with the write length
		personData = new Person[numOfPerson];
		
		Path infile = Paths.get("src/Model/dist.names");
		try (InputStream in = Files.newInputStream(infile);
			BufferedReader reader
			= new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			// reading infile
			for(int i=0; i<numOfPerson; i++) {
				line = reader.readLine();
				String[] pieces = line.split(" ", 2);
				personData[i] = new Person(pieces[0], pieces[1]);
			}
		} catch (IOException x) {
			System.err.println(x);
		}
	}
	
	public Person[] getData() {
		return personData;
	}
	
	public void mergeSort() {
//		Merge.sortMerge(personData);
	}
	
	public static void main (String[] args) {
		InitData model = new InitData(500);
		Person[] data = model.getData();
		System.out.println(Arrays.toString(model.getData()));
		
		
	}
}
