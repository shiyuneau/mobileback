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
  >d.用户密码找回：<br>
   >>POST<br>
   >>传递参数： <br>
   >>>email（邮箱）<br>
   
   >>返回结果： <br>
   >>>密码发送 成功或 失败<br>
## 9.其他接口 (已完成，见4月6日完成)
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
   a.用户注册: /student/registry  post请求   指定 Content-Type 为 application/json  <br>
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
   a.用户登录: /student/login  post请求  指定 Content-Type 为 application/json  <br>
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
   c.更改用户信息接口开发完成，地址: /student/userinforeset , post请求 ，<br>
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
# 3.31日更新
   a.更改用户信息接口逻辑更改，字段可不全输入 <br>
   b.增加学校列表接口，用于 搜索申请学校 使用

# 4.6日更新
   a.文件的上传与下载分别为 /file/upload 和 /file/download ，详情建接口文档 <br>
      备注: 测试前 请创建目录 D:/data/mobileback/
   b.更新新的sql文件 文件位置 sql目录下 <br>
   c.学校搜索接口 /tjeducation/schoolsearch 搜索学校 <br>
   d.留学相关 <br>

	1.留学申请 /studyabroad/apply post请求<br>
>具体参数如下: <br>
>>header参数: <br>
        Content-Type:application/json, <br>
        Authorization:TJEDU eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzOTU3NzUwLCJleHAiOjE1NTM5NjM3NTAsIm5iZiI6MTU1Mzk1Nzc1MH0.1wxmqNB_i6b05TVfXM38CnxHYdaLT3Gyy2c-XIuCUPA <br>
        (用户的认证主要主要通过 Authorization:参数判定， 格式 为 TJEDU token) <br>
>>body参数: <br>
        ``
        {
		"passportname":"你好啊是",
		"passportcode": "789798798798",
		"passportexpire": "2000-01-01",
		"familyname": "是",
		"givenname": "是",
		"highestdegree": "最高学历",
		"religion": "宗教",
		"nationality": "国籍",
		"mothertongue": "母语",
		"emigrantfrom": 0,
		"photoid": "123456789照片id long型",
		"sex": 0,
		"birth": "1996-03-20",
		"birthplace": "被警告",
		"maritalstatus": 0,
		"college": "123123",
		"taughtby": "阿斯蒂芬",
		"startyear": "2017",
		"fundingsource": "经费来源",
		"studyfield": "123123",
		"degree": "学历",
		"admissionseason": "入学季节",
		"english": "英语能力",
		"ielts": "雅思",
		"hsk": "HSK等级",
		"toefl": "托福",
		"referenceby":"中国大使馆",
		"referencetel": "111111",
		"finacial": "中国大使馆",
		"guarantorin": "大使馆",
		"guarantorintel":"123213",
		"guardian": "我自己啊",
		"educationList": [{
			"educationfrom": "20190222",
			"educationto": "29302222",
			"educationschool": "家里蹲啊",
			"educationstudy": "没有证数"
		}, {
			"educationfrom": "教育经历开始时间2",
			"educationto": "教育经历结束时间2",
			"educationschool": "教育经历就读学校2",
			"educationstudy": "教育经历专业或证书2"
		}],
		"workList": [{
			"workfrom": "工作经历1开始时间",
			"workto": "工作经历1结束时间",
			"workcompany": "工作经历1单位名称",
			"workposition": "工作经历1职务"
		}, {
			"workfrom": "工作经历2开始时间",
			"workto": "工作经历2结束时间",
			"workcompany": "工作经历2单位名称",
			"workposition": "工作经历2职务"
		}],
		"validpassport": "223arer",
		"graduatecertificate": "/daaatee",
		"highestacademic": 123456789,
		"studyplan": 123456789,
		"medicalreport": 123456789,
		"chineselanguagecertificate": 123456789,
		"juniorcollegedipint": 123456789,
		"collegetranscript": 123456789,
		"streetaddress": "北京市",
		"cityprovince": "北京",
		"country": "中国",
		"countryemail": "100101",
		"countryphone": "12346",
		"countryzipcode": "111111",
		"applyemail": "申请人邮箱",
		"applyphone": "申请人电话",
		"applyaddress": "申请人现住址",
		"applyzipcode": "申请人邮编",
		"receivername": "收件人姓名",
		"receivercity": "收件人省市",
		"receiveraddress": "收件人地址",
		"receiverphone": "收件人手机",
		"receivercountry": "收件人国家",
		"receiverzipcode": "收件人邮编",
		"familyList": [{
			"familyname": "阿斯蒂芬",
			"familyage": "4545",
			"familyposition": "没有职务",
			"familyphone": "78789789798",
			"familyemail": "123123@123.com",
			"familyworkplace": "家庭成员1工作单位",
			"familycontace": "家庭成员1与本人关系"
		}, {
			"familyname": "家庭成员2姓名",
			"familyage": "家庭成员2年龄",
			"familyposition": "家庭成员2职务",
			"familyphone": "家庭成员2电话",
			"familyemail": "家庭成员2邮箱",
			"familyworkplace": "家庭成员2工作单位",
			"familycontace": "家庭成员2与本人关系"
		}],
		"applicationnode": "申请备注"
		}
        `` <br>
