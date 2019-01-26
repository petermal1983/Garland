package tangible;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {
	package tangible;

	import static org.junit.jupiter.api.Assertions.*;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	/**
	 * @author Петр
	 *
	 */
	class BinarysearchTest2 {

		public Binarysearch test;
		String[] args = {"garland.in"};
		String[] wrongargs={"garl.txt"};
		String[] nill= {};
		@Before
		public void before() {
			test = new Binarysearch();
		}
		@Test
		public void fullTest() {
			//Обычный прогон, все файлы есть
			assertTrue(test.fileRead(args));
			assertTrue(test.modeling());
			assertEquals(1,test.writeFile("garl.out",args));
			
		}
		@Test
		public void fullTest2() {
			//Не верный файла ввода, вывод через консоль
			assertTrue(test.fileRead(wrongargs));
			assertTrue(test.modeling());
			assertEquals(0,test.writeFile("garl.out",args));
		}
		@Test
		public void fullTest3() {
			//Нету файла ввода, вывод через консоль
			assertTrue(test.fileRead(nill));
			assertTrue(test.modeling());
			assertEquals(0,test.writeFile("garl.out",args));
		}
		@Test
		public void fullTest4() {
			//Не верный файл ввода, в консоли ошибка, вывода нет
			assertTrue(!test.fileRead(nill));
			assertTrue(!test.modeling());
			assertEquals(-1,test.writeFile("garl.out",args));
		}
		@After
		public void after() {
			
			test=null;
		}
		

		
		/*@Test
		public void testInput() {
			assertTrue(test.fileRead(args));// проверяет истиность логических выражений или выполняемых методов если они имеют тип boolean
			//assertTrue(!test.fileRead(wrongargs));
			assertTrue(test.fileRead(nill));
		}
		@Test
		public void testOutput() {
			test.modeling();
			assertEquals(1,test.writeFile("garl.out",args));
			assertEquals(1, test.writeFile("garland.out", args));// Метод проверяющий равенство первого значения и значения возвращаемое методом. То есть проверяем равны ли ожидаемое значение и получаемое
		}*/

	}
}
