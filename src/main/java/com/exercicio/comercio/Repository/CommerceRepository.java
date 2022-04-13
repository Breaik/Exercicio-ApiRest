package com.exercicio.comercio.Repository;

import com.exercicio.comercio.Entity.Comerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommerceRepository extends JpaRepository<Comerce, Integer> {

    @Query(value = "select * from comerce order by nome asc;", nativeQuery = true)
    List<Comerce> findAllComercios();

    @Query(value = "select * from comerce where categoria='shopping';", nativeQuery = true)
    List<Comerce> findAllShop();

    @Query(value = "select * from comerce where categoria='supermercado';", nativeQuery = true)
    List<Comerce> findAllSupermercado();

    @Query(value = "select * from comerce where categoria='bar';", nativeQuery = true)
    List<Comerce> findAllBares();

    @Query(value = "select * from comerce where categoria='academia';", nativeQuery = true)
    List<Comerce> findAllAcademia();

    @Query(value = "select * from comerce where nome like '%valor%';", nativeQuery = true)
    List<Comerce> findByTeste();

}