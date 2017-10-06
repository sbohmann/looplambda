package at.or.vogt.looplambda;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 */
class SplitStream extends CodePrinter {
    private static final Pattern portableNewline = Pattern.compile("\\r?\\n");
    private static final Pattern compoundNewline = Pattern.compile("\\r\\n");
    private static final Pattern simpleNewline = Pattern.compile("\\n");
    
    private long numberOfBytes;

    @Override
    public void printCode(final String code) {
        // Arrays.asList(code.split("\\r?\\n")).stream().forEach(this::count);
        // Stream.of(code.split("\\r?\\n")).forEach(this::count);
        // count(code.replaceAll("\\r\\n", "\\n"));
        
        //Arrays.asList(simpleNewline.split(code.replace("\r\n", "\n"))).forEach(this::count);
        
//        for (String intermediate : compoundNewline.split(code))
//        {
//            for (String line : simpleNewline.split(intermediate))
//            {
//                count(line);
//            }
//        }
        
        Stream.of(compoundNewline.split(code))
            .flatMap(intermediate -> Stream.of(simpleNewline.split(intermediate)))
            .forEach(this::count);
            
        //Stream.of(portableNewline.split(code)).forEach(this::count);
        //Arrays.asList(portableNewline.split(code)).forEach(this::count);
    }
}
