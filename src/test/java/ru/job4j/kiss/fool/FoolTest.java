package ru.job4j.kiss.fool;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;

class FoolTest {

    @Test
    void whenDigit3ThenFizz() {
        Fool foll = new Fool();
        assertThat(foll.check(3)).isEqualTo("Fizz")
                .isNotEmpty();

    }

    @Test
    void whenDigit5ThenBuzz() {
        Fool foll = new Fool();
        assertThat(foll.check(5)).isEqualTo("Buzz")
                .isNotEmpty();

    }

    @Test
    void whenDigit15ThenFizzBuzz() {
        Fool foll = new Fool();
        assertThat(foll.check(15)).isEqualTo("FizzBuzz")
                .isNotEmpty();

    }

    @Test
    void whenOtherDigit() {
        Fool foll = new Fool();
        assertThat(foll.check(17)).isEqualTo("17")
                .isNotEmpty();

    }
}