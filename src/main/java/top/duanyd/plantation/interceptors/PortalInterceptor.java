package top.duanyd.plantation.interceptors;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.duanyd.plantation.utils.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class PortalInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(PortalInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader("X-Token");
        HttpSession session = httpServletRequest.getSession();
        String sessionUserCode= session.getAttribute("userCode") == null ? "" : (String) session.getAttribute("userCode");
        String uri = httpServletRequest.getRequestURI();
        if(token == null || token.trim().length() == 0){
            Map<String, Object> result = new HashMap<>(2);
            result.put("code", -2);
            result.put("message", "用户未授权");
            dealErrorReturn(httpServletRequest, httpServletResponse, result);
            return false;
        }
        Claims claims = TokenUtil.verifyJwt(token);
        if(claims == null || !StringUtils.equals(String.valueOf(claims.get("userId")), sessionUserCode)){
            Map<String, Object> result = new HashMap<>(2);
            result.put("code", -1);
            result.put("message", "用户未登录");
            dealErrorReturn(httpServletRequest, httpServletResponse, result);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public void dealErrorReturn(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object obj){
        String json = JSONObject.toJSONString(obj);
        PrintWriter writer = null;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html; charset=utf-8");
        try {
            writer = httpServletResponse.getWriter();
            writer.print(json);
            writer.flush();
        } catch (IOException ex) {
            logger.error("response error",ex);
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
