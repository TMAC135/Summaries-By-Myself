package JunitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
	private Main main;

	@Before
	public void setUp() throws Exception {
		main = new Main();
	}

	@After
	public void tearDown() throws Exception {
		main = null;
	}

	@Test
	public void testConcatenate() {
//		Main main = new Main();
		assertEquals("onetwo",main.concatenate("one", "two"));
	}

	@Test
	public void testAdd() {
//		Main main = new Main();
		assertEquals(4,main.add(3, 1));
	}

}
