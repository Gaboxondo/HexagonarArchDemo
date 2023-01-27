package com.example.hexarchdemo.infrastructure.ddbb.jparepository;

import com.example.hexarchdemo.infrastructure.ddbb.entity.CarSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarJpaReposiotry extends JpaRepository<CarSql,String> {
}
