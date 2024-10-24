import java.util.*;

public class GameNumber {
    //필드
    HashSet<Integer> gameNumberSet;
    ArrayList<Integer> gameNumberList;

    //플레이어가 입력한 숫자를 저장
    ArrayList<Integer> inputNumberList;

    //시도횟수를 저장
    int trynumber = 0;


    //메서드
    //답이 될 숫자 생성하기
    public Set<Integer> makeGameNumber() {
        Random random = new Random();
        HashSet<Integer> gameNumbers = new LinkedHashSet<Integer>();
        while (gameNumbers.size() < 3) {
            gameNumbers.add(random.nextInt(9) + 1);
        }
        this.gameNumberSet = gameNumbers;
        this.gameNumberList = new ArrayList<>(gameNumbers);
        return gameNumberSet;
    }

    //입력값을 필드에 지정하기
    public void settingInput(String threeNumbers) throws BadException {
        char firstInputNum = threeNumbers.charAt(0);
        char secondInputNum = threeNumbers.charAt(1);
        char thirdInputNum = threeNumbers.charAt(2);

        HashSet<Integer> checkingSet = new LinkedHashSet<Integer>();
        checkingSet.add(Character.getNumericValue(firstInputNum));
        checkingSet.add(Character.getNumericValue(secondInputNum));
        checkingSet.add(Character.getNumericValue(thirdInputNum));

        while (checkingSet.size() != 3) {
            throw new BadException();
        }
        this.inputNumberList = new ArrayList<>(checkingSet);
    }

    //입력한 숫자가 포함되어있는지 확인 (아닐시 out)
    public boolean checkNumbers() {
        ArrayList<String> score = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            if (!this.gameNumberList.contains(this.inputNumberList.get(i))) {
                score.add("out");
            } else if (this.inputNumberList.get(i) == this.gameNumberList.get(i)) {
                score.add("strike");
            } else {
                score.add("ball");
            }
        }
        if (Collections.frequency(score, "strike") == 3) {
            System.out.println("정답입니다!");
            return true;
        } else {
            System.out.println(score);
            return false;
        }
    }
}
