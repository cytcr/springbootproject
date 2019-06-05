package com.tcr.springboottest.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2 配置
 *
 * @since 1.0
 * @version 1.0
 * @author RayLi
 */
@Configuration
@EnableSwagger2
//@ComponentScan
public class Swagger2Config {
	/**
	 * swagger2 API 注解配置 主题
	 */
	@Value("${swagger2-config.title:SPRINGBOOTTEST API管理接口}")
	private String swagger2ConfigTitle;
	/**
	 * swagger2 API 注解配置 主题
	 */
	@Value("${swagger2-config.desc:springboot练习}")
	private String swagger2ConfigDesc;
	/**
	 * swagger2 API 注解配置 联系人 名称
	 */
	@Value("${swagger2-config.contact.name:tcr}")
	private String swagger2ConfigContactName;
	/**
	 * swagger2 API 注解配置 项目地址默认 为空
	 */
	@Value("${swagger2-config.contact.url:\"\"}")
	private String swagger2ConfigContactUrl;
	/**
	 * swagger2 API 注解配置 联系人邮箱
	 */
	@Value("${swagger2-config.contact:670830864@qq.com}")
	private String swagger2ConfigContactEmail;
	/**
	 * swagger2 API 注解配置 版本
	 */
	@Value("${swagger2-config.version:1.0.0}")
	private String swagger2ConfigVersion;

	/**
	 * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
	 *
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				// globalOperationParameters 该参数 用来配置把token作为参数传递
//                .globalOperationParameters(setToken())
                .apiInfo(apiInfo()).select()
				// 为当前包路径
				//扫描指定包中的swagger注解
//				.apis(RequestHandlerSelectors.basePackage("com.boco.scms.business.baseuser.controller"))
				//扫描所有有注解的api，用这种方式更灵活
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any())
				.build()
				.securitySchemes(securitySchemes())
				.securityContexts(securityContexts());
	}

	/**
	 * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 页面标题
				.title(swagger2ConfigTitle)
				// 创建人
				.contact(new Contact(swagger2ConfigContactName, swagger2ConfigContactUrl, swagger2ConfigContactEmail))
				// 版本号
				.version(swagger2ConfigVersion)
				// 描述
				.description(swagger2ConfigDesc).build();
	}

	private List<ApiKey> securitySchemes() {
		List<ApiKey> apiKeyList = new ArrayList();
		//如果使用 **apiKeyList.add(new ApiKey("x-auth-token", "x-auth-token", "header"));
		apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
		return apiKeyList;
	}

    /**
     * 设置token参数 添加额外的参数
     * @return
     */
   /* private List<Parameter> setToken(){
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("access_token")
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("query")
//                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());
        return pars;
    }*/
	private List<SecurityContext> securityContexts() {
		List<SecurityContext> securityContexts = new ArrayList<>();
		securityContexts.add(SecurityContext.builder().securityReferences(defaultAuth())
				// 所有包含"auth"的接口不需要使用securitySchemes
				.forPaths(PathSelectors.regex("^(?!auth).*$")).build());
		return securityContexts;
	}

	/**
	 * 添加 swagger 的权限认证配置
	 * @return
	 */
	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		List<SecurityReference> securityReferences = new ArrayList<>();
		securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
		return securityReferences;
	}

}
