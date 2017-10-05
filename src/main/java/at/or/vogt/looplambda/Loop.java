package at.or.vogt.looplambda;

/**
 *
 */
class Loop extends CodePrinter {

    @Override
    public void printCode(final String code) {
        int offset = 0;
        final int size = code.length();
        boolean wasCarriageReturn = false;
        for (int index = 0; index < size; ++index) {
            final boolean isCarriageReturn = (code.charAt(index) == '\r');
            final boolean isNewline = (code.charAt(index) == '\n');

            if (wasCarriageReturn && isNewline) {
                continue;
            }

            if (isCarriageReturn || isNewline) {
                count(code.substring(offset, index));
                offset = index + 1;
            }

            wasCarriageReturn = isCarriageReturn;
        }
    
        String lastLine = code.substring(offset, size);
        if (lastLine.length() > 0) {
            count(lastLine);
        }
    }

}
