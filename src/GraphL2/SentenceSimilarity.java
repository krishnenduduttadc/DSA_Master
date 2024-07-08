package GraphL2;

import java.util.HashMap;

public class SentenceSimilarity {
    public static void main(String[] args) {
        // Hardcoded input
        int n = 3; // Number of words in each sentence
        String[] sentence1 = {"treat", "fight", "miss"};
        String[] sentence2 = {"like", "train", "lost"};
        int m = 4; // Number of pairs
        String[][] pairs = {
                {"treat", "catch"},
                {"train", "fight"},
                {"like", "catch"},
                {"miss", "lost"}
        };

        System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));
    }

    static HashMap<String, String> parent;
    static HashMap<String, Integer> rank;

    public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
        parent = new HashMap<>();
        rank = new HashMap<>();

        if (Sentence1.length != Sentence2.length) {
            return false;
        }

        // Union-find operations on pairs
        for (String[] p : pairs) {
            union(p[0], p[1]);
        }

        // Check similarity between Sentence1 and Sentence2
        for (int i = 0; i < Sentence1.length; i++) {
            String w1 = Sentence1[i];
            String w2 = Sentence2[i];

            if (!w1.equals(w2) && !find(w1).equals(find(w2))) {
                return false;
            }
        }
        return true;
    }

    static void union(String x, String y) {
        String lx = find(x);
        String ly = find(y);

        if (!lx.equals(ly)) {
            if (rank.getOrDefault(lx, 0) > rank.getOrDefault(ly, 0)) {
                parent.put(ly, lx);
            } else if (rank.getOrDefault(lx, 0) < rank.getOrDefault(ly, 0)) {
                parent.put(lx, ly);
            } else {
                parent.put(lx, ly);
                rank.put(ly, rank.getOrDefault(ly, 0) + 1);
            }
        }
    }

    static String find(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            rank.put(x, 1);
        }

        if (x.equals(parent.get(x))) {
            return x;
        }
        String temp = find(parent.get(x));
        parent.put(x, temp);
        return temp;
    }
}
