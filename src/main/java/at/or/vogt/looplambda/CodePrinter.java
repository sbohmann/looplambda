package at.or.vogt.looplambda;

/**
 *
 */
abstract class CodePrinter {
    private boolean debugMode;
    
    private long numberOfLines;
    private long numberOfBytes;
    
    abstract void printCode(final String code);
    
    long getNumberOfLines()
    {
        return numberOfLines;
    }
    
    long getNumberOfBytes()
    {
        return numberOfBytes;
    }
    
    void count(String line) {
        ++numberOfLines;
        numberOfBytes += line.length();
        
        if (debugMode) {
            System.out.println(line);
        }
    }
    
    void setDebugMode(boolean value) {
        debugMode = value;
    }
}
