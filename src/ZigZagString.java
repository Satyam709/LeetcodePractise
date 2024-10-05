public class ZigZagString {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s; // No need to zigzag if only one row or string length is less than numRows
        }

        StringBuilder out = new StringBuilder(s.length());
        int len = s.length();
        int cycleLen = 2 * (numRows - 1);

        // Process the first row
        for (int i = 0; i < len; i += cycleLen) {
            out.append(s.charAt(i));
        }

        // Process the middle rows
        for (int row = 1; row < numRows - 1; row++) {
            for (int i = row; i < len; i += cycleLen) {
                out.append(s.charAt(i));
                int secondCharIndex = i + cycleLen - 2 * row;
                if (secondCharIndex < len) {
                    out.append(s.charAt(secondCharIndex));
                }
            }
        }

        // Process the last row
        for (int i = numRows - 1; i < len; i += cycleLen) {
            out.append(s.charAt(i));
        }

        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // Expected output: "PAHNAPLSIIGYIR"
    }
}
