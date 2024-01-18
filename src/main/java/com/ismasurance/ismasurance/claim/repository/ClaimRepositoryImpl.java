package com.ismasurance.ismasurance.claim.repository;

import com.ismasurance.ismasurance.claim.api.v1.dto.SearchClaimRequest;
import com.ismasurance.ismasurance.claim.data.ClaimEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Collections;
import java.util.Collections;
import java.util.Collections;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ClaimRepositoryImpl implements ClaimRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<ClaimEntity> getClaimByRequest(SearchClaimRequest searchClaimRequest) {
        String claClaim = searchClaimRequest.getClaClaim();
        String handlerName = searchClaimRequest.getHandlerName();
        String claPolicy = searchClaimRequest.getClaPolicy();

        if ("".equals(claClaim) && "".equals(handlerName) && "".equals(claPolicy)) {
            return mongoTemplate.findAll(ClaimEntity.class);
        }

        Criteria criteria = new Criteria();
        criteria.orOperator(
                Criteria.where("CLA_CLAIM").is(claClaim),
                Criteria.where("CLA_POLICY").is(claPolicy),
                Criteria.where("HANDLER_NAME").is(handlerName)
        );
        Query query = new Query(criteria);
        return mongoTemplate.find(query, ClaimEntity.class, "Claims");
    }

    @Override
    public <S extends ClaimEntity> S save(S entity) {
        return mongoTemplate.save(entity);
    }

    @Override
    public <S extends ClaimEntity> List<S> saveAll(Iterable<S> entities) {
        return Collections.emptyList();
    }

    @Override
    public Optional<ClaimEntity> findById(String s) {
        return Optional.ofNullable(mongoTemplate.findById(s, ClaimEntity.class));
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<ClaimEntity> findAll() {
        return mongoTemplate.findAll(ClaimEntity.class, "Claims");
    }

    @Override
    public Iterable<ClaimEntity> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(ClaimEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends ClaimEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ClaimEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ClaimEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ClaimEntity> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends ClaimEntity> List<S> insert(Iterable<S> entities) {
        return Collections.emptyList();
    }

    @Override
    public <S extends ClaimEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ClaimEntity> List<S> findAll(Example<S> example) {
        return Collections.emptyList();
    }

    @Override
    public <S extends ClaimEntity> List<S> findAll(Example<S> example, Sort sort) {
        return Collections.emptyList();
    }

    @Override
    public <S extends ClaimEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ClaimEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ClaimEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ClaimEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
