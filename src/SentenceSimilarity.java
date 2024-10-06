public class SentenceSimilarity {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int i = 0;
        int j = 0;

        // Compare words from the beginning of both sentences
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }

        // Compare words from the end of both sentences
        while (j < words1.length - i && j < words2.length - i &&
                words1[words1.length - 1 - j].equals(words2[words2.length - 1 - j])) {
            j++;
        }

        // If all words have been checked and matched, the sentences are similar
        return i + j == words2.length || i + j == words1.length;
    }
}
