package org.chenqingci.subject.domain.handle.subject;

import org.chenqingci.subject.common.enums.IsDeletedFlagEnum;
import org.chenqingci.subject.common.enums.SubjectInfoTypeEnum;
import org.chenqingci.subject.domain.convert.BriefSubjectConverter;
import org.chenqingci.subject.domain.entity.SubjectInfoBO;
import org.chenqingci.subject.domain.entity.SubjectOptionBO;
import org.chenqingci.subject.infra.basic.entity.SubjectBrief;
import org.chenqingci.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/13
 * @Year 2024
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectBriefService subjectBriefService;
    @Override
    public SubjectInfoTypeEnum getSubjectType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId().intValue());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}
