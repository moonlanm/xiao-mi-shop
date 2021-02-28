package edu.hubu.xiaomishop.interceptor;

import edu.hubu.xiaomishop.model.Manager;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author moonlan
 * date 2021/1/12 下午3:31
 */
@SuppressWarnings(value = "unused")
public class BackendInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Manager user = (Manager) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/manager/login");
            return false;
        }

        return true;
    }
}
