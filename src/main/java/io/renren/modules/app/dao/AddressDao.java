package io.renren.modules.app.dao;

import io.renren.modules.app.entity.AddressEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 省市区联动表
 * 
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:23:50
 */
@Mapper
public interface AddressDao extends BaseMapper<AddressEntity> {
	
}
