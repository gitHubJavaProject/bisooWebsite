package com.demo.core.mapper;

import com.demo.core.model.chargeAndWithdrawOutData.ChargeAndWithdraw;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChargeAndWithdrawMapper {

    List<ChargeAndWithdraw> findByEntity(@Param("userId") String userId,
                                         @Param("finishTime")Date finishTime,
                                         @Param("type") String type,
                                         @Param("assetId") String assetId,
                                         @Param("offset") Integer offset,
                                         @Param("size") Integer size);

    long count(@Param("userId") String userId,
               @Param("finishTime") Date finishTime,
               @Param("type") String type,
               @Param("assetId") String assetId);
}
