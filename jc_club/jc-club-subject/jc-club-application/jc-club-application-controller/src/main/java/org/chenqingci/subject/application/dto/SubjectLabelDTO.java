package org.chenqingci.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签dto
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/5
 * @Year 2024
 */

@Data
public class SubjectLabelDTO implements Serializable {

    /**
     * 主键
     */
    private Long id;
    
    /**
     * 分类id
     */
    private Long categoryId;
    
    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;

}

