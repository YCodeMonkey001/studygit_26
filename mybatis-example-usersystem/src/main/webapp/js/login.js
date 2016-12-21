$('#btnLogin').linkbutton({    
    iconCls:'icon-man',
    onClick:function(){
    $("#loginForm").submit();
    }
}); 



$('#LoginDiv').dialog({    
    title: '',    
    width: 200,    
    border:false,
    modal:true,
    top:80
      
});  
   
$("#loginForm").form({
	url:"user/login",           
    success:function(data){   
    	if(data.trim() == "true"){
    		
        	location.replace("page/list.jsp");
        }else{
        	$.messager.show({
        		title:'登录信息',
        		msg:'登录失败，编号与姓名不匹配！！！',
        		showType:'show',
        		style:{       			
        			top:document.body.scrollTop+document.documentElement.scrollTop,
        		}
        	});
        }
    }       
});