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
        title : {
            text: '培训信息数据统计',
            /*subtext: '',*/
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
           
            data:[]
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'left',
                            max: 1548
                        }
                    }
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
               
                data:[]
            }
        ]
    };

    $.ajax({
        type:"post",
        url:"${pageContext.request.contextPath}/chart/getTrainInforStatic.action",
        data:{},
        cache:false,
        async: false,
        dataType:"json",
        success : function (result) {

            for(var i in result){

                data1.push(result[i].state);
                
                var map={};
                map.name=result[i].state;
                map.value=result[i].img;
                array[i]=map;

            }
            myChart.setOption({ //加载数据图表

                title : {
                    text: '文章状态数据统计',
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
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {
                            show: true,
                            type: ['pie', 'funnel'],
                            option: {
                                funnel: {
                                    x: '25%',
                                    width: '50%',
                                    funnelAlign: 'left',
                                    max: 1548
                                }
                            }
                        },
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                series : [
                    {
                        name:'统计结果:',
                        type:'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
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