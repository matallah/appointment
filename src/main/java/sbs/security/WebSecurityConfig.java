//package sbs.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import sbs.service.UsersService;
//
//import javax.sql.DataSource;
//
////@Configuration
////@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    public final static String ADMIN = "ADMIN";
//    public final static String USER = "USER";
//    //public final static Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//
//    @Autowired
//    private DataSource datasource;
//    @Autowired
//    private UsersService usersService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/bootstrap/**", "/dist/**", "/plugins/**").permitAll()
//                .antMatchers("/send-pin").permitAll()
//                .antMatchers("/send-email").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .failureUrl("/login?error")
//                .loginPage("/login").permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login")
//                .permitAll();
//    }
//
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/signup/**");
//        web.ignoring().antMatchers("/studentsguest/**");
//        web.ignoring().antMatchers("/reports/examsguest/**");
//        web.ignoring().antMatchers("/h2/**");
//        web.ignoring().antMatchers("/confirmEmail/**");
//        web.ignoring().antMatchers("/access-denied/**");
//        web.ignoring().antMatchers("/error/**");
//        web.ignoring().antMatchers("/visitors/**");
//    }
//
//    @Autowired
//    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(usersService)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }
///*
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        //this.runMigration();
//        //Use Spring Boots User detailsMAnager
//        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
//        //Set our Datasource to use the one defined in application.properties
//        userDetailsService.setDataSource(datasource);
//        //Create BCryptPassword encoder
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        //add components
//        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
//        auth.jdbcAuthentication().dataSource(datasource);
//        // add new user "user" with password "password" - password will be encrypted
//        if (!userDetailsService.userExists(ADMIN.toLowerCase())) {
//            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//            authorities.add(new SimpleGrantedAuthority(ADMIN));
//            User userDetails = new User(ADMIN.toLowerCase(), encoder.encode(ADMIN.toLowerCase()), authorities);
//            userDetailsService.createUser(userDetails);
//        }
//    }
//    */
//}
