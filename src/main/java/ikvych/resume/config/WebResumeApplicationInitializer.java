package ikvych.resume.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.Sm2TagRuleBundle;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

public class WebResumeApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = createWebApplicationContext(servletContext);

        servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
        servletContext.addListener(new ContextLoaderListener(context));

        registerFilters(servletContext, context);
        registerSpringMVCDispatcherServlet(servletContext, context);
    }

    public void registerFilters(ServletContext servletContext, WebApplicationContext context) {
        registerFilter(servletContext, new CharacterEncodingFilter("UTF-8", true));
        registerFilter(servletContext, buildConfigurableSiteMeshFilter(), "sitemesh");
        registerFilter(servletContext, new DelegatingFilterProxy("springSecurityFilterChain", context), "springSecurityFilterChain");
        registerFilter(servletContext, new OpenEntityManagerInViewFilter());
    }

    public void registerFilter(ServletContext servletContext, Filter filter, String... filters) {
        String filterName = filters.length > 0 ? filters[0] : filter.getClass().getSimpleName();
        servletContext.addFilter(filterName, filter).addMappingForUrlPatterns(null, true, "/*");
    }

    public WebApplicationContext createWebApplicationContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.scan("ikvych.resume.config");
        applicationContext.setServletContext(servletContext);
        applicationContext.refresh();
        return applicationContext;
    }

    public void registerSpringMVCDispatcherServlet(ServletContext servletContext, WebApplicationContext context) {
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
    }

    public ConfigurableSiteMeshFilter buildConfigurableSiteMeshFilter() {
        return new ConfigurableSiteMeshFilter() {
            @Override
            protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
                builder.addDecoratorPath("/*", "/WEB-INF/template/page-template.jsp")
                        .addTagRuleBundle(new Sm2TagRuleBundle());
            }
        };
    }
}
