package com.hongcheng.techinnovte.service.impl;

import com.diboot.core.config.Cons;
import com.diboot.core.mapper.BaseCrudMapper;
import com.diboot.core.service.impl.BaseServiceImpl;
import com.diboot.core.util.BeanUtils;
import com.hongcheng.techinnovte.service.BaseCustomService;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class BaseCustomServiceImpl<M extends BaseCrudMapper<T>, T> extends BaseServiceImpl<M, T> implements BaseCustomService<T> {


}
