//package com.github.lansheng228;
//
//import com.github.lansheng228.config.EmbeddedRedisStandaloneConfiguration;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.annotation.DirtiesContext.ClassMode;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//
//@Slf4j
//@ExtendWith(SpringExtension.class)
//@ActiveProfiles("test")
//@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//        classes = {EmbeddedRedisStandaloneConfiguration.class,
//                Application.class})
//@EnableConfigurationProperties
//public class ApplicationTest {
//
//    @Test
//    public void load() {
//        log.info("load...");
//    }
//}
