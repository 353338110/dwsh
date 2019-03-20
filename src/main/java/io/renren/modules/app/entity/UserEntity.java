package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * 
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-20 23:53:45
 */
@Data
@TableName("dw_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		@TableId(type = IdType.ID_WORKER_STR)
			private String id;
	/**
	 * 对应的管理员id
	 */
			private String adminId;
	/**
	 * 真实姓名
	 */
			private String realName;
	/**
	 * 用户名
	 */
			private String username;
	/**
	 * 用户密码
	 */
			private String password;
	/**
	 * 用户头像图片地址
	 */
			private String photo;
	/**
	 * 性别 0 男 1 女
	 */
			private Integer gender;
	/**
	 * 学校名称
	 */
			private String school;
	/**
	 * 年级
	 */
			private Integer grade;
	/**
	 * 班级
	 */
			private String className;
	/**
	 * 年龄
	 */
			private Integer age;
	/**
	 * 省市联动中的地区id
	 */
			private String areaId;
	/**
	 * 省市联动中的城市id
	 */
			private String cityId;
	/**
	 * 省市联动中的省份id
	 */
			private String provinceId;
	/**
	 * 省市联动的名称 如 福建省，福州市，仓山区 中间用逗号连接
	 */
			private String address;
	/**
	 * 登录次数
	 */
			private Integer loginAcount;
	/**
	 * 邮箱
	 */
			private String mail;
	/**
	 * qq号码
	 */
			private String qq;
	/**
	 * 微信号
	 */
			private String wechat;
	/**
	 * 电话号码
	 */
			private String mobile;
	/**
	 * 上次登录时间
	 */
			private Date lastLogin;
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
