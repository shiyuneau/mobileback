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
						   +'		<div>工作单位：'+value.company+'</div>'
						   +'		<div>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：'+value.name+'</div>'
						   +'		<div>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：'+value.position+'</div>'
						   +'		<div>民&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;族：'+value.nation+'</div>'
						   +'		<div>手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机：'+value.mobile+'</div>'
						   +'		<div>具体联系人：'+value.lianxiren+'</div>'
						   +'		<div>电话/座机：'+value.lianxirenmobile+'</div>'
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


