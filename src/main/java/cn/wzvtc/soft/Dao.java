package cn.wzvtc.soft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


//TODO
@Service
public class Dao {

    //SpringBoot提供的数据库操作类
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean checkUser(String username,String password) {
        String sql="select * from student where username='"+username+"' and password='"+password+"'";
        List list=jdbcTemplate.queryForList(sql);
        return !list.isEmpty();
    }

    /*
    public void createUser(User user) {
        jdbcTemplate.update("insert into users(name,age)values(?,?)",user.getName(),user.getAge());
    }
*/
    public List<Map> getList(){
        return null;
       //return  List<Map<String,Object>> lists = jdbcTemplate.queryForList("");

    }

}
