package com.sauzny.sbapigateway;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@RestController()
@RequestMapping("/swagger-resources")
public class SwaggerController {
	
	// 需要提供三个GET接口
	// /swagger-resources
	// /swagger-resources/configuration/ui
	// /swagger-resources/configuration/security
	
	@Autowired
    private SwaggerResourcesProvider swaggerResources;

    @Autowired(required = false)
    private SecurityConfiguration securityConfiguration;
    
	@GetMapping("")
	public  List<SwaggerResource> root() {
        return swaggerResources.get();
	}
	
	@GetMapping("/configuration/ui")
	public UiConfiguration ui() {
        return UiConfigurationBuilder.builder().build();
	}
	
	@GetMapping("/configuration/security")
	public SecurityConfiguration security() {
        return Optional.ofNullable(securityConfiguration)
                .orElse(SecurityConfigurationBuilder.builder().build());
	}
	
}
