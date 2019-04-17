/**
* @author frank
* @version 0.0.1(2019-04-13)
*/

$(function(){
	// 初始化
	// zwgk_init();
	// 监听
	// myHandel();
	
	// 初始化
	function zwgk_init(){
		$.getJSON("/govern/list",{},function(data){
			var html = "";
			$.each(data.children,function(index,value){
				html = html+'<div class="zwgk-block">'
					   +'	<div class="zwgk-block-head">'
					   +'		<img src="./images/zwgk_list.png" width="9" style="margin-right: 6px;">'
					   +	value.com_Stye
			   if(value.children.length == 0){
				   html=html+'   <a href="" class="right-arrow"></a>'
			   }
					
				html=html+'	</div>'
			   if(value.children.length > 0){
				   html=html+'	<div class="zwgk-block-body">'
						   +'		<div class="row" style="margin-right:0;margin-left:0;">'
						   $.each(value.children,function(i,v){
							   html=html+'			<div class="zwgk-block-list">'
							   		    +'				<a href="" class="right-line" data-id="'+v.com_Id+'">'+v.com_Stye+'</a>'
							   		    +'			</div>'
						   })
						   html = html +'		</div>'
						   			   +'	</div>'
			   }
				html=html+'</div>'
			})
			$("#zwgk").html(html)
		})
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


