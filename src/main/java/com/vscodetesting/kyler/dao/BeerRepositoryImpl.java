package com.vscodetesting.kyler.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.vscodetesting.kyler.config.CouchbaesConfig;
import com.vscodetesting.kyler.models.Beer;

@Repository
public class BeerRepositoryImpl implements BeerRepository {

    private final Cluster cluster;
    private final Collection collection;
    private final CouchbaesConfig couchbaseConfig;

    public BeerRepositoryImpl(Cluster cluster, Bucket bucket, CouchbaesConfig couchbaseConfig) {
        this.cluster = cluster;
        this.collection = bucket.scope("_default").collection("_default");
        this.couchbaseConfig = couchbaseConfig;
    }

    @Override
    public Beer findById(String id) {
        return collection.get(id).contentAs(Beer.class);
    }

    @Override
    public Beer save(Beer beer) {
        collection.insert(beer.getId(), beer);
        return beer;
    }

    @Override
    public Beer update(String id, Beer beer) {
        collection.replace(beer.getId(), beer);
        return beer;
    }

    @Override
    public void delete(String id) {
        collection.remove(id);
    }

    @Override
    public List<Beer> findAll() {
                String statement = "SELECT id, name, description, type FROM `beers`.`_default`.`_default`";
        return cluster
                .query(statement)
                .rowsAs(Beer.class);
    }

    @Override
    public List<Beer> findByType(String type) {
        String statement = "Select id, name, description, type FROM `beers`.`_default`.`_default` WHERE type= '" + type + "'";
        return cluster.query(statement).rowsAs(Beer.class);
    }
    
}
