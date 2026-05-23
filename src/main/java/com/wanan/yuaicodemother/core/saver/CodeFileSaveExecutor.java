package com.wanan.yuaicodemother.core.saver;

import com.wanan.yuaicodemother.ai.model.HtmlCodeResult;
import com.wanan.yuaicodemother.ai.model.MultiFileCodeResult;
import com.wanan.yuaicodemother.exception.BusinessException;
import com.wanan.yuaicodemother.exception.ErrorCode;
import com.wanan.yuaicodemother.model.enums.CodeGenTypeEnum;

import java.io.File;

public class CodeFileSaveExecutor {
    private static final HtmlCodeFileSaverTemplate htmlCodeFileSaverTemplate = new HtmlCodeFileSaverTemplate();
    private static final MultiFileCodeFileSaverTemplate multiFileCodeFileSaverTemplate = new MultiFileCodeFileSaverTemplate();

    public static File executeSaver(Object codeContent, CodeGenTypeEnum codeGenType, Long appId) {
        return switch (codeGenType) {
            case HTML-> htmlCodeFileSaverTemplate.saveCode((HtmlCodeResult) codeContent, appId);
            case MULTI_FILE-> multiFileCodeFileSaverTemplate.saveCode((MultiFileCodeResult) codeContent, appId);
            default -> throw new BusinessException(ErrorCode.SYSTEM_ERROR, "不支持的代码生成类型：" + codeGenType);
        };
    }
}
