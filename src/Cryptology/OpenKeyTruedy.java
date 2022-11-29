package Cryptology;

public class OpenKeyTruedy {
    private String TruedyId;
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

    public String getTruedyId() {
        return TruedyId;
    }

    public void setTruedyId(String truedyId) {
        TruedyId = truedyId;
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
