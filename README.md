# mobileback
接口文档地址：https://easydoc.xyz/#/doc/99704100/ <br>

接口整体情况
## 1.新闻相关接口
   a.获取新闻列表  /news/listPage?pageNum=1 <br>
   b.获取指定新闻ID的详细信息 /news/searchId/88 <br>
## 2.通知公告相关接口
   a.通知公告列表 /notice/listPage?pageNum=1 <br>
   b.通知公告详情接口 /notice/searchId/88 <br>
## 3.政务公开相关接口 `3.27日已完成`
   a.政务公开栏目列表 /govern/list <br>
   b.获取栏目对应的文章列表 /govern/news?governId=  <br>
   c.获取文章内容 /govern/details?newsId= <br>
## 4.获取教育交流世界(期刊)数据 `不做，`
   `问题描述：教育交流世界 下 目前只有子栏目 天津教育国际交流与合作 ,年报， 会刊 ， 没有其他的新闻数据，要去那里找期刊数据` <br>
   a.搜索 <br>
   b.期刊订阅 <br>
## 5.获取天津市国际教育交流服务中心数据 `未完成`
   `问题描述： 天津市国际教育交流服务中心 在accessdb中对应的表 Comstye 中 ID 是82， 并没有其他的子栏目，获取的数据在哪里？`  <br>
   a.获取服务中心子栏目 <br>
   b.获取栏目下面的文章列表 <br>
   c.获取栏目下面的文章具体内容 <br> 
## 6..获取大栏目数据（首页展示使用） `未完成`
   `问题描述:不清楚接口 的 目的及要获取的数据？？？` <br>
   a.获取大栏目名称及图片说明 <br>
   b.获取大栏目对应的内容 <br>
## 7.获取首页轮播图
   a.获取首页图片地址 /advertisement/list <br>
`以下均为未完成`
## 8.用户部分
`此处的登录完全没有考虑 token的问题么?注册时只有这两个参数么？用户名是手机号还是邮箱？`<br>
`密码找回要介入第三方找回么?`
   >a.用户登录
   >>传递参数: <br>
   >>>username <br>
   >>>password <br>
   
   >>返回参数<br>
   >>>返回用户id，失败返回-1
   
   >b.用户注册 <br>
   >>POST <br>
   >>传递参数： username（用户名） <br>
   >>>email   （邮箱) <br>
   >>>password（密码）<br>
   
   >>返回结果： <br>
   >>>返回用户id，失败返回-1 <br>
    
   >c.用户数据修改 <br> 
   >>POST<br>
   >>传递参数： 
   >>>userid（用户ID）<br>
   >>>username（用户名）<br>
   >>>email（邮箱）<br>
   >>>password（密码）<br>
        
   >>返回结果： <br>
   >>>返回用户id，失败返回-1  <br>
   
   >d.用户密码找回：<br>
   >>POST<br>
   >>传递参数： <br>
   >>>email（邮箱）<br>
   
   >>返回结果： <br>
   >>>密码发送 成功或 失败<br>
## 9.其他接口 
`对应的数据表是哪个？`
 >a.添加照片或文档
 >>POST <br>
 >>传递参数：
 >>>userid（用户ID）<br>
 >>>code(随机数) <br>
 >>>2进制流 <br>
 
 >>返回结果：
 >>>返回文件ID，code(随机数),失败返回-1
     
 >b.获取照片或文档下载地址
 >>POST <br>
 >>传递参数：
 >>>userid（用户ID）<br>
 >>>fileid (文件ID)
 
 >>返回结果：
 >>>返回文件下载地址。

`以下三个接口对应的mysql数据库的表与提供的参数有很大差异，需确定后在开发，详情见0324文档`
## 10.留学申请
## 11.奖学金
## 12.学校审核

   
   

# 3.23日更新 :
## 1.获取留学风采数据 相关接口
   a.获取校友新闻列表 (未做分页处理，后续更改为分页) /article/alumin/news <br>
   b.获取校友活动列表 /article/alumin/details?id= <br>
   c.搜索校友 (需求不明确，未开发) <br>
## 2.获取生活助手数据 (页面端未分页，此处不做分页)
   a.获取生活助手子栏目 /article/lifeassistant/news <br>
   b.获取栏目下具体内容 /article/lifeassistant/details?id= <br>
