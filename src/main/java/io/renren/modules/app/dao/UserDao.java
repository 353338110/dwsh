package io.renren.modules.app.dao;

import io.renren.modules.app.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-20 23:53:45
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
