# mobileback
接口文档地址：https://easydoc.xyz/#/doc/99704100/


3.23日更新 :
## 1.获取留学风采数据 相关接口
  -- a.获取校友新闻列表 (未做分页处理，后续更改为分页) /article/alumin/news
  -- b.获取校友活动列表 /article/alumin/details?id=
  -- c.搜索校友 (需求不明确，未开发)
## 2.获取生活助手数据 (页面端未分页，此处不做分页)
  -- a.获取生活助手子栏目 /article/lifeassistant/news
  -- b.获取栏目下具体内容 /article/lifeassistant/details?id=
## 3.获取留学生活数据 (源文档中存在三个接口，目前版本 省略栏目ID，直接获取 新闻列表)
  -- 实现的接口
  -- a.获取栏目下面的文章列表 /article/overseaslife/news
  -- b.获取栏目下面的文章具体内容 /article/overseaslife/details?id=
## 4.获取天津教育数据
  -- a.获取天津教育大学列表 /tjeducation/colleges
  -- b.获取大学或子学院的详细说明 /tjeducation/details?schoolGuid=&collegeGuid=
## 5.获取为什么留学天津数据 (问题同 3 :)
  -- a.获取栏目下面的文章列表 /article/studytianjin/news
  -- b.获取栏目下面的文章具体内容 /article/studytianjin/details?id=
