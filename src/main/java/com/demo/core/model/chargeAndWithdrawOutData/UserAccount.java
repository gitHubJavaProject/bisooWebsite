package com.demo.core.model.chargeAndWithdrawOutData;

import com.demo.core.model.base.BaseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 资产管理查询数据实体
 */
public class UserAccount extends BaseEntity {

    private static final long serialVersionUID = 7518279376802374980L;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 资产数量
     */
    private BigDecimal balance;
    /**
     *
     */

}
