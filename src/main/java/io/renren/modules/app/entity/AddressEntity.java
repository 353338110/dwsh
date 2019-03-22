package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 省市区联动表
 * 
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:23:50
 */
@Data
@TableName("dw_address")
public class AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		@TableId(type = IdType.ID_WORKER_STR)
			

private String id;
	/**
	 * 省市区名称
	 */
			

private String name;
	/**
	 * 上级id
	 */
			

private String parentId;
	/**
	 * 省份1城市2区县3
	 */
			

private Integer level;
	/**
	 * 邮编
	 */
			

private String code;
	/**
	 * 创建时间
	 */
			@TableField(fill = FieldFill.INSERT)
		

private Date createTime;
	/**
	 * 更新时间
	 */
				@TableField(fill = FieldFill.INSERT_UPDATE)
	

private Date updateTime;

}
