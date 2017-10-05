package at.or.vogt.looplambda;

import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 */
class SplitStream extends CodePrinter {
    private final static Pattern portableNewline = Pattern.compile("\\r?\\n");
    
    private long numberOfBytes;

    @Override
    public void printCode(final String code) {
        // Arrays.asList(code.split("\\r?\\n")).stream().forEach(System.out::println);
        // Stream.of(code.split("\\r?\\n")).forEach(System.out::println);
        // System.out.println(code.replaceAll("\\r\\n", "\\n"));
        //Arrays.asList(code.replaceAll("\\\\r\\\\n", "\\n").split("\\n")).forEach(System.out::println);
    
        Stream.of(portableNewline.split(code)).forEach(this::count);
    }

}
