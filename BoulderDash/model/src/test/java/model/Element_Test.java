package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.Element;

public class Element_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getX_test() {
		Element element = new Element(null, null);
		final int expected = 5;

		element.setX(expected);
		
		assertEquals("", expected, element.getX());
	}
	
	@Test
	public void getY_test() {
		Element element = new Element(null, null);
		final int expected = 3;

		element.setY(expected);
		
		assertEquals("", expected, element.getY());
	}
	
	@Test
	public void test() {
		
	}
}
