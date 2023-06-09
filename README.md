# graphing dependency

* Download `graphviz`
* To see the UML breakdown of the dependencies:
    * Run following
      command: `mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false -Dscope=compile "-Dincludes=com.food.ordering.system*:*"`
* To do the initial kafka setup, run the following docker compose command in `infrastructure/docker-compose`,
    * `docker-compose -f common.yml -f zookeeper.yml up`
* To run the init: `docker-compose -f common.yml -f init_kafka.yml up`
