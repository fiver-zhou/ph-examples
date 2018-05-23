package com.ph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ph.common.annotion.ArchivesLog;
import com.ph.common.dto.AjaxObj;
import com.ph.service.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list", method={ RequestMethod.GET, RequestMethod.POST })
	public AjaxObj list() {
		return new AjaxObj(1, "", userService.list());	
	}
	
	@RequestMapping(value="/{id}/delete", method={ RequestMethod.GET, RequestMethod.POST })
	public AjaxObj delete(@PathVariable String id) {
		return new AjaxObj(1, "", "你删除了：" + id );	
	}
	
	@RequestMapping(value="/load", method={ RequestMethod.GET, RequestMethod.POST })
	@ArchivesLog(operationType="查询操作:",operationName="查询文件") 
	public AjaxObj load() {
		return new AjaxObj(1, "", "张三四 ");	
	}
}