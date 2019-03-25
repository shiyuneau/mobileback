# mobileback
接口文档地址：https://easydoc.xyz/#/doc/99704100/ <br>

接口整体情况
## 1.新闻相关接口
   a.获取新闻列表  /news/listPage?pageNum=1 <br>
   b.获取指定新闻ID的详细信息 /news/searchId/88 <br>
## 2.通知公告相关接口
   a.通知公告列表 /notice/listPage?pageNum=1 <br>
   b.通知公告详情接口 /notice/searchId/88 <br>
## 3.政务公开相关接口 `部分完成`
   a.政务公开栏目列表 /govern/list <br>
   b.获取栏目对应的文章列表 `未完成，未明确参数如何传递` <br>
   c.获取文章内容 `未完成，未明确参数如何传递` <br>
## 4.获取教育交流世界(期刊)数据 `未完成，`
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
   a.获取首页图片地址 /advertisement/list

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
   a.获取新闻热点数据 /article/hotnews/list
   b.获取新闻热点数据内容 /article/hotnews/details 
   c.新闻热点文章搜索 /article/hotnew/search `未完成，未确定接口`
## 2.增加JWT相关
   a.添加jwt认证，增加@JwtIgnore接口，方法上带有此接口的不会通过jwt验证  <br>
   b.jwt相关拦截 <br>
   c.登录的异常控制 UserException , 但完成情况不好，后续更改 <br>