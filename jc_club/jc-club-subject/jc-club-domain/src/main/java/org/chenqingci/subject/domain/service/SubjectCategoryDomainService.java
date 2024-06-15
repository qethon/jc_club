package org.chenqingci.subject.domain.service;

import org.chenqingci.subject.domain.entity.SubjectCategoryBO;
import org.chenqingci.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/9
 * @Year 2024
 */
public interface SubjectCategoryDomainService{
    void add(SubjectCategoryBO subjectCategoryBO);
    /**
     * 更新查询
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);
    /**
     * 更新分类
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);
    /**
     * 删除分类
     */
    Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
