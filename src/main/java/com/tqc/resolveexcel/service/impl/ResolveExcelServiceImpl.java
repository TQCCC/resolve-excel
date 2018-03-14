package com.tqc.resolveexcel.service.impl;

import com.tqc.resolveexcel.exception.CommonException;
import com.tqc.resolveexcel.model.excel.ExcelSet;
import com.tqc.resolveexcel.service.ResolveExcelService;
import com.tqc.resolveexcel.util.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by tangqingchang on 2017/12/5.
 * 解析Excel实现类
 */
@Service
public class ResolveExcelServiceImpl implements ResolveExcelService {

    private static Logger logger = LoggerFactory.getLogger(ResolveExcelServiceImpl.class);

    @Override
    public ExcelSet resolveExcel(String path) {
        logger.info("开始解析excel文件: {}", path);

        ExcelSet excelSet = new ExcelSet();
        try {
            excelSet = ExcelUtil.resolveExcel(path);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException("文件解析错误: " + e.getMessage(), e);
        }
        logger.info("解析excel文件结束: {}", path);
        return excelSet;
    }
}
