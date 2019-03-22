package io.renren.modules.app.dao;

import io.renren.modules.app.entity.GradeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 年段表
 * 
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:16:09
 */
@Mapper
public interface GradeDao extends BaseMapper<GradeEntity> {
	
}
