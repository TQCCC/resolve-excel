package com.tqc.resolveexcel.controller;

import com.tqc.resolveexcel.model.excel.ExcelSet;
import com.tqc.resolveexcel.service.ResolveExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by tangqingchang on 2017/12/4.
 * 解析Excel的controller
 */
@Controller
public class ResolveExcelController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(ResolveExcelController.class);

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
    public ModelAndView uploadExcel(HttpServletRequest request, @RequestParam("file") MultipartFile file) {

        String filename = file.getOriginalFilename();
        if (!isExcelFilename(filename)) {
            return error("upload", "请上传后缀名是xls、xlsx的excel文件");
        }

        try {
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            File uploadFile = new File(uploadDir + UUID.randomUUID() + file.getOriginalFilename());
            //先保存到本地
            file.transferTo(uploadFile);
            //解析，返回结果
            ExcelSet excelSet = resolveExcelService.resolveExcel(uploadFile.getAbsolutePath());

            return success("upload", excelSet);
        } catch (Exception e) {
            e.printStackTrace();
            return error("upload", e.getMessage());
        }

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
