package org.chenqingci.subject.infra.basic.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.chenqingci.subject.infra.basic.entity.SubjectCategory;
import org.chenqingci.subject.infra.basic.mapper.SubjectCategoryDao;
import org.chenqingci.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import javax.annotation.Resource;
import java.util.List;

/**
 * 题目分类(SubjectCategory)表服务实现类
 *
 * @author makejava
 * @since 2024-06-05 19:16:18
 */
@Slf4j
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl implements SubjectCategoryService {
    @Resource
    private SubjectCategoryDao subjectCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectCategory queryById(Long id) {
        return this.subjectCategoryDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory insert(SubjectCategory subjectCategory) {

        if(log.isInfoEnabled()){
            log.info("SubjectCategoryController.add:{}", JSON.toJSONString(subjectCategory));
        }
        this.subjectCategoryDao.insert(subjectCategory);
        return subjectCategory;
    }

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectCategoryDao.deleteById(id) > 0;
    }



        @Override
    public List<SubjectCategory> queryCategory() {
        return this.subjectCategoryDao.queryPrimaryCategory();
    }
    @Override
    public List<SubjectCategory> queryCategory(SubjectCategory subjectCategory) {
        Long parentId = subjectCategory.getParentId();
        return this.subjectCategoryDao.queryCategory(parentId);
    }

    @Override
    public int update(SubjectCategory subjectCategory) {
        return this.subjectCategoryDao.update(subjectCategory);
    }
}
