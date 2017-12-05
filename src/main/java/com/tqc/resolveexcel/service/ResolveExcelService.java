package com.tqc.resolveexcel.service;

import com.tqc.resolveexcel.model.excel.ExcelResultSet;

/**
 * Created by tangqingchang on 2017/12/4.
 * 解析Excel核心接口
 */
public interface ResolveExcelService {

	/**
	 * @param path excel文件路径
	 * @return 解析结果
	 */
	ExcelResultSet resolveExcel(String path);
}
