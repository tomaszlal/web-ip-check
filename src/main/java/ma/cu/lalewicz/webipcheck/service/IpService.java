package ma.cu.lalewicz.webipcheck.service;

import ma.cu.lalewicz.webipcheck.model.IpAddress;
import org.springframework.stereotype.Service;

@Service
public class IpService {


    IpAddress ipAddress;

    public IpAddress getInfoOfAdrress(String ip){
        ipAddress = new IpAddress();
        ipAddress.setIpInString(ip);
        return ipAddress;
    }
}
