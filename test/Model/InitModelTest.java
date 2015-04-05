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
public class InitModelTest {

	/**
	 * Test of getModel method, of class InitModel.
	 */
	@Test
	public void testGetModel() {
		System.out.println("getModel");
		InitModel model1 = new InitModel();
		int len1 = model1.getModel().length;
		assertEquals(500, len1);
		
		InitModel model2 = new InitModel(1000);
		int len2 = model2.getModel().length;
		assertEquals(1000, len2);
	}
	
}
