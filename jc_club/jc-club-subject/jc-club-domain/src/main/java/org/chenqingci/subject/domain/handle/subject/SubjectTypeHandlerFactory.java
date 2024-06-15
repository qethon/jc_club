package org.chenqingci.subject.domain.handle.subject;

import org.chenqingci.subject.common.enums.SubjectInfoTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/13
 * @Year 2024
 */

/**
 * 题目工厂
 */

@Component
public class SubjectTypeHandlerFactory implements InitializingBean {
    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerListhandlerList;
    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();
    public SubjectTypeHandler getHandle(int subjectType){
        SubjectInfoTypeEnum byCode = SubjectInfoTypeEnum.getByCode(subjectType);
        return handlerMap.get(byCode);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerListhandlerList) {
            handlerMap.put(subjectTypeHandler.getSubjectType(), subjectTypeHandler);
        }
    }
}
