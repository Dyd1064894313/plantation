package top.duanyd.plantation.filter;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/25.
 */
public class FrameFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(FrameFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        if(uri.contains("/resources")){//如果包含resources路径则不拦截
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if(uri.contains("/login")){//如果登录不拦截
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        String userCode= session.getAttribute("userCode") == null ? "" : (String) session.getAttribute("userCode");
        if(userCode == null || userCode.trim().length() == 0){
            Map<String, Object> result = new HashMap<>(2);
            result.put("code", -1);
            result.put("message", "用户未登录");
            String json = JSONObject.toJSONString(result);
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
            return ;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
