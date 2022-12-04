package Cryptology;

import java.util.HashMap;

public class OpenKeyProtocol_5 {
    static OpenKeyAlice Alice = new OpenKeyAlice();
    static OpenKeyBob Bob = new OpenKeyBob();
    static OpenKeyTruedy Truedy = new OpenKeyTruedy();
    static EncodeAndDecode code = new EncodeAndDecode();

    static String sessionKey = "sessionKey";
    static String encryptSessionKey;
    static String encryptT;

    static String decryptedSessionKey;
    static String decryptedT;
    private static int T = 1;

    public static void T1toB1(String publicKey) {
        Bob.setBobId("나는 트루디입니다");
        Truedy.setTruedyId("나는 트루디입니다");

        if (Bob.getBobId() != Truedy.getTruedyId()) {
            System.out.println("ERROR: 아이디가 다릅니다.");
            return;
        }
        encryptSessionKey = code.encode(sessionKey, publicKey);
        encryptT = code.encode(String.valueOf(T), publicKey);
        Bob.setSessionKey(encryptSessionKey);
        Bob.setOpenKey(encryptT);
    }

    public static void B2toT2(String publicKey, String privateKey) {
        decryptedSessionKey = code.decode(encryptSessionKey, privateKey);
        decryptedT = code.decode(encryptT, privateKey);
        int TPlusOne = Integer.parseInt(decryptedT) + 1;

        String encryptTPlusOne = code.encode(String.valueOf(TPlusOne), publicKey);
        Truedy.setOpenKey(encryptTPlusOne);
        Truedy.setSessionKey(encryptSessionKey);
    }


    public static void main(String[] args) {
        /**
         * 선암호후서명 시나리오에서 트루디 세션키 획득 방법 시나리오 작성하자
         * 트루디가 앨리스가 생성한 세션키 K를 획득하면 성공
         */
        HashMap<String, String> rsaKeyPair = code.createKeypairAsString();
        String publicKey = rsaKeyPair.get("publicKey");
        String privateKey = rsaKeyPair.get("privateKey");
        System.out.println("만들어진 공개키:" + publicKey);
        System.out.println("만들어진 개인키:" + privateKey);

        T1toB1(publicKey);
        System.out.println("\nT와 sessionKey를 Bob의 공개키로 암호화하고 Truedy가 서명하여 Bob에게 전송");
        System.out.println("암호화 T: " + encryptT);
        System.out.println("암호화 sessionKey: " + encryptSessionKey);

        B2toT2(publicKey, privateKey);
        String decryptedTrudyT = code.decode(Truedy.getOpenKey(), privateKey);

        if (Truedy.getSessionKey() == Bob.getSessionKey() && Integer.parseInt(decryptedT) == Integer.parseInt(decryptedTrudyT) - 1) {
            System.out.println("\n공격성공");
            System.out.println("T: " + Integer.parseInt(decryptedT));
            System.out.println("encryptSessionKey: " + Truedy.getSessionKey());
        }
    }
}
