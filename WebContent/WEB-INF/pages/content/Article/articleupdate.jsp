<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
    <title></title>
      <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
     <script	src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js"></script>
     <script src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.js"></script>
     <script	src="${pageContext.request.contextPath}/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
   <script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
  
</head>
<body>
<form method="post" enctype="multipart/form-data">
	

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save" ><a href="#" onclick="checkContent();this.blur();">审核</a></li>
<li id="save"><a href="#" onclick="createArticle1();this.blur();">发布</a></li>
<li id="save"><a href="#" onclick="createArticle2();this.blur();">保存</a></li>
<li id="back"><a href="tolist.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		修改文章信息
    </div> 
    </div>
    </div>
<div>
     <div id = "content1" hidden="hidden" >
${ list.content }
</div>
    <input type="hidden" value="${list.id}" name="id">
    <input type="hidden" value="${list.state}" name="state">
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">标题：</td>
	            <td class="tableContent"><input type="text" name="title"  value="${list.title}" dataType="整数" dispName="排序号"/></td>
	           
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">分类：</td>
	            <td class="tableContent"> <select name="cid" >
			   					 <c:forEach items="${type}" var="type">
			   					 <c:choose>
			   					 	<c:when test="${list.cid==type.id}">
			   							<option value="${type.id}" selected="selected">${type.name }</option>
			   					 	</c:when>
			   					 	<c:otherwise>
			   					 		<option value="${type.id}">${type.name }</option>
			   					 	</c:otherwise>
			   					 </c:choose>
			   					</c:forEach>	
                            </select></td>
	           
	        </tr>
	     
	      <tr>
	            <td class="columnTitle_mustbe">创建时间：</td>
	            <td class="tableContent"><input type="text" name="creattime"  value="<fmt:formatDate value='${list.creattime}' pattern='yyyy-MM-dd HH:mm:ss'/>" readonly="readonly" /></td>
	            
	        </tr>
	        <%-- <tr>
	            <td class="columnTitle_mustbe">修改时间：</td>
	            <td class="tableContent"><input type="text" name="sendtime" value="<fmt:formatDate value='${list.sendtime}' pattern='yyyy-MM-dd HH:mm:ss'/>"  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});" /></td>
	            
	        </tr> --%>
	    
	           
	       
	        <tr>
	        <td>图片上传：</td>
	          <td class="tableContent">
	         <input type="file" name="pictureFile" value="${list.fmimg}" onchange="previewFile()">
	         </td>
	         
	         </tr>
	          <tr>
	         <td class="columnTitle_mustbe">图片显示：</td>
	         <td class="tableContent">
	         <img alt="" src="${pageContext.request.contextPath }/image/${list.fmimg}" style="width:150px;height:150px;">
	         </td>
	        </tr>
	        <tr>
	            <td class="columnTitle">内容：</td>
	           <td class="tableContent"> 
	            
           </td>
	        </tr>

		</table>
	</div>
</div>
    <div >
                <textarea id="container" name="content"  type="text/plain" style="width:100%;height:500px;"></textarea>
           </div>
           <div id = "content1"  hidden="hidden">
			${list.content}
			</div>
          
             <script type="text/javascript">
             var ue = UE.getEditor('container');
		     $(document).ready(function(){  
		        var content =$('#content1').html();		 
		         var ue = UE.getEditor('container'); 
		         ue.ready(function() {//编辑器初始化完成再赋值  
			     ue.setContent(content);  //赋值给UEditor  
		         });  
		
		     });
		
      </script> 
       <script type="text/javascript">
   /**
    * 显示选择上传的图片略缩图
    * 当选择了图片文件时触发这个方法
    */
  
   function previewFile() {
       // 通过标签选择器获取HTML元素
       var preview = document.querySelector('img');
       var file = document.querySelector('input[type=file]').files[0];
       // Js内置文件流
       var reader = new FileReader();

       // 更新img标签的src属性为图片的本地路径，就可以显示了
       reader.onloadend = function () {
           preview.src = reader.result;
       }

       // 图片文件不空就显示
       if (file) {
    	
           reader.readAsDataURL(file);
          
       } else {
           // 图片文件是空的
          
           preview.src = "";
       }
   }
   </script>
</form>
 
</body>
<%@include file="../script.jsp"%>
<script>
	var checkedPass=false;
	function checkContent() {
		/* $("#title").val() */
	
		var config={
			url:"${ctx}/wordFilter/checked.action",
			data:{content:ue.getContent()},
			type:'post',
			dataType:'json',
			success:function (result) {
				console.log(result)
				if (result.code==100){
					alert("文字内容审核通过！");
					checkedPass=true;
				}else if (result.code==500){
					alert(result.msg);
				}else {
					var msg="您的文章内容有以下关键词未能通过审核：\n";
					for (var key in result.notPassMap){
						msg+=key+" 原因："+result.notPassMap[key];
					}
					alert(msg);
				}
			}
		};
		$.ajax(config)
	}

	function getLabel(index){
		if(index==1){
			return "暴力反恐";
		}if(index==1){
			return "文本色情";
		}if(index==1){
			return "政治敏感";
		}if(index==1){
			return "恶意推广";
		}if(index==1){
			return "低俗辱骂";
		}if(index==1){
			return "低质灌水";
		}

	}
	function doChecked() {
		var config={
			url:"${ctx}/wordFilter/getToken.action",
			data:{content:$("#content").val()},
			type:'post',
			dataType:'json',
			success:function (result) {
				var checkConfig={
					url:'https://aip.baidubce.com/rest/2.0/antispam/v2/spam?access_token='+result,
					data:{content:$("#content").val()},
					dataType:'json',
					type:'post',
					success:function (result) {

					}
				};
				$.ajax(checkConfig)
			}
		};
	}

	function createArticle1() {
		if (checkedPass){
			formSubmit("update.action","_self")
		}else {
			alert("请先通过审核！");
		}
	}
	function createArticle2() {
			if (checkedPass){
				formSubmit("update2.action","_self")
			}else {
				alert("请先通过审核！");
			}	
	}
</script>
</html>

