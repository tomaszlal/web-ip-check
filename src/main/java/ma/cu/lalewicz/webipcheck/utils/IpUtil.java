package ma.cu.lalewicz.webipcheck.utils;

import java.util.regex.Pattern;

public class IpUtil {

    public static boolean validateIp(String ipAdress) {
        try {
            String[] groups = ipAdress.split("\\.");
            if (groups.length == 4) {
                for (String x : groups) {
                    int liczba = Integer.parseInt(x);

                    if (liczba < 0 || liczba > 255) return false;
                }
                return true;
            } else {

                return false;
            }
        } catch (Exception e) {
            return false;
        }
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

    public static boolean validMask(String maskStr){
        if (Pattern.matches("^([\\d]|)[\\d]$",maskStr)) {
            int mask = Integer.parseInt(maskStr);
            if (mask >= 0 && mask <33 ){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }

    public static int maskaSieciowaBin(int iloscBitow) {
        if (iloscBitow == 0) return 0;
        else return (1 << 31) >> iloscBitow - 1;
    }

    public static int addressNet(int ipBin, int maskaBin) {
        return ipBin & maskaBin;
    }

    public static int addressBroadcast(int adressNet, int maskaBin) {
        return adressNet + (~maskaBin);
    }

    public static int lastAdr(int addressBr) {
        return addressBr - 0b1;
    }

    public static int firstAdr(int addressNet) {
        return addressNet + 0b1;
    }
}
