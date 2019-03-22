package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.VersionEntity;

import java.util.Map;

/**
 * 版本表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:16:09
 */
public interface VersionService extends IService<VersionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

