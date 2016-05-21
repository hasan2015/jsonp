/**
 * 
 */
package com.dd.dds;

import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Hasan
 * @Date 2016年5月21日 下午10:36:26
 *
 */
public class AccessKeyInterceptor extends HandlerInterceptorAdapter { 

		private static Log log=LogFactory.getLog(AccessKeyInterceptor.class);
		
//		@Autowired
//		private IAccessService accessService;
		
		private String accessKeyParameterName="accessKey";
		private List<String> defaultAccessAllowedFrom;
		
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
			String accessKey=request.getParameter(accessKeyParameterName);
			String referer = request.getHeader("Referer");
			URL u = new URL(referer);
			String host = u.getHost().toLowerCase();
			if(accessKey==null){
				log.error("====================================ILLEGAL ACCESS: ACCESS_KEY_MISSING!=======================");
			}else{
				log.debug("====================================ACCESS WITH Access KEY:"+accessKey+"====================");
//				IAccess access = accessService.getAccess(UserSessionUtils.getUserSession(request), accessKey);
//				if(access!=null){
//					defaultAccessAllowedFrom=access.getAccessAllowedFrom();
//				}else{
//					log.warn("======================================ACCESS KEY:"+accessKey+" DOES NOT EXIST!=================");	
//				}
			}
			for(String s : defaultAccessAllowedFrom) {
				if(host.matches(s)){							
					response.setHeader("Access-Control-Allow-Origin", referer);
					break;
				}
			}
			response.setHeader("Access-Control-Allow-Headers", "Content-Type");
			response.setHeader("Access-Control-Allow-Methods", "GET");
			response.setHeader("Allow", "GET");
			return true;
		}
		
		public List<String> getDefaultAccessAllowedFrom() {
			return defaultAccessAllowedFrom;
		}

		public void setDefaultAccessAllowedFrom(List<String> defaultAccessAllowedFrom) {
			this.defaultAccessAllowedFrom = defaultAccessAllowedFrom;
		}

//		public String getAccessKeyParameterName() {
//			return AccessKeyParameterName;
//		}
//
//		public void setAccessKeyParameterName(String accessKeyParameterName) {
//			this.AccessKeyParameterName = AccessKeyParameterName;
//		}
	
	
	

}
