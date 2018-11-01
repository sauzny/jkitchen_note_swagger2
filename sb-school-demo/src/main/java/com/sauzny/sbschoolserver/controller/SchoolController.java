package com.sauzny.sbschoolserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("学校服务")
@RestController
@RequestMapping(value="/api/school/v1")
public class SchoolController {

	@GetMapping()
	@ApiOperation(value="hello方法")
	public String get() {
		return "school hello";
	}
}
