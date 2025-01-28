package ru.job4j.template;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Disabled
class GeneratorTest {

    @Test
    void test1() {
        Generator gen = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Mikhail Popov");
        args.put("subject", "you");
        assertThat(gen.produce(template, args)).isEqualTo("I am a Mikhail Popov, Who are you? ");
    }

    @Test
    void whenTemplateKeyNotEqualsMapKeyThenException() {
        Generator gen = new SimpleGenerator();
        String template = "I am a ${name}, I {41} years old, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Mikhail Popov");
        args.put("subject", "you");
        assertThatThrownBy(() -> gen.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenExtraMapKeyThenException() {
        Generator gen = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Mikhail Popov");
        args.put("subject", "you");
        args.put("age", "41");
        assertThatThrownBy(() -> gen.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

}