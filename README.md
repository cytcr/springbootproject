# springboot-mybatisplus
springboot-mybatisplus整合

pom依赖
       <!-- mybatis-plus-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.0.5</version>
        </dependency>
        <!-- 数据库驱动-->

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>

application.properties配置文件

#数据库连接配置
spring.datasource.url=jdbc:mysql://localhost:3306/springboottest?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#mybatis-plus
mybatis-plus.mapper-locations=classpath:mapper/*/*.xml
mybatis-plus.configuration.call-setters-on-nulls=true
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
