package org.chenqingci.subject.domain.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.chenqingci.subject.domain.entity.SubjectCategoryBO;
import org.chenqingci.subject.infra.basic.entity.SubjectCategory;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T23:59:01+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class SubjectCategoryConvertImpl implements SubjectCategoryConvert {

    @Override
    public SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBo) {
        if ( subjectCategoryBo == null ) {
            return null;
        }

        SubjectCategory subjectCategory = new SubjectCategory();

        subjectCategory.setId( subjectCategoryBo.getId() );
        subjectCategory.setCategoryName( subjectCategoryBo.getCategoryName() );
        subjectCategory.setCategoryType( subjectCategoryBo.getCategoryType() );
        subjectCategory.setImageUrl( subjectCategoryBo.getImageUrl() );
        subjectCategory.setParentId( subjectCategoryBo.getParentId() );
        subjectCategory.setCreatedBy( subjectCategoryBo.getCreatedBy() );
        subjectCategory.setCreatedTime( subjectCategoryBo.getCreatedTime() );
        subjectCategory.setUpdateBy( subjectCategoryBo.getUpdateBy() );
        subjectCategory.setUpdateTime( subjectCategoryBo.getUpdateTime() );
        subjectCategory.setIsDeleted( subjectCategoryBo.getIsDeleted() );

        return subjectCategory;
    }

    @Override
    public List<SubjectCategoryBO> convertBoToCategory(List<SubjectCategory> subjectCategory) {
        if ( subjectCategory == null ) {
            return null;
        }

        List<SubjectCategoryBO> list = new ArrayList<SubjectCategoryBO>( subjectCategory.size() );
        for ( SubjectCategory subjectCategory1 : subjectCategory ) {
            list.add( subjectCategoryToSubjectCategoryBO( subjectCategory1 ) );
        }

        return list;
    }

    protected SubjectCategoryBO subjectCategoryToSubjectCategoryBO(SubjectCategory subjectCategory) {
        if ( subjectCategory == null ) {
            return null;
        }

        SubjectCategoryBO subjectCategoryBO = new SubjectCategoryBO();

        subjectCategoryBO.setId( subjectCategory.getId() );
        subjectCategoryBO.setCategoryName( subjectCategory.getCategoryName() );
        subjectCategoryBO.setCategoryType( subjectCategory.getCategoryType() );
        subjectCategoryBO.setImageUrl( subjectCategory.getImageUrl() );
        subjectCategoryBO.setParentId( subjectCategory.getParentId() );
        subjectCategoryBO.setCreatedBy( subjectCategory.getCreatedBy() );
        subjectCategoryBO.setCreatedTime( subjectCategory.getCreatedTime() );
        subjectCategoryBO.setUpdateBy( subjectCategory.getUpdateBy() );
        subjectCategoryBO.setUpdateTime( subjectCategory.getUpdateTime() );
        subjectCategoryBO.setIsDeleted( subjectCategory.getIsDeleted() );

        return subjectCategoryBO;
    }
}
