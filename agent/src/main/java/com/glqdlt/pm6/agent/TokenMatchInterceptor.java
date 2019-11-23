package com.glqdlt.pm6.agent;

import com.glqdlt.pm6.security.matcher.SecurityTokenMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public class TokenMatchInterceptor implements HandlerInterceptor {

    public static final String SECURITY_HEADER = "xxx-auth";
    private SecurityTokenMatcher securityTokenMatcher;

    public TokenMatchInterceptor(SecurityTokenMatcher securityTokenMatcher) {
        this.securityTokenMatcher = securityTokenMatcher;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String h = request.getHeader(SECURITY_HEADER);
        if (h == null || h.equals("")) {
            throw new NotAllowHeaderError(request.getRequestURL().toString(), request.getRemoteAddr());
        }
        boolean a = securityTokenMatcher.match(h);
        if (!a) {
            throw new NotAllowHeaderError(request.getRequestURL().toString(), request.getRemoteAddr());
        }
        return true;
    }
}
