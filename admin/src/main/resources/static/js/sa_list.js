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
		var id = GetQueryString("id");
		if(id==1 || id=="1"){
			//为什么留学天津
		}else if(id==2 || id=="2"){
			//留学生活
		}else if(id==3 || id=="3"){
			//校友活动
		}else if(id==4 || id=="4"){
			//体验天津
		}
		// 获取消息列表
		$.ajax({
			url: 'json/sa_list.json',
			type: 'GET',
			data: {
				id: id
			},
			dataType: 'json',
			success: function(resp){
				if(resp.data && resp.data.length>0){
					var sa_list_ele = $("#sa_list");
					var sa_list_str = "";
					for(var i=0;i<resp.data.length;i++){
						sa_list_str += ''
						+'<div class="row news-list" data-id="'+resp.data[i].id+'">'
						+'	<div class="col-md-8 col-sm-8 col-xs-8">'
						+'		<div class="news-list-title">'+resp.data[i].title+'</div>'
						+'	</div>'
						+'	<div class="col-md-4 col-sm-4 col-xs-4">'
						+'		<div class="news-list-date">'+resp.data[i].date+'</div>'
						+'	</div>'
						+'</div>';
					}
					sa_list_ele.empty();
					sa_list_ele.append(sa_list_str);
				}
				
			},
			error: function(err){
				console.log(err);
			}
		});
	}
	// 处理
	function myHandel(){
		// 消息点击
		$("#sa_list").on("click",".news-list",function(ele){
			var id = $(this).attr("data-id");
			//跳转页面
			window.location.href = 'sa_detail.html?id='+id;
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


