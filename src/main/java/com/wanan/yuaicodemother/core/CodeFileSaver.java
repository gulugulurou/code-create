package com.wanan.yuaicodemother.core;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.wanan.yuaicodemother.ai.model.HtmlCodeResult;
import com.wanan.yuaicodemother.ai.model.MultiFileCodeResult;
import com.wanan.yuaicodemother.model.enums.CodeGenTypeEnum;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class CodeFileSaver {
    // 文件保存根目录
    private static final String File_save_root_dir = System.getProperty("user.dir") + "/tmp/code_output";

    /**
     * 保存 HtmlCodeResult
     */
    public static File saveHtmlCodeResult(HtmlCodeResult result) {
        String dirPath = buildUniqueDir(CodeGenTypeEnum.HTML.getValue());
        writeToFile(dirPath, "index.html", result.getHtmlCode());
        return new File(dirPath);
    }

    /**
     * 保存 HtmlCodeResult
     */
    public static File saveMultiFileCodeResult(MultiFileCodeResult result) {
        String dirPath = buildUniqueDir(CodeGenTypeEnum.MULTI_FILE.getValue());
        writeToFile(dirPath, "index.html", result.getHtmlCode());
        writeToFile(dirPath, "style.css", result.getCssCode());
        writeToFile(dirPath, "script.js", result.getJsCode());
        return new File(dirPath);
    }

    /**
     * 构建唯一目录路径：/tmp/code_output/bizType_雪花ID
     */
    private static String buildUniqueDir(String bizType) {
        String snowId = String.format("%s_%s", bizType, IdUtil.getSnowflakeNextIdStr());
        String dirPath = File_save_root_dir + snowId;
        FileUtil.mkdir(dirPath);
        return dirPath;
    }

    /**
     * 写入单个文件
     */
    private static void writeToFile(String dirPath, String fileName, String content) {
        String filePath = dirPath + File.separator + fileName;
        FileUtil.writeString(content, filePath, StandardCharsets.UTF_8);
    }
}
