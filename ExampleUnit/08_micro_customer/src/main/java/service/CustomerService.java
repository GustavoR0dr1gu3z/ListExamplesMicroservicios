package service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import entities.CustomerEntity;
import repository.CustomerInterface;

@Service
public class CustomerService implements CustomerInterface {
	

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends CustomerEntity> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomerEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<CustomerEntity> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomerEntity getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerEntity getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerEntity getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomerEntity> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomerEntity> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomerEntity> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerEntity> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomerEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CustomerEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CustomerEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends CustomerEntity> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CustomerEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomerEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends CustomerEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomerEntity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends CustomerEntity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends CustomerEntity, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
