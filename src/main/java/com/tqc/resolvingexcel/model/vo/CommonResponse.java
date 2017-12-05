package com.tqc.resolvingexcel.model.vo;

import com.tqc.resolvingexcel.enums.CommonResultEnum;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by tangqingchang on 2017/12/4.
 * Excel解析系统统一返回VO
 */
@Data
@ToString(callSuper = true)
public class CommonResponse implements Serializable {
	private static final long serialVersionUID = -6822703863649643266L;

	/**
	 * 返回数据
	 * */
	private Object data;

	/**
	 * 结果码
	 * */
	private Integer resultCode = CommonResultEnum.SUCCESS.getState();

	/**
	 * 结果描述、错误描述
	 * */
	private String msg;

	public CommonResponse() {

	}

	public CommonResponse(CommonResultEnum commonResultEnum) {
		this.resultCode = commonResultEnum.getState();
		this.msg = commonResultEnum.getStateInfo();
	}

	public CommonResponse(Object data, CommonResultEnum commonResultEnum) {
		this.data = data;
		this.resultCode = commonResultEnum.getState();
		this.msg = commonResultEnum.getStateInfo();
	}

}
