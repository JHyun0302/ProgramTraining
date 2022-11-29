package Cryptology;

import java.util.HashMap;
import java.util.Random;

public class OpenKeyProtocol_1 {
    static OpenKeyAlice Alice = new OpenKeyAlice();
    static OpenKeyBob Bob = new OpenKeyBob();
    static EncodeAndDecode code = new EncodeAndDecode();
    private static int createBobR;

    public static void A1toB1() {
        Alice.setAliceId("나는 앨리스입니다");
        Bob.setBobId("나는 앨리스입니다");
        if (Alice.getAliceId() != Bob.getBobId()) {
            System.out.println("ERROR: 엘리스 아이디가 틀렸습니다.");
            return;
        }
    }

    public static void B1toA2(String publicKey) {
        int min = 1;
        int max = 10;
        Random rand = new Random();
        createBobR = rand.nextInt(max + min) + min; // 1 ~ 10까지난수로 생성
        System.out.println("밥이 생성한 난수: " + createBobR);
        Alice.setOpenKey(code.encode(String.valueOf(createBobR), publicKey)); // 엘리스 공개키로 암호화
        System.out.println("R을 Alice 공개키로 암호화: " + Alice.getOpenKey());
    }

    public static String A2toB2(String receiveAlice, String privateKey) {
        String decryptedText = code.decode(receiveAlice, privateKey);
        return decryptedText;
    }

    public static void main(String[] args) {
        /**
         * 공개키 기반 단방향 인증 프로토콜 구현 및 취약성
         * Ex :
         * A1toB1 (id) // id를 앨리스로 작성하고 B에 전송했다고 가정
         * B1toA2({R}앨리스) // R을 난수로 생성 후 앨리스 공개키로 암호화하여 전송
         * A2toB2 (R) //앨리스는 R을 복호화하여 밥에게 전송
         */
        HashMap<String, String> rsaKeyPair = code.createKeypairAsString();
        String publicKey = rsaKeyPair.get("publicKey");
        String privateKey = rsaKeyPair.get("privateKey");
        System.out.println("만들어진 공개키:" + publicKey);
        System.out.println("만들어진 개인키:" + privateKey);


        A1toB1();
        B1toA2(publicKey);
        String sendToBob = A2toB2(Alice.getOpenKey(), privateKey);
        System.out.println("복호화: " + sendToBob);

        if (sendToBob.equals(Integer.toString(createBobR))) {
            System.out.println("인증성공");
        }

    }
}


