import java.util.Random;
import java.util.Scanner;

public class baseball {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int r1,r2,r3;
        int n1,n2,n3;
        int number;
        int gamecnt = 1;
        int scnt = 0;
        int bcnt = 0;

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        while (true) {
            while (true) {
                r1 = random.nextInt(10);
                r2 = random.nextInt(10);
                r3 = random.nextInt(10);
                if (!(r1 == r2|| r2 == r3|| r3 == r1)) {
                    break;
                }
            }
            while (true) {
                System.out.print(gamecnt + "번째 시도 : ");
                number = sc.nextInt();
//                for(int i=3; i>0; i--){
//                    n[i] = number % 10;
//                    number /= 10;
//                }
                n1 = (number/100)%10;
                n2 = (number/10)%10;
                n3 = number%10;
                if (r1 == n1) {
                    scnt++;
                }
                if (r2 == n2) {
                    scnt++;
                }
                if (r3 == n3) {
                    scnt++;
                }

                if (r1 == n2 || r1 == n3) {
                    bcnt++;
                }
                if (r2 == n1 || r2 == n3) {
                    bcnt++;
                }
                if (r3 == n1 || r3 == n2) {
                    bcnt++;
                }

                if (scnt == 3) {
                    System.out.println(gamecnt + "번만에 맞히셨습니다.");
                    System.out.println("게임을 종료합니다.");
                    break;
                } else {
                    if (scnt == 0 && bcnt == 0) {
                        System.out.println("아웃입니다");
                    } else {
                        System.out.println(scnt + "s" + bcnt + "b");

                    }
                    scnt = 0;
                    bcnt = 0;
                }
                gamecnt++;
            }
            break;
        }
    }
}