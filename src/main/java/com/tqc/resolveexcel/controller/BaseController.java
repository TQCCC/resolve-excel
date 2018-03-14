package com.tqc.resolveexcel.controller;

import com.tqc.resolveexcel.enums.CommonResultEnum;
import com.tqc.resolveexcel.model.vo.CommonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangqingchang on 2017/12/4.
 * 统一方法Controller
 */
@Controller
public class BaseController {

    public static final String RESULT_PROPERTY_NAME = "result";
    public static final String ERROR_PAGE_NAME = "error";

    /**
     * 抛出任何异常时统一处理函数
     */
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception e) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setMsg(e.getMessage());
        commonResponse.setResultCode(CommonResultEnum.ERROR.getState());
        return error(ERROR_PAGE_NAME, e.getMessage());
    }

    /**
     * 以下是处理错误调用
     */
    protected ModelAndView error(String view) {
        Map<String, Object> map = new HashMap<>();
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResultCode(CommonResultEnum.ERROR.getState());
        map.put(RESULT_PROPERTY_NAME, commonResponse);
        return new ModelAndView(view, map);
    }

    protected ModelAndView error(String view, String errorMsg) {
        Map<String, Object> map = new HashMap<>();
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResultCode(CommonResultEnum.ERROR.getState());
        commonResponse.setMsg(errorMsg);
        map.put(RESULT_PROPERTY_NAME, commonResponse);
        return new ModelAndView(view, map);
    }

    protected ModelAndView error(String view, String errorMsg, Object resultData) {
        Map<String, Object> map = new HashMap<>();
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResultCode(CommonResultEnum.ERROR.getState());
        commonResponse.setMsg(errorMsg);
        commonResponse.setData(resultData);
        map.put(RESULT_PROPERTY_NAME, commonResponse);
        return new ModelAndView(view, map);
    }

    /**
     * 以下是处理成功调用
     */
    protected ModelAndView success(String view) {
        Map<String, Object> map = new HashMap<>();
        map.put(RESULT_PROPERTY_NAME, new CommonResponse());
        return new ModelAndView(view, map);
    }

    protected ModelAndView success(String view, Object resultData) {
        Map<String, Object> map = new HashMap<>();
        map.put(RESULT_PROPERTY_NAME, new CommonResponse(resultData, CommonResultEnum.SUCCESS));
        return new ModelAndView(view, map);
    }
}
