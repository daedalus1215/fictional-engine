# graphing dependency

* Download `graphviz`
* To see the UML breakdown of the dependencies:
    * Run following
      command: `mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false -Dscope=compile "-Dincludes=com.food.ordering.system*:*"`
* To do the initial kafka setup, go into the `infrastructure/docker-compose` directory:
    * Create a `.env` file at `infrastructure/.env`, and give it the following content: 
    ```
    KAFKA_VERSION=7.0.1
    GLOBAL_NETWORK=food-ordering-system
    GROUP_ID=com.food.ordering.system
    ```
    * Then run: `docker-compose -f common.yml -f zookeeper.yml up`
    * Then run: `docker-compose -f common.yml -f kafka_cluster.yml up`
    * Then run: `docker-compose -f common.yml -f init_kafka.yml up`

# Kafka Cluster Setup:
* http://localhost:9000/addCluster
* Cluster Name: `food-ordering-system-cluster`
* Cluster Zookeeper Hosts: `zookeeper:2181`

# Running Apps
* Go to each service: payment-service, restaurant-service, order-service, find their containers and run the Apps from those container packages.
* Customer Service: should be run to create db objects.