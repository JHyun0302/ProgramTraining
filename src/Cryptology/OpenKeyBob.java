package Cryptology;

public class OpenKeyBob {

    private String BobId;
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

    public String getBobId() {
        return BobId;
    }

    public void setBobId(String bobId) {
        BobId = bobId;
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
