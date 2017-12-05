package com.tqc.resolvingexcel.controller;

import com.tqc.resolvingexcel.model.excel.ExcelResultSet;
import com.tqc.resolvingexcel.service.ResolveExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tangqingchang on 2017/12/4.
 * 解析Excel的controller
 */
@Controller
public class ResolvingExcelController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(ResolvingExcelController.class);

	@Autowired
	private ResolveExcelService resolveExcelService;

	@Autowired
	private Environment env;

	@RequestMapping(value = "/")
	public ModelAndView hello() {
		return success("index");
	}

	@RequestMapping(value = "/upload")
	public ModelAndView upload() {
		return success("upload");
	}

	@RequestMapping(value = "/uploadExcel")
	public ModelAndView uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {

		String filename = file.getOriginalFilename();
		if (!isExcelFilename(filename)) {
			return error("upload", "请上传后缀名是xls、xlsx的excel文件");
		}

		InputStream is = file.getInputStream();
		ExcelResultSet excelResultSet = resolveExcelService.resolveExcel(is);
		is.close();
		return success("upload", excelResultSet);
	}


	/**
	 * 判断Excel文件后缀名是否正确
	 */
	private boolean isExcelFilename(String filename) {
		String ext = filename.substring(filename.lastIndexOf(".") + 1);
		String[] exts = env.getProperty("excel.types").split(",");
		for (String e : exts) {
			if (ext.equals(e)) {
				return true;
			}
		}
		return false;
	}

}
