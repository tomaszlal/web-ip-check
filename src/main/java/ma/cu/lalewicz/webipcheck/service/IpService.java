package ma.cu.lalewicz.webipcheck.service;

import ma.cu.lalewicz.webipcheck.model.IpAddress;
import ma.cu.lalewicz.webipcheck.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpService {


    IpAddress ipAddress;

    public IpAddress getInfoOfAdrress(String ip, String mask){
        if(IpUtil.validateIp(ip) && IpUtil.validMask(mask)){
            ipAddress = new IpAddress(ip,mask);

            return ipAddress;
        } else {
            return new IpAddress(false);
        }

    }


}
