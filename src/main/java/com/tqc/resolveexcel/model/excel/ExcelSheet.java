package com.tqc.resolveexcel.model.excel;

import java.util.List;

/**
 * Created by tangqingchang on 2017/12/5.
 * Excel表格中的一张工作表
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
}
