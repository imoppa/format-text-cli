package com.formattextcli.app;

import java.util.Arrays;
import java.util.List;

/**
 * FORMAT TEXT CLI APP Class
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Cli cli = new Cli();
        cli.start(args);
    }
}

//
//package com.formattextcli.app;
//
//        import java.util.Arrays;
//        import java.util.List;
//
//public class Cli {
//    // TODO: read this from config file
//    private String _version = "1.0.0";
//
//    public Cli() { }
//
//    public void start(String[] _args) {
//        List<String> args = Arrays.asList(_args);
//
//        while (!args.isEmpty()) {
//            String firstCommand = args.get(0);
//
//            if (firstCommand.equals("-version")) {
//                System.out.println("Version: " + this._version);
//                return;
//            }
//
//            return;
//        }
//    }
//}


//
//package com.formattextcli.app;
//
//        import org.junit.Test;
//        import org.junit.jupiter.api.Test;
//
///**
// * Unit test for simple App.
// */
//class AppTest
////    extends TestCase
//{
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
////    public AppTest( String testName )
////    {
////        super( testName );
////    }
//
//    /**
//     * @return the suite of tests being tested
//     */
////    public static Test suite()
////    {
////        return new TestSuite( AppTest.class );
////    }
//
//    /**
//     * Rigourous Test :-)
//     */
////    public void testApp()
////    {
////        assertTrue( true );
////    }
//
//    @Test
//    void givenRadius_whenCalculateArea_thenReturnArea() {
////        double actualArea = Circle.calculateArea(1d);
////        double expectedArea = 3.141592653589793;
////        Assert.assertEquals(expectedArea, actualArea);
//    }
//}
