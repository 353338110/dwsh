package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 年段表
 * 
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:16:09
 */
@Data
@TableName("dw_grade")
public class GradeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		@TableId(type = IdType.ID_WORKER_STR)
			

private String id;
	/**
	 * 学科id 目前只有英语
	 */
			

private String subjectId;
	/**
	 * 年级名称 如 初中
	 */
			

private String gradleName;
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
