package cn.wzvtc.soft;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List bookById() {
        List resultList=dao.getCourseList();
        return resultList;
    }


    @RequestMapping(value = "/addCourse")
    public void addCourse(String name,int credit) {
        dao.addCourse(name,credit);
    }

    @RequestMapping(value = "/creditByName")
    public int getCrditByName(String name,HttpSession httpSession) {
        if(httpSession.getAttribute("username")==null){
            return -1;
        }

        if("计算机编程基础".equals(name)){
            return 4;
        }else {
            return 2;
        }
    }

    @Autowired
    Dao dao;

    @RequestMapping(value="/login")
    public boolean login(String password,String username,HttpSession httpSession){
        if(dao.checkUser(username,password)){
            httpSession.setAttribute("username",username);
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping(value="/logout")
    public void llogoutogin(HttpSession httpSession){
        httpSession.invalidate();
    }
}