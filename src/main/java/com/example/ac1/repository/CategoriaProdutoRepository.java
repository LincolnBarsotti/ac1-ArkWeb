package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ac1.entity.CategoriaProduto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Integer > {
    @Query("SELECT c FROM CategoriaProduto c LEFT JOIN FETCH c.produtos WHERE c.id_categoria = :id_categoria")
    CategoriaProduto findByCategoriaId(Integer id_categoria);

    List <CategoriaProduto>  findByNomeStartingWith(String nome);

}

