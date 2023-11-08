package com.common.interview.shorts.pokerevaluator.services;

import com.common.interview.shorts.pokerevaluator.model.Card;
import com.common.interview.shorts.pokerevaluator.model.Pattern;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static com.common.interview.shorts.pokerevaluator.model.Pattern.UNKNOWN;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Evaluator {

    public static Pattern evaluate(Set<Card> cards) {
        if (cards.size() != 5) {
            throw new IllegalArgumentException("5 cards needed!");
        }

        Map<Long, Long> cardsPattern = cards.stream()
                .collect(groupingBy(Card::getRank, counting())) // counting by ranks
                .values().stream()
                .collect(groupingBy(identity(), counting())); // counting by counts

        return Arrays.stream(Pattern.values())
                .filter(pattern -> pattern.matches(cardsPattern))
                .findAny()
                .orElse(UNKNOWN);
    }
}
