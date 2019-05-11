/**
 * 新闻中心
* @author frank
* @version 0.0.0(2019-03-25)
*/

$(function(){
	pageNum = 1
	// 初始化
	sa_list_init();
	// 监听
	myHandel();
	
	// 初始化
	function sa_list_init(){
			//新闻列表
			$.getJSON("/API/tjschools/accesslinks",{'type':3},function(data){
				var sa_list1_ele = $("#zwgk");
				var sa_list1_str = "";
					$.each(data,function(index,value){
						sa_list1_str += ''
							+'<div class="zwgk-block">'
							+'	<div class="zwgk-block-head">'
							+		data.l_Title
							+'		<a href="'+l_Link+'" class="right-arrow"></a>'
							+'	</div>'
							+'</div>'
					})
					sa_list1_ele.empty();
					sa_list1_ele.append(sa_list1_str);
			})
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


