package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("apple", "banana", "orange", "kiwi");
        assertThat(list).hasSize(4)
                .contains("banana")
                .contains("kiwi", Index.atIndex(3))
                .containsAnyOf("mango", "apple", "tomato")
                .doesNotContain("apple", Index.atIndex(1));
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("red", "green", "blue", "red");
        assertThat(set).hasSize(3)
                .contains("green")
                .containsExactlyInAnyOrder("red", "blue", "green")
                .doesNotContain("yellow");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three");
        assertThat(map).hasSize(3)
                .containsKeys(1, 2, 3)
                .containsValues("two", "three", "one")
                .doesNotContainKey(0)
                .doesNotContainValue("five")
                .containsEntry(2, "two");
    }
}