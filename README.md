

# wx-mp-chatgpt-java

微信公众号集成 chatgpt 实现公众号AI机器人

<!-- PROJECT SHIELDS --> 
## 目录

- [上手指南](#上手指南)
  - [开发前的配置要求](#开发前的配置要求)
  - [安装步骤](#安装步骤)
- [开发的架构](#开发的架构)
- [部署](#部署)
- [如何参与开源项目](#如何参与开源项目)

### 上手指南
###### 开发前的配置要求

1. 微信公众平台账号（订阅号/服务号）
> 如果你没有微信公众号 请申请个体订阅号 [here](https://mp.weixin.qq.com/)
2. chatgpt账号 [openai](https://beta.openai.com/)
> 如果你没有 OpenAI 的账号，并且您在无法访问 OpenAI 的国家或地区，你可以查看 [here](https://mirror.xyz/boxchen.eth/9O9CSqyKDj4BKUIil7NC1Sa1LJM-3hsPqaeW_QjfFBc).
3. 最好有一个私人域名
###### **安装步骤**

1. Clone the repo

```sh
git clone https://github.com/5pyx55CG5ri4/wx-mp-chatgpt-java.git
``` 
2. 更换 [application](https://github.com/5pyx55CG5ri4/wx-mp-chatgpt-java/blob/main/src/main/resources/application.yml) 中的配置

```
#微信公众号配置
wx-config:
  appId: your appid
  appSecret: your appSecret
  checkToken: your checkToken
#chatgpt配置  
chatgpt-config:
  model: text-davinci-003 #ai模型 可默认
  temperature: 0.9 #热度 可默认
  maxTokens: 512 # 最大token数 可默认
  apiKey: your apiKey
```
3. run project
```
1. mvn clean package
2. java -jar ${projectName}
``` 
### 开发的架构
> 1. java8
> 2. springboot2.x
### 部署
> - 推荐使用微信云托管平台部署 新用户可免费试用3个月 项目内置了Dockerfile 上云托管看下就明白了
> - 私人云服务是一样的 未依赖任何中间件 有jdk环境的服务器都可以部署 
> - railway 也可以试试 作者没成功 微信公众号服务器配置 域名映射不上
> - 服务启动后需到微信公众平台后台 -> 设置与开发 -> 基本配置菜单 -> 服务器配置 
> ```sh
> 服务器地址(URL):服务映射的域名 + wx/login
> 令牌(Token):application.yml中配置的 checkToken
> 消息加解密密钥(EncodingAESKey):自动生成
> 消息加解密方式:明文模式 
> ``` 

#### 如何参与开源项目

贡献使开源社区成为一个学习、激励和创造的绝佳场所。你所作的任何贡献都是**非常感谢**的。


1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request





