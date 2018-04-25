package com.zeal.shiyulin.modules.currency.service;

import com.zeal.shiyulin.modules.currency.dao.CurrencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通用方法的service接口
 * Created by Zeal on 2017/4/26.
 */
@Service
public class CurrencyService {
    @Autowired
    CurrencyDao dao;

}
