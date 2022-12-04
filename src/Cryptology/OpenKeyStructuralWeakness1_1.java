package Cryptology;

import java.util.HashMap;
import java.util.Random;

public class OpenKeyStructuralWeakness1_1 {
    static OpenKeyAlice Alice = new OpenKeyAlice();
    static OpenKeyTruedy Truedy = new OpenKeyTruedy();
    static EncodeAndDecode code = new EncodeAndDecode();

    private static int createBobR;

    public static void A1toT1() {
        Alice.setAliceId("나는 앨리스입니다");
        Truedy.setTruedyId("나는 앨리스입니다");
        if (Alice.getAliceId() != Truedy.getTruedyId()) {
            System.out.println("ERROR: 엘리스 아이디가 틀렸습니다.");
            return;
        }
    }

    public static void T1toA2(String publicKey) {
        int min = 1;
        int max = 10;
        Random rand = new Random();
        createBobR = rand.nextInt(max + min) + min; // 1 ~ 10까지난수로 생성
        System.out.println("트루디가 생성한 난수: " + createBobR);
        Alice.setOpenKey(code.encode(String.valueOf(createBobR), publicKey)); // 엘리스 공개키로 암호화
        System.out.println("R을 Alice 공개키로 암호화: " + Alice.getOpenKey());
    }

    public static String A2toT2(String receiveAlice, String privateKey) {
        String decryptedText = code.decode(receiveAlice, privateKey);
        return decryptedText;
    }

    public static void main(String[] args) {
        /**
         * 공개키 기반 단방향 인증 프로토콜 구현 및 취약성
         * Ex : 트루디는 {R}앨리스 복호화 가능
         * <p>
         * A1toT1(id)
         * T1toA2({R}앨리스 )
         * A2toT2 (R)
         */

        HashMap<String, String> rsaKeyPair = code.createKeypairAsString();
        String publicKey = rsaKeyPair.get("publicKey");
        String privateKey = rsaKeyPair.get("privateKey");
        System.out.println("만들어진 공개키:" + publicKey);
        System.out.println("만들어진 개인키:" + privateKey);

        A1toT1();
        T1toA2(publicKey);
        String sendToTruedy = A2toT2(Alice.getOpenKey(), privateKey);
        System.out.println("복호화: " + sendToTruedy);

        if (sendToTruedy.equals(Integer.toString(createBobR))) {
            System.out.println("공격성공");
        }

    }

}


