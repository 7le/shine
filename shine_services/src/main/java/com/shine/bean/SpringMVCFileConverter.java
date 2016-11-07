package com.shine.bean;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by hq on 2016/9/9 0009.
 */
public class SpringMVCFileConverter implements Converter<String, MultipartFile> {

    public SpringMVCFileConverter() {
        super();
    }

    @Override
    public MultipartFile convert(String source) {
        return null;
    }
}