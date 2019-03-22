package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.SubjectEntity;

import java.util.Map;

/**
 * 学科表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:16:09
 */
public interface SubjectService extends IService<SubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

