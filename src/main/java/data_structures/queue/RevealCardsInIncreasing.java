package data_structures.queue;

import java.util.Arrays;

public class RevealCardsInIncreasing {
        public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> deckIdx = new Queue<>(n);
        for (int i = 0; i < n; i++) {
            deckIdx.enqueue(i);
        }
        Arrays.sort(deck);
        int[] reOrdered = new int[n];
        for (int i = 0; i < n; i++) {
            reOrdered[deckIdx.dequeue()] = deck[i];
            if (i == n - 1) break;
            deckIdx.enqueue(deckIdx.dequeue());
        }
        return reOrdered;
    }
}
