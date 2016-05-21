/**
 * 
 */
package com.dd.dds.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dd.dds.dto.Company;
import com.dd.dds.dto.User;

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

	@ResponseBody
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public List<User> json(HttpServletResponse response) {
		//response.addHeader("Access-Control-Allow-Origin", "*");//调测通过，可以跨域访问了
		 
		List<User> lUses = new ArrayList<User>();
		User user = new User();
		user.setAge("10");
		user.setId("201");
		user.setName("张三");
		user.setSex("nv");
		lUses.add(user);
		user = new User();
		user.setAge("12");
		user.setId("203");
		user.setName("李四");
		user.setSex("nan");
		lUses.add(user);

		return lUses;

	}

}
