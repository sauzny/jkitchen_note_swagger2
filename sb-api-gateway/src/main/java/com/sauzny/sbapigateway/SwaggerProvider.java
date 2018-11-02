package com.sauzny.sbapigateway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

// Swagger 目测是不支持webflux 所以 spring cloud gateway暂时不能这么用 
@Component
@Primary
public class SwaggerProvider implements SwaggerResourcesProvider {

	// 这不能用List读取，但是我在别的 spring boot 项目里是可以的，并不知道为什么
	@Value("${rest.api.names}")
    private String[] apiNames;
	
	private static final String SWAGGER_API_PATH_PREFIX = "/v2/api-docs";
	
	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
		if(apiNames != null && apiNames.length > 0) {
			Arrays.stream(apiNames).forEach(apiName -> {
				// 注意application.yml中的openapi配置
				resources.add(swaggerResource(apiName, "/openapi/" + apiName + SWAGGER_API_PATH_PREFIX, "1.0"));
			});
		}
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
