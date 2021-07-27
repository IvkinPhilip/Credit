
public class Assert {

    public static void assertEquals(String testName, Object expected, Object actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " test passed ");
        } else {
            System.out.println(testName + " test failed ");
        }
    }
}

