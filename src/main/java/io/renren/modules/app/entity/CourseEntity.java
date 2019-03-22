package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程表
 * 
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:23:50
 */
@Data
@TableName("dw_course")
public class CourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		@TableId(type = IdType.ID_WORKER_STR)
			

private String id;
	/**
	 * 版本id 如人教版
	 */
			

private String versionId;
	/**
	 * 课程名称 如 元音课程
	 */
			

private String courseName;
	/**
	 * 价格
	 */
			

private BigDecimal price;
	/**
	 * 是否免费
	 */
			

private Integer isFree;
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
