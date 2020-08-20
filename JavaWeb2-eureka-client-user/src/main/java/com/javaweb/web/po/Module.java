package com.javaweb.web.po;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.javaweb.annotation.sql.Column;
import com.javaweb.annotation.sql.Table;
import com.javaweb.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="sys_module")
public class Module extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 8495542220648641440L;

	private List<Module> list;/**辅助属性*/
	
	private String parentName;/**辅助属性（模块的上级模块名称）*/
	
	@NotEmpty(groups={update.class,delete.class},message="validated.module.moduleId.notEmpty")
	@Column(name="module_id",pk=true)
	private String moduleId;//模块ID
	
	@NotEmpty(groups={add.class,update.class},message="validated.module.moduleName.notEmpty")
	@Column(name="module_name")
	private String moduleName;//模块名称
	
	@Column(name="page_url")
	private String pageUrl;//页面URL
	
	@Column(name="api_url")
	private String apiUrl;//API的URL
	
	@Column(name="parent_id")
	private String parentId;//模块的上级ID
	
	@Column(name="fcode")
	private String fcode;//层级关系
	
	@Column(name="level")
	private Integer level = 0;//第几级(0表示未定义层级数;层级数1为最高,即根节点)
	
	@Column(name="orders")
	private Integer orders = 0;//模块顺序(0表示没有顺序;顺序从1开始)
	
	@Column(name="module_type")
	private Integer moduleType = 0;//模块类型(0:未定义模块类型;1:目录;2:菜单；3:功能)
	
	@Column(name="alias")
	private String alias;//别名
	
	@Column(name="parent_alias")
	private String parentAlias;//上级别名
	
	@Column(name="system_id")
	private String systemId;//系统ID
	
	@Column(name="remark")
	private String remark;//备注
	
	@Column(name="icon")
	private String icon;//图标
	
	@Column(name="type")
	private Integer type = 0;//类型(0:未定义类型,作为全端通用接口使用;1:PC端;2:安卓端;3:IOS端) 

}