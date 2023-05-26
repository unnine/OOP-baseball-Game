package pitch.factory;

import pitch.Pitching;

public interface PitchingFactory {

    Pitching create();

    Pitching create(String balls);

}
