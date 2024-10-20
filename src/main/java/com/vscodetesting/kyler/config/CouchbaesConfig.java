package com.vscodetesting.kyler.config;

import java.time.Duration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.couchbase.client.core.error.BucketNotFoundException;
import com.couchbase.client.core.error.UnambiguousTimeoutException;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class CouchbaesConfig {
    
    @Bean(destroyMethod = "disconnect")
    Cluster getCouchbaseCluster() {
        try {
            log.debug("Connecting to Couchbase cluster at localhost");
            Cluster cluster = Cluster.connect("localhost", "Administrator", "sixteenth");
            cluster.waitUntilReady(Duration.ofSeconds(15));
            return cluster;
        } catch (UnambiguousTimeoutException e) {
            log.error("Connection to Couchbase cluster at localhost timed out");
            throw e;
        } catch (Exception e) {
            log.error(e.getClass().getName());
            log.error("Could not connect to Couchbase cluster at localhost");
            throw e;
        }
    }

    @Bean
    Bucket getCouchbaseBucket(Cluster cluster) {
        try {
            if (!cluster.buckets().getAllBuckets().containsKey("beers")) {
                throw new BucketNotFoundException("Bucket beers does not exist");
            }
            Bucket bucket = cluster.bucket("beers");
            bucket.waitUntilReady(Duration.ofSeconds(15));
            return bucket;
        } catch (UnambiguousTimeoutException e) {
            log.error("Connection to bucket beers timed out");
            throw e;
        } catch (BucketNotFoundException e) {
            log.error("Bucket beers does not exist");
            throw e;
        } catch (Exception e) {
            log.error(e.getClass().getName());
            log.error("Could not connect to bucket beers");
            throw e;
        }
    }
}
