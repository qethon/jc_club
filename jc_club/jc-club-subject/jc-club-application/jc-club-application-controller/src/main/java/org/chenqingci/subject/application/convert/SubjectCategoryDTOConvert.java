package org.chenqingci.subject.application.convert;

import org.chenqingci.subject.application.dto.SubjectCategoryDTO;
import org.chenqingci.subject.domain.convert.SubjectCategoryConvert;
import org.chenqingci.subject.domain.entity.SubjectCategoryBO;
import org.chenqingci.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/9
 * @Year 2024
 */
@Mapper
public interface SubjectCategoryDTOConvert {
    SubjectCategoryDTOConvert INSTANCE = Mappers.getMapper(SubjectCategoryDTOConvert.class);
    SubjectCategoryBO convertBoToCategory(SubjectCategoryDTO subjectCategoryDTO);
    List<SubjectCategoryDTO> convertBoToCategoryDTOLst(List<SubjectCategoryBO> subjectCategoryBOList);
    SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO);
}
