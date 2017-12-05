package com.tqc.resolvingexcel.model.excel;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by tangqingchang on 2017/12/5.
 * Excel表格中的一张工作表
 */
@Data
@ToString(callSuper = true)
public class ExcelSheet {

	/**
	 * 工作表名
	 */
	private String name;

	/**
	 * 行数
	 */
	private int numberOfRow;

	/**
	 * 单元格内容
	 * */
	private List<List<String>> content;

}
