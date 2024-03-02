package com.github.lansheng228;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@EnableCaching
@SpringBootApplication
//@EnableJpaAuditing
@EnableConfigurationProperties
public class UNOCardGameApplication {
    public static void main(String[] args) {
        SpringApplication.run(UNOCardGameApplication.class, args);
    }

//
//    public static void main(String[] args) {
//        var appService = new GameAppService();
//
//        SwingUtilities.invokeLater(() -> {
//            new AppFrame(appService);
//
//            logger.info("UNO app is launched");
//        });
//    }
}

