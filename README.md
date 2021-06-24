# Spring boot JPA with Replication
- database schema
```sql
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `contents` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into `product` (title, contents) values ('상품1', '상품1입니다'), ('상품2', '상품2입니다'), ('상품3', '상품3입니다');
```

# Reference
- [Spring Boot + JPA DB Replication 설정하기](https://velog.io/@kingcjy/Spring-Boot-JPA-DB-Replication-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0) by [kingcjy](https://velog.io/@kingcjy)
