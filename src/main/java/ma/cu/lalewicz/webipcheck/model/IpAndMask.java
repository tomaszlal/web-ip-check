package ma.cu.lalewicz.webipcheck.model;

public class IpAndMask {
    private String ip;
    private int mask;

    public IpAndMask(String ip, int mask) {
        this.ip = ip;
        this.mask = mask;
    }

    public IpAndMask() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getMask() {
        return mask;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }
}
