package top.duanyd.plantation.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.duanyd.plantation.dto.Result;
import top.duanyd.plantation.utils.ResultUtil;
import top.duanyd.plantation.utils.TokenUtil;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/login")
    @ResponseBody
    public Result<Map> login(@RequestBody Map params, HttpSession session){
        logger.info("params = {}", JSONObject.toJSONString(params));
        String userName = String.valueOf(params.get("userName"));
        String token = TokenUtil.generateToken(userName, null);
        session.setAttribute("userCode", userName);
        Map resut = new HashMap();
        resut.put("token", token);
        return ResultUtil.success(resut);
    }
}
