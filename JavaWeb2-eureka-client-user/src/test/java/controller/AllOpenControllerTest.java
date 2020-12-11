package controller;

import org.junit.Test;

import com.javaweb.constant.SystemConstant;
import com.javaweb.util.core.HttpUtil;
import com.javaweb.web.eo.user.UserLoginRequest;

public class AllOpenControllerTest extends BaseControllerTest {
	
	@Test
	public void testWebLogin() throws Exception {
		UserLoginRequest userLoginRequest = new UserLoginRequest();
		userLoginRequest.setUsername(SystemConstant.ADMIN);
		userLoginRequest.setPassword(SystemConstant.ADMIN);
		userLoginRequest.setClientType(1);
		userLoginRequest.setLoginWay(1);
		String out = HttpUtil.defaultPostRequest(URL_PREFIX+"/webLogin",objectMapper.writeValueAsString(userLoginRequest),null);
		System.out.println(out);
	}

}
