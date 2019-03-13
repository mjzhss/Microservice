
日志管理:
https://blog.csdn.net/peterwanghao/article/details/86595765
1.每个事务生成一个惟一标识符，并利用其关联事件以及追踪各项事务
2.ELK安装：
 2.1 Elasticsearch
    https://www.elastic.co/downloads/elasticsearch
    在命令提示符下运行bin\elasticsearch.bat。
    默认情况下，它可从http://localhost:9200开始访问
 2.2 Kibana
    https://www.elastic.co/downloads/kibana
    在编辑器中打开config/kibana.yml，并设置elasticsearch.url指向您的Elasticsearch实例。在我们的例子中，elasticsearch.url: “http://localhost:9200”
    在命令提示符下运行bin\kibana.bat。
    成功启动后，Kibana将启动默认端口5601，Kibana UI将通过http://localhost:5601访问
 2.3 Logstash
    https://www.elastic.co/downloads/logstash
    根据配置说明创建一个文件logstash.conf。我们将在后面实际演示时再次确定配置。
    现在运行bin/logstash -f logstash.conf以启动logstash。

