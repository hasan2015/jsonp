/**
 * 
 */
package com.dd.dds.ctrl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dd.dds.dto.Company;

/**
 * @author Hasan
 * @Date 2016年5月21日 下午3:45:46
 *
 */
@Controller("Cors")
public class Cors {
	@RequestMapping("/get")
	public void get(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/plain");
		String callbackFunName = req.getParameter("callbackparam");// 得到js函数名称
		try {
			res.getWriter().write(callbackFunName + "([ { name:\"John\"}])"); // 返回jsonp数据
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getJsonp", method = RequestMethod.GET)
	@ResponseBody
	public JSONPObject getJsonp(String callbackparam) {
		Company company = new Company();
		company.setAddress("浙江省国家大学科技园");
		company.setEmail("hasan@qq.com");
		company.setName("曦客科技有限公司");
		company.setPhone("135880768929");
		return new JSONPObject(callbackparam, company);
	}
}
