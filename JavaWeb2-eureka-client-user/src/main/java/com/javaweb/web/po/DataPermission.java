package com.javaweb.web.po;

import java.io.Serializable;

import com.javaweb.annotation.sql.Column;
import com.javaweb.annotation.sql.Table;
import com.javaweb.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="sys_data_permission")
public class DataPermission extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -4584788854424411139L;
	
    @Column(name="id",pk=true,columnDesc="ID")
    private String id;//ID
    
    @Column(name="exclude_field",columnDesc="排除字段")
    private String excludeField;//排除字段
    
    @Column(name="interfaces_id",columnDesc="接口ID")
    private String interfacesId;//接口ID
    
    @Column(name="remark",columnDesc="备注说明")
    private String remark;//备注说明

}
