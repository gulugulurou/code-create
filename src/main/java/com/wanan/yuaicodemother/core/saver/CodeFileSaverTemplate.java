package com.wanan.yuaicodemother.core.saver;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.IdUtil;
import com.wanan.yuaicodemother.model.enums.CodeGenTypeEnum;
import com.wanan.yuaicodemother.exception.BusinessException;
import com.wanan.yuaicodemother.exception.ErrorCode;

import java.io.File;

public abstract class CodeFileSaverTemplate<T> {

    private static final String FILE_SAVE_ROOT_DIR = System.getProperty("user.dir") + "/temp/code_out_put";

    public final File saveCode(T codeResult) {
        // 校验 入参
        validataInput(codeResult);
        // 创建存储的文件夹
        String dirPath = buildDirPath();
        // 保存到文件
        saveFiles(codeResult, dirPath);

        return new File(dirPath);
    }

    private String buildDirPath() {
        String type = getCodeGenType().getValue();
        String uniqueDirName = String.format("%s_%s", type, IdUtil.getSnowflakeNextIdStr());
        String dirPath = FILE_SAVE_ROOT_DIR + File.separator + uniqueDirName;
        FileUtil.mkdir(dirPath);
        return dirPath;
    }

    protected final void writeToFile(String dirPath, String fileName, String content) {
        if (content != null && FileUtil.exist(dirPath + File.separator + fileName)) {
            String filePath = dirPath + File.separator + fileName;
            FileUtil.writeString(content, filePath, CharsetUtil.UTF_8);
        }
    }

    public void validataInput(T codeResult) {
        if (codeResult == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "生成的代码内容为空");
        }
    }

    public abstract CodeGenTypeEnum getCodeGenType();

    public abstract void saveFiles(T result, String dirPath);
}
