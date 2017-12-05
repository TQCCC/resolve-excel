package com.tqc.resolvingexcel.model.excel;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tangqingchang on 2017/12/4.
 * 封装解析Excel完成后的内容
 */
@Data
@ToString(callSuper = true)
public class ExcelResultSet implements Serializable {
	private static final long serialVersionUID = -3197016356844783536L;

	/**
	 * 工作表数量
	 */
	private int numberOfSheet;

	/**
	 * 工作表列表
	 * */
	private List<ExcelSheet> sheets;
}