>>>返回参数: <br>
        JsonResult<br>

	2.取消留学申请 /studyabroad/applycancel?applyid= Get请求<br>
>具体参数如下:<br>
	Authorization:TJEDU eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzOTU3NzUwLCJleHAiOjE1NTM5NjM3NTAsIm5iZiI6MTU1Mzk1Nzc1MH0.1wxmqNB_i6b05TVfXM38CnxHYdaLT3Gyy2c-XIuCUPA <br>
	(用户的认证主要主要通过 Authorization:参数判定， 格式 为 TJEDU token) <br>
>>传入参数:<br>
	applyid  申请id<br>
>>>返回参数: <br>
	JsonResult <br>

	3.留学申请列表 /studyabroad/applylist Get请求<br>
	
> 具体参数如下:<br>
	Authorization:TJEDU eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzOTU3NzUwLCJleHAiOjE1NTM5NjM3NTAsIm5iZiI6MTU1Mzk1Nzc1MH0.1wxmqNB_i6b05TVfXM38CnxHYdaLT3Gyy2c-XIuCUPA <br>
	(用户的认证主要主要通过 Authorization:参数判定， 格式 为 TJEDU token) <br>
>>传入参数:<br>
	userid  学生id <br>
>>>返回参数: <br>
	StudyabroadapplicationEntity <br>
	
e.奖学金相关 <br>
1.奖学金申请 /scholarship/apply post请求<br>
>具体参数如下: <br>
>>header参数: <br>
        Content-Type:application/json, <br>
        Authorization:TJEDU eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzOTU3NzUwLCJleHAiOjE1NTM5NjM3NTAsIm5iZiI6MTU1Mzk1Nzc1MH0.1wxmqNB_i6b05TVfXM38CnxHYdaLT3Gyy2c-XIuCUPA <br>
        (用户的认证主要主要通过 Authorization:参数判定， 格式 为 TJEDU token) <br>
