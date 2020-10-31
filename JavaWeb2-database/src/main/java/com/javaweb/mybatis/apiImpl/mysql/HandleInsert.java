package com.javaweb.mybatis.apiImpl.mysql;

import java.util.List;

import com.javaweb.enums.DbTypeEnum;
import com.javaweb.exception.ServiceException;
import com.javaweb.mybatis.apiImpl.SqlBuildInfo;
import com.javaweb.mybatis.apiImpl.SqlHandle;

public class HandleInsert implements SqlHandle {

	public String handle(SqlBuildInfo sqlBuildInfo) {
		StringBuilder stringBuilder = new StringBuilder();
		if(DbTypeEnum.MYSQL.equals(sqlBuildInfo.getDbTypeEnum())){
			String tableName = sqlBuildInfo.getTableName();
			List<Object> entityValueList = sqlBuildInfo.getEntityValueList();
			List<String> columnList = sqlBuildInfo.getColumnList();
			if(sqlBuildInfo.getPkGenerate()){//主键自增的处理
				for(int i=0;i<columnList.size();i++){
					if(sqlBuildInfo.getPk().equals(columnList.get(i))){
						columnList.remove(i);
						entityValueList.remove(i);
						break;
					}
				}
			}
			stringBuilder.append("insert into ").append(tableName).append("(");
			for(int i=0;i<columnList.size();i++){
				stringBuilder.append(columnList.get(i));
				if(i!=columnList.size()-1){
					stringBuilder.append(",");
				}
			}
			stringBuilder.append(")").append(" values ").append("(");
			for(int i=0;i<entityValueList.size();i++){
				Object eachValue = entityValueList.get(i);
				if(eachValue==null){
					stringBuilder.append("null");
				}else if(eachValue instanceof String){
					stringBuilder.append("'"+entityValueList.get(i)+"'");
				}else{
					stringBuilder.append(entityValueList.get(i));
				}
				if(i!=entityValueList.size()-1){
					stringBuilder.append(",");
				}
			}
			stringBuilder.append(")");
		}else{
			throw new ServiceException("目前只支持mysql数据库");
		}
		return stringBuilder.toString();
	}

}
