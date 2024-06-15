package org.chenqingci.subject.application.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.chenqingci.subject.application.dto.SubjectCategoryDTO;
import org.chenqingci.subject.domain.entity.SubjectCategoryBO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T23:59:05+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class SubjectCategoryDTOConvertImpl implements SubjectCategoryDTOConvert {

    @Override
    public SubjectCategoryBO convertBoToCategory(SubjectCategoryDTO subjectCategoryDTO) {
        if ( subjectCategoryDTO == null ) {
            return null;
        }

        SubjectCategoryBO subjectCategoryBO = new SubjectCategoryBO();

        subjectCategoryBO.setId( subjectCategoryDTO.getId() );
        subjectCategoryBO.setCategoryName( subjectCategoryDTO.getCategoryName() );
        subjectCategoryBO.setCategoryType( subjectCategoryDTO.getCategoryType() );
        subjectCategoryBO.setImageUrl( subjectCategoryDTO.getImageUrl() );
        subjectCategoryBO.setParentId( subjectCategoryDTO.getParentId() );
        subjectCategoryBO.setCreatedBy( subjectCategoryDTO.getCreatedBy() );
        subjectCategoryBO.setCreatedTime( subjectCategoryDTO.getCreatedTime() );
        subjectCategoryBO.setUpdateBy( subjectCategoryDTO.getUpdateBy() );
        subjectCategoryBO.setUpdateTime( subjectCategoryDTO.getUpdateTime() );
        subjectCategoryBO.setIsDeleted( subjectCategoryDTO.getIsDeleted() );

        return subjectCategoryBO;
    }

    @Override
    public List<SubjectCategoryDTO> convertBoToCategoryDTOLst(List<SubjectCategoryBO> subjectCategoryBOList) {
        if ( subjectCategoryBOList == null ) {
            return null;
        }

        List<SubjectCategoryDTO> list = new ArrayList<SubjectCategoryDTO>( subjectCategoryBOList.size() );
        for ( SubjectCategoryBO subjectCategoryBO : subjectCategoryBOList ) {
            list.add( subjectCategoryBOToSubjectCategoryDTO( subjectCategoryBO ) );
        }

        return list;
    }

    @Override
    public SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO) {
        if ( subjectCategoryDTO == null ) {
            return null;
        }

        SubjectCategoryBO subjectCategoryBO = new SubjectCategoryBO();

        subjectCategoryBO.setId( subjectCategoryDTO.getId() );
        subjectCategoryBO.setCategoryName( subjectCategoryDTO.getCategoryName() );
        subjectCategoryBO.setCategoryType( subjectCategoryDTO.getCategoryType() );
        subjectCategoryBO.setImageUrl( subjectCategoryDTO.getImageUrl() );
        subjectCategoryBO.setParentId( subjectCategoryDTO.getParentId() );
        subjectCategoryBO.setCreatedBy( subjectCategoryDTO.getCreatedBy() );
        subjectCategoryBO.setCreatedTime( subjectCategoryDTO.getCreatedTime() );
        subjectCategoryBO.setUpdateBy( subjectCategoryDTO.getUpdateBy() );
        subjectCategoryBO.setUpdateTime( subjectCategoryDTO.getUpdateTime() );
        subjectCategoryBO.setIsDeleted( subjectCategoryDTO.getIsDeleted() );

        return subjectCategoryBO;
    }

    protected SubjectCategoryDTO subjectCategoryBOToSubjectCategoryDTO(SubjectCategoryBO subjectCategoryBO) {
        if ( subjectCategoryBO == null ) {
            return null;
        }

        SubjectCategoryDTO subjectCategoryDTO = new SubjectCategoryDTO();

        subjectCategoryDTO.setId( subjectCategoryBO.getId() );
        subjectCategoryDTO.setCategoryName( subjectCategoryBO.getCategoryName() );
        subjectCategoryDTO.setCategoryType( subjectCategoryBO.getCategoryType() );
        subjectCategoryDTO.setImageUrl( subjectCategoryBO.getImageUrl() );
        subjectCategoryDTO.setParentId( subjectCategoryBO.getParentId() );
        subjectCategoryDTO.setCreatedBy( subjectCategoryBO.getCreatedBy() );
        subjectCategoryDTO.setCreatedTime( subjectCategoryBO.getCreatedTime() );
        subjectCategoryDTO.setUpdateBy( subjectCategoryBO.getUpdateBy() );
        subjectCategoryDTO.setUpdateTime( subjectCategoryBO.getUpdateTime() );
        subjectCategoryDTO.setIsDeleted( subjectCategoryBO.getIsDeleted() );

        return subjectCategoryDTO;
    }
}
