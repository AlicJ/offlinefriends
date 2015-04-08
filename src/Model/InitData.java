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
import org.apache.commons.lang3.time.StopWatch;

/**
 *
 * @author Alic Jiang
 */
public class InitData {
	public Person[] personData;
	private final int MAX = 10000;
	private int interval = 1;
	
	public InitData() {
		initialize(500);
	}
	
	public InitData(int len) {
		initialize(len);
	}
	
	private void initialize(int numOfPerson) {
		// initialize personData with the write length
		personData = new Person[numOfPerson];
		interval = MAX/numOfPerson;
		System.out.println(interval);
				
		Path infile = Paths.get("src/Model/dist.names");
		try (InputStream in = Files.newInputStream(infile);
			BufferedReader reader
			= new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			// reading infile
			for(int i=0; i<numOfPerson; i++) {
				// use interval to minimize duplication on smaller sizes
				for (int j=0; j<interval; j++)
					line = reader.readLine();
				String[] pieces = line.split(" ", 2);
				personData[i] = new Person(pieces[0], pieces[1]);
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		// sort after reading names
		Merge.sortMerge(personData);
	}
	
	public Person[] getData() {
		return personData;
	}
	
	private void mergeSort() {
		Merge.sortMerge(personData);
	}
	
	public static void main (String[] args) {
		InitData model = new InitData(1000000);
		Person[] data = model.getData();
//		System.out.println(Arrays.toString(model.getData()));
		// merge sort
		StopWatch sw = new StopWatch();
		sw.start();
		double startTime = sw.getTime();
		model.mergeSort();
		double runTime = sw.getTime() - startTime;
		sw.stop();
		System.out.println(runTime);
//		System.out.println(Arrays.toString(model.getData()));
		
	}
}
