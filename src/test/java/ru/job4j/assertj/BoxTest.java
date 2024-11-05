package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .startsWith("S")
                .endsWith("e");
    }

    @Test
    void itThisTetrahedron() {
        Box box = new Box(4, 14);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron")
                .startsWith("T")
                .endsWith("n");
    }

    @Test
    void itThisCube() {
        Box box = new Box(8, 24);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .startsWith("C")
                .endsWith("e");
    }1

    @Test
    void whenNumberOfVerticesIsZero() {
        Box box = new Box(0, 2);
        int countOfVertices = box.getNumberOfVertices();
        assertThat(countOfVertices).isEqualTo(0)
                .isLessThan(1);

    }

    @Test
    void whenNumberOfVerticesIsSix() {
        Box box = new Box(4, 2);
        int countOfVertices = box.getNumberOfVertices();
        assertThat(countOfVertices).isEqualTo(4)
                .isGreaterThan(3)
                .isLessThan(5);
    }

    @Test
    void whenNumberOfVerticesIsEight() {
        Box box = new Box(8, 2);
        int countOfVertices = box.getNumberOfVertices();
        assertThat(countOfVertices).isEqualTo(8)
                .isGreaterThan(7)
                .isLessThan(9);
    }

    @Test
    void whenNotExist() {
        Box box = new Box(7, 2);
        boolean exist = box.isExist();
        assertThat(exist).isFalse();
    }

    @Test
    void whenExist() {
        Box box = new Box(8, 2);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }

    @Test
    void whenSphereArea() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        assertThat(area).isCloseTo(1256.63d, withPrecision(0.01d))
                .isPositive();
    }

    @Test
    void whenTetrahedronArea() {
        Box box = new Box(4, 12);
        double area = box.getArea();
        assertThat(area).isCloseTo(249.41d, withPrecision(0.01d))
                .isPositive();
    }

    @Test
    void whenCubeArea() {
        Box box = new Box(8, 15);
        double area = box.getArea();
        assertThat(area).isCloseTo(1350.0d, withPrecision(0.01d));
    }
}