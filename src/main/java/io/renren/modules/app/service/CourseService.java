package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.CourseEntity;

import java.util.Map;

/**
 * 课程表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:23:50
 */
public interface CourseService extends IService<CourseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

