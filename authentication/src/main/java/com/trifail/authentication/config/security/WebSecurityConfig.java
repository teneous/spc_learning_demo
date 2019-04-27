package com.trifail.authentication.config.security;

//import com.trifail.authentication.filter.JwtUsernameAndPasswordAuthenticationFilter;
import com.trifail.authentication.service.SysUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new SysUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置认证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//             .and().addFilterAfter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()),UsernamePasswordAuthenticationFilter.class)
//             .authorizeRequests()
//                .antMatchers(HttpMethod.POST,"/oauth/token").permitAll()
//                .anyRequest().authenticated();
//    }
//


}
