package actividad.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.src.CircularlyLinkedList;

public class TestJUCircularlyLinkedList {
    
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearh() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");

		Assert.assertEquals(list.search("A"), "A");
		Assert.assertEquals(list.search("D"), "D");
		Assert.assertNull(list.search("Z"));
	}

	@Test
	public void testConcatenate() {
		CircularlyLinkedList<String> list1 = new CircularlyLinkedList<String>();
		list1.addLast("A");
		list1.addLast("B");
		list1.addLast("C");
		CircularlyLinkedList<String> list2 = new CircularlyLinkedList<String>();
		list2.addLast("D");
		list2.addLast("E");
		list1.concatenate(list2);

		CircularlyLinkedList<String> listTest = new CircularlyLinkedList<String>();
		listTest.addLast("A");
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");
		listTest.addLast("E");

		Assert.assertEquals(list1, listTest);
	}

	@Test
	public void testAddPos1() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addPos("Z", 0);

		CircularlyLinkedList<String> listTest = new CircularlyLinkedList<String>();
		listTest.addLast("Z");
		listTest.addLast("A");
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");

		Assert.assertEquals(list, listTest);
	}

	@Test
	public void testAddPos2() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addLast("Z");
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addPos("Y", 5);

		CircularlyLinkedList<String> listTest = new CircularlyLinkedList<String>();
		listTest.addLast("Z");
		listTest.addLast("A");
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");
		listTest.addLast("Y");

		Assert.assertEquals(list, listTest);

	}

	@Test
	public void testAddPos3() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addLast("Z");
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("Y");
		list.addPos("X", 5);
		
		CircularlyLinkedList<String> listTest = new CircularlyLinkedList<String>();
		listTest.addLast("Z");
		listTest.addLast("A");
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");
		listTest.addLast("X");
		listTest.addLast("Y");

		Assert.assertEquals(list, listTest);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddPos4() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addPos("X", -1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddPos5() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addPos("X", 1);
	}

	@Test
	public void testRemovePos1() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");
		String s= list.removePos(0);

		CircularlyLinkedList<String> listTest = new CircularlyLinkedList<String>();
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");
		listTest.addLast("E");

		Assert.assertEquals(list, listTest);
		Assert.assertEquals(s,"A");
	}

	@Test
	public void testRemovePos2() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");
		String s= list.removePos(3);

		CircularlyLinkedList<String> listTest = new CircularlyLinkedList<String>();
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");

		Assert.assertEquals(list, listTest);
		Assert.assertEquals(s,"E");
	}

	@Test
	public void testRemovePos3() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		String s= list.removePos(1);

		CircularlyLinkedList<String> listTest = new CircularlyLinkedList<String>();
		listTest.addLast("B");
		listTest.addLast("D");
	
		Assert.assertEquals(list, listTest);
		Assert.assertEquals(s,"C");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemovePos4() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.removePos(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemovePos5() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.removePos(1);
	}

	@Test
	public void testRemoveElement1() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");
		String s= list.removeElement("W");
		
		CircularlyLinkedList<String> listTest = new CircularlyLinkedList<String>();
		listTest.addLast("A");
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");
		listTest.addLast("E");
		
		Assert.assertEquals(list, listTest);
		Assert.assertNull(s);
		
	}

	@Test
	public void testRemoveElement2() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");
		String s =list.removeElement("C");
		
		CircularlyLinkedList<String> listTest = new CircularlyLinkedList<String>();
		listTest.addLast("A");
		listTest.addLast("B");		
		listTest.addLast("D");
		listTest.addLast("E");
		
		Assert.assertEquals(list, listTest);
		Assert.assertEquals(s,"C");
	}
	
	@Test
	public void testRemoveElement3() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");		
		list.addLast("D");
		list.addLast("E");		
		String s= list.removeElement("A");
			
		CircularlyLinkedList<String> listTest = new CircularlyLinkedList<String>();
		listTest.addLast("B");		
		listTest.addLast("D");
		listTest.addLast("E");
		
		Assert.assertEquals(list, listTest);
		Assert.assertEquals(s,"A");
	}
	
	@Test
	public void testRemoveElement4() {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addLast("B");		
		list.addLast("D");
		list.addLast("E");		
		String s= list.removeElement("E");
		
		CircularlyLinkedList<String> listTest = new CircularlyLinkedList<String>();
		listTest.addLast("B");		
		listTest.addLast("D");		
		
		Assert.assertEquals(list, listTest);
		Assert.assertEquals(s,"E");
	}
}