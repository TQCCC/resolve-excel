package com.tqc.resolvingexcel.service;

import com.tqc.resolvingexcel.model.excel.ExcelResultSet;

import java.io.InputStream;

/**
 * Created by tangqingchang on 2017/12/4.
 * 解析Excel核心接口
 */
public interface ResolveExcelService {

	/**
	 * @param is excel文件输入流
	 * @return 解析结果
	 */
	ExcelResultSet resolveExcel(InputStream is);
}
