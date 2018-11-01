package com.sauzny.sbapigateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

// Swagger 目测是不支持webflux 所以 spring cloud gateway暂时不能这么用 
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

	@Value("${rest.api.names}")
    private List<String> apiNames;
	
	private static final String SWAGGER_API_PATH_PREFIX = "/v2/api-docs";
	
	@Override
	public List<SwaggerResource> get() {
		System.out.println(apiNames);
		List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
		if(!CollectionUtils.isEmpty(apiNames)) {
			apiNames.forEach(apiName -> {
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
