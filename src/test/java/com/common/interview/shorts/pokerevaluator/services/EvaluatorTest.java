package com.common.interview.shorts.pokerevaluator.services;

import com.common.interview.shorts.pokerevaluator.model.Card;
import com.common.interview.shorts.pokerevaluator.model.Pattern;
import com.common.interview.shorts.pokerevaluator.model.Rank;
import com.common.interview.shorts.pokerevaluator.model.Suit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static com.common.interview.shorts.pokerevaluator.model.Pattern.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EvaluatorTest {

    @ParameterizedTest
    @MethodSource("hands")
    void evaluationTest(Pattern expectation, Set<Card> cards) {
        assertEquals(expectation, Evaluator.evaluate(cards));
    }

    private static Stream<Arguments> hands() {
        return Stream.of(
                arguments(FULL_HOUSE, Set.of(
                        new Card(Rank.ACE, Suit.CLUB),
                        new Card(Rank.ACE, Suit.DIAMOND),
                        new Card(Rank.ACE, Suit.HEART),
                        new Card(Rank.EIGHT, Suit.SPADE),
                        new Card(Rank.EIGHT, Suit.CLUB))
                ),
                arguments(THREE_OF_A_KIND, Set.of(
                        new Card(Rank.ACE, Suit.CLUB),
                        new Card(Rank.ACE, Suit.DIAMOND),
                        new Card(Rank.ACE, Suit.HEART),
                        new Card(Rank.EIGHT, Suit.SPADE),
                        new Card(Rank.FIVE, Suit.CLUB))
                ),
                arguments(TWO_PAIR, Set.of(
                        new Card(Rank.ACE, Suit.CLUB),
                        new Card(Rank.ACE, Suit.DIAMOND),
                        new Card(Rank.FIVE, Suit.HEART),
                        new Card(Rank.EIGHT, Suit.SPADE),
                        new Card(Rank.EIGHT, Suit.CLUB))
                ),
                arguments(PAIR, Set.of(
                        new Card(Rank.ACE, Suit.CLUB),
                        new Card(Rank.ACE, Suit.DIAMOND),
                        new Card(Rank.FIVE, Suit.HEART),
                        new Card(Rank.JACK, Suit.SPADE),
                        new Card(Rank.EIGHT, Suit.CLUB))
                ),
                arguments(NOTHING, Set.of(
                        new Card(Rank.ACE, Suit.CLUB),
                        new Card(Rank.KING, Suit.DIAMOND),
                        new Card(Rank.FIVE, Suit.HEART),
                        new Card(Rank.JACK, Suit.SPADE),
                        new Card(Rank.EIGHT, Suit.CLUB))
                ));
    }
}