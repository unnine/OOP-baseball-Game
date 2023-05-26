package pitch;

import type.BallStatus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneralPitching implements Pitching {

    private final Ball[] balls;

    public GeneralPitching(String s, int size) {
        assertEqualsLength(s, size);
        this.balls = toBalls(s, size);
    }

    private Ball[] toBalls(String s, int pitchSize) {
        Ball[] balls = new Ball[pitchSize];
        for (int i = 0; i < pitchSize; i++) {
            balls[i] = new Ball(s.charAt(i) - '0');
        }
        return balls;
    }

    private void assertEqualsLength(String s, int pitchSize) {
        if (s == null || s.length() != pitchSize) {
            String message = String.format("숫자의 길이는 %d이어야 합니다.", pitchSize);
            throw new IllegalArgumentException(message);
        }
    }

    private int indexOf(Ball target) {
        for (int i=0; i < balls.length; i++) {
            if (balls[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<BallStatus> compareTo(Pitching other) {
        List<BallStatus> statuses = new ArrayList<>(balls.length);
        int location;
        int i = -1;
        for (Ball ball : other) {
            i++;
            location = indexOf(ball);

            if (location == -1) {
                statuses.add(BallStatus.NOTHING);
                continue;
            }
            if (location == i) {
                statuses.add(BallStatus.STRIKE);
                continue;
            }
            statuses.add(BallStatus.BALL);
        }
        return statuses;
    }

    @Override
    public Iterator<Ball> iterator() {
        return new Iterator<>() {
            private int i = -1;

            @Override
            public boolean hasNext() {
                return i < balls.length - 1;
            }

            @Override
            public Ball next() {
                i++;
                return balls[i];
            }
        };
    }
}
