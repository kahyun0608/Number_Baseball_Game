import java.util.ArrayList;
import java.util.Scanner;

public class GameApp {
    static ArrayList<Integer> record = new ArrayList<Integer>();

    public static boolean start() throws BadException {
        Scanner sc = new Scanner(System.in);

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
        System.out.println("1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");

        String start = sc.nextLine();
        if (start.equals("1")) {                                             //1번 게임 시작하기 선택
            BaseballGame baseballGame = new BaseballGame();
            boolean gameWin = false;
            while (gameWin == false) {                    //게임 한 판(round) 시작
                try {
                    gameWin = baseballGame.play(); //게임 구동 -> 한 번의 숫자 입력 후 결과출력
                    baseballGame.trynumber += 1; //시도 횟수 + 1

                } catch (BadException e) {
                    System.out.println(e.getMessage());
                }
            }
            record.add(baseballGame.trynumber);     //방금 한 게임의 시도횟수 저장
            return false;
        } else if (start.equals("2")) {                                       // 2번 게임 기록 보기 선택
            System.out.println("<게임 기록 보기>");
            for (int i = 0; i < record.size(); i++) {
                System.out.println(i + 1 + "번째 게임 : 시도횟수 - " + record.get(i));
            }
            return false;
        } else if (start.equals("3")) {                                                     // 3번 종료하기 선택
            System.out.println("< 숫자 야구 게임을 종료합니다. >");
            return true;
        } else {
            throw new BadException();
        }
    }
}