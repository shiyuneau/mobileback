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
		    url: "/API/jwgjjl/applyListByPage",
		    success: function(data) {
		    	$.each(data.rows,function(index,value){
					html = html+'<div class="zwgk-block">'
						   +'	<div class="zwgk-block-head">'
						   +'		<div>学校：'+value.collegeName+'</div>'
						   +'		<div>学院：'+value.xyName+'</div>'
						   +'		<div>专业：'+value.professionName+'</div>'
						   +'		<div>学生：'+value.studentName+'</div>'
						   +'	</div>'
		    	}
			    $("#zwgk").html(html)
		    },
		    beforeSend: function(xhr) {
		        xhr.setRequestHeader("Authorization", "TJEDU "+token);
		    }
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


