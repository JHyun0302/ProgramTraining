package Cryptology;

public class OpenKeyAlice {
    public int AliceId;
    private String openKey = "";
    private String personalKey = "";

    public int getAliceId() {

        return AliceId;
    }

    public void setAliceId(int aliceId) {
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
