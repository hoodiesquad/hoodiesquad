package site.hoodiesquad.handlers;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserService userService;

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    private final Environment env;
//
//    public WebSecurityConfig(Environment env) {
//        this.env = env;
//    }
//
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf()
                .disable()
            .authorizeRequests()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/admin/**").authenticated()
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/resources/**").permitAll()
                //Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
            .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/admin")
                .permitAll()
            .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }
//
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}" + env.getProperty("app.admin_password"))
//                .roles("ADMIN");
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("admin")
//                .password(env.getProperty("app.admin_password"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/projects").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll();
//    }
//
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                    .username("admin")
//                    .password(Objects.requireNonNull(env.getProperty("app.admin_password")))
//                    .roles("ADMIN")
//                    .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
