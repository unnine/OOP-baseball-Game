package judge;

import pitch.Pitching;
import type.BallStatus;
import util.Logger;

import java.util.List;
import java.util.function.Predicate;

public class Umpire implements Judgeable {

    private final Pitching answer;

    public Umpire(Pitching pitching) {
        this.answer = pitching;
    }

    @Override
    public boolean isOut(Pitching pitching) {
        List<BallStatus> statuses = compare(pitching);

        int strikeCount = count(statuses, BallStatus::isStrike);
        int ballCount = count(statuses, BallStatus::isBall);

        printStatus(strikeCount, ballCount);

        return strikeCount == statuses.size();
    }

    private List<BallStatus> compare(Pitching pitching) {
        return answer.compareTo(pitching);
    }

    private int count(List<BallStatus> statuses, Predicate<BallStatus> ballStatus) {
        return (int) statuses.stream().filter(ballStatus).count();
    }

    private void printStatus(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();
        if (strikeCount == 0 && ballCount == 0) {
            sb.append("낫싱");
        }
        if (ballCount > 0) {
            sb.append(ballCount).append("볼").append(" ");
        }
        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }
        Logger.log(sb.toString());
    }


}
