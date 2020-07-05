package com.mzj.hellospringboot.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckmoneyRepository luckmoneyRepository;

    @Autowired
    private LuckymoneyService luckymoneyService;

    /**
     * 获取红包列表
     *
     * @return
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        return luckmoneyRepository.findAll();
    }

    /**
     * 创建红包
     */
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money") BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return luckmoneyRepository.save(luckymoney);
    }

    /**
     * 通过id查询红包
     *
     * @param id
     * @return
     */
    @GetMapping("/luckymoneys/{id}")//这里的id对应@PathVariable("id")的id
    public Luckymoney findById(@PathVariable("id") Integer id) {
        return luckmoneyRepository.findById(id).orElse(null);//如果查不到返回null
    }

    /**
     * 更新红包
     *
     * @param id
     * @param consumer
     * @return
     */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer) {
        //更新操作需要首先查询出需要更新的整条记录，然后设置修改的内容
        Optional<Luckymoney> optionalLuckymoney = luckmoneyRepository.findById(id);
        //在使用这个对象进行更新
        if (optionalLuckymoney.isPresent()) {//判断是否查询到这个id的记录
            Luckymoney luckymoney = optionalLuckymoney.get();
            luckymoney.setConsumer(consumer);
            return luckmoneyRepository.save(luckymoney);//更新与创建使用的都是save接口，区别是，是否传递主键
        }
        return null;
    }

    /**
     *  事务示例：一起发送两个红包，要么全成功，要么全失败
     */
    @PostMapping("/luckymoneys/two")
    public void createTwo(){
        luckymoneyService.createTwo();
    }
}
