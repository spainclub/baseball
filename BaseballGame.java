import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        // 숫자 입력 받기
//        int[] inputuser = new int[3];

        // 랜덤한 숫자 만들기  배열이 10개
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 10);  // 0~9
            int temp = number[0];
            number[0] = number[n];
            number[n] = temp;
        }
//        System.out.println(Arrays.toString(number));


        // 랜덤한 숫자를 크기가 3인 배열에 넣기 (기준점)
        int[] ball = new int[3];
        for (int i = 0; i < ball.length; i++) {
            ball[i] = number[i];
        }
        System.out.println(Arrays.toString(ball));


        // 유저가 입력한 숫자와 랜덤 숫자 비교

        int count = 0;

        Scanner sc = new Scanner(System.in);
        String input;

        boolean game = true;
        while (game) {

            boolean flag = false;
            while (!flag) {
                System.out.print("0~9 사이의 정수 세개를 입력하세요 : ");

                input = sc.nextLine();  // 유저가 입력
                int[] inputuser = new int[input.length()];

                for (int i = 0; i < input.length(); i++) {
                    inputuser[i] = input.charAt(i) - 48;
                }
                System.out.println(Arrays.toString(inputuser));

                flag = check(inputuser); // 자릿수, 중복 검사, 실패 시 입력부터 다시 시작

                // 야구 시작
                int s = 0;
                int b = 0;
                count++; // 야구를 플레이한 횟수
                System.out.println(count + "번째 시도");
                for (int i = 0; i < ball.length; i++) {
                    for (int j = 0; j < inputuser.length; j++) {
                        if ((ball[i] == inputuser[j]) && i == j) {  // 값이 같고, 위치가 같을 떄
                            s++;
                        } else if ((ball[i] == inputuser[j]) && i != j) { // 값이 같고, 위치가 다를 때
                            b++;
                        }
                    }
                }
                if (s == 3) {
                    System.out.println("정답입니다.");
                    game = false;
                    break;
//                    System.out.println(Arrays.toString(ball));
                }
                System.out.println(b + "b" + s + "s");
            }
        }
    }


    // 숫자 중복 확인 + 세자리만 넣었는지 확인
    static boolean check(int[] inputuser) {
        if ((inputuser.length) == 3) {  // 세자리일 경우 -> 중복값 확인
            for (int i = 0; i < inputuser.length - 1; i++) {
//                    System.out.println(Arrays.toString(inputuser));
                for (int j = i + 1; j < inputuser.length; j++) {
                    if (inputuser[j] == inputuser[i]) {  // 중복된 값 입력
                        System.out.println("서로 다른 숫자를 입력해주세요.");
                        return false;
                    }
                }
            }
        } else {  //세자리가 아닐 경우
            System.out.println("세자리 숫자를 입력해주세요.");
            return false;
        }
        return true;
    }
}
