/*
  BBD Service Inc
  All Rights Reserved @2018
 */
package com.ganzib.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * BaseMapper
 *
 * @author Created by LiYao on 2018-11-21 11:06.
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
