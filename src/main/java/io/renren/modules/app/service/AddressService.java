package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.AddressEntity;

import java.util.Map;

/**
 * 省市区联动表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:23:50
 */
public interface AddressService extends IService<AddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

