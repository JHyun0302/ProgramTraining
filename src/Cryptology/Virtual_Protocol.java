package Cryptology;

import java.util.Random;
import java.util.Scanner;


public class Virtual_Protocol {

    public static int A1toB1() {
        /**
         * A1 to B1 (id) // id를 앨리스로 작성하고 B에 전송했다고 가정
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Alice가 id 입력: "); // A1 to B1 (id)
        int AliceId = sc.nextInt();

        return AliceId;
    }

    public static int B1toA2() {
        /**
         * B1 to A2(R) // R을 난수로 생성 후 A에게 전송했다고 가정
         */
        int min = 1;
        int max = 10;
        Random rand = new Random();
        int BobRandom = rand.nextInt(max + min) + min; // 1 ~ 10까지난수로 생성

        return BobRandom;
    }

    public static int A2toB2(int AliceId) {
        /**
         * A2 to B2 (H, R+1) //앨리스 패스워드 해쉬값과 R+1을 B에게 전송했다고 가정,
         *                                B는 앨리스 패스워드 해쉬값을 비교하여 앨리스를 인증
         */
        int AliceIdHash = AliceId + 55; // hash 값: id + 55
        return AliceIdHash;
    }

    public static void VirtualProtocol(Virtual_Protocol_Bob Bob, Virtual_Protocol_Alice Alice, int AliceIdHash) {
        /**
         * id, R, h(앨리스 패스워드), R+1은 Capture 가능
         */
        System.out.println("Alice 난수: " + Alice.R + "\tAlice 해시값: " + AliceIdHash);
        System.out.println("Bob 난수: " + Bob.R + "\tBob 해시값: " + Bob.hash);

        if ((Bob.R + 1 == Alice.R + 1) && Bob.hash == AliceIdHash) {
            System.out.println("인증 성공");
        }
    }

    public static void main(String[] args) {
        int AliceId = A1toB1();
        int BobRandom = B1toA2();
        int AliceIdHash = A2toB2(AliceId);
        Virtual_Protocol_Bob Bob = new Virtual_Protocol_Bob(BobRandom, AliceIdHash);
        Virtual_Protocol_Alice Alice = new Virtual_Protocol_Alice(AliceId, BobRandom, AliceIdHash);
        VirtualProtocol(Bob, Alice, AliceIdHash);

    }


}
