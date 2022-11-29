package Cryptology;

import java.util.HashMap;
import java.util.Random;

public class OpenKeyOnewayConfirmWeakness_2 {
    static OpenKeyAlice Alice = new OpenKeyAlice();
    static OpenKeyTruedy Truedy = new OpenKeyTruedy();
    static EncodeAndDecode code = new EncodeAndDecode();

    private static int createTruedyR;

    public static void A1toT1() {
        Alice.setAliceId("나는 앨리스입니다");
        Truedy.setTruedyId("나는 앨리스입니다");
        if (Alice.getAliceId() != Truedy.getTruedyId()) {
            System.out.println("ERROR: 엘리스 아이디가 틀렸습니다.");
            return;
        }
    }

    public static void T1toA2() {
        int min = 1;
        int max = 10;
        Random rand = new Random();
        createTruedyR = rand.nextInt(max + min) + min; // 1 ~ 10까지난수로 생성
        System.out.println("트루디가 생성한 난수: " + createTruedyR);
        Alice.setRandom(createTruedyR);
    }

    public static void A2toB2(String publicKey) {
        Alice.setPersonalKey(code.encode(String.valueOf(Alice.getRandom()), publicKey));
    }

    public static void main(String[] args) {
        /**
         * 공개키 기반 단방향 인증 프로토콜 구현 및 취약성
         * Ex : 트루디는 엘리스에게 R 전자서명 가능
         * A1toT1(id)
         * T1toA2(R )
         * A2toT2 ([R]앨리스)
         */
        HashMap<String, String> rsaKeyPair = code.createKeypairAsString();
        String publicKey = rsaKeyPair.get("publicKey");
        String privateKey = rsaKeyPair.get("privateKey");
        System.out.println("만들어진 공개키:" + publicKey);
        System.out.println("만들어진 개인키:" + privateKey);

        A1toT1();
        T1toA2();
        A2toB2(publicKey);
        System.out.println("R을 복호화하여 Truedy에게 전송: " + Alice.getPersonalKey());

        String decryptedText = code.decode(Alice.getPersonalKey(), privateKey);
        if (decryptedText.equals(Integer.toString(createTruedyR))) {
            System.out.println("공격성공");
        }
    }
}



