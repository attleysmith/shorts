package com.common.interview.shorts.passwordtester;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTakerTest {

    @Test
    void sample1Test() {
        assertEquals("PASS6word",
                TestTaker.password(
                        new String[]{"P@sswORD1", "20passWORD20", "PASS6word",},
                        "4dro6"
                ));
    }

    @Test
    void sample2Test() {
        assertEquals("crazyPassword1#$%",
                TestTaker.password(
                        new String[]{"MyPassword2", "crazyPassword1#$%",},
                        "1%$#1"
                ));
    }

    @Test
    void sample3Test() {
        assertEquals("",
                TestTaker.password(
                        new String[]{"luckyPASSWORD#$$$", " luckyDay666",},
                        "6pass7"
                ));
    }

}