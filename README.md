# Shine 说明


> 简单介绍

已集成组件：
```
1、rabbitmq
2、mybatis-plus （mybatis 自动 crud 功能）
3、mail（收发邮件）
4、freemarker （继承模板支持、环境控制）
5、redis
6、j2cache
7、mongodb
8、quartz (定时任务)
9、H+（界面）
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
driver=xxxx
url=xxxx
username=xxxx
password=xxxx
initialSize=0
maxActive=20
maxIdle=20
minIdle=1
maxWait=60000
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