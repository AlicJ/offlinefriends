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
import java.util.Random;
import org.apache.commons.lang3.text.WordUtils;

public class GenerateNames {

	private static final String[] maleFirst = new String[1219];
	private static final String[] femaleFirst = new String[4274];
	private static final String[] last = new String[88798];

	private static final String[] names = new String[10000];

	public static void main(String args[]) {

		// read all (1219) male firstnames
		Path infile = Paths.get("src/Model/dist.male.first");
		try (InputStream in = Files.newInputStream(infile);
			BufferedReader reader
			= new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			// reading infile
			int count = 0;
			while ((line = reader.readLine()) != null) {
				String[] pieces = line.split(" ", 2);
				maleFirst[count] = pieces[0];
				count++;
			}
		} catch (IOException x) {
			System.err.println(x);
		}

		// read all 4275 female firstnames
		infile = Paths.get("src/Model/dist.female.first");
		try (InputStream in = Files.newInputStream(infile);
			BufferedReader reader
			= new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			// reading infile
			int count = 0;
			while ((line = reader.readLine()) != null) {
				String[] pieces = line.split(" ", 2);
				femaleFirst[count] = pieces[0];
				count++;
			}
		} catch (IOException x) {
			System.err.println(x);
		}

		// read all 88799 lastnames
		infile = Paths.get("src/Model/dist.all.last");
		try (InputStream in = Files.newInputStream(infile);
			BufferedReader reader
			= new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			// reading infile
			int count = 0;
			while ((line = reader.readLine()) != null) {
				String[] pieces = line.split(" ", 2);
				last[count] = pieces[0];
				count++;
			}
		} catch (IOException x) {
			System.err.println(x);
		}

		// check all name arrays do not have null elements
		for (int i = 0; i < maleFirst.length; i++) {
			if (maleFirst[i] == null) {
				System.out.println(i + "null");
				break;
			}
		}
		System.out.println("male first check complete");
		// female
		for (int i = 0; i < femaleFirst.length; i++) {
			if (femaleFirst[i] == null) {
				System.out.println(i + "null");
				break;
			}
		}
		System.out.println("female first check complete");
		// female
		for (int i = 0; i < last.length; i++) {
			if (last[i] == null) {
				System.out.println(i + "null");
				break;
			}
		}
		System.out.println("first name check complete");

		// generate 1 million names
		Random random = new Random();
		String fn;
		String ln;
		for (int i = 0; i < names.length; i++) {
			if (i%2 == 0) // get a female first name
				fn = femaleFirst[random.nextInt(femaleFirst.length)];
			else// get a male first name
				fn = maleFirst[random.nextInt(maleFirst.length)];
			// get a last name
			ln = last[random.nextInt(last.length)];
			// combine firstname and lastname
			names[i] = WordUtils.capitalizeFully(fn + " " + ln + "\n");
		}
		
		// check if has null elements
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				System.out.println(i + "null");
				break;
			}
		}
		System.out.println("names check complete");
		
		// sort the names
//		Merge.sortMerge(names);

		// write 1 million names to file
		Path outfile = Paths.get("src/Model/dist.names");
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedWriter writer = Files.newBufferedWriter(outfile, charset)) {
			for (String name : names) {
				// write to file
				writer.write(name, 0, name.length());
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
}
