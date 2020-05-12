package ikvych.resume.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class WebSiteFilter extends AbstractWebResumeFilter {
    @Value("${application.production}")
    private boolean production;

    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        String requestUrl = servletRequest.getRequestURI();
        servletRequest.setAttribute("REQUEST_URL", requestUrl);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        catch (Throwable throwable) {
            LOGGER.error("Process request failed: " + requestUrl, throwable);
            handleException(throwable, requestUrl, servletResponse);
        }
    }

    private void handleException(Throwable th, String requestUrl, HttpServletResponse resp) throws ServletException, IOException {
        if(production) {
            if ("/error".equals(requestUrl)) {
                throw new ServletException(th);
            } else {
                resp.sendRedirect("/error?url=" + requestUrl);
            }
        } else {
            throw new ServletException(th);
        }
    }
}