>>body参数: <br>
        ``
        {
	"userid": 12323,
	"recominstitutions": "推荐院校",
	"phone": "联系人电话",
	"project": "奖学金项目",
	"type": "全额奖学金",
	"level": "学生层次",
	"decprofession": "申报专业",
	"photoid": 123123,
	"passportname": "护照姓名",
	"familyname": "姓",
	"givenname": "名",
	"nationality": "国籍",
	"passportno": "护照号码",
	"birth": "出生日期11",
	"birthcountry": "出生地国家",
	"birthcity": "出生地城市",
	"sex": 0,
	"marriage": 0,
	"nativelanguage": "母语",
	"religion": "宗教",
	"presentaddress": "当前联系地址",
	"tel": "电话",
	"fax": "传真",
	"Email": "email",
	"premanentaddres": "永久通信地址",
	"educationList": [{
		"educationfrom": "教育经历开始时间",
		"educationto": "教育经历结束时间",
		"educationschool": "教育经历就读学校",
		"educationstudy": "教育经历专业或证书"
	}, {
		"educationfrom": "教育经历开始时间2",
		"educationto": "教育经历结束时间2",
		"educationschool": "教育经历就读学校2",
		"educationstudy": "教育经历专业或证书2"
	}],
	"workList": [{
		"workfrom": "工作经历1开始时间",
		"workto": "工作经历1结束时间",
		"workcompany": "工作经历1单位名称",
		"workposition": "工作经历1职务"
	}, {
		"workfrom": "工作经历2开始时间",
		"workto": "工作经历2结束时间",
		"workcompany": "工作经历2单位名称",
		"workposition": "工作经历2职务"
	}],
	"chinese": "很好，好，较好，差，不会",
	"hsk": "HSK考试等级或其他类型汉语考试成绩",
	"english": "英语（很好，好，较好，差，不会）",
	"canstudy": true,
	"otherlanguage": "其他语言",
	"studyplan": "来华学习计划（专科，本科，硕士研究生，博士研究生） 其他-",
	"subject": "申请来华学习专业或研究专题",
	"educationchina": "申请院校",
	"studystart": "申请专业学习时间起",
	"studyend": "申请专业学习时间终",
	"needstudyChinese": true,
	"needstudyChinesetime": "是否需要补习汉语的补习时间",
	"other": "其他的（否的回答）",
	"otherplan": "拟在华学习或研究的详细内容",
	"otherpublished": "曾发表的主要学术论文、著作及作品",
	"scholarship": "推荐您申请天津市政府奖学金的机构或个人",
	"contactname": "申请人在华事务联系人或机构名称",
	"contacttel": "申请人在华事务联系人或机构电话",
	"contactfax": "申请人在华事务联系人或机构传真",
	"contactaddress": "申请人在华事务联系人或机构地址",
	"studiedorwork": false,
	"institutionoremployer": "学习或任职单位",
	"starttimechina": "在华时间起  2000-02",
	"endtimechina": "在华时间止 2000-02",
	"spousename": "配偶姓名",
	"spouseage": "配偶年龄",
	"spouseemployment": "配偶职业",
	"fathername": "父亲姓名",
	"fatherage": "父亲年龄",
	"fatheremploymnet": "父亲职业",
	"mothername": "母亲姓名",
	"motherage": "母亲年龄",
	"motheremployment": "母亲职业",
	"recom1": 123123,
	"recom2": 123123,
	"notice": 123123,
	"schoolreport": 123123,
	"diploma": 123123,
	"diplomatype": "本人最后学历证书复印件类型 （本科/，硕士，博士，其它）",
	"examination": 123123,
	"planchina": 123123,
	"article": 123123
}
        `` <br>
>>>返回参数: <br>
        JsonResult<br>

	2.取消奖学金申请 /scholarship/applycancel?applyrecordid= Get请求<br>
>具体参数如下:<br>
	Authorization:TJEDU eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzOTU3NzUwLCJleHAiOjE1NTM5NjM3NTAsIm5iZiI6MTU1Mzk1Nzc1MH0.1wxmqNB_i6b05TVfXM38CnxHYdaLT3Gyy2c-XIuCUPA <br>
	(用户的认证主要主要通过 Authorization:参数判定， 格式 为 TJEDU token) <br>
>>传入参数:<br>
	applyrecordid  申请id<br>
>>>返回参数: <br>
	JsonResult <br>

	3.留学申请列表 /scholarship/applylist Get请求<br>
	
> 具体参数如下:<br>
	Authorization:TJEDU eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzOTU3NzUwLCJleHAiOjE1NTM5NjM3NTAsIm5iZiI6MTU1Mzk1Nzc1MH0.1wxmqNB_i6b05TVfXM38CnxHYdaLT3Gyy2c-XIuCUPA <br>
	(用户的认证主要主要通过 Authorization:参数判定， 格式 为 TJEDU token) <br>
