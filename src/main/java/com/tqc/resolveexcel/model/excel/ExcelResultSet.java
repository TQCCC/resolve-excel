package com.tqc.resolveexcel.model.excel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tangqingchang on 2017/12/4.
 * 封装解析Excel完成后的内容
 */
public class ExcelResultSet implements Serializable {
	private static final long serialVersionUID = -3197016356844783536L;
	/**
	 * 工作表列表
	 */
	private List<ExcelSheet> sheets;

	public List<ExcelSheet> getSheets() {
		return sheets;
	}

	public void setSheets(List<ExcelSheet> sheets) {
		this.sheets = sheets;
	}
}
