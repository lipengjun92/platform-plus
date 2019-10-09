package com.platform.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 在一个分布式系统中，服务注册中心是最重要的基础部分，理应随时处于可以提供服务的状态。
 * 如果是单点部署，如果注册中心出现故障，将会出现毁灭性的灾难。为了维持其可用性，使用
 * 集群是很好的解决方案。Eureka通过互相注册的方式来实现高可用的部署，所以我们只需要将
 * Eureke Server配置其他可用的serviceUrl就能实现高可用部署。
 *
 * @author 李鹏军
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaApplication.class, args);
    }

    /**
     * 2.1版本的security默认加上了 csrf 拦截, 所以需要通过重写方法, 把csrf拦截禁用
     * 参考: https://github.com/spring-cloud/spring-cloud-netflix/issues/2754
     * <pre>
     *     This is because @EnableWebSecurity is now added by default when Spring Security is on the classpath.
     *     This enable CSRF protection by default. You will have the same problem in 1.5.10 if you add @EnableWebSecurity.
     *     One work around, which is not the most secure workaround if you have browsers using the Eureka dashboard, is to disable CSRF protection.
     *     This can be done by adding the following configuration to your app.
     * </pre>
     */
    @EnableWebSecurity
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
//            http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
            // 禁用用户名密码
            http.csrf().disable();
        }
    }
}
