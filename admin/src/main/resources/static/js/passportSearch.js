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
		$("#ps_sBtn").on("click",function(ele){
			var ps_sVlvue = $("#ps_sVlvue").val();
			if(ps_sVlvue){
				$(".ps_showCtrl").show();
				// 获取查询的信息
				$.ajax({
					url: '/API/jwgjjl/passportSearch',
					type: 'GET',
					data: {
						searchName: ps_sVlvue
					},
					dataType: 'json',
					success: function(resp){
						if(resp.rows && resp.rows.length>0){
							var ps_sResult_ele = $("#ps_sResult");
							var ps_sResult_str = "";
							for(var i=0;i<resp.rows.length;i++){
								ps_sResult_str += ''
								+'<div class="ps_box">'
								+'	<div class="ps_box-item">'
								+'		<span class="ps_box-title">姓名</span>：'
								+'		<span class="ps_box-value">'+resp.rows[i].name+'</span>'
								+'	</div>'
								+'	<div class="ps_box-item">'
								+'		<span class="ps_box-title">护照号</span>：'
								+'		<span class="ps_box-value">'+resp.rows[i].passportid+'</span>'
								+'	</div>'
								+'	<div class="ps_box-item">'
								+'		<span class="ps_box-title">工作单位</span>：'
								+'		<span class="ps_box-value">'+resp.rows[i].company+'</span>'
								+'	</div>'
								+'	<div class="ps_box-item">'
								+'		<span class="ps_box-title">职务</span>：'
								+'		<span class="ps_box-value">'+resp.rows[i].position+'</span>'
								+'	</div>'
								+'	<div class="ps_box-item">'
								+'		<span class="ps_box-title">签发日期</span>：'
								+'		<span class="ps_box-value">'+resp.rows[i].begindate+'</span>'
								+'	</div>'
								+'	<div class="ps_box-item">'
								+'		<span class="ps_box-title">有效期</span>：'
								+'		<span class="ps_box-value">'+resp.rows[i].enddate+'</span>'
								+'	</div>'
								+'</div>';
							}
							ps_sResult_ele.empty();
							ps_sResult_ele.append(ps_sResult_str);
						}else{
							$("#ps_sResult").html('<div class="ps_box">没有任何结果，请输入正确的姓名"</div>');
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


