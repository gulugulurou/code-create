package com.wanan.yuaicodemother.core.parser;

import com.wanan.yuaicodemother.exception.BusinessException;
import com.wanan.yuaicodemother.exception.ErrorCode;
import com.wanan.yuaicodemother.model.enums.CodeGenTypeEnum;

public class CodeParserExecutor {

    private static final HtmlCodeParser htmlCodeParser = new HtmlCodeParser();
    private static final MultiFileCodeParser multiFileCodeParser = new MultiFileCodeParser();

    public static Object executeParser(String CodeContent, CodeGenTypeEnum codeGenTypeEnum) {
        return switch (codeGenTypeEnum) {
            case HTML -> htmlCodeParser.parseCode(CodeContent);
            case MULTI_FILE -> multiFileCodeParser.parseCode(CodeContent);
            default -> throw new BusinessException(ErrorCode.SYSTEM_ERROR, "不支持的代码生成类型");
        };
    }
}