## 3.获取留学生活数据 (源文档中存在三个接口，目前版本 省略栏目ID，直接获取 新闻列表)
   实现的接口 <br>
   a.获取栏目下面的文章列表 /article/overseaslife/news <br>
   b.获取栏目下面的文章具体内容 /article/overseaslife/details?id= <br>
## 4.获取天津教育数据
   a.获取天津教育大学列表 /tjeducation/colleges <br>
   b.获取大学或子学院的详细说明 /tjeducation/details?schoolGuid=&collegeGuid= <br>
## 5.获取为什么留学天津数据 (问题同 3 :)
   a.获取栏目下面的文章列表 /article/studytianjin/news <br>
   b.获取栏目下面的文章具体内容 /article/studytianjin/details?id= <br>

# 3.25日更新:
## 1.获取新闻热点数据
   `问题: 与校友活动列表 的数据相同?` <br>
   a.获取新闻热点数据 /article/hotnews/list <br>
   b.获取新闻热点数据内容 /article/hotnews/details <br> 
   c.新闻热点文章搜索 /article/hotnew/search `未完成，未确定接口`
## 2.增加JWT相关
   a.添加jwt认证，增加@JwtIgnore接口，方法上带有此接口的不会通过jwt验证  <br>
   b.jwt相关拦截 <br>
   c.登录的异常控制 UserException , 但完成情况不好，后续更改 <br>

# 3.26日更新
## 1.增加留学风采 接口
   a.添加 获取 体验天津新闻接口 /article/exeperienceTJ/news <br>
   b.添加 体验天津 新闻详细接口 /article/exeperienceTJ/details?id=
## 2.用户注册接口
   a.用户注册: /registry  post请求   指定 Content-Type 为 application/json  <br>
        传入得数据如下: <br>
        ``	
        {
            "username":"shiyu", 
          	"password":"111", 
          	"email":"shiyuneau@163.com"
         }
          ``
          返回 token : 如下 <br>
          eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzNjAxNzIzLCJleHAiOjE1NTM2MDE3ODMsIm5iZiI6MTU1MzYwMTcyM30.RX-33PBpo75Wy2uSwOv-Qmc8IHb3XGP3W4ZBlxmpZIg
## 3.用户登录接口
   a.用户登录: /login  post请求  指定 Content-Type 为 application/json  <br>
        传入得数据如下: <br>
           ``	
           {
               "username":"shiyu", 
             	"password":"111"
           }
             ``
        返回 token : 如下 <br>
           eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzNjAxNzIzLCJleHAiOjE1NTM2MDE3ODMsIm5iZiI6MTU1MzYwMTcyM30.RX-33PBpo75Wy2uSwOv-Qmc8IHb3XGP3W4ZBlxmpZIg
<br>
# 3.27日更新
## 1.政务公开相关
   a.获取栏目对应的文章列表 /govern/news?governId= (governId取最后一级得栏目ID)<br>
   b.获取栏目下新闻得详细信息 /govern/details?newsId= <br>
## 2.获取天津各高校链接
   a.获取天津各高校链接 /tjschools/links <br>
 
# 3.30日更新
   a.增加新闻详情页标题显示 <br>
   b.用户登录、注册接口完善 <br>
   c.更改用户信息接口开发完成，地址: /userinforeset , post请求 ，<br>
     具体的参数如下: <br>
     header参数: <br>
        Content-Type:application/json, <br>
        Authorization:TJEDU eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzOTU3NzUwLCJleHAiOjE1NTM5NjM3NTAsIm5iZiI6MTU1Mzk1Nzc1MH0.1wxmqNB_i6b05TVfXM38CnxHYdaLT3Gyy2c-XIuCUPA <br>
        (用户的认证主要主要通过 Authorization:参数判定， 格式 为 TJEDU token) <br>
     body参数: <br>
        ``
        { 
        	"oldusername":"shi", 原用户名称 
        	"newusername":"shiyu", 新用户名称
        	"password":"111111", 新密码
        	"email":"shiyuneau@123.com" 新邮箱
        }
        `` <br>
     返回参数: <br>
        token