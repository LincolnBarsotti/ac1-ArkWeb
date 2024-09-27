package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ac1.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

  @Query("SELECT p FROM Produto p WHERE p.idProduto = :idProduto")
  List<Produto> findByIdProduto(int idProduto);

  List<Produto> findByProdPrecoGreaterThan(Double prodPreco);
  List<Produto> findByProdPrecoLessThanEqual(Double prodPreco);
  List<Produto> findByProdName(String prodName);
}

