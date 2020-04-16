package cn.wzvtc.soft;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController("/" )
public class TestController {

    
    @RequestMapping(value="/data.json",method={RequestMethod.GET})
    public Map<String,String> bookById(){
    Map<String,String> resultMap=new HashMap<>();
    resultMap.put("myname","刘笑锋1");
    resultMap.put("mynumber","2012020045");
    return resultMap;
}
}