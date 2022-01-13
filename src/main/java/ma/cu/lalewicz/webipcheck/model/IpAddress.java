package ma.cu.lalewicz.webipcheck.model;

import org.springframework.context.annotation.Bean;


public class IpAddress {
    private int ipInBits;
    private String ipInString;
    private String mask;
    private String netAddress;
    private String broadcastAddress;
    private String firstAddress;
    private String lastAddress;


    public String getIpInString() {
        return ipInString;
    }

    public void setIpInString(String ipInString) {
        this.ipInString = ipInString;
        this.ipInBits = ipToBits(ipInString);
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getNetAddress() {
        return netAddress;
    }

    public void setNetAddress(String netAddress) {
        this.netAddress = netAddress;
    }

    public String getBroadcastAddress() {
        return broadcastAddress;
    }

    public void setBroadcastAddress(String broadcastAddress) {
        this.broadcastAddress = broadcastAddress;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getLastAddress() {
        return lastAddress;
    }

    public void setLastAddress(String lastAddress) {
        this.lastAddress = lastAddress;
    }

    public static int ipToBits(String ipAdress)  //zamienia string zapisany w formacie xxx.xxx.xxx.xxx na binarnie w liczbie int
    {
        int IpBinTemp = 0;
        String[] groups = ipAdress.trim().split("\\.");
        if (groups.length == 4) {
            for (String x : groups) {
                IpBinTemp = IpBinTemp << 8;
                IpBinTemp = IpBinTemp | Integer.parseInt(x);
            }
        }
        return IpBinTemp;
    }

    public static String ipToString(int ipBinTemp) // zamienia adres ip zapisany binarnie w int do postaci tekstu
    {
        int tempOctet = 0;
        String ipString = "";
        for (int i = 0; i < 25; i = i + 8) {
            tempOctet = ipBinTemp << i;
            tempOctet = tempOctet >>> 24;
            ipString = ipString + Integer.toString(tempOctet);
            if (i < 24) ipString = ipString + ".";
        }
        return ipString;
    }
}
