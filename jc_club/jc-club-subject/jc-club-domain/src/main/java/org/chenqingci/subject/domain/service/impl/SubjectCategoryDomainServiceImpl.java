package org.chenqingci.subject.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.chenqingci.subject.common.enums.IsDeletedFlagEnum;
import org.chenqingci.subject.domain.convert.SubjectCategoryConvert;
import org.chenqingci.subject.domain.entity.SubjectCategoryBO;
import org.chenqingci.subject.domain.service.SubjectCategoryDomainService;
import org.chenqingci.subject.infra.basic.entity.SubjectCategory;
import org.chenqingci.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/9
 * @Year 2024
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        SubjectCategory insert = subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList= subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> subjectCategoryBOList = SubjectCategoryConvert.INSTANCE.convertBoToCategory(subjectCategoryList);
        if(log.isInfoEnabled()){
            log.info("SubjectCategoryController.queruPrimaryCategory.boList:{}", JSON.toJSONString(subjectCategoryBOList));
        }

        return subjectCategoryBOList;
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }
    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }
}
