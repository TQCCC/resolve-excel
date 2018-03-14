package com.tqc.resolveexcel.model.excel;


import java.io.File;
import java.util.List;

/**
 * Creator: qingchang.tang
 * Date: 2018/03/06
 * Time: 上午 9:45
 * 封装解析Excel完成后的内容
 */
public class ExcelSet {

    /**
     * 工作表列表
     */
    private List<ExcelSheet> sheets;

    /**
     * excel文件信息
     */
    private File excelFile;

    public List<ExcelSheet> getSheets() {
        return sheets;
    }

    public void setSheets(List<ExcelSheet> sheets) {
        this.sheets = sheets;
    }

    public File getExcelFile() {
        return excelFile;
    }

    public void setExcelFile(File excelFile) {
        this.excelFile = excelFile;
    }
}
