package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.UserCourseDao;
import io.renren.modules.app.entity.UserCourseEntity;
import io.renren.modules.app.service.UserCourseService;


@Service("userCourseService")
public class UserCourseServiceImpl extends ServiceImpl<UserCourseDao, UserCourseEntity> implements UserCourseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserCourseEntity> page = this.page(
                new Query<UserCourseEntity>().getPage(params),
                new QueryWrapper<UserCourseEntity>()
        );

        return new PageUtils(page);
    }

}