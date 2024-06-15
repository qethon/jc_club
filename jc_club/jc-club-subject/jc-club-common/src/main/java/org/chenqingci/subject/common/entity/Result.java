package org.chenqingci.subject.common.entity;

import lombok.Data;
import org.chenqingci.subject.common.enums.ResultCodeEnum;

/**
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/9
 * @Year 2024
 */
@Data
    public class Result<T> {

        private Boolean success;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        private Integer code;

        private String message;

        private T data;

        public static Result ok(){
            Result result = new Result();
            result.setSuccess(true);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMessage(ResultCodeEnum.SUCCESS.getDesc());
            return result;
        }

        public static <T> Result ok(T data){
            Result result = new Result();
            result.setSuccess(true);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMessage(ResultCodeEnum.SUCCESS.getDesc());
            result.setData(data);
            return result;
        }

        public static Result fail(){
            Result result = new Result();
            result.setSuccess(false);
            result.setCode(ResultCodeEnum.FAIL.getCode());
            result.setMessage(ResultCodeEnum.FAIL.getDesc());
            return result;
        }

        public static <T> Result fail(T data){
            Result result = new Result();
            result.setSuccess(false);
            result.setCode(ResultCodeEnum.FAIL.getCode());
            result.setMessage(ResultCodeEnum.FAIL.getDesc());
            result.setData(data);
            return result;
        }

    }

