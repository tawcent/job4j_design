package ru.job4j.set;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleArraySetTest {

    @Test
    void whenAddNonNull() {
        SimpleSet<Integer> set = new SimpleArraySet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
    }

    @Test
    void whenAddSomeElementsNonNull() {
        SimpleSet<Integer> set = new SimpleArraySet<>();
        assertThat(set.contains(1)).isFalse();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
        assertThat(set.contains(2)).isFalse();
        assertThat(set.add(2)).isTrue();
        assertThat(set.contains(2)).isTrue();
        assertThat(set.add(2)).isFalse();
        assertThat(set.contains(3)).isFalse();
        assertThat(set.add(3)).isTrue();
        assertThat(set.contains(3)).isTrue();
        assertThat(set.add(3)).isFalse();
    }

    @Test
    void whenAddNull() {
        SimpleSet<Integer> set = new SimpleArraySet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.contains(null)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenAddStrings() {
        SimpleSet<String> set = new SimpleArraySet<>();
        assertThat(set.add("yo")).isTrue();
        assertThat(set.contains("yo")).isTrue();
        assertThat(set.add("yaustal")).isTrue();
        assertThat(set.contains("yaustal")).isTrue();
        assertThat(set.add("yaustal")).isFalse();
    }

    @Test
    void whenAddList() {
        SimpleSet<List<Integer>> set = new SimpleArraySet<>();
        assertThat(set.add((List.of(1, 2, 3)))).isTrue();
        assertThat(set.contains(List.of(1, 2, 3))).isTrue();
        assertThat(set.add(List.of(3, 2, 1))).isTrue();
        assertThat(set.contains(List.of(3, 2, 1))).isTrue();
        assertThat(set.add(List.of(3, 2, 1))).isFalse();
    }
}