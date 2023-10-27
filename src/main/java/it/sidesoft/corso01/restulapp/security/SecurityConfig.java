//package it.sidesoft.corso01.restulapp.security;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import static org.springframework.security.config.Customizer.withDefaults;
//@Configuration
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity
//                .authorizeHttpRequests((authz) ->
//                        authz
//                            .requestMatchers(new AntPathRequestMatcher("/progetto")).permitAll()
//                            .requestMatchers(new AntPathRequestMatcher("/v3/api-docs")).permitAll()
//                            .anyRequest().authenticated())
//                .httpBasic(withDefaults());
//        return httpSecurity.build();
//    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails user = User.withUsername("lucrezia")
//                .password(passwordEncoder().encode("qwer"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder(8);}
//}
