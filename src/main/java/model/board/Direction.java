package model.board;

import java.util.stream.Stream;

public enum Direction {
    EAST(1, 0),
    NORTH_EAST(1, 1),
    NORTH(0, 1),
    NORTH_WEST(-1, 1),
    WEST(-1, 0),
    SOUTH_WEST(-1, -1),
    SOUTH(0, -1),
    SOUTH_EAST(1, -1);

    final int offsetX;
    final int offsetY;

    Direction(final int offsetX, final int offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public static Stream<Direction> every() {
        return Stream.of(values());
    }

    public static Stream<Direction> orthogonal() {
        return Stream.of(NORTH, EAST, SOUTH, WEST);
    }

    public static Stream<Direction> diagonal() {
        return Stream.of(NORTH_WEST, NORTH_EAST, SOUTH_EAST, SOUTH_WEST);
    }

    public static Direction directionOfVector(Position lhs, Position rhs) {
        final int degreeOfDirection = 45;
        if (lhs == rhs) {
            throw new IllegalArgumentException();
        }
        final int direction = (int) (Math.toDegrees(
                Math.atan2(rhs.y().val() - lhs.y().val(), rhs.x().val() - lhs.x().val())
        ) + degreeOfDirection / 2.0) / degreeOfDirection;
        return values()[direction >= 0 ? direction : direction + values().length - 1];
    }

    public Direction rotateClockwise(final int number) {
        return (number >= 0)
                ? rotateCounterClockwise(values().length - (number % values().length))
                : rotateCounterClockwise(-number);
    }

    public Direction rotateCounterClockwise(final int number) {
        return (number >= 0)
                ? values()[(this.ordinal() + number) % values().length]
                : rotateClockwise(-number);
    }
}