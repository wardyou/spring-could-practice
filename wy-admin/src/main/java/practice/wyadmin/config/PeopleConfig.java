package practice.wyadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import practice.wyadmin.bean.People;


/**
 * 人配置
 *
 * @author
 * @create 2019-05-27 10:28
 */
@Component
public class PeopleConfig {
    @Bean
    public People allPeople() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aotu/peo.xml");
        People bean = context.getBean("people", People.class);
        return bean;
    }

}
