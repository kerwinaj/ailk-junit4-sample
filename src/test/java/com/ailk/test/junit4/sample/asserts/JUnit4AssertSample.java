package com.ailk.test.junit4.sample.asserts;

import static com.ailk.test.hamcrest.machers.StartWith.startWith;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JUnit4AssertSample {
//6个：fnes
	@Test
	public void testAssertFalse() {
		assertFalse("failure - should be false", false);
	}
	
	@Test
	public void testAssertNull() {
		assertNull("should be null", null);
	}
	
	@Test
	public void testAssertNotNull() {
		assertNotNull("should not be null", new Object());
	}
	
	@Test
	public void testAssertEquals() {
		assertEquals("failure - strings not same", 5l, 5l);
	}

	@Test
	public void testAssertNotSame() {
		assertNotSame("should not be same Object", new Object(), new Object());
//		test by yuk:是不同的对象才会通过！
//		Object a = new Object();
//		assertNotSame("should not be same Object", a,a);
	}

	@Test
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		assertSame("should be same", aNumber, aNumber);
//		test by yuk:是相同的对象才会通过！
//		Object a = new Object();
//		assertSame("should not be same Object", a,a);
//		assertSame("", new Object(), new Object());
	}
	

	@Test
	public void testAssertArrayEquals() {
		byte[] expected = "trial".getBytes();
		byte[] actual = "trial".getBytes();
		assertArrayEquals("failure - byte arrays not same", expected, actual);
	}
	
	// JUnit Matchers assertThat
	@Test
	public void testAssertThatBothContainsString() {
		/*使用junit自带的Matcher*/
		assertThat("albumen", both(containsString("a")).and(containsString("b")));
		/*使用Core Hamcrest Matchers*/
//		assertThat("albumen",allOf(containsString("a"),containsString("b")));
	}

	@Test
	public void testAssertThathasItemsContainsString() {
		assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
	}

	@Test
	public void testAssertThatEveryItemContainsString() {
		assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
	}

	// Core Hamcrest Matchers with assertThat
	@Test
	public void testAssertThatHamcrestCoreMatchers() {
		assertThat("good", startWith("good"));
		/*
		 * allOf()==>必须要=bad,且必须要=good.
		 * not==>不需要(所以任何都是对的)
		 */
		assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
//		assertThat("good", not(allOf(equalTo("good"), equalTo("good"))));
		assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
		assertThat(new Object(), not(sameInstance(new Object())));
	}
}