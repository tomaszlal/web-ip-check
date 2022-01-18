package ma.cu.lalewicz.webipcheck.controller;

import ma.cu.lalewicz.webipcheck.model.IpAddress;
import ma.cu.lalewicz.webipcheck.model.IpAndMask;
import ma.cu.lalewicz.webipcheck.service.IpService;
import ma.cu.lalewicz.webipcheck.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IpThController {

    String[] masksNet = {"/0 - 0.0.0.0", "/1 - 128.0.0.0", "/2 - 192.0.0.0", "/3 - 224.0.0.0", "/4 - 240.0.0.0"
            , "/5 - 248.0.0.0", "/6 - 252.0.0.0", "/7 - 254.0.0.0", "/8 - 255.0.0.0", "/9 - 255.128.0.0"
            , "/10 - 255.192.0.0", "/11 - 255.224.0.0", "/12 - 255.240.0.0", "/13 - 255.248.0.0"
            , "/14 - 255.252.0.0.", "/15 - 255.254.0.0", "/16 - 255.255.0.0", "/17 - 255.255.128.0"
            , "/18 - 255.255.194.0", "/19 - 255.255.224.0", "/20 - 255.255.240.0", "/21 - 255.255.248.0"
            , "/22 - 255.255.252.0", "/23 - 255.255.254.0", "/24 - 255.255.255.0", "/25 - 255.255.255.128"
            , "/26 - 255.255.255.192", "/27 - 255.255.255.224", "/28 - 255.255.255.240", "/29 - 255.255.255.248"
            , "/30 - 255.255.255.252", "/31 - 255.255.255.254", "/32 - 255.255.255.255"};

    @Autowired
    IpService ipService;



    @RequestMapping("/")
    public String index(Model model){


        List<IpAndMask> masksNetList = new ArrayList<IpAndMask>();
        for (int i=0;i < masksNet.length;i++){
            masksNetList.add(new IpAndMask(masksNet[i],i));
        }
        model.addAttribute("ipMask", new IpAndMask()); //przekazanie pustego obiektu do formularza
        model.addAttribute("masksNet",masksNetList); // przekazanie wartości do select option
//        model.addAttribute("ipAddress",new IpAddress(false));
        return "index";
    }

    @GetMapping("/checkip")
    public String checkip(@RequestParam(name = "ip") String ip,
                          @RequestParam(name = "mask") String mask,
                          Model model){
        List<IpAndMask> masksNetList = new ArrayList<IpAndMask>();
        for (int i=0;i < masksNet.length;i++){
            masksNetList.add(new IpAndMask(masksNet[i],i));
        }
        model.addAttribute("ipMask", new IpAndMask()); //przekazanie pustego obiektu do formularza
        model.addAttribute("masksNet",masksNetList);
        if (IpUtil.validateIp(ip)){
            IpAddress ipAddress = new IpAddress(ip,mask);
            System.out.println(ipAddress);
            model.addAttribute("ipAddress",ipAddress);

//            return "redirect:/";
            return "index";
        }
        else {
            return "error";
        }
    }


}
