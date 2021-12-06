/**
 * 
 */
	// jQuery를 이용하여 가져오기
	$(document).ready(function(){
		
		$('#validate').click(function(){
			alert('jquery event');
			var flag = false;
			var id = $('#user_id').val();
			var pwd = $('#user_pwd').val();
			alert(id+":"+pwd);
			//Ajax연결해서 
			$.ajax({
				data :  {user_id : id, user_pwd : pwd },//JSON방식
				type : "post",
				dataType: "text",
				async: false,
				url : '/member/login_check',
				success : function(data, textStatus){
					//성공여부를 출력합니다.
					//alert(data);
					alert(data+"님 반갑습니다.\n"+textStatus);
					//flag = true;
				},
				error : function(data, textStatus){
					$('#message').text('error');
				},
				complete : function(data,textStatus){
					//alert(flag);
					alert('complete '+flag);
				}
			});
			
			return flag;
		})
		$('#member_add').click(function(){
			//alert("Add Connect");
			var flag = false;
			var id = $('#id').val();
			var pwd = $('#pwd').val();
			var name = $('#name').val();
			var sub_name = $('#sub_name').val();
			var birth = $('#birth').val();
			var num = $('#num').val();
			var email = $('#email').val();
			var si = $('#si').val();
			var doe = $('#doe').val();
			var gu = $('#gu').val();
			var detail_address = $('#detail_address').val();
			
			//alert(id);
			$.ajax({
				data :  {"id" : id, "pwd" : pwd, "name" : name,"sub_name" : sub_name,"birth" : birth,"num" : num, "email" : email, "addr" : addr},//JSON방식
				type : "post",
				dataType: "text",
				async: false,
				url : '/team/addMember.do',
				success : function(data, textStatus){
					//성공여부를 출력합니다.
					//alert(data);
					alert(id+"님 회원가입이 완료되었습니다.\n"+textStatus);
					flag = true;
				},
				error : function(data, textStatus){
					$('#message').text('error');
				},
				complete : function(data,textStatus){
					
					//alert('complete '+flag);
				}
			});
			
			return flag;
			})
		$('#id_check').click(function(){
			//alert("Check id");
			var flag = false;
			var id = $('#id').val();
			//alert(id);
			$.ajax({
				data :  {"id" : id},//JSON방식
				type : "post",
				dataType: "text",
				async: false,
				url : '/team/idCheck.do',
				success : function(data, textStatus){
					//성공여부를 출력합니다.
					//alert(data);
					if(eval(data) ==true){
						alert(id+"는 이미 사용중입니다.\n"+textStatus);
						flag = true;
					} else{
						alert(id+"는 사용할 수 있습니다.");
					}
				},
				error : function(data, textStatus){
					$('#message').text('error');					
				},
				complete : function(data,textStatus){
					
					//alert('complete '+flag);
				}
			});
			
			return flag;
		
		})
		$('#email_check').click(function(){
			//alert("Check email");
			var flag = false;
			var email = $('#email').val();
			//alert(email);
			$.ajax({
				data :  {"email" : email},//JSON방식
				type : "post",
				dataType: "text",
				async: false,
				url : '/team/emailCheck.do',
				success : function(data, textStatus){
					//성공여부를 출력합니다.
					//alert(data);
					if(eval(data) ==true){
						alert(email+"는 이미 사용중입니다.\n"+textStatus);
						flag = true;
					} else{
						alert(email+"는 사용할 수 있습니다.");
					}
				},
				error : function(data, textStatus){
					$('#message').text('error');					
				},
				complete : function(data,textStatus){
					
					//alert('complete '+flag);
				}
			});
			
			return flag;
		
		})
		$('#subName_check').click(function(){
			//alert("Check subName");
			var flag = false;
			var sub_name = $('#sub_name').val();
			//alert(sub_name);
			$.ajax({
				data :  {"sub_name" : sub_name},//JSON방식
				type : "post",
				dataType: "text",
				async: false,
				url : '/team/subNameCheck.do',
				success : function(data, textStatus){
					//성공여부를 출력합니다.
					//alert(data);
					if(eval(data) ==true){
						alert(sub_name+"는 이미 사용중입니다.\n"+textStatus);
						flag = true;
					} else{
						alert(sub_name+"는 사용할 수 있습니다.");
					}
				},
				error : function(data, textStatus){
					$('#message').text('error');					
				},
				complete : function(data,textStatus){
					
					//alert('complete '+flag);
				}
			});
			
			return flag;
		
		})
		
		
	});
	