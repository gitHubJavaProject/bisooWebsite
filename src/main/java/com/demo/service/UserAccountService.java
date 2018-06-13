package com.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface UserAccountService {

    List<Map<String, BigDecimal>> findUserAccountByUserId(String userId, Integer page, Integer size);

    long count(String userId);

    List<String> types();
}
