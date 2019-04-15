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
		var url = "";
			url = "/API/govern/details?newsId="+id;
			
		// 获取消息详情
		$.ajax({
			url: url,
			type: 'GET',
			data: {
				
			},
			dataType: 'json',
			success: function(resp){
				$("#sa_detail_title").empty().html(resp.n_Title);
				$("#sa_detail_content").empty().html(resp.n_Content);
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


