package com.demo.service;

import com.demo.core.mapper.ChargeAndWithdrawMapper;
import com.demo.core.model.chargeAndWithdrawOutData.ChargeAndWithdraw;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ChargeAndWithdrawService {

    List<ChargeAndWithdraw> findByEntity(ChargeAndWithdraw chargeAndWithdraw);

    long count(ChargeAndWithdraw chargeAndWithdraw);
}
