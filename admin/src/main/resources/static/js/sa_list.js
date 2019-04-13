/**
* @author frank
* @version 0.0.0(2019-03-25)
*/

$(function(){
	// 初始化
	sa_list_init();
	// 监听
	myHandel();
	
	// 初始化
	function sa_list_init(){
		var id = GetQueryString("type");
		if(id==2 || id=="2"){
			//留学生活
			$.getJSON("/API/article/overseaslife/news","",function(data){
				var sa_list1_ele = $("#sa_list");
				var sa_list1_str = "";
				$.each(data,function(index,value){
					sa_list1_str += ''
						+'<div class="row news-list" data-type="2" data-id="'+value.guid+'">'
						+'	<div class="col-md-8 col-sm-8 col-xs-8">'
						+'		<div class="news-list-title">'+value.title+'</div>'
						+'	</div>'
						+'	<div class="col-md-4 col-sm-4 col-xs-4">'
						+'		<div class="news-list-date">'+value.createdtime+'</div>'
						+'	</div>'
						+'</div>';
				})
				sa_list1_ele.empty();
				sa_list1_ele.append(sa_list1_str);
			})
		}else if(id==3 || id=="3"){
			//校友活动
			$.getJSON("/API/article/alumin/events","",function(data){
				var sa_list1_ele = $("#sa_list");
				var sa_list1_str = "";
				$.each(data,function(index,value){
					sa_list1_str += ''
						+'<div class="row news-list" data-type="3" data-id="'+value.guid+'">'
						+'	<div class="col-md-8 col-sm-8 col-xs-8">'
						+'		<div class="news-list-title">'+value.title+'</div>'
						+'	</div>'
						+'	<div class="col-md-4 col-sm-4 col-xs-4">'
						+'		<div class="news-list-date">'+value.createdtime+'</div>'
						+'	</div>'
						+'</div>';
				})
				sa_list1_ele.empty();
				sa_list1_ele.append(sa_list1_str);
			})
		}else if(id==4 || id=="4"){
			//体验天津
			$.getJSON("/API/article/exeperienceTJ/news","",function(data){
				var sa_list1_ele = $("#sa_list");
				var sa_list1_str = "";
				$.each(data,function(index,value){
					sa_list1_str += ''
						+'<div class="row news-list" data-type="4" data-id="'+value.guid+'">'
						+'	<div class="col-md-8 col-sm-8 col-xs-8">'
						+'		<div class="news-list-title">'+value.title+'</div>'
						+'	</div>'
						+'	<div class="col-md-4 col-sm-4 col-xs-4">'
						+'		<div class="news-list-date">'+value.createdtime+'</div>'
						+'	</div>'
						+'</div>';
				})
				sa_list1_ele.empty();
				sa_list1_ele.append(sa_list1_str);
			})
		}else if(id==5 || id=="5"){
			//体验天津
			$.getJSON("/API/article/lifeassistant/news","",function(data){
				var sa_list1_ele = $("#sa_list");
				var sa_list1_str = "";
				$.each(data,function(index,value){
					sa_list1_str += ''
						+'<div class="row news-list" data-type="5" data-id="'+value.guid+'">'
						+'	<div class="col-md-8 col-sm-8 col-xs-8">'
						+'		<div class="news-list-title">'+value.title+'</div>'
						+'	</div>'
						+'	<div class="col-md-4 col-sm-4 col-xs-4">'
						+'		<div class="news-list-date">'+value.createdtime+'</div>'
						+'	</div>'
						+'</div>';
				})
				sa_list1_ele.empty();
				sa_list1_ele.append(sa_list1_str);
			})
		}else{
			//为什么留学天津
			$.getJSON("/API/article/studytianjin/news","",function(data){
				var sa_list1_ele = $("#sa_list");
				var sa_list1_str = "";
				$.each(data,function(index,value){
					sa_list1_str += ''
						+'<div class="row news-list" data-type="1" data-id="'+value.guid+'">'
						+'	<div class="col-md-8 col-sm-8 col-xs-8">'
						+'		<div class="news-list-title">'+value.title+'</div>'
						+'	</div>'
						+'	<div class="col-md-4 col-sm-4 col-xs-4">'
						+'		<div class="news-list-date">'+value.createdtime+'</div>'
						+'	</div>'
						+'</div>';
				})
				sa_list1_ele.empty();
				sa_list1_ele.append(sa_list1_str);
			})
		}
		}
	
		// 处理
		function myHandel(){
			// 消息点击
			$("#sa_list").on("click",".news-list",function(ele){
				var id = $(this).attr("data-id");
				var type = $(this).attr("data-type");
				//跳转页面
				if(id){
					window.location.href = 'sa_detail.html?id='+id+'&flag='+type;
				}else{
					console.log("没有消息的id，请联系管理员");
				}
			});
			
		}
	
	// 获取地址栏参数
	function GetQueryString(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r!=null)return  unescape(r[2]);
		return null;
	}
	
});


