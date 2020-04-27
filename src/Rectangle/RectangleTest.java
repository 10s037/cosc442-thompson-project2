

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The unit test Class for Rectangle.
 */
public class RectangleTest {

	/**
	 * Declaring necessary test objects for {@link Rectangle}
	 */
	Rectangle rect1, /**
	 * The Rect 2.
	 */
	rect2;

	/**
	 * Initializes the necessary test objects for the test cases to use.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		rect1 = new Rectangle(new Point(2.0, 2.0), new Point(4.0, 7.0));
		rect2 = new Rectangle(new Point(2.0, 6.0), new Point(4.0, 3.0));
	}

	/**
	 * Test for the getArea() method of the {@link Rectangle} class.
	 */
	@Test
	public void testGetArea() {
		assertEquals(25.0, rect1.getArea(),0.001);
		assertEquals(9.0, rect2.getArea(),0.001);
	}

	/**
	 * Test for the getDiagonal() method of the {@link Rectangle} class.
	 */
	@Test
	public void testGetDiagonal() {
		assertEquals(7.0710678118654755, rect1.getDiagonal(), 0.0001);
		assertEquals(4.242640687119285, rect2.getDiagonal(), 0.0001);
	}

	/**
	 * Cleans up test objects after a test case is executed.
	 */
	@After
	public void tearDown(){
		rect1 = null;
		rect2 = null;
	}
}
