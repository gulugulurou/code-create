package com.wanan.yuaicodemother.core.saver;

import com.wanan.yuaicodemother.ai.model.HtmlCodeResult;
import com.wanan.yuaicodemother.exception.BusinessException;
import com.wanan.yuaicodemother.exception.ErrorCode;
import com.wanan.yuaicodemother.model.enums.CodeGenTypeEnum;


public class HtmlCodeFileSaverTemplate extends CodeFileSaverTemplate<HtmlCodeResult> {

    @Override
    public CodeGenTypeEnum getCodeGenType() {
        return CodeGenTypeEnum.HTML;
    }

    @Override
    public void validataInput(HtmlCodeResult codeResult) {
        super.validataInput(codeResult);
    }

    @Override
    public void saveFiles(HtmlCodeResult result, String dirPath) {
        writeToFile(dirPath, "index.html", result.getHtmlCode());
    }
}
