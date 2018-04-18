package ro.mindit.forum.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CookieInRequestInterceptor extends HandlerInterceptorAdapter {

        private static final String COOKIES_NOT_NEEDED_ON = "/user/";
        private static final String COOKIE_NAME_TO_BE_PRESENT = "isLogged";

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            return super.preHandle(request, response, handler);
        }
    }
