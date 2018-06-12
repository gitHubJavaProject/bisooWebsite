package com.demo.service.impl;

import com.demo.core.mapper.ChargeAndWithdrawMapper;
import com.demo.core.model.chargeAndWithdrawOutData.ChargeAndWithdraw;
import com.demo.service.ChargeAndWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeAndWithdrawServiceImpl implements ChargeAndWithdrawService {

    @Autowired
    private ChargeAndWithdrawMapper chargeAndWithdrawMapper;


    @Override
    public List<ChargeAndWithdraw> findByEntity(ChargeAndWithdraw chargeAndWithdraw) {
        if (chargeAndWithdraw.getPage() < 1) {
            chargeAndWithdraw.setPage(1);
        }
        return chargeAndWithdrawMapper.findByEntity(chargeAndWithdraw.getUserId(),
                chargeAndWithdraw.getFinishTime(),
                chargeAndWithdraw.getType(),
                chargeAndWithdraw.getAssetId(),
                (chargeAndWithdraw.getPage()-1)*chargeAndWithdraw.getRows(),
                chargeAndWithdraw.getRows());
    }

    @Override
    public long count(ChargeAndWithdraw chargeAndWithdraw) {
        return chargeAndWithdrawMapper.count(chargeAndWithdraw.getUserId(),
                chargeAndWithdraw.getFinishTime(),
                chargeAndWithdraw.getType(),
                chargeAndWithdraw.getAssetId());
    }
}
