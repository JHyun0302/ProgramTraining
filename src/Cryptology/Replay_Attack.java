package Cryptology;

import java.util.Random;
import java.util.Scanner;

public class Replay_Attack {
    /**
     * 단방향 인증 프로토콜 구현 및 재연 공격
     * Ex : id, R, H, R+1을 이용하여 트루디의 재연공격
     * T1toB1(id)
     * B1toT2(R)
     * T2toB2 (H, R+1)
     */
    public static int T1toB1() {
        /**
         * T1 to B1(id) // Truedy가 id를 앨리스로 작성하고 B에 전송했다고 가정
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Truedy가 id 입력: "); // T1 to B1(id)
        int AliceId = sc.nextInt(); // Truedy의 Fake
        return AliceId;
    }

    public static int B1toT2() {
        /**
         * B1 to T2(R) // R을 난수로 생성 후 T에게 전송했다고 가정
         */
        int min = 1;
        int max = 10;
        Random rand = new Random();
        int BobRandom = rand.nextInt(max + min) + min; // 1 ~ 10까지난수로 생성

        return BobRandom;
    }

    public static int T2toB2(int TruedyFakeId) {
        /**
         *  T2 to B2(H, R+1) //앨리스 패스워드 해쉬값과 R+1을 B에게 전송했다고 가정,
         *                                B는 앨리스 패스워드 해쉬값을 비교하여 앨리스라고 착각하고 Truedy를 인증
         */
        int TruedyFakeHash = TruedyFakeId + 55; // hash 값: id + 55
        return TruedyFakeHash;
    }

    public static void VirtualProtocol(Virtual_Protocol_Bob Bob, Virtual_Protocol_Truedy Truedy) {
        /**
         * 단방향 인증 프로토콜 구현 및 재연 공격
         * Ex : id, R, H, R+1을 이용하여 트루디의 재연공격
         */
        System.out.println("Truedy 난수: " + Truedy.R + "\tTruedy 해시값: " + Truedy.hash);
        System.out.println("Bob 난수: " + Bob.R + "\tBob 해시값: " + Bob.hash);

        if ((Bob.R + 1 == Truedy.R + 1) && Bob.hash == Truedy.hash) {
            System.out.println("인증 성공");
        }
    }

    public static void main(String[] args) {
        int TruedyFakeId = T1toB1();
        int BobRandom = B1toT2();
        int TruedyFakeHash = T2toB2(TruedyFakeId);
        Virtual_Protocol_Bob Bob = new Virtual_Protocol_Bob(BobRandom, TruedyFakeHash);
        Virtual_Protocol_Truedy Truedy = new Virtual_Protocol_Truedy(BobRandom, TruedyFakeHash);
        VirtualProtocol(Bob, Truedy);
    }
}
