package com.javaweb.config.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.javaweb.util.core.HttpUtil;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
@Aspect
@Component
public class LogAspect {
	
	/* 如果业务要求只记录Controller校验通过的操作，最简单的方法就是将@Before变为@Around，主要判断逻辑示例如下： 
	@Around(value=DEFAULT_LOG_POINT_CUT)
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		Object object = joinPoint.proceed();
		String url = httpServletRequest.getRequestURL().toString();
		if(url.contains("add")||url.contains("modify")||url.contains("delete")){
			BaseResponseResult baseResponseResult = new ObjectMapper().readValue(JSONObject.fromObject(object).toString(),BaseResponseResult.class);
			if("200".equals(baseResponseResult.getCode().toString())){//只记录操作成功的数据
				//记录操作日志
			}
		}
		return object;
	}
	*/
	
	public static final String DEFAULT_LOG_POINT_CUT = "execution(* com.javaweb.web.controller..*.*(..))";

	@Before(value=DEFAULT_LOG_POINT_CUT)
	public void beforeMethod(JoinPoint joinPoint) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("请求URL：").append(httpServletRequest.getRequestURL().toString())
					 .append("，")
		             .append("请求方式：").append(httpServletRequest.getMethod())
		             .append("，")
		             .append("请求类方法：").append(joinPoint.getSignature())
		             .append("，")
		             .append("请求类方法参数：").append(Arrays.toString(joinPoint.getArgs()))
					 .append("，")
					 .append("请求IP：").append(HttpUtil.getIpAddress(httpServletRequest));
        log.info(stringBuilder.toString());
	}
	
	@AfterReturning(value=DEFAULT_LOG_POINT_CUT,returning="object")
	public void afterReturningMethod(Object object) {
		log.info("返回内容："+JSONObject.fromObject(object).toString());
	}

}
