import java.util.HashMap;

public class NumberToWords {
    public String numberToWords(int num) {

        StringBuilder[] suf = new StringBuilder[4];

        for (int i = 0; i < 4; i++) {
            suf[i] = new StringBuilder();
        }

        HashMap<Integer, String> numberWordsMap = new HashMap<>();
        constructMap(numberWordsMap);

        int n = num, sufix = 0;

        while (n > 0) {
            appendSuffix(n % 1000, numberWordsMap, suf[sufix], sufix);
            n /= 1000;
            sufix++;
        }

        for (int i = 2; i >= 0; i--) {
            suf[3].append(suf[i]);
        }

        String s =suf[3].toString();
        return s.substring(0,s.length()-1);
    }

    private void appendSuffix(int n, HashMap<Integer, String> numberWordsMap, StringBuilder suf, int sufix) {

        if (n / 1000 > 0)
            throw new IllegalArgumentException("Greater number than 3 digits");

        if (n / 100 != 0) {
            suf.append(numberWordsMap.get(n / 100)).append(" ").append(numberWordsMap.get(100)).append(" ");
        }
        n %= 100;

        if (n < 20 && n >= 10) {
            suf.append(numberWordsMap.get(n)).append(" ");
        } else {
            if (n / 10 != 0) {
                suf.append(numberWordsMap.get(10 * (n / 10))).append(" ");
            }
            n %= 10;
            if (n != 0) {
                suf.append(numberWordsMap.get(n)).append(" ");
            }
        }

        // add suffix if !empty
        if (suf.isEmpty())return;

        if (sufix == 1) {
            // thousands
            suf.append(numberWordsMap.get(101)).append(" ");
        } else if (sufix == 2) {
            // millions
            suf.append(numberWordsMap.get(102)).append(" ");
        } else if (sufix == 3) {
            // billions
            suf.append(numberWordsMap.get(103)).append(" ");
        }
    }

    private void constructMap(HashMap<Integer, String> numberWordsMap) {
        numberWordsMap.put(0, "Zero");
        numberWordsMap.put(1, "One");
        numberWordsMap.put(2, "Two");
        numberWordsMap.put(3, "Three");
        numberWordsMap.put(4, "Four");
        numberWordsMap.put(5, "Five");
        numberWordsMap.put(6, "Six");
        numberWordsMap.put(7, "Seven");
        numberWordsMap.put(8, "Eight");
        numberWordsMap.put(9, "Nine");
        numberWordsMap.put(10, "Ten");
        numberWordsMap.put(11, "Eleven");
        numberWordsMap.put(12, "Twelve");
        numberWordsMap.put(13, "Thirteen");
        numberWordsMap.put(14, "Fourteen");
        numberWordsMap.put(15, "Fifteen");
        numberWordsMap.put(16, "Sixteen");
        numberWordsMap.put(17, "Seventeen");
        numberWordsMap.put(18, "Eighteen");
        numberWordsMap.put(19, "Nineteen");
        numberWordsMap.put(20, "Twenty");
        numberWordsMap.put(30, "Thirty");
        numberWordsMap.put(40, "Forty");
        numberWordsMap.put(50, "Fifty");
        numberWordsMap.put(60, "Sixty");
        numberWordsMap.put(70, "Seventy");
        numberWordsMap.put(80, "Eighty");
        numberWordsMap.put(90, "Ninety");
        numberWordsMap.put(100, "Hundred");
        numberWordsMap.put(101, "Thousand");
        numberWordsMap.put(102, "Million");
        numberWordsMap.put(103, "Billion");
    }

    public static void main(String[] args) {
        int n = 314490121;
        NumberToWords obj = new NumberToWords();
        System.out.println(obj.numberToWords(n));
    }
}
