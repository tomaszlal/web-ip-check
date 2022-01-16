package ma.cu.lalewicz.webipcheck.controller;

import ma.cu.lalewicz.webipcheck.model.IpAddress;
import ma.cu.lalewicz.webipcheck.service.IpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IpController {

    @Autowired
    IpService ipService;

    @GetMapping("/ip/{ip}/{mask}")
    private IpAddress getInformation(@PathVariable("ip") String ip,@PathVariable("mask") String mask){
        return ipService.getInfoOfAdrress(ip, mask);
    }
}
