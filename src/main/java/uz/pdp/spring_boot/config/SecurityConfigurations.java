package uz.pdp.spring_boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import uz.pdp.spring_boot.services.ApplicationUserDetailsService;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserDetailsService service;

    public SecurityConfigurations(PasswordEncoder passwordEncoder, ApplicationUserDetailsService service) {
        this.passwordEncoder = passwordEncoder;
        this.service = service;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**", "/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement(session ->
                        session.maximumSessions(1)
                                .maxSessionsPreventsLogin(false))
                .authorizeRequests((authorizeRequests) -> authorizeRequests
                        .antMatchers("/", "/css/*", "/js/*")
                        .permitAll().anyRequest()
                        .authenticated())
                .formLogin((httpSecurityFormLoginConfigurer) -> httpSecurityFormLoginConfigurer
                        .permitAll().loginPage("/auth/login")
                        .loginProcessingUrl("/auth/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true))
                .rememberMe((httpSecurityRememberMeConfigurer) ->
                        httpSecurityRememberMeConfigurer
                                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30))
                                .alwaysRemember(false)
                                .userDetailsService(service)
                                .key("#$@#$WERWE%#$%#SDT#^$%^")
                                .rememberMeParameter("remember-me"))
                .logout(logout -> logout
                        .logoutUrl("/auth/logout")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID", "remember-me")
                        .logoutSuccessUrl("/auth/login"));

        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(service);
        return daoAuthenticationProvider;
    }
}
