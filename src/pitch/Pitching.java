package pitch;

import type.BallStatus;

import java.util.List;

public interface Pitching extends Iterable<Ball> {

    List<BallStatus> compareTo(Pitching other);

}
