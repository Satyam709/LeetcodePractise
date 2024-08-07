import java.util.HashMap;

public class NumberToWords {
    public String numberToWords(int num) {

        if (num == 0)
            return "Zero";

        StringBuilder suf = new StringBuilder();

        HashMap<Integer, String> numberWordsMap = new HashMap<>();
        constructMap(numberWordsMap);

        int n = num, sufix = 3;

        while (n > 0) {
            int factor = (int) Math.pow(1000, sufix);
            appendSuffix(n / factor, numberWordsMap, suf, sufix);
            n %= factor;
            sufix--;
        }
        String s = suf.toString();
        return s.substring(0, s.length() - 1);
    }

    private void appendSuffix(int n, HashMap<Integer, String> numberWordsMap, StringBuilder suf, int sufix) {

        if (n == 0) return;

        if (n >= 100) {
            suf.append(numberWordsMap.get(n / 100)).append(" ").append(numberWordsMap.get(100)).append(" ");
            n %= 100;

        }
        if (n >= 20) {
            suf.append(numberWordsMap.get(10 * (n / 10))).append(" ");
            n %= 10;
        }
        if (n > 0)
            suf.append(numberWordsMap.get(n)).append(" ");

        // add suffix
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
        int n = 1000010;
        NumberToWords obj = new NumberToWords();
        System.out.println(obj.numberToWords(n));
    }
}
