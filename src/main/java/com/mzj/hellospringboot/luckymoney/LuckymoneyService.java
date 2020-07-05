package com.mzj.hellospringboot.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckmoneyRepository luckmoneyRepository;

    @Transactional
    public void createTwo(){
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setProducer("mazhongjia");
        luckymoney1.setMoney(new BigDecimal("520"));

        luckmoneyRepository.save(luckymoney1);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("mazhongjia");
        luckymoney2.setMoney(new BigDecimal("1314"));

        luckmoneyRepository.save(luckymoney2);
    }
}
