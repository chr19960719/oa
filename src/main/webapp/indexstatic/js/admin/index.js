function loadToken(app) {
	$.ajax({
        type:"get",
        url: "/token",
        async : true,
        success: function(data){
            if(data.code === 0){
				app.user=data.token;
            }
            else{
                alert('获取当前登录用户信息失败，请重新登录');
            }
        }
    });
}

var header_app = new Vue({
	el: "#header-app",
	data: {
		newMessages: [],
		num:[],
		tasknum:[],
		newTask:[]
	},
	methods: {
		logout: function() {
			confirm('确定退出登录？', function(id){
				$.ajax({
					type:"get",
					url: "/logout",
					async : true,
					success: function(data){
						if(data.code === 0){
							window.location.href='/login';
						}
						else{
							alert('系统异常，请联系管理员');
						}
					}
				});
			});
		},
		loadNewMessages: function() {
			var app = this;
			var m = {};
			$.ajax({
				type:"get",
				url: "test_getAllMessage",
				async : true,
				success: function(data){
 					if(data.num){
 						app.newMessages = data.message;
 						app.num = data.num;
 					}
				}
			});
		},
		loadNewTask:function(){
			var app = this;
			var m = {};
			$.ajax({
				url:'task_getAllTask',
				type:'GET',
				dataType:'json',
				async:true,
				success: function(data){
 					if(data.num){
 						app.newTask = data.task;
 						app.tasknum = data.num;
 					}
				}
			});
		},
		timeFormat: function(ms){
			// 毫秒转日期时间
			return millisecondsToDateTime(ms);
		},
		titleFormat: function(msg){
			// 长度超过12，截取12个字符
			if(msg.length<=12){
				return msg;
			}				
			return msg.substr(0,11)+"···";
		},
		numberFormat: function(num){
			// 消息数量角标，大于99显示99+
			if(num=="")
				return 0;
			if(num<=99){
				return num;
			}
			return '&middot;&middot;';
		},
		settings:function(){
			sidebar_app.go('settings.html','系统设置');
		},
		getmessage:function(id,rid){
			localStorage.rid = rid; 
			localStorage.sid = id; 
			sidebar_app.go("details.html","详细消息");
		},
		msg:function(){
			sidebar_app.go('msglist.html','我的消息');
		},
		tasks:function(){
			sidebar_app.go('calendar.html','任务表');
		}
	},
	computed :{
		
	},
	created: function(){
		// 创建实例时获取未读消息
		this.loadNewMessages();
		// 创建实时事务
		this.loadNewTask(); 
	}
})

var sidebar_app = new Vue({
	el: "#sidebar-app",
	data:{
		title: '主页',
		user: {}
	},
	methods: {
		profileEdit: function(){
			alert('修改信息成功')
		},
		go: function(p,tilte){
			//fillPage(p)
			loadpage(p);
			this.title = tilte;
		}
	},
	created: function () {
		//loadToken(this);
    }
})

var title_app = new Vue({
	el: "#title-app",
	data:{
	},
	computed:{
		title: function(){
			return sidebar_app.title;
		},
	},
	methods: {
		
	}
})

var fillPage = function(goal){
	$.ajax({
		method:"get",
        dataType: "html",
        async : true,
		url: goal,
		success: function(content) {
			$("#page-container").load(content);
		}
	});
}

var loadpage = function(goal){
	//var id = geturl(goal,'id');
	$("#page-container").load(goal);
}

var geturl = function(goal,name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = goal.substr(goal.search('id')).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
};

function millisecondsToDateTime(ms){
	return new Date(ms).toLocaleString();
}
