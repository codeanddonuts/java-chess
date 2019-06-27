package model.board;

import org.junit.jupiter.api.Test;

import static model.board.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
    @Test
    void rotationCWTest1() {
        assertThat(NORTH.rotateClockwise(11)).isEqualTo(SOUTH_EAST);
    }

    @Test
    void rotationCWTest2() {
        assertThat(NORTH.rotateClockwise(1)).isEqualTo(NORTH_EAST);
    }

    @Test
    void rotationCWTest3() {
        assertThat(NORTH.rotateClockwise(-3)).isEqualTo(SOUTH_WEST);
    }

    @Test
    void rotationCCWTest1() {
        assertThat(NORTH.rotateCounterClockwise(45)).isEqualTo(SOUTH_EAST);
    }

    @Test
    void rotationCCWTest2() {
        assertThat(NORTH.rotateCounterClockwise(1)).isEqualTo(NORTH_WEST);
    }

    @Test
    void rotationCCWTest3() {
        assertThat(NORTH.rotateCounterClockwise(-11)).isEqualTo(SOUTH_EAST);
    }

    @Test
    void directionOfVectorTest1() {
        assertThat(Direction.directionOfVector(Position.of("a1"), Position.of("c1"))).isEqualTo(EAST);
    }

    @Test
    void directionOfVectorTest2() {
        assertThat(Direction.directionOfVector(Position.of("a1"), Position.of("h8"))).isEqualTo(NORTH_EAST);
    }

    @Test
    void directionOfVectorTest3() {
        assertThat(Direction.directionOfVector(Position.of("a1"), Position.of("e8"))).isEqualTo(NORTH_EAST);
    }

    @Test
    void directionOfVectorTest4() {
        assertThat(Direction.directionOfVector(Position.of("a1"), Position.of("h2"))).isEqualTo(EAST);
    }

    @Test
    void directionOfVectorTest5() {
        assertThat(Direction.directionOfVector(Position.of("b1"), Position.of("a8"))).isEqualTo(NORTH);
    }

    @Test
    void directionOfVectorTest6() {
        assertThat(Direction.directionOfVector(Position.of("e5"), Position.of("a1"))).isEqualTo(SOUTH_WEST);
    }
}