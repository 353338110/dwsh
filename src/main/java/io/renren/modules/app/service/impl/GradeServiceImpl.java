package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.GradeDao;
import io.renren.modules.app.entity.GradeEntity;
import io.renren.modules.app.service.GradeService;


@Service("gradeService")
public class GradeServiceImpl extends ServiceImpl<GradeDao, GradeEntity> implements GradeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GradeEntity> page = this.page(
                new Query<GradeEntity>().getPage(params),
                new QueryWrapper<GradeEntity>()
        );

        return new PageUtils(page);
    }

}