package ma.cu.lalewicz.webipcheck.model;

import ma.cu.lalewicz.webipcheck.utils.IpUtil;



public class IpAddress {
    private int ipBit;
    private int maskBit;
    private int netAddressBit;
    private int broadcastAddressBit;
    private String ip;
    private String mask;
    private String netAddress;
    private String broadcastAddress;
    private String firstAddress;
    private String lastAddress;
    private String numberOfAddresses;
    private boolean validIp;

    public IpAddress() {
    }

    public IpAddress(boolean validIp) {
        this.validIp = validIp;
    }

    public IpAddress(String ip, String mask) {
        this.ip = ip;
        this.ipBit = IpUtil.ipToBits(ip);
        this.maskBit = IpUtil.maskaSieciowaBin(Integer.parseInt(mask));
        this.mask = IpUtil.ipToString(maskBit);
        this.netAddressBit = IpUtil.addressNet(ipBit,maskBit);
        this.netAddress = IpUtil.ipToString(netAddressBit);
        this.broadcastAddressBit = IpUtil.addressBroadcast(netAddressBit,maskBit);
        this.broadcastAddress =IpUtil.ipToString(broadcastAddressBit);
        this.firstAddress = IpUtil.ipToString(IpUtil.firstAdr(netAddressBit));
        this.lastAddress = IpUtil.ipToString(IpUtil.lastAdr(broadcastAddressBit));
        if (maskBit ==0) {
            this.numberOfAddresses = "4294967294";
        }else {
            this.numberOfAddresses = String.valueOf(broadcastAddressBit - IpUtil.ipToBits(firstAddress));
        }
        this.validIp = true;
    }

    public String getIp() {
        return ip;
    }



    public String getMask() {
        return mask;
    }



    public String getNetAddress() {
        return netAddress;
    }



    public String getBroadcastAddress() {
        return broadcastAddress;
    }



    public String getFirstAddress() {
        return firstAddress;
    }



    public String getLastAddress() {
        return lastAddress;
    }



    public boolean isValidIp() {
        return validIp;
    }

    public String getNumberOfAddresses() {
        return numberOfAddresses;
    }

    @Override
    public String toString() {
        return "IpAddress{" +
                "ip='" + ip + '\'' +
                ", mask='" + mask + '\'' +
                ", netAddress='" + netAddress + '\'' +
                ", broadcastAddress='" + broadcastAddress + '\'' +
                ", firstAddress='" + firstAddress + '\'' +
                ", lastAddress='" + lastAddress + '\'' +
                ", numberOfAddresses='" + numberOfAddresses + '\'' +
                ", validIp=" + validIp +
                '}';
    }
}
