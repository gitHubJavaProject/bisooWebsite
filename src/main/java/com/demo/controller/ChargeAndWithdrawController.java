package com.demo.controller;

import com.demo.core.model.base.ResultEntity;
import com.demo.core.model.chargeAndWithdrawOutData.ChargeAndWithdraw;
import com.demo.service.ChargeAndWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("chargeAndWithdraw")
public class ChargeAndWithdrawController {

    @Autowired
    private ChargeAndWithdrawService chargeAndWithdrawService;

    @RequestMapping("list")
    public String list() {
        return "charge_withdraw";
    }

    @RequestMapping("")
    @ResponseBody
    public Object chargeAndWithdraws(ChargeAndWithdraw chargeAndWithdraw) {
        return convert(chargeAndWithdrawService.findByEntity(chargeAndWithdraw), chargeAndWithdraw);
    }

    private Map<String,Object> convert(List<ChargeAndWithdraw> chargeAndWithdraws, ChargeAndWithdraw chargeAndWithdraw) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "");
        map.put("count", chargeAndWithdrawService.count(chargeAndWithdraw));
        map.put("data", chargeAndWithdraws);
        return map;
    }

}
