package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

//Test Life Cycle -Vedio-15

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
	
	public MathUtilsTest()
	{
		System.out.println("Default Constructor MathUtilsTest");
	}

	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;

	@BeforeAll
	void beforeAllinit()
	{
		System.out.println(" @BeforeAll is Running..");
		System.out.println("This method is run before initialisation of MathUtilsTest Class,so it should be Static");
	}
	
	@AfterAll
	void afterAllinit()
	{
		System.out.println(" @AfterAll is Running..");
		System.out.println("This method is run After initialisation of MathUtilsTest Class,so it should be Static");
	}
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		mathUtils = new MathUtils();
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		
		testReporter.publishEntry("Running :"+testInfo.getDisplayName()+": with tags "+testInfo.getTags());
	}
	
	@AfterEach
	void cleanUp()
	{
		System.out.println("AfterEach Cleaning Up..!!");
	}

	@Nested
	@DisplayName("Add Method Test")
	@Tag("Math")
	class AddTest
	{
		@Test
		@DisplayName("When adding two Possitive Numbers")
		void addPossNo() {
			// fail("Not yet implemented");
			System.out.println("This is test Run!!");
			int expected = 8;
			int actual = mathUtils.add(3, 5);
			
			//assertEquals(expected, actual,"should return sum "+expected+" but returned "+actual);
			//to increase performance use lambda expression
			//Now this string is only computed if out test case fails.()->"should return sum "+expected+" but returned "+actual
			assertEquals(expected, actual,()->"should return sum "+expected+" but returned "+actual);
			
		}
		
		@Test
		@DisplayName("Add 2 Negative Numbers")
		void addNegNo()
		{
			int expected = -8;
			int actual = mathUtils.add(-3, -5);
			assertEquals(expected, actual);
		}
		
		@Test
		@DisplayName("Add 0 & Negative Numbers")
		void addZeroNegNo()
		{
			int expected = -5;
			int actual = mathUtils.add(0, -5);
			assertEquals(expected, actual);
		}
		
		@Test
		@DisplayName("Add 0 & Possitive Numbers")
		void addZeroPosNo()
		{
			int expected = 5;
			int actual = mathUtils.add(0,5);
			assertEquals(expected, actual);
		}
	}
	

	@RepeatedTest(4)
	@EnabledOnOs(OS.WINDOWS)
	@DisplayName("Calculate Area of Circle")
	@Tag("Circle")
	void testComputeCircleArea(RepetitionInfo repetitionInfo) {
		System.out.println("repetitionInfo.getCurrentRepetition() :"+repetitionInfo.getCurrentRepetition());
		System.out.println("repetitionInfo.getTotalRepetitions()  :"+repetitionInfo.getTotalRepetitions());
		
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right Circle Area");
	}

	@Test
	@DisplayName("Testing Divide by 0")
	@Tag("Math")
	void testDivide() {
		
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		//server Up
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(5, 0), "Divide by zero should throw");
		// assertThrows(NullPointerException.class, ()->mathUtils.divide(5, 0), "Divide
		// by zero should throw");
	}
	
	@Test
	@DisplayName("TDD(Test Driven Developement) should not run")
	@Disabled
	void testDisabled()
	{
		fail("This test should be disabled");
	}

	@Test
	@DisplayName("Test Multiply Method")
	@Tag("Math")
	void testMultiply()
	{
		System.out.println("Running :"+testInfo.getDisplayName()+": with tags "+testInfo.getTags());
		testReporter.publishEntry("Running :"+testInfo.getDisplayName()+": with tags "+testInfo.getTags());
		assertAll(
				()-> assertEquals(4, mathUtils.multiply(2, 2)),
				()-> assertEquals(-4, mathUtils.multiply(-2, 2)),
				()-> assertEquals(0, mathUtils.multiply(0, 2)),
				()-> assertEquals(6, mathUtils.multiply(1, 6))
				);
	}
}