>>传入参数:<br>
	userid   <br>
>>>返回参数: <br>
	ScholarshipapplicationEntity <br>

   f.管理员登录接口 /manager/login post请求<br>
>具体参数如下: <br>
指定 Content-Type 为 application/json  <br>
>>传入得数据如下: <br>
           ``	
           {
               "username":"admin", 
             	"password":"admin"
           }
             ``
>>>返回 json : 如下 <br>
   {
    "msg": "操作成功",
    "code": 1,
    "certificate": "manager",
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJlNTNhOTQ5Yi00ZTJlLTQzYmItYWRiYy02NmIwN2ExNGUwZjciLCJpbnVzZSI6MSwidXNlckZsYWciOjEsImlzcyI6Im1vYmlsZWJhY2siLCJpYXQiOjE1NTQ2ODY5OTIsImV4cCI6MTU1NDY5Mjk5MiwibmJmIjoxNTU0Njg2OTkyfQ.Z68wscQ7nmjmEY64xpZBRQM_TcvtyWjXqALTJtsGzxs"
	}<br>

g.学校审核接口<br>

	1.留学申请审核数据列表 /manager/studyabroadapplycheck Get请求
> 具体参数如下:<br>
	Authorization:TJEDU eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzOTU3NzUwLCJleHAiOjE1NTM5NjM3NTAsIm5iZiI6MTU1Mzk1Nzc1MH0.1wxmqNB_i6b05TVfXM38CnxHYdaLT3Gyy2c-XIuCUPA <br>
	(用户的认证主要主要通过 Authorization:参数判定， 格式 为 TJEDU token) <br>
>>传入参数:<br>
	userid   <br>
>>>返回参数: <br>
	StudyabroadapplicationEntity json结构 <br>

	2.奖学金申请审核数据列表 /manager/scholarshipapplycheck Get请求
> 具体参数如下:<br>
	Authorization:TJEDU eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzOTU3NzUwLCJleHAiOjE1NTM5NjM3NTAsIm5iZiI6MTU1Mzk1Nzc1MH0.1wxmqNB_i6b05TVfXM38CnxHYdaLT3Gyy2c-XIuCUPA <br>
	(用户的认证主要主要通过 Authorization:参数判定， 格式 为 TJEDU token) <br>
>>传入参数:<br>
	userid   <br>
>>>返回参数: <br>
	ScholarshipapplicationEntity json结构 <br>

	3.奖学金审核 /manager/scholarcshipcheck Post请求
>具体参数如下:<br>
>Content-Type:application/json <br>
	Authorization:TJEDU eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzOTU3NzUwLCJleHAiOjE1NTM5NjM3NTAsIm5iZiI6MTU1Mzk1Nzc1MH0.1wxmqNB_i6b05TVfXM38CnxHYdaLT3Gyy2c-XIuCUPA <br>
	(用户的认证主要主要通过 Authorization:参数判定， 格式 为 TJEDU token) <br>
>>传入参数:<br>
	userid  <br>
>>>返回参数: <br>
	JsonResult 成功/失败<br>

	4.留学审核    /manager/studyabroadcheck Post请求
>具体参数如下:<br>
>Content-Type:application/json <br>
	Authorization:TJEDU eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJiYjQ3ZTg0Ny04NWVkLTQ3NzgtYmJhNC03YjQ5Y2E5MTU0NjkiLCJpc3MiOiJtb2JpbGViYWNrIiwiaWF0IjoxNTUzOTU3NzUwLCJleHAiOjE1NTM5NjM3NTAsIm5iZiI6MTU1Mzk1Nzc1MH0.1wxmqNB_i6b05TVfXM38CnxHYdaLT3Gyy2c-XIuCUPA <br>
	(用户的认证主要主要通过 Authorization:参数判定， 格式 为 TJEDU token) <br>
>>传入参数:<br>
	userid  <br>
>>>返回参数: <br>
	JsonResult 成功/失败<br>