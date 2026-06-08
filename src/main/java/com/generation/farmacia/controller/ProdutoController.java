package com.generation.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.CategoriaRepository;
import com.generation.farmacia.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id) {
		return produtoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto) {

		if (produto.getCategoria() == null || produto.getCategoria().getId() == null) {
			return ResponseEntity.badRequest().build();
		}

		if (categoriaRepository.existsById(produto.getCategoria().getId())) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(produtoRepository.save(produto));
		}

		return ResponseEntity.badRequest().build();
	}

	@PutMapping
	public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto) {

		if (produto.getId() == null) {
			return ResponseEntity.badRequest().build();
		}

		if (!produtoRepository.existsById(produto.getId())) {
			return ResponseEntity.notFound().build();
		}

		if (produto.getCategoria() == null || produto.getCategoria().getId() == null) {
			return ResponseEntity.badRequest().build();
		}

		if (!categoriaRepository.existsById(produto.getCategoria().getId())) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(produtoRepository.save(produto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		if (produtoRepository.existsById(id)) {
			produtoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
}