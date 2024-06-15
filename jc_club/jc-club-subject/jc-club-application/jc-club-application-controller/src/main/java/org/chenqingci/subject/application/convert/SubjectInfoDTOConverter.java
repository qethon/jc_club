package org.chenqingci.subject.application.convert;


import org.chenqingci.subject.application.dto.SubjectAnswerDTO;
import org.chenqingci.subject.application.dto.SubjectInfoDTO;
import org.chenqingci.subject.domain.entity.SubjectAnswerBO;
import org.chenqingci.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目信息dto转换器
 * @Author 陈佳豪
 * @Date 2024/6/9
 * @Year 2024
 */
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface SubjectInfoDTOConverter {

    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);

    SubjectInfoBO convertDTOToBO(SubjectInfoDTO subjectInfoDTO);

    SubjectInfoDTO convertBOToDTO(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoDTO> convertBOToDTOList(List<SubjectInfoBO> subjectInfoBOList);

    SubjectAnswerDTO map(SubjectAnswerBO value);

    List<SubjectAnswerDTO> mapList(List<SubjectAnswerBO> valueList);

    // 添加此方法来转换列表
    List<SubjectAnswerBO> convertListDTOToBO(List<SubjectAnswerDTO> dtoList);
}


