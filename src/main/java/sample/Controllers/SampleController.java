package sample.Controllers;

;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sample.Model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @Autowired
    private RedisTemplate sessionRedisTemplate ;


    @RequestMapping("/redisTest")
    @ResponseBody
    String redisTest() {
        return sessionRedisTemplate.getHashKeySerializer().toString();
    }


    @RequestMapping("/")
    String home() {
        return "login";
    }

    @RequestMapping("/dologin")
    String login(HttpServletRequest req,Model model,HttpSession session) {
        if(null==req.getSession().getAttribute("user")){
            User u =  new User();
            u.setName(req.getParameter("username"));
            u.setPassword(req.getParameter("password"));
            req.getSession().setAttribute("user",u);
        }
        return "main";
    }
    @RequestMapping("/logout")
    String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}