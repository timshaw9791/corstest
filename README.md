## 以maven项目导入(import)到idea中  
请注意综合运用删除.idea文件夹，*.iml文件功能，学会重新导入，学会运行maven命令mvn compile去下载依赖包

## 运行CorsTestApplication程序
    并留意输出：启动成功了吗？用的是什么数据库(也要留意resources/application.properties，其数据库连接字符串是什么)，
    
## 请确认这个数据库里是否存在这几个表
    如果不存在，则在项目中找到schema-h2.sql所在的目录，在你的数据库中运行相应的schema-数据库类型.sql
    SPRING_SESSION 
    SPRING_SESSION_ATTRIBUTES 
        
##  首次运行时进行其他表及数据的初始化 
    手动执行resource/db.sql
    
    