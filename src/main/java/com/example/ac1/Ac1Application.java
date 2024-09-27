package com.example.ac1;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.entity.CategoriaProduto;
import com.example.ac1.entity.Produto;
import com.example.ac1.repository.CategoriaProdutoRepository;
import com.example.ac1.repository.ProdutoRepository;

import java.util.List;

@SpringBootApplication
public class Ac1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

	@Bean
	public CommandLineRunner init(@Autowired CategoriaProdutoRepository categoriaProdutoRepository,
		@Autowired ProdutoRepository produtoRepository
	) {
		return args -> {
			// Inserção de categorias
			categoriaProdutoRepository.save((new CategoriaProduto(0,"Bebidas","Produto liquídos")));
			categoriaProdutoRepository.save((new CategoriaProduto(0,"Comidas","Produtos alimentícios")));
			categoriaProdutoRepository.save((new CategoriaProduto(0,"Eletrônicos","Produtos eletrônicos")));
			categoriaProdutoRepository.save((new CategoriaProduto(0,"Casa","Produtos para casa")));

			// Inserrção de  produtos
			produtoRepository.save((new Produto(0,10.0,"Computador")));
			produtoRepository.save((new Produto(0,20.0,"Fone")));
			produtoRepository.save((new Produto(0,5.0,"Tablet")));

			CategoriaProduto cat = categoriaProdutoRepository.findByCategoriaId(1);
			var prod = produtoRepository.getById(1);
			cat.getProdutos().add(prod);
			categoriaProdutoRepository.save(cat);

			// Select categorias 
			List<CategoriaProduto> listaCategorias = categoriaProdutoRepository.findAll();

			System.out.println("===== Imprimindo as listas de  categorias =====");
			listaCategorias.forEach(c -> {
				System.out.println(c.toString());
			});

			// PRODUTOS 
			List<Produto> listaProdutos = produtoRepository.findAll();
			Produto p1 = listaProdutos.get(0);
			Produto p2 = listaProdutos.get(1);
			Produto p3 = listaProdutos.get(2);

			p1.setCategoriaProduto(listaCategorias.get(2));
			p2.setCategoriaProduto(listaCategorias.get(2));
			p3.setCategoriaProduto(listaCategorias.get(2));

			produtoRepository.save(p1);
			produtoRepository.save(p2);
			produtoRepository.save(p3);

			System.out.println("===== Imprimindo as listas de  produtos =====");
			listaProdutos.forEach(c -> {
				System.out.println(c.toString());
			});

			System.out.println("===== Imprimindo as listas de  produtos com o Preço maior que 9 =====");
			var pd = produtoRepository.findByProdPrecoGreaterThan(9.0);
			pd.forEach(System.out::println);

			System.out.println("===== Imprimindo as listas de  produtos com o Preço Menor Igual que 10 =====");
			var produtos = produtoRepository.findByProdPrecoLessThanEqual(10.0);
			produtos.forEach(System.out::println);

			System.out.println("===== Imprimindo as listas de  produtos com o Nome Igual Fone =====");
			produtos = produtoRepository.findByProdName("Fone");
			produtos.forEach(System.out::println);

			//	Categoria e Produto por ID
			CategoriaProduto listaCategoriasPeloId = categoriaProdutoRepository.findByCategoriaId(3);

			System.out.println("===== Imprimindo as listas de  produtos Pelo ID_Categoria: 1 =====");
			System.out.println(listaCategoriasPeloId.toString());
			listaCategoriasPeloId.getProdutos().forEach(produto -> {
				System.out.println(produto.toString());
			});

			System.out.println("===== Imprimindo as listas de  produtos Pelo Nome contendo: E =====");

			var cats = categoriaProdutoRepository.findByNomeStartingWith("E");
			cats.forEach(System.out::println);
		};
	}
}
