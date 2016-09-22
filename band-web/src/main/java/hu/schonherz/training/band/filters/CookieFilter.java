package hu.schonherz.training.band.filters;

import hu.schonherz.training.band.utils.RemoteEJBLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hu.schonherz.training.landing.service.remote.UserRemoteService;
import hu.schonherz.training.landing.vo.remote.RemoteUserVo;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Attila on 2016.09.22..
 */
public class CookieFilter implements Filter {

    UserRemoteService userRemoteService;
    private static Logger LOG = LoggerFactory.getLogger(CookieFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        RemoteUserVo remoteUserVo = null;
        if (req.getCookies() != null) {
            List<Cookie> cookies = Arrays.asList(req.getCookies());
            String cookieValue = getHashFromCookies(cookies);
            if (cookieValue != null) {
                remoteUserVo = userRemoteService.getLoggedInUser(cookieValue);
                req.setAttribute("USER", remoteUserVo);
            }
        }
        if (remoteUserVo == null) {
            ((HttpServletResponse) response).sendRedirect("/../landing");
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        final String appName = "landing-ear";
        final String moduleName = "landing-service";
        final String distinctName = "";
        final String beanName = "UserService";

        try {
            userRemoteService = RemoteEJBLookup.lookup(UserRemoteService.class, appName, moduleName, distinctName, beanName);
        } catch (NamingException ne) {
            LOG.error(ne.toString());
        }
    }

    @Override
    public void destroy() {

    }

    private String getHashFromCookies(List<Cookie> cookies) {

        if (!cookies.isEmpty()) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loggedInUser")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
