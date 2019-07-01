package com.inspur.shardingsphere.encrypt;

import com.inspur.shardingsphere.mybatis.service.SpringUserServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @Author chiyupei
 * @Date 19/6/28 上午11:31
 * @Version 1.0
 * @Description TODO
 */
public class SpringNamespaceExample {

    private static final String CONFIG_FILE = "META-INF/application-encrypt-databases.xml";

    public static void main(final String[] args) {
        try (ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_FILE)) {
            SpringUserServiceImpl userService = applicationContext.getBean(SpringUserServiceImpl.class);
//            userService.initEnvironment();
//            userService.processSuccess();
//            userService.cleanEnvironment();
            userService.printData();
            userService.selectOne();
        }
    }
}
