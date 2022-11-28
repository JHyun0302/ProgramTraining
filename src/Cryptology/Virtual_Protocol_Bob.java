package Cryptology;

public class Virtual_Protocol_Bob {
    public int id;
    public int R;
    public int hash;

    public Virtual_Protocol_Bob(int R, int hash) {
        this.hash = hash;
        this.R = R;
    }
}
