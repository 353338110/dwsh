package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 单元表
 * 
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:16:09
 */
@Data
@TableName("dw_word")
public class WordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		@TableId(type = IdType.ID_WORKER_STR)
			

private String id;
	/**
	 * 单元id
	 */
			

private String unitId;
	/**
	 * 单词的拼写 如 apple
	 */
			

private String spelling;
	/**
	 * 单词的发音 有特殊符号
	 */
			

private String spellingSound;
	/**
	 * 单词的中文意思
	 */
			

private String meaning;
	/**
	 * 分音节 如 rul,er 音节中间用逗号隔开
	 */
			

private String spellingSeparate;
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
