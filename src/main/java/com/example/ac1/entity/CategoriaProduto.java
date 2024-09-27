package com.example.ac1.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaProduto {

  public CategoriaProduto(int id_categoria, String cat_nome, String cat_descricao) {
    this.id_categoria = id_categoria;
    this.nome = cat_nome;
    this.cat_descricao = cat_descricao;
  }

  public CategoriaProduto() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id_categoria;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String cat_descricao;

  @OneToMany(mappedBy = "categoriaProduto")
  private List<Produto> produtos;

  public int getId_categoria() {
    return id_categoria;
  }

  public void setId_categoria(int id_categoria) {
    this.id_categoria = id_categoria;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCat_descricao() {
    return cat_descricao;
  }

  public void setCat_descricao(String cat_descricao) {
    this.cat_descricao = cat_descricao;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  @Override
  public String toString() {
    return "CategoriaProduto [id_categoria=" + id_categoria + ", nome=" + nome + ", cat_descricao="
        + cat_descricao + "]";
  }

}
