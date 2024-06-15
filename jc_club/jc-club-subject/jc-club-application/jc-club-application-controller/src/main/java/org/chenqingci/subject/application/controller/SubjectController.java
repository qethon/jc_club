package org.chenqingci.subject.application.controller;
import javax.annotation.Resource;

//import org.chenqingci.subject.infra.basic.entity.SubjectCategory;
//import org.chenqingci.subject.infra.basic.service.SubjectCategoryService;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.chenqingci.subject.application.convert.SubjectAnswerDTOConverter;
import org.chenqingci.subject.application.convert.SubjectInfoDTOConverter;
import org.chenqingci.subject.application.dto.SubjectAnswerDTO;
import org.chenqingci.subject.application.dto.SubjectCategoryDTO;
import org.chenqingci.subject.application.dto.SubjectInfoDTO;
import org.chenqingci.subject.common.entity.PageResult;
import org.chenqingci.subject.common.entity.Result;
import org.chenqingci.subject.domain.entity.SubjectAnswerBO;
import org.chenqingci.subject.domain.entity.SubjectInfoBO;
import org.chenqingci.subject.domain.service.SubjectInfoDomainService;
import org.chenqingci.subject.infra.basic.entity.SubjectCategory;
import org.chenqingci.subject.infra.basic.mapper.SubjectInfoDao;
import org.chenqingci.subject.infra.basic.service.SubjectCategoryService;
import org.chenqingci.subject.infra.basic.service.SubjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/5
 * @Year 2024
 */

@Slf4j
@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Resource
    private SubjectCategoryService subjectCategoryService;
    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;
    @Autowired
    private SubjectInfoDao subjectInfoDao;

    @GetMapping("/test")
    public String test(){
        SubjectCategory subjectCategory = subjectCategoryService.queryById(1L);
        String categoryName = subjectCategory.getCategoryName();
//        SubjectCategory subjectCategory = subjectCategoryService.queryById(1l);
//        String categoryName = subjectCategory.getCategoryName();
//        return subjectCategory.getCategoryName();
        return categoryName;
    }

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            List<SubjectAnswerDTO> optionList = subjectInfoDTO.getOptionList();
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()),
                    "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds())
                    , "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds())
                    , "标签id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS =
                    SubjectAnswerDTOConverter.INSTANCE.convertListDTOToBO(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增题目失败");
        }
    }

    /**
     * 查询题目列表
     */
    @PostMapping("/getSubjectPage")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.getSubjectPage.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标签id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            subjectInfoBO.setPageNo(subjectInfoDTO.getPageNo());
            subjectInfoBO.setPageSize(subjectInfoDTO.getPageSize());
            PageResult<SubjectInfoBO> boPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("分页查询题目失败");
        }
    }




    /**
     * 查询题目信息
     */
    @PostMapping("/querySubjectInfo")
    public Result<SubjectInfoDTO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.querySubjectInfo.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getId(), "题目id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            SubjectInfoBO boResult = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            SubjectInfoDTO dto = SubjectInfoDTOConverter.INSTANCE.convertBOToDTO(boResult);
            return Result.ok(dto);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("查询题目详情失败");
        }
    }


}
