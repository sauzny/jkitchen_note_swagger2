package com.sauzny.sbswaggergateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Value("${rest.api.paths}")
    private List<String> apiPaths;
	
	public static Map<String, String> map = new HashMap<String, String>();
	
	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
		if(!CollectionUtils.isEmpty(apiNames)) {
			apiNames.forEach(apiName -> {
			});
			for(int i=0; i<apiNames.size(); i++) {
				String apiName = apiNames.get(i);
				String apiPath = apiPaths.get(i);
				resources.add(swaggerResource(apiName, "/openapi/" + apiName, "1.0"));
				DocumentationConfig.map.put(apiName, apiPath);
			}
			
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
