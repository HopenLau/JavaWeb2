package com.javaweb.web.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.base.BaseController;
import com.javaweb.base.BaseResponseResult;
import com.javaweb.base.BaseValidatedGroup;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.HttpCodeEnum;
import com.javaweb.util.core.DateUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.module.ModuleListRequest;
import com.javaweb.web.po.Module;
import com.javaweb.web.po.User;

@RestController
@RequestMapping("/web/pc/sys/module")
public class ModuleController extends BaseController {
	
	@PostMapping("/list")
	public BaseResponseResult moduleList(HttpServletRequest request,@RequestBody ModuleListRequest moduleListRequest){
		Page page = moduleService.moduleList(moduleListRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"module.list.success",page);
	}
	
	@DeleteMapping("/delete/{moduleId}")
	public BaseResponseResult moduleDelete(@PathVariable(name="moduleId",required=true) String moduleId){
		moduleService.moduleDelete(moduleId);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"module.delete.success",null);
	}
	
	@PostMapping("/add")
	public BaseResponseResult moduleAdd(HttpServletRequest request,@RequestBody @Validated({BaseValidatedGroup.add.class}) Module module,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,bindingResult,CommonConstant.EMPTY_VALUE);
		}else{
			TokenData tokenData = getTokenData(request);
			User currentUser = tokenData.getUser();
			module.setModuleId(UUID.randomUUID().toString());
			module.setCreateDate(DateUtil.getDefaultDate());
			module.setCreator(currentUser.getUserName());
			moduleService.moduleAdd(module);
			return getBaseResponseResult(HttpCodeEnum.SUCCESS,"module.add.success",null);
		}
	}
	
	@PutMapping("/modify")
	public BaseResponseResult moduleModify(HttpServletRequest request,@RequestBody @Validated({BaseValidatedGroup.update.class}) Module module,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,bindingResult,CommonConstant.EMPTY_VALUE);
		}else{
			TokenData tokenData = getTokenData(request);
			User currentUser = tokenData.getUser();
			module.setUpdateDate(DateUtil.getDefaultDate());
			module.setUpdater(currentUser.getUserName());
			moduleService.moduleModify(module);
			return getBaseResponseResult(HttpCodeEnum.SUCCESS,"module.modify.success",null);
		}
	}
	
	@GetMapping("/detail/{moduleId}")
	public BaseResponseResult moduleDetail(@PathVariable(name="moduleId",required=true) String moduleId){
		Module module = moduleService.moduleDetail(moduleId);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"module.detail.success",module);
	}

}
