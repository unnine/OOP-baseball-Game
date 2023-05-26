package player;

import pitch.Pitching;
import pitch.factory.PitchingFactory;
import util.Logger;

import java.util.Scanner;

public class Pitcher implements Pitcheable {

    private final PitchingFactory pitchingFactory;
    private final Scanner scanner;

    public Pitcher(PitchingFactory pitchingFactory, Scanner scanner) {
        this.pitchingFactory = pitchingFactory;
        this.scanner = scanner;
    }

    @Override
    public Pitching pitch() {
        Logger.lnlog("숫자를 입력해주세요.");
        return pitchingFactory.create(scanner.next());
    }
}