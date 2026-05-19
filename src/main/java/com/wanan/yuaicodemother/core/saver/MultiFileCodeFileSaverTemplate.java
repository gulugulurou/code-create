package com.wanan.yuaicodemother.core.saver;

import com.wanan.yuaicodemother.ai.model.MultiFileCodeResult;
import com.wanan.yuaicodemother.exception.BusinessException;
import com.wanan.yuaicodemother.exception.ErrorCode;
import com.wanan.yuaicodemother.model.enums.CodeGenTypeEnum;

public class MultiFileCodeFileSaverTemplate extends CodeFileSaverTemplate<MultiFileCodeResult> {

    @Override
    public void validataInput(MultiFileCodeResult codeResult) {
        super.validataInput(codeResult);
        if (codeResult.getHtmlCode() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "html代码内容不能为空");
        }
    }

    @Override
    public CodeGenTypeEnum getCodeGenType() {
        return CodeGenTypeEnum.MULTI_FILE;
    }

    @Override
    public void saveFiles(MultiFileCodeResult result, String dirPath) {
        writeToFile(dirPath, "index.html", result.getHtmlCode());
        writeToFile(dirPath, "style.css", result.getCssCode());
        writeToFile(dirPath, "script.js", result.getJsCode());
    }
}
