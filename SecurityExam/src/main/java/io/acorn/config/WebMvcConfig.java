package io.acorn.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 확장자가 Mustache로 되어있어서 config 로 기본 설정 변경
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		MustacheViewResolver resolver = new MustacheViewResolver();
		
		resolver.setCharset("UTF-8");
		resolver.setContentType("text/html;charset=UTF-8");
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".html"); // 기본값이 mustache로 되어있어서 html로 변경해줌
		
		registry.viewResolver(resolver);
	}
}
