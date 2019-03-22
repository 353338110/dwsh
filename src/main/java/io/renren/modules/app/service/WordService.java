package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.WordEntity;

import java.util.Map;

/**
 * 单元表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:16:09
 */
public interface WordService extends IService<WordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

