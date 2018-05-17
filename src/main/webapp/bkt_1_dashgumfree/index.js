var sidebar_app = new Vue({
	el: "#sidebar-app",
	data:{
		title: '主页',
		user: {}
	},
	methods: {		
		go: function(p,tilte){
			fillPage(p)
			this.title = tilte;
		}
	}
})
var fillPage = function(goal){
	$.ajax({
		method:"get",
        dataType: "html",
		url: goal,
		success: function(content) {
			$("#page-container").html(content)
		}
	});
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