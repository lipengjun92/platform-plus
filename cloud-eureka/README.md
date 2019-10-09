### 说明

在一个分布式系统中，服务注册中心是最重要的基础部分，理应随时处于可以提供服务的状态。如果是单点部署，如果注册中心出现故障，将会出现毁灭性的灾难。为了维持其可用性，使用集群是很好的解决方案。Eureka通过互相注册的方式来实现高可用的部署，所以我们只需要将Eureke Server配置其他可用的serviceUrl就能实现高可用部署。

### 打包
~~~
mvn clean package
mvn install
~~~

### 运行
~~~
java -jar cloud-eureka.jar --spring.profiles.active=peer1

java -jar cloud-eureka.jar --spring.profiles.active=peer2

java -jar cloud-eureka.jar --spring.profiles.active=peer3
~~~
