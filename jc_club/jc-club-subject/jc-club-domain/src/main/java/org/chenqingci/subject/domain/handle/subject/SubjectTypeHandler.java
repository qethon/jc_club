package org.chenqingci.subject.domain.handle.subject;
import org.chenqingci.subject.common.enums.SubjectInfoTypeEnum;
import org.chenqingci.subject.domain.entity.SubjectInfoBO;
import org.chenqingci.subject.domain.entity.SubjectOptionBO;

/**
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/13
 * @Year 2024
 */

public interface SubjectTypeHandler {
    SubjectInfoTypeEnum getSubjectType();
    void add(SubjectInfoBO subjectInfoBO);
    SubjectOptionBO query(int subjectId);


}
