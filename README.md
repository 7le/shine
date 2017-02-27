# Shine 说明


> 简单介绍

已集成组件：
```
1、rabbitmq
2、mybatis-plus （mybatis 自动 crud 功能）
3、freemarker
4、redis
5、j2cache
6、mongodb
7、quartz (定时任务)
8、H+（界面）
等...
```

> 配置的添加

在mongodb的模块 main文件下
创建一个resources文件夹存放配置文件
mongodb.properties
```
mongo_host=XXXXX #服务器IP
mongo_port=27017 #端口号 一般为27017
mongo_db=XXX
mongo_user=XXX
mongo_psw=XXX
```

在shine_services的模块 main文件下
创建一个resources文件夹存放配置文件
jdbc.properties
```
url=xxxx
driverClassName: com.mysql.jdbc.Driver
username: root
password: root
filters: stat
maxActive: 20
initialSize: 1
maxWait: 60000
minIdle: 10
maxIdle: 15
timeBetweenEvictionRunsMillis: 60000
minEvictableIdleTimeMillis: 300000
validationQuery: SELECT 'x'
testWhileIdle: true
testOnBorrow: false
testOnReturn: false
maxOpenPreparedStatements: 20
removeAbandoned: true
removeAbandonedTimeout: 1800
logAbandoned: true
initialSize=0
maxActive=20
maxIdle=20
minIdle=1
maxWait=60000
```
```
监控界面 http://ip:port/projectName/druid/index.html
```


在src的 properties文件下
创建一个resources文件夹存放配置文件
redis.properties
```
redis.password=XXX
redis.ip=XXX
redis.database=0
redis.port=16379
redis.timeOut=2000
redis.maxIdle=36000
redis.maxWait=1000
redis.maxActive=300
```
rabbitmq.properties
```
mq_IP=127.0.0.1
mq_port=5672
mq_username=guest
mq_password=guest
mq_maxConnNum=2
```