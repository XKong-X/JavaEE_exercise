package com.xkong.demo;

import com.xkong.demo.component.UserComponent;
import com.xkong.demo.config.UserConfig;
import com.xkong.demo.controller.UserController;
import com.xkong.demo.repo.UserRepository;
import com.xkong.demo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IocDemoApplication {
    // spring 上下文
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(IocDemoApplication.class, args);
        // 从 context 中获取 bean
        UserController bean = context.getBean(UserController.class);
        bean.doController();

        UserService userService = context.getBean(UserService.class);
        userService.doService();
        // 根据名称来获取 bean
        UserService userService2 = (UserService) context.getBean("userService");
        userService2.doService();
        // 根据名称和类型
        UserService userService3 = context.getBean("userService", UserService.class);
        userService3.doService();

        UserRepository userRepository = context.getBean(UserRepository.class);
        userRepository.doRepository();

        UserComponent userComponent = context.getBean(UserComponent.class);
        userComponent.doComponent();

        UserConfig userConfig = context.getBean(UserConfig.class);
        userConfig.doConfig();

    }
}
