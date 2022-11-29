package Cryptology;

public class OpenKeyAlice {
    private String AliceId;
    private String openKey = "";
    private String personalKey = "";

    private String sessionKey = "";

    private int random;


    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }


    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }


    public String getAliceId() {
        return AliceId;
    }

    public void setAliceId(String aliceId) {
        AliceId = aliceId;
    }

    public String getOpenKey() {
        return openKey;
    }

    public void setOpenKey(String openKey) {
        this.openKey = openKey;
    }

    public String getPersonalKey() {
        return personalKey;
    }

    public void setPersonalKey(String personalKey) {
        this.personalKey = personalKey;
    }
}
