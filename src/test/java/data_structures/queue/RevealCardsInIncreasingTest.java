package data_structures.queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RevealCardsInIncreasingTest {
    private RevealCardsInIncreasing reveal;

    @BeforeEach
    public void setUp() {
        reveal = new RevealCardsInIncreasing();
    }

    @Test
    public void testExample1() {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        int[] expected = {2, 13, 3, 11, 5, 17, 7};
        int[] result = reveal.deckRevealedIncreasing(deck);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testExample2() {
        int[] deck = {1, 1000};
        int[] expected = {1, 1000};
        int[] result = reveal.deckRevealedIncreasing(deck);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEmptyDeck() {
        int[] deck = {};
        int[] expected = {};
        int[] result = reveal.deckRevealedIncreasing(deck);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSingleCard() {
        int[] deck = {42};
        int[] expected = {42};
        int[] result = reveal.deckRevealedIncreasing(deck);
        assertArrayEquals(expected, result);
    }
}
