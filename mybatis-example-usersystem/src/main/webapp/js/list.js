$('#userList').datagrid({  
	url:"user/list",
	pagination:true,
	fitColumns:true,
	pageList:[5,10,15,20,25,30],
    columns:[[    
        {field:'id',title:'编号',width:100},    
        {field:'name',title:'姓名',width:100},    
        {field:'birthday',title:'生日',width:100,align:'center'}, 
        {field:'gender',title:'性别',width:100,align:'center'} , 
        {field:'career',title:'职称',width:100,align:'center'},  
        {field:'address',title:'地址',width:100,align:'center'},
        {field:'mobile',title:'电话',width:100,align:'center'},
        {field:'picPath',title:'图像',width:100,align:'center',
        	formatter: function(value,row,index){
        		console.info("values===>"+value);
        		if(value ==null){
        			
        			return "<img width='100' src='image/not_pic.jpg'/>"
        		}else{
        			return "<img width='100' src='"+value+"'/>"
        		}
        	}
        	
        	},
        {field:'operator',title:'操作',width:100,align:'center',
        	formatter: function(value,row,index){
        	
				var oprStr ='<a class="detailBtn" href="javascript:void(0)" onClick="openDetail('+index+')">详情</a>&nbsp;&nbsp;'+
				'<a class="modifyBtn" href="javascript:void(0)" onClick="openUpdate('+index+')">修改</a> '+
				'<script>$(".modifyBtn").linkbutton({iconCls: "icon-edit" });'+
				'$(".detailBtn").linkbutton({iconCls: "icon-search" });</script>'
					return oprStr;
        	}
        }
    ]],
}); 

$("#modifyDiv").dialog({
	title:"用户修改",
		closeable:false
});
$("#modifyDiv").dialog("close");

$("#modifyForm").form({
	url:"user/modify",           
    success:function(data){
    	if(data.trim()=="true"){
    		$("#modifyDiv").dialog("close");//关闭修改框
    		$('#userList').datagrid("reload");//刷新修改数据
    	}else{
    		$.messager.show({
    			title:'修改信息',
    			msg:'信息修改失败。',
    			showType:'show',
    			style:{   				
    				top:document.body.scrollTop+document.documentElement.scrollTop,
    			}
    		});

    	}
    	
    }
});

$(".closeBtn").linkbutton({
	iconCls:"icon-cancel",
	onClick:function(){
	$("#modifyDiv").dialog("close");
	}
});

$(".updateBtn").linkbutton({
	iconCls:"icon-ok",
	onClick:function(){
		$("#modifyForm").submit();
		}
});

function openUpdate(index){
	
	$("#modifyDiv").dialog("open");
	var row = $("#userList").datagrid("getRows")[index];
	$("#uid").val(row.id);
	$("#uname").val(row.name);
	$("#ubirthday").val(row.birthday);
	$("#ugender").val(row.gender);
	$("#ucareer").val(row.career);
	$("#uaddress").val(row.address);
	$("#umobile").val(row.mobile);
	if(row.picPath){
		$("#pic").attr("src",row.picPath);
	}else{
		$("#dpic").attr("src","image/not_pic.jpg");
	}
}

function chgPic(obj){
	$("#pic").attr("src",window.URL.createObjectURL(obj.files[0]));
}

$("#detailDiv").dialog({
	title:"用户详情",
	closeable:false
});
$("#detailDiv").dialog("close");

$(".dcloseBtn").linkbutton({
	iconCls:"icon-cancel",
	onClick:function(){
	$("#detailDiv").dialog("close");
	}
});

function openDetail(index){
	
	$("#detailDiv").dialog("open");
	var row = $("#userList").datagrid("getRows")[index];
	$("#duid").val(row.id);
	$("#duname").val(row.name);
	$("#dubirthday").val(row.birthday);
	$("#dugender").val(row.gender);
	$("#ducareer").val(row.career);
	$("#duaddress").val(row.address);
	$("#dumobile").val(row.mobile);
	if(row.picPath){
		$("#dpic").attr("src",row.picPath);
	}else{
		$("#dpic").attr("src","image/not_pic.jpg");
	}
}
