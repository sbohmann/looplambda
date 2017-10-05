package at.or.vogt.looplambda;

import java.io.*;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 *
 */
public class PerformanceTest {
    
    private static final boolean Debug = false;

    @Test
    public void testLoop() {
        final CodePrinter loop = new Loop();
        final CodePrinter splitstream = new SplitStream();
        
        loop.setDebugMode(Debug);
        splitstream.setDebugMode(Debug);
        
        try (InputStream fis = getClass().getResourceAsStream("llama.txt")) {
            final String code = IOUtils.toString(fis);
            
            final int maxloops = 50000;
            for (int i = 0; i < 5; i++) {
                preftestCodePrinter(code, loop, maxloops);
                preftestCodePrinter(code, splitstream, maxloops);
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void preftestCodePrinter(String code, final CodePrinter dut, final int maxLoops) {
        System.out.println("testing " + dut.getClass());
        
        final PrintStream original = System.out;
        
        final long start = System.currentTimeMillis();
        for (int i = 0; i < maxLoops; i++) {
            dut.printCode(code);
        }
        System.setOut(original);
        System.out.println("duration = " + (System.currentTimeMillis() - start));
        System.out.println(dut.getNumberOfLines() + " lines, " + dut.getNumberOfBytes() + " characters");
    }

}
