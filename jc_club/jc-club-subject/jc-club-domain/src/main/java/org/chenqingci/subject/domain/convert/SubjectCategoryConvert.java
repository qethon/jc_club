package org.chenqingci.subject.domain.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.chenqingci.subject.domain.entity.SubjectCategoryBO;
import org.chenqingci.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/9
 * @Year 2024
 */
@Mapper
public interface SubjectCategoryConvert {
    SubjectCategoryConvert INSTANCE = Mappers.getMapper(SubjectCategoryConvert.class);
    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBo);
    List<SubjectCategoryBO > convertBoToCategory(List<SubjectCategory >subjectCategory);




}
