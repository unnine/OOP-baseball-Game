package pitch.factory;

import pitch.GeneralPitching;
import pitch.Pitching;
import util.NumberGenerator;

public class GeneralPitchingFactory implements PitchingFactory {

    private final int pitchSize;

    public GeneralPitchingFactory(int pitchSize) {
        this.pitchSize = pitchSize;
    }

    @Override
    public Pitching create() {
        return create(NumberGenerator.randomString(pitchSize));
    }

    @Override
    public Pitching create(String balls) {
        return new GeneralPitching(balls, pitchSize);
    }

}
