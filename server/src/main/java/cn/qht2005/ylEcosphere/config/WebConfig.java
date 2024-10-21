package cn.qht2005.ylEcosphere.config;

import cn.qht2005.ylEcosphere.interceptor.JwtTokenAdminInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;
	/**
	 *  添加拦截器
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 登录接口不拦截
		registry.addInterceptor(jwtTokenAdminInterceptor).excludePathPatterns("/user/login","/admin/login",
				"/user/indexSlider/list", "/user/register",
				"/common/sendEmailCode"
		);
	}
}
