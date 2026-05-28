package com.wanan.yuaicodemother.ai;

import com.wanan.yuaicodemother.ai.model.HtmlCodeResult;
import com.wanan.yuaicodemother.ai.model.MultiFileCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    void testChatMemory() {
        HtmlCodeResult htmlCode = aiCodeGeneratorService.generateHtmlCode(1,"写一个20行的登录页面");
        System.out.println(htmlCode);
        htmlCode = aiCodeGeneratorService.generateHtmlCode(1, "不要生成代码，告诉我你刚才做了什么");
        System.out.println(htmlCode);
    }
}