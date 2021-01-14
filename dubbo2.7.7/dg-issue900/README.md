## 代码

三个 maven 模块

- common 公共的接口和对象
- provider 提供方
- consumer 消费方

## 镜像

基于 docker 文件夹内容构建

- provider 提供方
- consumer 消费方

```bash
cd docker/consumer
docker build -t jd-consumer:0.0.1 .
```

```bash
cd docker/provider
docker build -t jd-provider:0.0.1 .
```

## 镜像启动

> zookeeper 需要在本地安装

```bash
docker pull ironc/jd-provider:dgissue900
docker run --network host --name java-provider -it ironc/jd-provider:dgissue900
```

```bash
docker pull ironc/jd-consumer:dgissue900
docker run --network host --name java-consumer -it ironc/jd-consumer:dgissue900
```

正常输出：

```bash
Hello tc You are 18
```
