package com.example;

import com.example.modules.Product;
import com.example.modules.enums.ProductStatus;
import com.example.modules.Purchase;
import com.example.modules.User;
import com.example.modules.enums.ProductStatus;
import com.example.modules.enums.PurchasesStatus;
import com.example.repository.ProductRepo;
import com.example.repository.PurchaseRepo;
import com.example.repository.UserRepo;
import com.example.services.EmailMessage;
import com.example.services.ProductService;
import com.example.services.PurchaseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RunWith(SpringRunner.class)

@SpringBootTest
class P02ApplicationTests {

	private ProductRepo pr = new ProductRepo() {
		@Override
		public List<Product> findAllBySeller(User p) {
			return null;
		}

		@Override
		public List<Product> findByNameContaining(String s) {
			return null;
		}

		@Override
		public List<Product> findAllByStatusid(ProductStatus open) {
			return null;
		}

		@Override
		public List<Product> findByNameContainingAndStatusid(String s, ProductStatus open) {
			return null;
		}

		@Override
		public List<Product> findAll() {
			return null;
		}

		@Override
		public List<Product> findAll(Sort sort) {
			return null;
		}

		@Override
		public List<Product> findAllById(Iterable<Integer> integers) {
			return null;
		}

		@Override
		public <S extends Product> List<S> saveAll(Iterable<S> entities) {
			return null;
		}

		@Override
		public void flush() {

		}

		@Override
		public <S extends Product> S saveAndFlush(S entity) {
			return null;
		}

		@Override
		public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
			return null;
		}

		@Override
		public void deleteAllInBatch(Iterable<Product> entities) {

		}

		@Override
		public void deleteAllByIdInBatch(Iterable<Integer> integers) {

		}

		@Override
		public void deleteAllInBatch() {

		}

		@Override
		public Product getOne(Integer integer) {
			return null;
		}

		@Override
		public Product getById(Integer integer) {
			return null;
		}

		@Override
		public <S extends Product> List<S> findAll(Example<S> example) {
			return null;
		}

		@Override
		public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
			return null;
		}

		@Override
		public Page<Product> findAll(Pageable pageable) {
			return null;
		}

		@Override
		public <S extends Product> S save(S entity) {
			return null;
		}

		@Override
		public Optional<Product> findById(Integer integer) {
			return Optional.empty();
		}

		@Override
		public boolean existsById(Integer integer) {
			return false;
		}

		@Override
		public long count() {
			return 0;
		}

		@Override
		public void deleteById(Integer integer) {

		}

		@Override
		public void delete(Product entity) {

		}

		@Override
		public void deleteAllById(Iterable<? extends Integer> integers) {

		}

		@Override
		public void deleteAll(Iterable<? extends Product> entities) {

		}

		@Override
		public void deleteAll() {

		}

		@Override
		public <S extends Product> Optional<S> findOne(Example<S> example) {
			return Optional.empty();
		}

		@Override
		public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
			return null;
		}

		@Override
		public <S extends Product> long count(Example<S> example) {
			return 0;
		}

		@Override
		public <S extends Product> boolean exists(Example<S> example) {
			return false;
		}

		@Override
		public <S extends Product, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
			return null;
		}
	};
	private PurchaseRepo rR = new PurchaseRepo() {
		@Override
		public List<Purchase> findAllByBuyer(User u) {
			return null;
		}

		@Override
		public List<Purchase> findAllByBuyerAndStatusid(User u, PurchasesStatus cart) {
			return null;
		}

		@Override
		public List<Purchase> findAllByBuyerAndStatusidNot(User u, PurchasesStatus cart) {
			return null;
		}

		@Override
		public List<Purchase> findAll() {
			return null;
		}

		@Override
		public List<Purchase> findAll(Sort sort) {
			return null;
		}

		@Override
		public List<Purchase> findAllById(Iterable<Integer> integers) {
			return null;
		}

		@Override
		public <S extends Purchase> List<S> saveAll(Iterable<S> entities) {
			return null;
		}

		@Override
		public void flush() {

		}

		@Override
		public <S extends Purchase> S saveAndFlush(S entity) {
			return null;
		}

		@Override
		public <S extends Purchase> List<S> saveAllAndFlush(Iterable<S> entities) {
			return null;
		}

		@Override
		public void deleteAllInBatch(Iterable<Purchase> entities) {

		}

		@Override
		public void deleteAllByIdInBatch(Iterable<Integer> integers) {

		}

		@Override
		public void deleteAllInBatch() {

		}

		@Override
		public Purchase getOne(Integer integer) {
			return null;
		}

		@Override
		public Purchase getById(Integer integer) {
			return null;
		}

		@Override
		public <S extends Purchase> List<S> findAll(Example<S> example) {
			return null;
		}

		@Override
		public <S extends Purchase> List<S> findAll(Example<S> example, Sort sort) {
			return null;
		}

		@Override
		public Page<Purchase> findAll(Pageable pageable) {
			return null;
		}

		@Override
		public <S extends Purchase> S save(S entity) {
			return null;
		}

		@Override
		public Optional<Purchase> findById(Integer integer) {
			return Optional.empty();
		}

		@Override
		public boolean existsById(Integer integer) {
			return false;
		}

		@Override
		public long count() {
			return 0;
		}

		@Override
		public void deleteById(Integer integer) {

		}

		@Override
		public void delete(Purchase entity) {

		}

		@Override
		public void deleteAllById(Iterable<? extends Integer> integers) {

		}

		@Override
		public void deleteAll(Iterable<? extends Purchase> entities) {

		}

		@Override
		public void deleteAll() {

		}

		@Override
		public <S extends Purchase> Optional<S> findOne(Example<S> example) {
			return Optional.empty();
		}

		@Override
		public <S extends Purchase> Page<S> findAll(Example<S> example, Pageable pageable) {
			return null;
		}

		@Override
		public <S extends Purchase> long count(Example<S> example) {
			return 0;
		}

		@Override
		public <S extends Purchase> boolean exists(Example<S> example) {
			return false;
		}

		@Override
		public <S extends Purchase, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
			return null;
		}
	};
	private UserRepo ur;


	@Test
	void contextLoads() {
	}

	private ProductService pservice = new ProductService(pr, ur);

	@Test
	public void testingProduct(){
		List<Product> products = pservice.getAllProducts();
		products = pservice.getAllProductsByStatus(ProductStatus.Close);
		products = pservice.getLikeName("name");

	}

	private PurchaseService rservice = new PurchaseService(rR, ur, pr);

	@Test
	public void testingPurchase(){
		List<Purchase> purchases = rservice.getAllPurchases();
	}



}