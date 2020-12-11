package com.javaweb.constant;

public class SwaggerConstant {

	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-基础常量 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_TITLE = "SpringBoot使用Swagger构建API文档";
	public static final String SWAGGER_HEAD_USERID = "用户ID";
	public static final String SWAGGER_HEAD_TOKEN = "TOKEN";
	public static final String SWAGGER_HEAD_TYPE = "登录类型";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-基础常量 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-AllOpenController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_ALL_OPEN_CONTROLLER_TAGS = "1、无需登录即可访问模块";
	
	public static final String SWAGGER_GET_SERVE_TIME = "获取服务器时间接口";
	public static final String SWAGGER_LOGIN = "用户登录接口";
	public static final String SWAGGER_REQUEST_PARAMETER_LOST = "请求参数缺失接口";
	public static final String SWAGGER_INVALID_REQUEST = "请求失效接口";
	public static final String SWAGGER_REQUEST_PARAMETER_ERROR = "请求参数错误接口";
	public static final String SWAGGER_NO_AUTHORY = "没有权限接口";
	public static final String SWAGGER_NOT_FOUND = "请求接口不存在接口";
	public static final String SWAGGER_INTERNAL_ERROR = "系统异常接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-AllOpenController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-LoginAccessController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_LOGIN_ACCESS_CONTROLLER_TAGS = "2、登录才可访问的模块";
	
	public static final String SWAGGER_LOGOUT = "用户登出接口";
	public static final String SWAGGER_GET_REDIS_TOKEN_DATA = "获取redis中的token信息接口";
	public static final String SWAGGER_GET_DICTIONARY = "获得字典信息接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-LoginAccessController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-ModuleController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_MODULE_CONTROLLER_TAGS = "3、登录且需要权限才可访问的模块管理模块";
	
	public static final String SWAGGER_MODULE_GET_MODULE_ID_AND_NAME_LIST = "获取模块ID和模块名称列表接口";
	public static final String SWAGGER_MODULE_ADD = "新增模块接口";
	public static final String SWAGGER_MODULE_LIST = "查询模块接口";
	public static final String SWAGGER_MODULE_MODIFY = "修改模块接口";
	public static final String SWAGGER_MODULE_DETAIL = "模块详情接口";
	public static final String SWAGGER_MODULE_DELETE = "删除模块接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-ModuleController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-RoleController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_ROLE_CONTROLLER_TAGS = "4、登录且需要权限才可访问的角色管理模块";
	
	public static final String SWAGGER_ROLE_ADD = "新增角色接口";
	public static final String SWAGGER_ROLE_LIST = "查询角色接口";
	public static final String SWAGGER_ROLE_MODIFY = "修改角色接口";
	public static final String SWAGGER_ROLE_DETAIL = "角色详情接口";
	public static final String SWAGGER_ROLE_DELETE = "删除角色接口";
	public static final String SWAGGER_ROLE_MODULE_ASSIGNMENT = "角色模块分配接口";
	public static final String SWAGGER_ROLE_MODULE_INFO = "角色模块信息接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-RoleController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-UserController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_USER_CONTROLLER_TAGS = "5、登录且需要权限才可访问的用户管理模块";
	
	public static final String SWAGGER_USER_ADD = "新增用户接口";
	public static final String SWAGGER_USER_LIST = "查询用户接口";
	public static final String SWAGGER_USER_MODIFY = "修改用户接口";
	public static final String SWAGGER_USER_DETAIL = "用户详情接口";
	public static final String SWAGGER_USER_DELETE = "删除用户接口";
	public static final String SWAGGER_USER_ROLE_INFO = "用户角色信息接口";
	public static final String SWAGGER_USER_ROLE_ASSIGNMENT = "用户角色分配接口";
	public static final String SWAGGER_USER_MODULE_INFO = "用户模块信息接口";
	public static final String SWAGGER_USER_MODULE_ASSIGNMENT = "用户模块分配接口";
	public static final String SWAGGER_USER_INIT_PASSWORD = "初始化密码接口";
	public static final String SWAGGER_USER_PORTRAIT_UPLOAD = "用户头像上传接口";
	public static final String SWAGGER_USER_PORTRAIT = "获取用户头像接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-UserController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-DictionaryController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_DICTIONARY_CONTROLLER_TAGS = "6、登录且需要权限才可访问的字典管理模块";
	
	public static final String SWAGGER_DICTIONARY_ADD = "新增字典接口";
	public static final String SWAGGER_DICTIONARY_LIST = "查询字典接口";
	public static final String SWAGGER_DICTIONARY_MODIFY = "修改字典接口";
	public static final String SWAGGER_DICTIONARY_DETAIL = "字典详情接口";
	public static final String SWAGGER_DICTIONARY_DELETE = "删除字典接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-UserController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-OperationLogController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_OPERATIONLOG_CONTROLLER_TAGS = "7、登录且需要权限才可访问的操作日志管理模块";
	
	public static final String SWAGGER_OPERATIONLOG_LIST = "查询操作日志接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-UserController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-OperationLogController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_SCHEDULE_CONTROLLER_TAGS = "8、登录且需要权限才可访问的日程管理模块";
	
	public static final String SWAGGER_SCHEDULE_LIST = "日程列表接口";
	public static final String SWAGGER_SCHEDULE_ADD = "保存日程接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-UserController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-InterfacesController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_INTERFACES_CONTROLLER_TAGS = "9、登录且需要权限才可访问的接口管理模块";
	
	public static final String SWAGGER_INTERFACES_LIST = "接口列表接口";
	public static final String SWAGGER_INTERFACES_MODIFY = "修改接口接口";
	public static final String SWAGGER_INTERFACES_DETAIL = "接口详情接口";
	public static final String SWAGGER_INTERFACES_USER_ROLE_DATA_PERMISSION = "用户角色数据权限接口";
	public static final String SWAGGER_INTERFACES_DATA_PERMISSION_ASSIGNMENT = "数据权限分配接口";
	public static final String SWAGGER_INTERFACES_TEST = "接口测试接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-UserController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-OnlineUserController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_ONLINE_USER_CONTROLLER_TAGS = "10、登录且需要权限才可访问的在线用户管理模块";
	
	public static final String SWAGGER_ONLINE_USER_LIST = "在线用户列表接口";
	public static final String SWAGGER_ONLINE_USER_OFFLINE = "用户下线接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-OnlineChatController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-DbTablesController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_DB_TABLES_CONTROLLER_TAGS = "11、登录且需要权限才可访问的数据库表管理模块";
	
	public static final String SWAGGER_DB_TABLES_LIST = "数据库表列表接口";
	public static final String SWAGGER_DB_TABLES_DETAIL = "数据库表详情接口";
	public static final String SWAGGER_DB_TABLES_CODE_GENERATE = "数据库表代码生成接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-DbTablesController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
}
