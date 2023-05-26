package pitch;

import java.util.Objects;

public final class Ball {

    private final int value;

    public Ball(int value) {
        assertOneBetweenNine(value);
        this.value = value;
    }

    private void assertOneBetweenNine(int value) {
        int min = 1;
        int max = 9;
        if (value < min || value > max) {
            String message = String.format("숫자는 %d ~ %d만 허용됩니다.", min, max);
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}