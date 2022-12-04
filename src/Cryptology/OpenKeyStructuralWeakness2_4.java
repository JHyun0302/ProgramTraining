package Cryptology;

import java.util.HashMap;
import java.util.Random;

public class OpenKeyStructuralWeakness2_4 {
    static OpenKeyAlice Alice = new OpenKeyAlice();
    static OpenKeyTruedy Truedy = new OpenKeyTruedy();
    static EncodeAndDecode code = new EncodeAndDecode();

    static String sessionKey = "sessionKey";

    private static int createAliceR;

    public static void A1toT1() {
        Alice.setAliceId("나는 앨리스입니다");
        Truedy.setTruedyId("나는 앨리스입니다");
        int min = 1;
        int max = 10;
        Random rand = new Random();
        createAliceR = rand.nextInt(max + min) + min; // 1 ~ 10까지난수로 생성
        System.out.println("Alice가 생성한 난수: " + createAliceR);
        Truedy.setRandom(createAliceR);

        if (Alice.getAliceId() != Truedy.getTruedyId()) {
            System.out.println("ERROR: 엘리스 아이디가 틀렸습니다.");
            return;
        }
    }

    public static String T1toA2(String publicKey) {
        String encryptSessionKey = code.encode(sessionKey, publicKey);
        Alice.setSessionKey(encryptSessionKey);
        Alice.setPersonalKey(code.encode(String.valueOf(Truedy.getRandom()), publicKey));
        return encryptSessionKey;
    }

    public static String A2toT2(String publicKey, String privateKey, String encryptSessionKey) {
        String decryptedR = code.decode(Alice.getPersonalKey(), privateKey);
        int RandPlusOne = Integer.parseInt(decryptedR) + 1;
        Truedy.setSessionKey(encryptSessionKey);
        Truedy.setPersonalKey(code.encode(String.valueOf(RandPlusOne), publicKey));
        return decryptedR;
    }

    public static void main(String[] args) {
        /**
         * 공개키 기반 단방향 인증 프로토콜 구현 및 취약성
         * Ex :
         * A1toT1 (id) // id를 앨리스로 작성하고 R과 함께 T에 전송했다고 가정
         * T1toA2({R,K}앨리스) // R과 세션키 K를 앨리스 공개키로 암호화하여 전송
         * A2toT2 {R +1,K}밥) //R+1과 K를 밥 공개키로 암호화하여 전송
         */
        HashMap<String, String> rsaKeyPair = code.createKeypairAsString();
        String publicKey = rsaKeyPair.get("publicKey");
        String privateKey = rsaKeyPair.get("privateKey");
        System.out.println("만들어진 공개키:" + publicKey);
        System.out.println("만들어진 개인키:" + privateKey);

        A1toT1();
        String encryptSessionKey = T1toA2(publicKey);
        System.out.println("R과 sessionKey를 Alice 개인키로 암호화하여 Bob에게 전송");
        System.out.println("R: " + Alice.getSessionKey());
        System.out.println("sessionKey: " + Alice.getPersonalKey());
        String AliceCheck = A2toT2(publicKey, privateKey, encryptSessionKey);
        int check = Integer.parseInt(AliceCheck);
        String decryptedBobR = code.decode(Truedy.getPersonalKey(), privateKey);
        int BobCheck = Integer.parseInt(decryptedBobR) - 1;


        if (Truedy.getSessionKey() == Alice.getSessionKey() && check == BobCheck) {
            System.out.println("\n공격성공");
            System.out.println("R: " + check);
            System.out.println("encryptSessionKey: " + Truedy.getSessionKey());
        }
    }
}



