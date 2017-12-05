package com.tqc.resolvingexcel.service.impl;

import com.tqc.resolvingexcel.exception.CommonException;
import com.tqc.resolvingexcel.model.excel.ExcelResultSet;
import com.tqc.resolvingexcel.model.excel.ExcelSheet;
import com.tqc.resolvingexcel.service.ResolveExcelService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangqingchang on 2017/12/5.,m nb
 * 解析Excel实现类
 */
@Service
public class ResolveExcelServiceImpl implements ResolveExcelService {

	private static Logger logger = LoggerFactory.getLogger(ResolveExcelServiceImpl.class);

	@Override
	public ExcelResultSet resolveExcel(InputStream is) {

		ExcelResultSet excelResultSet = new ExcelResultSet();
		try {
			//Excel文件
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

			int numberOfSheet = xssfWorkbook.getNumberOfSheets();
			excelResultSet.setNumberOfSheet(numberOfSheet);

			List<ExcelSheet> sheets = new ArrayList<ExcelSheet>();
			//处理每个sheet
			for (int s = 0; s < numberOfSheet; s++) {
				ExcelSheet excelSheet = new ExcelSheet();
				XSSFSheet sheet = xssfWorkbook.getSheetAt(s);

				excelSheet.setName(sheet.getSheetName());
				int numberOfRow = sheet.getLastRowNum();
				excelSheet.setNumberOfRow(numberOfRow);

				List<List<String>> content = new ArrayList<List<String>>();
				//处理该sheet下每一行
				for (int r = 0; r < numberOfRow; r++) {
					List<String> contentsOfRow = new ArrayList<String>();
					XSSFRow row = sheet.getRow(r);
					short numberOfCell = (row == null) ? 0 : row.getLastCellNum();
					//处理该行每个cell
					for (int c = 0; c < numberOfCell; c++) {
						XSSFCell cell = row.getCell(c);
						if (cell == null) {
							contentsOfRow.add("");
						} else {
							contentsOfRow.add(cell.toString());
						}
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
