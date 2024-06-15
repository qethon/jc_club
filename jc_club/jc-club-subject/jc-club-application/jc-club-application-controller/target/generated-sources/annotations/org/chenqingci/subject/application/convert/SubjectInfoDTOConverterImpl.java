package org.chenqingci.subject.application.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.chenqingci.subject.application.dto.SubjectAnswerDTO;
import org.chenqingci.subject.application.dto.SubjectInfoDTO;
import org.chenqingci.subject.domain.entity.SubjectAnswerBO;
import org.chenqingci.subject.domain.entity.SubjectInfoBO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T23:59:05+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class SubjectInfoDTOConverterImpl implements SubjectInfoDTOConverter {

    @Override
    public SubjectInfoBO convertDTOToBO(SubjectInfoDTO subjectInfoDTO) {
        if ( subjectInfoDTO == null ) {
            return null;
        }

        SubjectInfoBO subjectInfoBO = new SubjectInfoBO();

        subjectInfoBO.setPageNo( subjectInfoDTO.getPageNo() );
        subjectInfoBO.setPageSize( subjectInfoDTO.getPageSize() );
        subjectInfoBO.setId( subjectInfoDTO.getId() );
        subjectInfoBO.setSubjectName( subjectInfoDTO.getSubjectName() );
        subjectInfoBO.setSubjectDifficult( subjectInfoDTO.getSubjectDifficult() );
        subjectInfoBO.setSettleName( subjectInfoDTO.getSettleName() );
        subjectInfoBO.setSubjectType( subjectInfoDTO.getSubjectType() );
        subjectInfoBO.setSubjectScore( subjectInfoDTO.getSubjectScore() );
        subjectInfoBO.setSubjectParse( subjectInfoDTO.getSubjectParse() );
        subjectInfoBO.setSubjectAnswer( subjectInfoDTO.getSubjectAnswer() );
        List<Integer> list = subjectInfoDTO.getCategoryIds();
        if ( list != null ) {
            subjectInfoBO.setCategoryIds( new ArrayList<Integer>( list ) );
        }
        List<Integer> list1 = subjectInfoDTO.getLabelIds();
        if ( list1 != null ) {
            subjectInfoBO.setLabelIds( new ArrayList<Integer>( list1 ) );
        }
        List<String> list2 = subjectInfoDTO.getLabelName();
        if ( list2 != null ) {
            subjectInfoBO.setLabelName( new ArrayList<String>( list2 ) );
        }
        subjectInfoBO.setOptionList( convertListDTOToBO( subjectInfoDTO.getOptionList() ) );
        subjectInfoBO.setCategoryId( subjectInfoDTO.getCategoryId() );
        subjectInfoBO.setLabelId( subjectInfoDTO.getLabelId() );
        subjectInfoBO.setKeyWord( subjectInfoDTO.getKeyWord() );
        subjectInfoBO.setCreateUser( subjectInfoDTO.getCreateUser() );
        subjectInfoBO.setCreateUserAvatar( subjectInfoDTO.getCreateUserAvatar() );
        subjectInfoBO.setSubjectCount( subjectInfoDTO.getSubjectCount() );
        subjectInfoBO.setLiked( subjectInfoDTO.getLiked() );
        subjectInfoBO.setLikedCount( subjectInfoDTO.getLikedCount() );
        subjectInfoBO.setNextSubjectId( subjectInfoDTO.getNextSubjectId() );
        subjectInfoBO.setLastSubjectId( subjectInfoDTO.getLastSubjectId() );

        return subjectInfoBO;
    }

    @Override
    public SubjectInfoDTO convertBOToDTO(SubjectInfoBO subjectInfoBO) {
        if ( subjectInfoBO == null ) {
            return null;
        }

        SubjectInfoDTO subjectInfoDTO = new SubjectInfoDTO();

        subjectInfoDTO.setPageNo( subjectInfoBO.getPageNo() );
        subjectInfoDTO.setPageSize( subjectInfoBO.getPageSize() );
        subjectInfoDTO.setId( subjectInfoBO.getId() );
        subjectInfoDTO.setSubjectName( subjectInfoBO.getSubjectName() );
        subjectInfoDTO.setSubjectDifficult( subjectInfoBO.getSubjectDifficult() );
        subjectInfoDTO.setSettleName( subjectInfoBO.getSettleName() );
        subjectInfoDTO.setSubjectType( subjectInfoBO.getSubjectType() );
        subjectInfoDTO.setSubjectScore( subjectInfoBO.getSubjectScore() );
        subjectInfoDTO.setSubjectParse( subjectInfoBO.getSubjectParse() );
        subjectInfoDTO.setSubjectAnswer( subjectInfoBO.getSubjectAnswer() );
        List<Integer> list = subjectInfoBO.getCategoryIds();
        if ( list != null ) {
            subjectInfoDTO.setCategoryIds( new ArrayList<Integer>( list ) );
        }
        List<Integer> list1 = subjectInfoBO.getLabelIds();
        if ( list1 != null ) {
            subjectInfoDTO.setLabelIds( new ArrayList<Integer>( list1 ) );
        }
        subjectInfoDTO.setOptionList( mapList( subjectInfoBO.getOptionList() ) );
        List<String> list3 = subjectInfoBO.getLabelName();
        if ( list3 != null ) {
            subjectInfoDTO.setLabelName( new ArrayList<String>( list3 ) );
        }
        subjectInfoDTO.setCategoryId( subjectInfoBO.getCategoryId() );
        subjectInfoDTO.setLabelId( subjectInfoBO.getLabelId() );
        subjectInfoDTO.setKeyWord( subjectInfoBO.getKeyWord() );
        subjectInfoDTO.setCreateUser( subjectInfoBO.getCreateUser() );
        subjectInfoDTO.setCreateUserAvatar( subjectInfoBO.getCreateUserAvatar() );
        subjectInfoDTO.setSubjectCount( subjectInfoBO.getSubjectCount() );
        subjectInfoDTO.setLiked( subjectInfoBO.getLiked() );
        subjectInfoDTO.setLikedCount( subjectInfoBO.getLikedCount() );
        subjectInfoDTO.setNextSubjectId( subjectInfoBO.getNextSubjectId() );
        subjectInfoDTO.setLastSubjectId( subjectInfoBO.getLastSubjectId() );

        return subjectInfoDTO;
    }

    @Override
    public List<SubjectInfoDTO> convertBOToDTOList(List<SubjectInfoBO> subjectInfoBOList) {
        if ( subjectInfoBOList == null ) {
            return null;
        }

        List<SubjectInfoDTO> list = new ArrayList<SubjectInfoDTO>( subjectInfoBOList.size() );
        for ( SubjectInfoBO subjectInfoBO : subjectInfoBOList ) {
            list.add( convertBOToDTO( subjectInfoBO ) );
        }

        return list;
    }

    @Override
    public SubjectAnswerDTO map(SubjectAnswerBO value) {
        if ( value == null ) {
            return null;
        }

        SubjectAnswerDTO subjectAnswerDTO = new SubjectAnswerDTO();

        subjectAnswerDTO.setOptionType( value.getOptionType() );
        subjectAnswerDTO.setOptionContent( value.getOptionContent() );
        subjectAnswerDTO.setIsCorrect( value.getIsCorrect() );

        return subjectAnswerDTO;
    }

    @Override
    public List<SubjectAnswerDTO> mapList(List<SubjectAnswerBO> valueList) {
        if ( valueList == null ) {
            return null;
        }

        List<SubjectAnswerDTO> list = new ArrayList<SubjectAnswerDTO>( valueList.size() );
        for ( SubjectAnswerBO subjectAnswerBO : valueList ) {
            list.add( map( subjectAnswerBO ) );
        }

        return list;
    }

    @Override
    public List<SubjectAnswerBO> convertListDTOToBO(List<SubjectAnswerDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<SubjectAnswerBO> list = new ArrayList<SubjectAnswerBO>( dtoList.size() );
        for ( SubjectAnswerDTO subjectAnswerDTO : dtoList ) {
            list.add( subjectAnswerDTOToSubjectAnswerBO( subjectAnswerDTO ) );
        }

        return list;
    }

    protected SubjectAnswerBO subjectAnswerDTOToSubjectAnswerBO(SubjectAnswerDTO subjectAnswerDTO) {
        if ( subjectAnswerDTO == null ) {
            return null;
        }

        SubjectAnswerBO subjectAnswerBO = new SubjectAnswerBO();

        subjectAnswerBO.setOptionType( subjectAnswerDTO.getOptionType() );
        subjectAnswerBO.setOptionContent( subjectAnswerDTO.getOptionContent() );
        subjectAnswerBO.setIsCorrect( subjectAnswerDTO.getIsCorrect() );

        return subjectAnswerBO;
    }
}
