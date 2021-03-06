import org.junit.jupiter.api.*;
import shapes.Circle;
import shapes.Triangle;

public class AreaTest {

    @BeforeAll // it is a lifecycle method and equivalent to @BeforeClass annotation in JUnit 4.
    static void initAll() {
        System.out.println("Welcome to the JUnit 5 tutorial");
    }

    @BeforeEach // will be called before every new test case
    void init() {
        System.out.println("initializing new test case");
    }

    @AfterEach // will be called after every test case
    void turnOffTest() {
        System.out.println("Test case ended.");
    }

    @AfterAll // will be called after all test cases run
    static void turnOffAllTests() {
        System.out.println("All test cases run");
    }

    @Test
    @DisplayName("Succeeded circle area test") // developer can declare custom names to the test case.
    public void testCalculateCircleAreaSuccess() {
        Circle circle = new Circle(1.5);
        Assertions.assertEquals(circle.calculateArea(), Math.PI * Math.pow(1.5, 2.0));
    }

    @Test
    @DisplayName("failed Test")
    public void testCalculateCircleAreaFail() {
        Assertions.fail("circle tests failed");
    }

    @Test //It will print the method's name as name.
    public void testCalculateTriangleAreaSuccess() {
        Triangle triangle = new Triangle(1.5, 3.5);
        Assertions.assertEquals(triangle.calculateArea(), (1.5 * 3.5) / 2);
    }

    // Grouped tests execute together. If any of them fails, the whole test fails.
    @Test
    public void groupedAssertions() {
        double radius = 1.5;
        Circle circle = new Circle(radius);
        Assertions.assertAll("circle",
                () -> Assertions.assertEquals(Math.PI * radius, circle.calculateCircumference()),
                () -> Assertions.assertEquals(Math.PI * radius, circle.calculateArea()));
    }

    @Test // Expected exceptions can be tested using assertThrows
    public void exceptionTesting() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> { int i = 1 / 0;});
    }
}
