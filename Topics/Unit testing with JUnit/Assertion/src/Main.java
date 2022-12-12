class CalculatorTest {
    void testAddition() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(10, calculator.add(6, 4));
    }
}