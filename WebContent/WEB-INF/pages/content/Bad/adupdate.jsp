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
<style type="text/css" media="screen">
    .upload-pic{ width: 120px;  height: 30px;  line-height: 30px; border-radius: 4px; color: #fff; position: relative; cursor: pointer;
        font-size: 14px;  background-color: #44b549;  text-align: center;  display: inline-block;
        vertical-align: middle; margin-left: 8px;  margin-top: 8px;  }
    .upload-pic .up-lab,.upload-pic .up-file{ width: 100%; height: 100%; position: absolute; left: 0; top: 0; z-index: 2; overflow: hidden;}
    .upload-pic .up-lab{ background-color: #44b549; cursor: pointer; }
    .upload-pic .up-file{ z-index: 1;}
    .group-coms-pic{ padding-top: 30px; overflow: hidden; }
    .group-coms-pic .item{  width: 116px; height: 148px; border:1px solid #f0f0f0; position: relative; float: left;margin-right: 20px; margin-bottom: 20px; }
    .group-coms-pic .pic-box{ width:118px; height:117px; border-bottom:1px solid #f0f0f0;  overflow: hidden;  position: relative;}
    .group-coms-pic .pic-box .img{ height:117px; position: absolute; left: 50%; top: 50%;
        transform:translate(-50%,-50%);}
    .group-coms-pic .tk{ padding:0 9px; height: 32px; line-height: 32px; text-align: left;
        overflow: hidden;  white-space: nowrap;  text-overflow: ellipsis; color: #353535;  font-size: 14px;}
    .group-coms-pic .item .del{ width:20px; height: 20px; line-height: 20px; text-align: center; border-radius: 50%; color: #fff;
        background-color: #ff6982; cursor: pointer; font-style: normal; position: absolute; right: -10px; top: -10px; }
</style>
</head>
<body>
<form method="post" enctype="multipart/form-data">
	

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('update.action','_self');this.blur();">发布</a></li>
<li id="save"><a href="#" onclick="formSubmit('update2.action','_self');this.blur();">保存</a></li>
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
    <input type="hidden" value="${list.type}" name="state">
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">广告名称</td>
	            <td class="tableContent"><input type="text" name="title" value="${list.title }" style="width:100%;height:27px;"/></td>
	            
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">广告位置：</td>
	            <td class="tableContent"> 
	            <select name="adpositionid" >
			   					 <c:forEach items="${type}" var="type">
			   					 <c:choose>
			   					 	<c:when test="${list.adpositionid==type.id}">
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
	            <td class="columnTitle_mustbe">开始日期：</td>
	            <td class="tableContent"><input type="text" name="begindate" value="<fmt:formatDate value='${list.begindate}' pattern='yyyy-MM-dd HH:mm:ss'/>"  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});" style="width:100%;height:27px;"/></td>
	            
	        </tr> 
	           <tr>
	            <td class="columnTitle_mustbe">结束日期：</td>
	            <td class="tableContent"><input type="text" name="enddate" value="<fmt:formatDate value='${list.enddate}' pattern='yyyy-MM-dd HH:mm:ss'/>"  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});" style="width:100%;height:27px;"/></td>
	            
	        </tr> 
	          <tr>
	            <td class="columnTitle_mustbe">广告图片：</td>
	            <td class="tableContent">
	           
	             <div class="upload-pic">
               <label class="up-lab" for="add-pic-btn">上传图片</label>
               <input type="file" accept="image/*" name="pictureFile" value="${list.path}" multiple class="up-file" id="add-pic-btn">
                </div>
	            </td>
	        </tr>
	         <tr>
	         <td class="columnTitle_mustbe">图片显示：</td>
	         <td><div class="group-coms-pic" id="groupTu">
	       
	         </div></td>
	        </tr>
	         <tr>
	            <td class="columnTitle_mustbe">广告链接：</td>
	            <td class="tableContent"><input type="text" name="url" value="${list.url }" style="width:100%;height:27px;"/></td>
	            
	        </tr> 
	            <tr>
	            <td class="columnTitle_mustbe">是否开启：</td>
	           
	            
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
		     $(document).ready(function(){  
		        var content =$('#content1').html();		 
		         var ue = UE.getEditor('container'); 
		         ue.ready(function() {//编辑器初始化完成再赋值  
			     ue.setContent(content);  //赋值给UEditor  
		         });  
		     });
		
      </script> 
      <script>
    //上传多个文件方法
    //input file已增加multiple属性，按住ctrl可选择多图
    document.getElementById("add-pic-btn").addEventListener("change",function(){
        var obj = this,
            length = obj.files.length,
            arrTitle = []; //存标题名
            _html = '';

        for(var i=0; i<length; i++) {
            var reader = new FileReader();
            if (!reader) {
               console.log('对不起，您的浏览器不支持！请更换浏览器试一下');
                return
            }
            //存储上传的多张图片名字
            arrTitle.push(obj.files[i].name)

            reader.error=function(e){
                console.log("读取异常")
            }

            //iffi语法
            ;(function(i){
                  //读取成功
                reader.onload = function(e){
                    //console.log(e)
                    var _src = e.target.result;

                    //节点
                    var divItem = document.createElement('div');
                    divItem.setAttribute('class','item');
                    var divPic = document.createElement('div');
                    divPic.setAttribute('class','pic-box');
                    var img = document.createElement('img');
                    img.setAttribute('class','img');
                    img.setAttribute('src',_src);
                    var divTk = document.createElement('div');
                    divTk.setAttribute('class','tk')
                    var spanDel = document.createElement('span');
                    spanDel.setAttribute('class','del');
                    spanDel.setAttribute('title',arrTitle[i]);
                    spanDel.innerText = 'x';

                    divTk.innerHTML = arrTitle[i];

                    divItem.appendChild(divPic);
                    divPic.appendChild(img);
                    divItem.appendChild(divTk);
                    divItem.appendChild(spanDel);

                    //增加节点结构
                    var groupTu =  document.getElementById('groupTu');
                    groupTu.insertBefore(divItem, groupTu.firstChild);

                    //增加删除节点
                    spanDel.onclick = function(){
                        removeItem(this);
                        return false;
                    };

                };
            })(i)

            reader.onloadstart=function(){

            }
            reader.onprogress=function(e){
                if(e.lengthComputable){
                   console.log("正在读取文件")
                }
            };
            reader.readAsDataURL(obj.files[i]);
        }

    })

    //删除图片
    function removeItem(delNode){
        var itemNode = delNode.parentNode,
            title = delNode.getAttribute('title');
        var flag = confirm("确认要删除名为："+title+"的图片？");
        if(flag) {
            itemNode.parentNode.removeChild(itemNode);
            console.log('删除成功~')
        }
        return false;
    }

</script>
</form>
 
</body>
</html>

