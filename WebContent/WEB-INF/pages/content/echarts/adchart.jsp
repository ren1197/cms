<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 导入echart图表的核心依赖库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/echarts/echarts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>

<title>饼状图表</title>
</head>
<body>
 
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 600px;height:400px;"></div>
	
</body>
<script type="text/javascript">
$(function(){
    var myChart = echarts.init(document.getElementById('main'));
    /*   data1 表示每个饼状图的名字，每个培训类型
         data2 表示每个饼状图，即每个培训类型的统计结果
     */
    var data1=[];
    var data2=[];
    var array=[];



    option = {
    	    tooltip: {
    	        trigger: 'item',
    	        formatter: "{a} <br/>{b}: {c} ({d}%)"
    	    },
    	    legend: {
    	        orient: 'vertical',
    	        x: 'left',
    	        data:[]
    	    },
    	    
    	    series: [
    	        {
    	            name:'访问来源',
    	            type:'pie',
    	            radius: ['50%', '70%'],
    	            avoidLabelOverlap: false,
    	            label: {
    	                normal: {
    	                    show: false,
    	                    position: 'center'
    	                },
    	                emphasis: {
    	                    show: true,
    	                    textStyle: {
    	                        fontSize: '30',
    	                        fontWeight: 'bold'
    	                    }
    	                }
    	            },
    	            labelLine: {
    	                normal: {
    	                    show: false
    	                }
    	            },
    	            data:[
    	            ]
    	        }
    	    ]
    	};
    $.ajax({
        type:"post",
        url:"${pageContext.request.contextPath}/chart/getadposition.action",
        data:{},
        cache:false,
        async: false,
        dataType:"json",
        success : function (result) {

            for(var i in result){

                data1.push(result[i].name);
                
                var map={};
                map.name=result[i].name;
                map.value=result[i].num;
                array[i]=map;

            }
            myChart.setOption({ //加载数据图表

                title : {
                    text: '广告位数据统计',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient : 'vertical',
                    x : 'left',
                    data:data1
                },
                
                series : [
                    {
                    	 name:'统计结果',
                         type:'pie',
                         radius: ['50%', '70%'],
                         avoidLabelOverlap: false,
                         label: {
                             normal: {
                                 show: false,
                                 position: 'center'
                             },
                             emphasis: {
                                 show: true,
                                 textStyle: {
                                     fontSize: '30',
                                     fontWeight: 'bold'
                                 }
                             }
                         },
                         labelLine: {
                             normal: {
                                 show: false
                             }
                         },
                         data:array
                    }
                ]
            });
        },
        error : function(result) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    });

})

</script>

</html>