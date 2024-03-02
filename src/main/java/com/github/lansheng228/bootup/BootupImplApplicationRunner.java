package com.github.lansheng228.bootup;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BootupImplApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        log.info("启动后执行");
//        var appService = new GameAppService();
//
//        SwingUtilities.invokeLater(() -> {
//            new AppFrame(appService);
//
//            log.info("UNO app is launched");
//        });
    }
}
