package app.listener;

import app.security.SecurityConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        SecurityConfig securityConfig = new SecurityConfig();

        securityConfig.configureAdminRights("/delete", "/edit", "/add");
        securityConfig.configureUserRights("/news");

        sce.getServletContext().setAttribute("securityConfig", securityConfig);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
