# sql-test
Mysql和Cassandra的demo

## Cassandra by docker

### Kownledge based

cluster >= data center >= node

MEMTable 内存中的表

SSTable  硬盘中的

CommitLog 提交日志是Cassandra中的崩溃恢复机制。每个写操作都写入提交日志。

bloom filter 测试集合中元素知否存在，每次查询后调用该算法

- 写操作：节点的每个写入活动都由写在节点中的提交日志捕获。稍后数据将被捕获并存储在存储器表中。每当内存表满时，数据将写入SStable数据文件。所有写入都会在整个集群中自动分区和复制。Cassandra会定期整合SSTables，丢弃不必要的数据。

- 读操作：在读操作，Cassandra 从MEM-table得到的值，并检查过滤器绽放找到保存所需数据的相应的SSTable。

更多了解

https://asyty.iteye.com/blog/1202072

### 默认端口说明

- 7199 - JMX（8080 pre Cassandra 0.8.xx）
- 7000 - 节点间通信（如果启用了TLS，则不使用）
- 7001 - TLS节点间通信（使用TLS时使用）
- 9160 - Thrift客户端API
- 9042 - CQL本地传输端口

我们用9042，需要暴露出，当然用到thrift也可以提前暴露出来

```docker run --name my-cassandra -d -p 9160:9160 -p 9042:9042 cassandra:3```

如果想在容器中访问 cqlsh

```docker exec -it my-cassandra bash```

```cqlsh -u cassandra -p cassandra```

先建一个keyspace(相当于建库),使用该keyspace

```CREATE KEYSPACE test WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};```

```USE test;```

建个表user id为主键 还有一个字段是name,一般都是用代码中生成的uuid来当做主键，没办法id自增

```CREATE TABLE user ( id text, name text, PRIMARY KEY (id));```

具体springboot中结构可以仿照这个网址来写 

https://www.jianshu.com/p/5540cca823ca


## Mysql by docker

从docker使用mysql需要在容器内部，把权限开放外部使用 
 
```docker run --name my-mysql -e MYSQL_ROOT_PASSWORD=123456 -d -p 3306:3306 mysql:8.0.15```

如果直接在navicat会报错，远端没有权限访问，进入容器修改，mysql的root密码就是123456

```docker exec -it my-mysql bash```

```mysql -uroot -p123456```

修改USER表中root密码就远端就可以获取到权限

```ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';```

然后建个库，我自己起的名字。。使用该库

```CREATE DATABASE tony;```

```USE tony;```

然后建个表，就可以起项目了

```CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
); ```

