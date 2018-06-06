$(function(){
		
		//加载数据库数据
		var datajson;
		$.ajax({
			url:'task_getAllTask',
				type:'GET',
				dataType:'json',
				async:false,
				success:function(data){
					if(data==null){
						alert("当前无事务");
					}
					datajson = data.task;					
				},
				error:function(){
					alert("Failed");
				}
				
		});
		
		//初始化日历
		$("#calendar").fullCalendar({
			theme: true,
			customButtons:{
				button1:{
					text:"新建",
					click:function(){
						
						//初始化界面
						$("#title").val("");
						$("#taskInfo").val("");							
						$("#isallday").prop("checked",false);
						$("#end").prop("checked",false);
						$("#starttime,#endtime").show();
						$("#startdate").val("");
						$("#isallday").val("0");
						$("#enddate").hide();
						
						$(".datepicker").datepicker({
							language:"zh-CN",
							format:"yyyy-mm-dd",
							todayHighlight:true,
							autoclose:true,
							weekStart:0
						});
						$(".timepicki").wickedpicker({
							title:'',
							showSeconds:true,
							twentyFour:true
						});
						$("#isallday").click(function(){
							if($("#isallday").prop("checked") == true){
								$("#isallday").val("1");
								$("#starttime,#endtime").hide();
							}else{
								$("#isallday").val("0");
								$("#starttime,#endtime").show();
							};	
						});
						$("#end").click(function(){
							if($("#end").prop("checked") == true){
								$("#enddate").show();
							}else{
								$("#enddate").hide();
							};
						});

		
						dialog({
							title:"新建日程",
							content:$("#dialog-form"),
							okValue:"确定",
							ok:function(){
								var titledetail = $("#titledetail").val();
								var startdate = $("#startdate").val();
								var starttime = $("#starttime").val().split(" ").join("");
								var enddate = $("#stopdate").val();
								var endtime = $("#endtime").val().split(" ").join("");
								var allDay = $("#isallday").val();
								if(titledetail){
									$.ajax({
										url:'../../indexstatic/fullcalendar/detail.php',
				   						data:{title:titledetail,sdate:startdate,stime:starttime,edate:enddate,etime:endtime,allDay:allDay},
				   						type:'POST',
				   						dataType:'json',
				  						success:function(data){
				  							$("#calendar").fullCalendar("renderEvent",data,true);
				  						},
				  						error:function(){
				  							alert("Failed");
				  						}
				   						
									});
								};
							},
							cancelValue:"关闭",
							cancel:function(){
								//$("#ui-datepicker-div").remove();
							}
						}).showModal();
					}
				},				
				button3:{
					text:"设置",
					click:function(){
						$("#slider").slider({
							range:true,
							min:0,
							max:24,
							values:[8,18],
							slide: function( event, ui ) {
				        		$( "#amount" ).val(ui.values[ 0 ] + ":00 - " + ui.values[ 1 ]+":00");
				        		
				      		}
						});
						$( "#amount" ).val($( "#slider" ).slider( "values", 0 ) +
      ":00 - " + $( "#slider" ).slider( "values", 1 )+":00");
						dialog({
							title:"设置时间段",
							content:$("#set"),
							okValue:"确定",
							ok:function(){
								var minTime = $( "#slider" ).slider( "values", 0 )+":00:00";
				      			var maxTime = $( "#slider" ).slider( "values", 1 )+":00:00";
				      			$("#calendar").fullCalendar("option","minTime",minTime);
				      			$("#calendar").fullCalendar("option","maxTime",maxTime);
							},
							cancelValue:"关闭",
							cancel:function(){}
						}).showModal();
					}
				}
			},
			header: {
				left: 'prev,next today button3',
				center: 'title',
				right: 'button1 button2 month,agendaWeek,agendaDay,listMonth'
			},
			firstDay: 1,
			monthNames: ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"],
			monthNamesShort: ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"],
			dayNames:["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
			dayNamesShort:["日","一","二","三","四","五","六"],
			buttonText:{
				today: "今天",
				month: "月",
				week: "周",
				day: "天",
				listMonth:"列表"
			},		
			allDayDefault:false,
			slotLabelFormat:"H",
			businessHours: {
				dow:[1,2,3,4,5],
				start:"8:00",
				end:"17:00"
			},
			allDaySlot: true,
			allDayText: "全天",
			timeFormat: "HH:mm",//设置的是添加的具体的日程上显示的时间
			views:{
				month:{
					titleFormat:"YYYY年M月"
				},
				week:{
					titleFormat:"YYYY年M月D日",
					columnFormat:"M.D dddd"
				},
				day:{
					titleFormat:"YYYY年M月D日 dddd",
					columnFormat:"M/D dddd"
				}
			},
			dayClick: function(date,allDay,jsEvent,view){
				var selDate = $.fullCalendar.formatDate(date,"YYYY-MM-DD");
				var d = dialog({
					title:"新建简单事件",
					content:"<textarea rows=5 class='taxt' placeholder='事件标题' id='eventall'></textarea><p>"+selDate+"</p>",
					width:460,
					button:[{
						value:"完整编辑",
						callback:function(){
							
							$("#title").val("");
							$("#taskInfo").val("");							
							$("#isallday").prop("checked",false);
							$("#end").prop("checked",false);
							$("#starttime,#endtime").show();
							$("#startdate").val(selDate);
							$("#isallday").val("0");
							$("#enddate").hide();

							$(".datepicker").datepicker({
								language:"zh-CN",
								format:"yyyy-mm-dd",
								todayHighlight:true,
								autoclose:true,
								weekStart:0
							});
							$(".timepicki").wickedpicker({
								title:'',
								showSeconds:true,
								twentyFour:true
							});
							$("#isallday").click(function(){
								if($("#isallday").prop("checked") == true){
									$("#isallday").val("1");
									$("#starttime,#endtime").hide();
								}else{
									$("#isallday").val("0");
									$("#starttime,#endtime").show();
								};	
							});
							$("#end").click(function(){
								if($("#end").prop("checked") == true){
									$("#enddate").show();
								}else{
									$("#enddate").hide();
								};
							});
						
						
							dialog({
								title:"新建日程",
								content:$("#dialog-form"),
								okValue:"确定",
								ok:function(){
									add();
								},
								cancelValue:"关闭",
								cancel:function(){}
							}).showModal();
						},	
					}],
					okValue:"确定",
					ok:function(){
						addsimple(selDate);
					},
					cancelValue:"取消",
					cancel:function(){}
				});
				d.showModal();
				
			},
			eventClick:function(event,jsEvent,view){
				var editstarttime = $.fullCalendar.formatDate(event.start,"YYYY-MM-DD HH:mm:ss");
				var editstart = $.fullCalendar.formatDate(event.start,"YYYY-MM-DD");
				//alert(editstart);
				var title = event.title;//任务编号
				var taskInfo = event.description;//任务描述
				var eventid = event.id;//任务id编号
				var taskState = event.state;//任务状态
				var allDay = event.allDay;//任务是否全天的状态
				var start = event.start;//任务开启时间
				var end = event.end;//任务结束时间
				
				//设置显示内容
				$("#edittitle").html(event.description);//点击任务后显示的任务内容
				if(event.end){
					var editendtime = $.fullCalendar.formatDate(event.end,"YYYY-MM-DD HH:mm:ss");
					$("#edittime").html(editstarttime+"  至  "+editendtime);
				}else{
					$("#edittime").html(editstarttime);
				};
				if(taskState == 1){
					$("#edittype").val("1");
				}else{
					$("#edittype").val("0");
				}
				
				
				// var time = '19:00:00';
				dialog({
					title:"编辑日程",
					content:$("#edit"),
					okValue:"编辑",
					ok:function(){
						if(taskState == 1){
							$("#edittype1").val("1");
						}else{
							$("#edittype1").val("0");
						}
						$("#title").val(title);
						$("#taskInfo").val(taskInfo);
						$("#end").prop("checked",false);
						$("#enddate").hide();
						$("#startdate").val(editstart);
						if(allDay == 1){
							$("#isallday").prop("checked",true);
							$("#starttime,#endtime").hide();
						}else{
							$("#isallday").prop("checked",false);
						}
						$(".datepicker").datepicker({
							language:"zh-CN",
							format:"yyyy-mm-dd",
							todayHighlight:true,
							autoclose:true,
							weekStart:0
						});
						$(".timepicki").wickedpicker({
							// now: time,
							title:'',
							showSeconds:true,
							twentyFour:true
						});
						$("#isallday").click(function(){
							if($("#isallday").prop("checked") == true){
								$("#isallday").val("1");
								$("#starttime,#endtime").hide();
							}else{
								$("#isallday").val("0");
								$("#starttime,#endtime").show();
							};	
						});
						$("#end").click(function(){
							if($("#end").prop("checked") == true){
								$("#enddate").show();
							}else{
								$("#enddate").hide();
							};
						});
						
						
						dialog({
							title:"新建日程",
							content:$("#dialog-form"),
							okValue:"确定",
							ok:function(){
								updata(eventid);
							},
							cancelValue:"关闭",
							cancel:function(){
							}
						}).showModal();
						$("#calendar").fullCalendar("removeEvents",function(event){
									
						});
					},
					//删除任务
					button:[{
						value:"删除",
						callback:function(){
							deleteTask(eventid);
							$('#calendar').fullCalendar('removeEvents',eventid);
						}
					}],
					cancelValue:"取消",
					cancel:function(){}
				}).showModal();
			}
		
		});
		
		var obj = new Object();
		for (var i = 0; i < datajson.length; i++) {            
            obj.id = datajson[i].id;
            obj.title = datajson[i].title;
            obj.description = datajson[i].taskInfo;
            obj.start = datajson[i].start;         
            obj.end = datajson[i].end;
            obj.state = datajson[i].taskState;
            if(obj.state==0){
            	obj.color="red";
            }else{
            	obj.color="green";
            }
            if(datajson[i].allDay)
            	obj.allDay = true;
            else
            	obj.allDay = false;
            //alert(obj.id+"  "+obj.title+"  "+obj.description+"  "+obj.start+"  "+obj.end);
            $("#calendar").fullCalendar('renderEvent', obj, true);
        }
	
	});

//更新事务
function updata(eventid){
	var title1 = $("#title").val();
	var taskInfo1 = $("#taskInfo").val();
	var startdate = $("#startdate").val();
	var starttime = $("#starttime").val().split(" ").join("");
	var enddate = $("#stopdate").val();
	var endtime = $("#endtime").val().split(" ").join("");
	var allDay1;
	if($("#isallday").val()=="1"){
		allDay1 = 1;
	}else
		allDay1 = 0;
	var state = $("#edittype1").val();
	var start1 = startdate+" "+starttime;
	var end1;
	if(enddate)
		end1 = enddate+" "+endtime;
	if((taskInfo1||title1)&&startdate){
		if(end){
			 $.ajax({
				url:'task_updataTask',
					data:{
						id:eventid,
						title:title1,
						taskInfo:taskInfo1,					   							
						start:start1,
						end:end1,
						allDay:allDay1,
						taskState:state
					},
					type:'GET',
					dataType:'json',
					success:function(data){
						$('#calendar').fullCalendar('removeEvents',eventid);						
						addupdata(data);
						alert("更新成功");
						header_app.loadNewTask();
					},
					error:function(){
						alert("Failed");
					}
					
			});
		}else{
			$.ajax({
				url:'task_updataTask',
					data:{
						id:eventid,
						title:title1,
						taskInfo:taskInfo1,					   							
						start:start1,
						allDay:allDay1,
						taskState:state
					},
					type:'GET',
					dataType:'json',
					success:function(data){
						$('#calendar').fullCalendar('removeEvents',eventid);
						addupdata(data);
						alert("更新成功");
						header_app.loadNewTask();
					},
					error:function(){
						alert("Failed");
					}
					
			});
		}
	}
	else{
		alert("事务标签或事务标题和开始时间不能为空");
	}
}

//添加简单事务
function addsimple(selDate){
	var titleall = $("#eventall").val();
	if(titleall){
		$.ajax({
			url:'task_addTask',
			data:{
				title:titleall,				   							
				start:selDate,
				allDay:1
			},
			type:'GET',
			dataType:'json',
			success:function(data){
				addupdata(data);
				alert("添加成功");
				header_app.loadNewTask();
			},
			error:function(){
				alert("Failed");
			}
			
		});
	}else{
		alert("事务标题不能为空");
	}
}

//添加数据到数据库
function add(){
	var title1 = $("#title").val();
	var taskInfo1 = $("#taskInfo").val();
	var startdate = $("#startdate").val();
	var starttime = $("#starttime").val().split(" ").join("");
	var enddate = $("#stopdate").val();
	var endtime = $("#endtime").val().split(" ").join("");
	var allDay1 = $("#isallday").val();
	var state = $("#edittype1").val();
	var start1 = startdate+" "+starttime;
	var end1;
	if(enddate)
		end1 = enddate+" "+endtime;
	if((taskInfo1||title1)&&startdate){
		if(end){
			 $.ajax({
				url:'task_addTask',
					data:{
						title:title1,
						taskInfo:taskInfo1,					   							
						start:start1,
						end:end1,
						allDay:allDay1,
						taskState:state
					},
					type:'GET',
					dataType:'json',
					success:function(data){
						addupdata(data);
						alert("添加成功");
						header_app.loadNewTask();
					},
					error:function(){
						alert("Failed");
					}
					
			});
		}else{
			$.ajax({
				url:'task_addTask',
					data:{
						title:title1,
						taskInfo:taskInfo1,					   							
						start:start1,
						allDay:allDay1,
						taskState:state
					},
					type:'GET',
					dataType:'json',
					success:function(data){
						addupdata(data);
						alert("添加成功");
						header_app.loadNewTask();
					},
					error:function(){
						alert("Failed");
					}
					
			});
		}
	}
	else{
		alert("事务标签或事务标题和开始时间不能为空");
	}
}
//添加任务到日历
function addupdata(data){
	var t_task = data.a_task;
	var tobj = new Object();
	tobj.id = t_task.id;
    // obj.color = "red";
    tobj.title = t_task.title;
    tobj.description = t_task.taskInfo;
    tobj.start = t_task.start;
    tobj.end = t_task.end;
    tobj.state = t_task.taskState;
    if(tobj.state==0){
    	tobj.color="red";
    }else{
    	tobj.color="green";
    }
    if(t_task.allDay)
    	tobj.allDay = true;
    else
    	tobj.allDay = false;	
  	//alert(tobj.id+"  "+tobj.title+"  "+tobj.description+"  "+tobj.start+"  "+tobj.end);
  	$("#calendar").fullCalendar('renderEvent', tobj, true);
}
//从数据库删除事务
function deleteTask(eventid){
	$.ajax({
		url:'task_deleteTask',
		data:{
			id:eventid
		},
		type:'GET',
		dataType:'json',
		success:function(data){
			alert(data.msg);
			header_app.loadNewTask();
		},
		error:function(){
			alert("Failed");
		}		
	});
}