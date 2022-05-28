项目模板生成：
https://start.spring.io/
MAC 安装maven详细教程：
https://blog.csdn.net/m0_67392182/article/details/123656536
maven启动：
mvn spring-boot:run
利用打包方式启动（生成jar文件）
mvn clean package
使用java命令启动这个文件：
java -jar target/demo-0.0.1-SNAPSHOT.jar

brew 安装:
/bin/zsh -c "$(curl -fsSL https://gitee.com/cunkai/HomebrewCN/raw/master/Homebrew.sh)"
初步介绍几个brew命令
本地软件库列表：brew ls
查找软件：brew search google（其中google替换为要查找的关键字）
查看brew版本：brew -v  更新brew版本：brew update
安装cask软件：brew install --cask firefox 把firefox换成你要安装的


mybatis自动生成：
执行：选中工程-——》右键——》Run As_——》Maven Build
Goals:mybatis-generator:generate

lombok插件安装（eclipse、intellJ idea）
https://blog.csdn.net/weixin_43820771/article/details/122702187
------------------------------------------------------------------------------------------------------------------------

docker部署java项目or安装nginx:
https://blog.csdn.net/qq_45506409/article/details/112169087

（一）查看镜像列表：
docker images

（二）查看容器：
1: 进入容器：
(1):如果要基于镜像名称获取容器ID，则应该可以使用:（image_name：oa镜像名）
$ docker ps | grep '<image_name>' | awk '{ print $1 }'
(2)进入指定容器（长短容器id都可以）
docker exec -it ef9221525cea1d1ece94299d2e5a911b82bbc937fc144b9a05d628e764903c95 /bin/sh
				（短id：ef9221525cea）
2:查询容器ip
(1)进入容器内部后 cat /etc/hosts 会显示自己以及(– link)软连接的容器IP
(2)宿主机：docker inspect 容器ID | grep IPAddress

3：删除容器：
1. 删除指定容器 
docker rm -f <containerid>
2. 删除未启动成功的容器
docker rm $(docker ps -a|grep Created|awk '{print $1}')
或者
docker rm $(docker ps -qf status=created)
3. 删除退出状态的容器
docker rm $(docker ps -a|grep Exited|awk '{print $1}')
或者
docker rm $(docker ps -qf status=exited)
4. 删除所有未运行的容器
docker rm $(docker ps -a -q) #正在运行的删除不了，所有未运行的都被删除了
或者
docker container prune #Docker 1.13版本以后，可以使用 docker containers prune 命令，删除孤立的容器

4:启动停止容器：
docker （start）stop [OPTIONS] Container [Container …]



Vue 安装相关：
This package has installed:
	•	Node.js v16.14.2 to /usr/local/bin/node
	•	npm v8.5.0 to /usr/local/bin/npm
Make sure that /usr/local/bin is in your $PATH.
mac 安装vue全网最详细教程
https://blog.csdn.net/qq_34663267/article/details/116266997
https://blog.csdn.net/anndy_/article/details/120785886
VUE CLI创建项目无权限解决：
第一步：
sudo vim /etc/synthetic.conf
第二步：按 i 进入编辑模式，输入下行文字
data /System/Volumes/Data/data
注意 data 和 /System 之间是 tab 键
第三步：进入到 /System/Volumes/Data 下，创建文件夹 data
cd /System/Volumes/Data
sudo mkdir data
第四步：给 data 设置权限，我给了最高权限
sudo chmod -R 777 data
第五步：
重启！
一、vue2.0
1、创建项目
vue init webpack iproject  
2、启动项目
npm run dev
二、vue3.0
1、创建项目
vue create iproject
2、启动项目
npm run serve
uniapp 教程
https://uniapp.dcloud.io
------------------------------------------------------------------------------------------------------------------------
Dockerfile文件配置例子：
# 运行环境
FROM java:latest
#将本地文件夹挂在到当前容器
VOLUME /tmp
#复制文件到容器
ADD oa.jar /app.jar
#声明需要暴露的端口
EXPOSE 8081
#配置容器启动后执行的命令
ENTRYPOINT java -jar /app.jar




	docker run \
   --name mynginx02 \
   -d -p 8082:8080 \
   -v /Users/admin/liubiao/nginx/conf/nginx.conf:/etc/nginx/nginx.conf \
   -v /Users/admin/liubiao/nginx/log:/var/log/nginx \
   -v /Users/admin/liubiao/nginx/html:/usr/share/nginx/html \
   nginx:latest


docker desktop安装redis
https://blog.csdn.net/qq_44345263/article/details/123327509

