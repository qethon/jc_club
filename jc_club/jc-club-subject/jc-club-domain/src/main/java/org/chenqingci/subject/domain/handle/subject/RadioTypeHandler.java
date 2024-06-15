package org.chenqingci.subject.domain.handle.subject;

import org.chenqingci.subject.common.enums.SubjectInfoTypeEnum;
import org.chenqingci.subject.domain.convert.RadioSubjectConverter;
import org.chenqingci.subject.domain.entity.SubjectAnswerBO;
import org.chenqingci.subject.domain.entity.SubjectInfoBO;
import org.chenqingci.subject.domain.entity.SubjectOptionBO;
import org.chenqingci.subject.infra.basic.entity.SubjectRadio;
import org.chenqingci.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/13
 * @Year 2024
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getSubjectType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if (subjectInfoBO == null || subjectInfoBO.getOptionList() == null) {
            throw new IllegalArgumentException("SubjectInfoBO or its optionList cannot be null");
        }

        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadioList.add(subjectRadio);
        });

        try {
            subjectRadioService.batchInsert(subjectRadioList);
        } catch (Exception e) {
            // 处理异常，如记录日志或抛出自定义异常
            throw new RuntimeException("Failed to batch insert SubjectRadio entities", e);
        }
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(Long.valueOf(subjectId));
        List<SubjectRadio> result = subjectRadioService.queryByCondition(subjectRadio);
        List<SubjectAnswerBO> subjectAnswerBOList = RadioSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }

}
