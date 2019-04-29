/**
* @author frank
* @version 0.0.0(2019-03-25)
*/

$(function(){
	$.ajaxSettings.async = true
	//为什么留学天津
	$.getJSON("/API/article/studytianjin/news","",function(data){
		var sa_list1_ele = $("#sa_list1");
		var sa_list1_str = "";
		$.each(data.rows,function(index,value){
			sa_list1_str += ''
				+'<li class="mylist-item" data-type="1" data-id="'+value.guid+'">'
				+'	<div class="mylist-title">'+value.title+'</div>'
				+'	<div class="mylist-date">'+value.createdtime+'</div>'
				+'</li>';
		})
		sa_list1_ele.empty();
		sa_list1_ele.append(sa_list1_str);
	})
	//留学生活
	$.getJSON("/API/article/overseaslife/news","",function(data){
		var sa_list1_ele = $("#sa_list2");
		var sa_list1_str = "";
		$.each(data.rows,function(index,value){
			sa_list1_str += ''
				+'<li class="mylist-item" data-type="2" data-id="'+value.guid+'">'
				+'	<div class="mylist-title">'+value.title+'</div>'
				+'	<div class="mylist-date">'+value.createdtime+'</div>'
				+'</li>';
		})
		sa_list1_ele.empty();
		sa_list1_ele.append(sa_list1_str);
	})
	
	//校友活动
	$.getJSON("/API/article/alumin/events","",function(data){
		var sa_list1_ele = $("#sa_list3");
		var sa_list1_str = "";
		$.each(data.rows,function(index,value){
			sa_list1_str += ''
				+'<li class="mylist-item" data-type="3" data-id="'+value.guid+'">'
				+'	<div class="mylist-title">'+value.title+'</div>'
				+'	<div class="mylist-date">'+value.createdtime+'</div>'
				+'</li>';
		})
		sa_list1_ele.empty();
		sa_list1_ele.append(sa_list1_str);
	})
	
	//体验天津
	$.getJSON("/API/article/exeperienceTJ/news","",function(data){
		var sa_list1_ele = $("#sa_list4");
		var sa_list1_str = "";
		$.each(data.rows,function(index,value){
			sa_list1_str += ''
				+'<li class="mylist-item" data-type="4" data-id="'+value.guid+'">'
				+'	<div class="mylist-title">'+value.title+'</div>'
				+'	<div class="mylist-date">'+value.createdtime+'</div>'
				+'</li>';
		})
		sa_list1_ele.empty();
		sa_list1_ele.append(sa_list1_str);
	})
	
	//生活助手
	$.getJSON("/API/article/lifeassistant/news","",function(data){
		var sa_list1_ele = $("#sa_list5");
		var sa_list1_str = "";
		$.each(data.rows,function(index,value){
			sa_list1_str += ''
				+'<li class="mylist-item" data-type="5" data-id="'+value.guid+'">'
				+'	<div class="mylist-title">'+value.title+'</div>'
				+'	<div class="mylist-date">'+value.createdtime+'</div>'
				+'</li>';
		})
		sa_list1_ele.empty();
		sa_list1_ele.append(sa_list1_str);
	})
	// 处理
		// 消息标题点击
		$("#studyAbroad").on("click",".tag",function(ele){
			var type = $(this).attr("data-type");
			//跳转页面
			if(type){
				window.location.href = 'sa_list.html?type='+type;;
			}else{
				console.log("html页面设置的id有问题，请联系管理员");
			}
		});
		// 消息点击
		$("#studyAbroad").on("click",".mylist-item",function(ele){
			var id = $(this).attr("data-id");
			var type = $(this).attr("data-type");
			//跳转页面
			if(id){
				window.location.href = 'sa_detail.html?id='+id+'&flag='+type;
			}else{
				console.log("没有消息的id，请联系管理员");
			}
		});
});


