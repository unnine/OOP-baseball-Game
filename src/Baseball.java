import judge.Judgeable;
import player.Pitcheable;
import util.Logger;

public class Baseball {

    private final Judgeable umpire;
    private final Pitcheable pitcher;

    public Baseball(Judgeable judge, Pitcheable pitcher) {
        this.umpire = judge;
        this.pitcher = pitcher;
    }

    public void start() {
        ready();
        play();
        end();
    }

    public void ready() {
        Logger.log("숫자 야구 게임을 시작합니다.");
    }

    private void play() {
        while(!umpire.isOut(pitcher.pitch()));
    }

    private void end() {
        Logger.log("아웃! 게임 종료");

    }
}