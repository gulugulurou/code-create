package com.wanan.yuaicodemother.ai;

import com.wanan.yuaicodemother.ai.model.HtmlCodeResult;
import com.wanan.yuaicodemother.ai.model.MultiFileCodeResult;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import reactor.core.publisher.Flux;

public interface AiCodeGeneratorService {

    /**
     * 生成 Html 代码 ( langchain4j 记忆功能版本)
     *
     * @param userMessage 用户信息
     * @return 生成的代码结果
     */
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    HtmlCodeResult generateHtmlCode(@MemoryId int menoryId, @UserMessage String userMessage);

    /**
     * 生成 Html 代码
     *
     * @param userMessage 用户信息
     * @return 生成的代码结果
     */
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    HtmlCodeResult generateHtmlCode(String userMessage);

    /**
     * 生成 多文件 代码
     *
     * @param userMessage 用户信息
     * @return 生成的代码结果
     */
    @SystemMessage(fromResource = "prompt/codegen-multi-file-system-prompt.txt")
    MultiFileCodeResult generateMultiFileCode(String userMessage);

    /**
     * 生成 Html 代码
     *
     * @param userMessage 用户信息
     * @return 生成的代码结果
     */
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    Flux<String> generateHtmlCodeStream(String userMessage);

    /**
     * 生成 多文件 代码
     *
     * @param userMessage 用户信息
     * @return 生成的代码结果
     */
    @SystemMessage(fromResource = "prompt/codegen-multi-file-system-prompt.txt")
    Flux<String> generateMultiFileCodeStream(String userMessage);
}
