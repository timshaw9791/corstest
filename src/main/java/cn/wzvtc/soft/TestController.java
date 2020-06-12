package cn.wzvtc.soft;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5500",allowCredentials = "true")
@RestController("/")
public class TestController {

    @RequestMapping(value = "/data.json")
    public List bookByIdWithAuthened(HttpSession httpSession) {
        String username = (String) httpSession.getAttribute("username");
        if (StringUtils.hasText(username)) {
            return bookById();
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/login")
    public boolean login(String username,String password,HttpSession httpSession) {
        if("2012020045".equals(username) && "lxf".equals(password)){
            httpSession.setAttribute("useranme","2012020045");
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpSession httpSession) {
        httpSession.removeAttribute("username");
    }







    private List bookById() {

        List resultList=new ArrayList();
        Map resultMap = new HashMap<>();
        resultMap.put("name", "计算机安装与维护");
        resultMap.put("credit", 2);
        resultList.add(resultMap);


        resultMap = new HashMap<>();
        resultMap.put("name", "静态网页制作");
        resultMap.put("credit", 2);
        resultList.add(resultMap);

        resultMap = new HashMap<>();
        resultMap.put("name", "计算机编程基础");
        resultMap.put("credit", 4);
        resultList.add(resultMap);

        resultMap = new HashMap<>();
        resultMap.put("name", "大学英语");
        resultMap.put("credit", 2);
        resultList.add(resultMap);

        return resultList;
    }


    @RequestMapping(value = "/creditByName")
    public int getCrditByName(String name) {
        if("计算机编程基础".equals(name)){
            return 4;
        }else {
            return 2;
        }
    }
}