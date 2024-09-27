package com.example.ac1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idProduto;

  @Column(nullable = false)
  private Double prodPreco;
  
  @ManyToOne()
  @JoinColumn(name="categoria_id")
  private CategoriaProduto categoriaProduto;

  @Column(nullable = false)
  private String prodName;

  public Produto(int idProduto, Double prodPreco, String prodName) {
    this.idProduto = idProduto;
    this.prodPreco = prodPreco;
    this.prodName = prodName;
  }

  public Produto() {
  }

  public int getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(int idProduto) {
    this.idProduto = idProduto;
  }

  public Double getprodPreco() {
    return prodPreco;
  }

  public void setprodPreco(Double prodPreco) {
    this.prodPreco = prodPreco;
  }

  public String getProdName() {
    return prodName;
  }

  public void setProdName(String prodName) {
    this.prodName = prodName;
  }

  public CategoriaProduto getCategoriaProduto() {
    return categoriaProduto;
  }

  public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
    this.categoriaProduto = categoriaProduto;
  }

  @Override
  public String toString() {
    return "Produto [idProduto=" + idProduto + ", prodPreco=" + prodPreco + ", categoriaProduto=" + categoriaProduto
        + ", prodName=" + prodName + "]";
  }
 
}
