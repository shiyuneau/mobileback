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
			$.getJSON("/API/news/listPage",{'pageNum':pageNum,'pageSize':10},function(data){
				var sa_list1_ele = $("#sa_list");
				var sa_list1_str = "";
				if(data.code == 0){
					$.each(data.rows,function(index,value){
						sa_list1_str += ''
							+'<div class="row news-list" data-id="'+value.n_Id+'">'
							+'	<div class="col-md-8 col-sm-8 col-xs-8" >'
							+'		<div class="news-list-title">'+value.n_Title+'</div>'
							+'	</div>'
							+'	<div class="col-md-4 col-sm-4 col-xs-4" style="padding:0px;">'
							+'		<div class="news-list-date">'+value.n_Date+'</div>'
							+'	</div>'
							+'</div>';
					})
					sa_list1_ele.empty();
					sa_list1_ele.append(sa_list1_str);
				}
			})
		}
	
		// 处理
		function myHandel(){
			// 消息点击
			$("#sa_list").on("click",".news-list",function(ele){
				var id = $(this).attr("data-id");
				//跳转页面
				if(id){
					window.location.href = 'newsdetail.html?id='+id;
				}else{
					console.log("没有消息的id，请联系管理员");
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


