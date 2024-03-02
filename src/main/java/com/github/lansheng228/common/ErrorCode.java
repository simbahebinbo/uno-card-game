package com.github.lansheng228.common;

public interface ErrorCode {

    Integer getErrCode();

    String getErrMsg(Object... args);

}
