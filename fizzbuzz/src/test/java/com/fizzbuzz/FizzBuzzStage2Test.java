package com.fizzbuzz;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public final class FizzBuzzStage2Test {

	private static final PrintStream originalOut = System.out;

	private ByteArrayOutputStream outContent;
	private String expected;
	private FizzBuzzGame fizzBuzz;

	@Before
	public void setUp() throws Exception {

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		try (InputStream in = getClass().getResourceAsStream("/stage2-expected.txt")) {
			byte[] readArray = new byte[in.available()];
			in.read(readArray);
			expected = new String(readArray, StandardCharsets.UTF_8);
			expected = expected.replaceAll("\\s+", "");
		}
		Assert.assertTrue(expected != null && !expected.isEmpty());

		fizzBuzz = new FizzBuzzGame();
	}

	private String getConsole() {
		return new String(outContent.toByteArray(), StandardCharsets.UTF_8).replaceAll("\\s+", "");
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeNumber() {

		fizzBuzz.playFizzBuzz(-1, FizzBuzzStage.STAGE2);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNoStage() {

		fizzBuzz.playFizzBuzz(100, null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testZeroNumber() {

		fizzBuzz.playFizzBuzz(0, FizzBuzzStage.STAGE2);

	}

	@Test
	public void testExpected10() {

		StringBuilder b = new StringBuilder();
		b.append("1");
		b.append("2");
		b.append("Fizz");
		b.append("4");
		b.append("Buzz");
		b.append("Fizz");
		b.append("7");
		b.append("8");
		b.append("Fizz");
		b.append("Buzz");

		fizzBuzz.playFizzBuzz(10, FizzBuzzStage.STAGE2);

		Assert.assertEquals(b.toString(), getConsole());

	}

	@Test
	public void testExpected100() {

		fizzBuzz.playFizzBuzz(100, FizzBuzzStage.STAGE2);

		Assert.assertEquals(expected, getConsole());

	}

}
