package com.tqc.resolveexcel.model.excel;

import java.util.List;

/**
 * Creator: qingchang.tang
 * Date: 2018/03/06
 * Time: 上午 9:45
 * 表示Excel表中的一张工作表
 */
public class ExcelSheet {

    /**
     * 工作表名
     */
    private String name;

    /**
     * 单元格内容
     * 第一层List代表每行、第二层List代表每个单元格
     */
    private List<List<String>> content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<String>> getContent() {
        return content;
    }

    public void setContent(List<List<String>> content) {
        this.content = content;
    }

    public Integer getRowNumber() {
        return getContent().size();
    }
}
