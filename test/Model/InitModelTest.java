/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alic Jiang
 */
public class InitModelTest {

	/**
	 * Test of getModel method, of class InitData.
	 */
	@Test
	public void testGetModel() {
		System.out.println("getModel");
		InitData model1 = new InitData();
		int len1 = model1.getData().length;
		assertEquals(500, len1);
		
		InitData model2 = new InitData(1000);
		int len2 = model2.getData().length;
		assertEquals(1000, len2);
	}
	
}
