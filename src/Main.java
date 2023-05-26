import judge.Judgeable;
import judge.Umpire;
import pitch.factory.GeneralPitchingFactory;
import pitch.factory.PitchingFactory;
import player.Pitcheable;
import player.Pitcher;
import type.GameCode;
import util.Logger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PitchingFactory pitchingFactory = createPitchingFactory();
        Pitcheable pitcher = new Pitcher(pitchingFactory, scanner);
        Judgeable judge;
        do {
            judge = new Umpire(pitchingFactory.create());
            new Baseball(judge, pitcher).start();
        } while (askContinueGame(scanner));
    }

    private static PitchingFactory createPitchingFactory() {
        int pitchSize = 3;
        return new GeneralPitchingFactory(pitchSize);
    }

    private static boolean askContinueGame(Scanner scanner) {
        String message = String.format(
                "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요",
                GameCode.CONTINUE.getCode(),
                GameCode.EXIT.getCode()
        );
        Logger.lnlog(message);
        return GameCode.isContinue(scanner.nextInt());
    }
}