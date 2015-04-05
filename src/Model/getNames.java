/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template infile, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Alic Jiang
 */
import java.nio.file.*;
import java.nio.charset.*;
import java.io.*;
import java.util.Arrays;

public class getNames {
	
	private static String[] first = new String[2000];
	private static String[] last = new String[2000];

	public static void main(String args[]) {
		// read 1000 male firstnames
		Path infile = Paths.get("src/Model/dist.male.first");
		try (InputStream in = Files.newInputStream(infile);
			BufferedReader reader
			= new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			// reading infile
			for(int i=0; i<1000; i++) {
				line = reader.readLine();
				String[] pieces = line.split(" ", 2);
				first[i] = pieces[0];
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		// read 1000 female firstnames
		infile = Paths.get("src/Model/dist.female.first");
		try (InputStream in = Files.newInputStream(infile);
			BufferedReader reader
			= new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			// reading infile
			for(int i=1000; i<2000; i++) {
				line = reader.readLine();
				String[] pieces = line.split(" ", 2);
				first[i] = pieces[0];
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		// read 2000 lastnames
		infile = Paths.get("src/Model/dist.all.last");
		try (InputStream in = Files.newInputStream(infile);
			BufferedReader reader
			= new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			// reading infile
			for(int i=0; i<2000; i++) {
				line = reader.readLine();
				String[] pieces = line.split(" ", 2);
				last[i] = pieces[0];
			}
		} catch (IOException x) {
			System.err.println(x);
		}

		// write names to file
		Path outfile = Paths.get("src/Model/names");
		Charset charset = Charset.forName("US-ASCII");
		String s;
		try (BufferedWriter writer = Files.newBufferedWriter(outfile, charset)) {
			for (int i=0; i<2000; i++) {
				// combine firstname and lastname
				s = first[i] + " " + last[i] + "\n";
				// write to file
				writer.write(s, 0, s.length());
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
}
