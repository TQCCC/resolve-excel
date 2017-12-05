package com.tqc.resolveexcel.service.impl;

import com.tqc.resolveexcel.exception.CommonException;
import com.tqc.resolveexcel.model.excel.ExcelResultSet;
import com.tqc.resolveexcel.model.excel.ExcelSheet;
import com.tqc.resolveexcel.service.ResolveExcelService;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tangqingchang on 2017/12/5.
 * 解析Excel实现类
 */
@Service
public class ResolveExcelServiceImpl implements ResolveExcelService {

	private static Logger logger = LoggerFactory.getLogger(ResolveExcelServiceImpl.class);

	@Override
	public ExcelResultSet resolveExcel(String path) {
		logger.info("开始解析excel文件: {}", path);

		ExcelResultSet excelResultSet = new ExcelResultSet();
		try {
			//Excel文件
			Workbook workbook = WorkbookFactory.create(new File(path));

			List<ExcelSheet> sheets = new ArrayList<ExcelSheet>();
			Iterator<Sheet> its = workbook.sheetIterator();
			//处理每个sheet
			while (its.hasNext()) {
				Sheet sheet = its.next();
				ExcelSheet excelSheet = new ExcelSheet();
				excelSheet.setName(sheet.getSheetName());

				List<List<String>> content = new ArrayList<List<String>>();
				Iterator<Row> itr = sheet.rowIterator();
				//处理该sheet下每一行
				while (itr.hasNext()) {
					Row row = itr.next();
					List<String> contentsOfRow = new ArrayList<String>();
					Iterator<Cell> itc = row.cellIterator();
					//处理该行每个cell
					while (itc.hasNext()) {
						Cell cell = itc.next();
						contentsOfRow.add(cell.toString());
					}
					content.add(contentsOfRow);
				}
				excelSheet.setContent(content);
				sheets.add(excelSheet);
			}
			excelResultSet.setSheets(sheets);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException("文件解析错误: " + e.getMessage(), e);
		}
		return excelResultSet;
	}
}
