package com.ph.common.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ph.common.dto.AjaxObj;

public class ResponseUtil {

	public static void sendMsgByJson(HttpServletResponse response, int code, String msg) throws IOException {
		response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        AjaxObj ajaxObj = new AjaxObj(code, msg);
        writer.print(JSON.toJSONString(ajaxObj));
        writer.close();
        response.flushBuffer(); 
	}
}