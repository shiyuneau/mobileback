/**
* @author frank
* @version 0.0.1(2019-05-06)
*/

$(function(){
	// 初始化
	// zwgk_init();
	// 监听
	myHandel();
	
	// 初始化
	function zwgk_init(){
		
	}
	// 处理
	function myHandel(){
		// 查询点击
		var token=GetQueryString("token")
		// 获取查询的信息
		$.ajax({
			url: '/API/schoolmanage/schinfo/collegeinfo',
			type: 'GET',
			data: {
			},
			dataType: 'json',
			success: function(resp){
				if(resp.entity && resp.entity.length>0){
					var ps_sResult_ele = $("#ps_sResult");
					var ps_sResult_str = "";
					for(var i=0;i<resp.entity.length;i++){
						ps_sResult_str += ''
						+'<div class="ps_box">'
						+'	<div class="ps_box-item">'
						+'		<span class="ps_box-title">学院名称：</span>：'
						+'		<span class="ps_box-value">'+resp.entity[i].name+'</span>'
						+'	</div>'
						+'	<div class="ps_box-item">'
						+'		<span class="ps_box-title">简介</span>：'
						+'		<span class="ps_box-value">'+resp.entity[i].introduction+'</span>'
						+'	</div>'
						+'</div>';
					}
					ps_sResult_ele.empty();
					ps_sResult_ele.html(ps_sResult_str);
				}else{
					$("#ps_sResult").html('<div class="ps_box">没有任何结果"</div>');
				}
			},
		    beforeSend: function(xhr) {
		        xhr.setRequestHeader("Authorization", "TJEDU "+token);
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


