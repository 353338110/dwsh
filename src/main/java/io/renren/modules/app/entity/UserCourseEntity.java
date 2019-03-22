package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生课程表
 * 
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:23:50
 */
@Data
@TableName("dw_user_course")
public class UserCourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		@TableId(type = IdType.ID_WORKER_STR)
			

private String id;
	/**
	 * 用户id
	 */
			

private String userId;
	/**
	 * 课程id
	 */
			

private String courseId;
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
