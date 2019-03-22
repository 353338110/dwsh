package io.renren.modules.app.dao;

import io.renren.modules.app.entity.UserCourseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生课程表
 * 
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:23:50
 */
@Mapper
public interface UserCourseDao extends BaseMapper<UserCourseEntity> {
	
}
