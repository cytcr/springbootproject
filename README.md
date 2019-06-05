# springbootproject
以springboot为核心从零搭建企业级项目

相对上个版本增加以下组件：
  1.集成swagger2,便于测试 
  2.集成logback日志
  3.增加mybatis-plus分页查询功能
  
 swagger2 
   1.pom配置
 
   <!-- swagger2 start -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
        <!-- swagger2 end -->
    2.创建Swagger2Config.java文件
  
  logback日志
    1.由于springboot的日志框架，就是logback,所以不用添加pom依赖
    2.创建logback-spring.xml文件
    3.配置文件增加
      #日志
      logging.config=classpath:logconf/logback-spring.xml
  
  分页查询
    1.创建MybatisPlusConfig.java文件
