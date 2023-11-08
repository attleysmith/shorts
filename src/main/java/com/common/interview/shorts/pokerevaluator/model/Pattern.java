package com.common.interview.shorts.pokerevaluator.model;

import java.util.Map;

public enum Pattern {
    PAIR(3, 1, 0, 0),
    TWO_PAIR(1, 2, 0, 0),
    THREE_OF_A_KIND(2, 0, 1, 0),
    FULL_HOUSE(0, 1, 1, 0),
    NOTHING(5, 0, 0, 0),
    UNKNOWN(0, 0, 0, 0);

    Pattern(int one, int two, int three, int four) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }

    public final int one;
    public final int two;
    public final int three;
    public final int four;

    public boolean matches(Map<Long, Long> patternMap) {
        return patternMap.getOrDefault(1L, 0L) == one &&
                patternMap.getOrDefault(2L, 0L) == two &&
                patternMap.getOrDefault(3L, 0L) == three &&
                patternMap.getOrDefault(4L, 0L) == four;
    }
}
