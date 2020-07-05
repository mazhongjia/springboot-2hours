package com.mzj.hellospringboot.luckymoney;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  泛型：A：对应的数据库实体类，B：数据库主键类型
 */
public interface LuckmoneyRepository extends JpaRepository<Luckymoney,Integer> {
}
