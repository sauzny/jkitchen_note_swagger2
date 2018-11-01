package com.sauzny.sbstudentserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("学生服务")
@RestController
@RequestMapping(value="/api/student/v1")
public class StudentController {

	@GetMapping()
	@ApiOperation(value="hello方法")
	public String get() {
		return "student hello";
	}
}
