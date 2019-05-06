/**
* @author frank
* @version 0.0.1(2019-04-13)
*/

$(function(){
	// 初始化
	zwgk_init();
	// 监听
	// myHandel();
	
	// 初始化
	function zwgk_init(){
		var token=GetQueryString("token")
		var html = ''
		$.ajax({
		    type: "GET",
		    url: "/API/jwgjjl/planApplyList",
		    success: function(data) {
		    	$.each(data.rows,function(index,value){
					html = html+'<div class="zwgk-block">'
						   +'	<div class="zwgk-block-head">'
						   +'		<div>学校：'+value.company+'</div>'
						   +'		<div>学院：'+value.company+'</div>'
						   +'		<div>专业：'+value.company+'</div>'
						   +'		<div>学生：'+value.company+'</div>'
						   +'		<div>状态：'+value.company+'</div>'
						   +'	</div>'
		    },
		    beforeSend: function(xhr) {
		        xhr.setRequestHeader("Authorization", "TJEDU "+token);
		    }
		    $("#zwgk").html(html)
		});
			
	}
	// 处理
	function myHandel(){
	}
	
	// 获取地址栏参数
	function GetQueryString(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r!=null)return  unescape(r[2]);
		return null;
	}
	
});


