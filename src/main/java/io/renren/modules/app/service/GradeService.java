package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.GradeEntity;

import java.util.Map;

/**
 * 年段表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:16:09
 */
public interface GradeService extends IService<GradeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

