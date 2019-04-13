/**
* @author frank
* @version 0.0.0(2019-03-25)
*/

$(function(){
	// 初始化
	sa_detail_init();
	
	// 初始化
	function sa_detail_init(){
		var id = GetQueryString("id");
		var type= GetQueryString("flag");
		var url = "";
		var sa_typee = "为什么留学天津";
		var sa_bg = "bg-blue";
		if(type==1 || type=="1"){
			//为什么留学天津
			url = "/API/article/studytianjin/details";
			sa_typee = "为什么留学天津";
			sa_bg = "bg-blue";
		}else if(type==2 || type=="2"){
			//留学生活
			url = "/API/article/overseaslife/details";
			sa_bg = "bg-orange";
			sa_typee = "留学生活";
		}else if(type==3 || type=="3"){
			//校友活动
			sa_typee = "校友活动";
			url = "/API/article/alumin/details";
			sa_bg = "bg-green";
		}else if(type==4 || type=="4"){
			//体验天津
			url = "/API/article/exeperienceTJ/details";
			sa_bg = "bg-yellow";
			sa_typee = "体验天津";
		}else if(type==5 || type=="5"){
			//体验天津
			url = "/API/article/lifeassistant/details";
			sa_bg = "bg-yellow";
			sa_typee = "生活助手";
		}else{
			alert(false)
			return;
		}
		$("#sa_typee").html(sa_typee);
		$("#sa_typee").addClass(sa_bg);
		$("#sa_line").addClass(sa_bg);
		// 获取消息详情
		$.ajax({
			url: url,
			type: 'GET',
			data: {
				id: id
			},
			dataType: 'json',
			success: function(resp){
				$("#sa_detail_title").empty().html(resp.title);
				$("#sa_detail_content").empty().html(resp.content);
			},
			error: function(err){
				console.log(err);
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


