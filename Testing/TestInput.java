import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tangible.Binarysearch;

public class TestInput {
	public Binarysearch test;
	String[] args = {"garland.in"};
	String[] wrongargs={"garl.txt"};
	String[] nill= {};
	@Before
	public void before() {
		test = new Binarysearch();
	}
	@Test
	public void Test() {
		assertTrue(test.fileRead(args));// проверяет истиность логических выражений или выполняемых методов если они имеют тип boolean
		assertTrue(!test.fileRead(wrongargs));
		assertTrue(test.fileRead(nill));
	}
	@After
	public void after() {
		test=null;
	}
}
