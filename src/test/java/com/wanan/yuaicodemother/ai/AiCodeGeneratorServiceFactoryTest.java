package com.wanan.yuaicodemother.ai;

import com.wanan.yuaicodemother.ai.model.HtmlCodeResult;
import com.wanan.yuaicodemother.ai.model.MultiFileCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiCodeGeneratorServiceFactoryTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        HtmlCodeResult htmlCode = aiCodeGeneratorService.generateHtmlCode("写一个20行的登录页面");
        System.out.println(htmlCode);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult htmlCode = aiCodeGeneratorService.generateMultiFileCode("写一个20行的登录页面");
        System.out.println(htmlCode);
    }
}