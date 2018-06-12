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
			var r=confirm("确定退出登录？");
			if (r==true){
				window.location.href='login.html';
			}			
		},
		loadNewMessages: function() {
			var app = this;
			var m = {};
			$.ajax({
				type:"get",
				url: "test_savefile",
				async : true,
				success: function(data){
 					if(data.num){
 						app.newMessages = data.message;
 						app.num = data.num;
 					}else{
 						app.num = 0;
 					}
				}
			});
		},
		loadNewTask:function(){
			var app = this;
			var m = {};
			$.ajax({
				url:'task_getListTask',
				type:'GET',
				dataType:'json',
				async:true,
				success: function(data){
 					if(data.num){
 						app.newTask = data.task;
 						app.tasknum = data.num;
 					}else{
 						app.tasknum = 0;
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
			sidebar_app.go('info-setting.html','个人信息')
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
		},
		help:function(){
			window.location.href='help.html';
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
		title: '首页',
		user: {},
		power:[]
	},
	methods: {
		profileEdit: function(){
			alert('修改信息成功')
		},
		go: function(p,tilte){
			//fillPage(p)
			loadpage(p);
			this.title = tilte;
		},
		loadFunction:function(){
			var app = this;
			$.ajax({
				url:'type_getFunction',
				type:'GET',
				dataType:'json',
				async:true,
				success: function(data){
 					app.power = data.power;
				}
			});
		}
	},
	created: function () {
		this.loadFunction();
    }
})

var menu = new Vue({
	el: "#menu",
	data:{
		power:[]
	},
	methods:{
		loadFunction:function(){
			var app = this;
			$.ajax({
				url:'type_getFunction',
				type:'GET',
				dataType:'json',
				async:false,
				success: function(data){
 					app.power = data.power;
				}
			});
		}
	},
	created: function () {
		this.loadFunction();
    }
})

function go(p,tilte){
	sidebar_app.go(p,tilte);
}

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
