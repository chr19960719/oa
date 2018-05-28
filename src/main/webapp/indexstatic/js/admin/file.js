$(function(){
 $('.summernote').summernote({
        height: 200,
        tabsize: 2,
        lang: 'zh-CN',
        toolbar: [
            // [groupName, [list of button]]
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['font', ['strikethrough', 'superscript', 'subscript']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['picture',['picture']],
            ['codeview',['codeview']],
            ['help',['help']]
          ],
        callbacks: {  
            onImageUpload: function(file) {  //图片默认以二进制的形式存储到数据库，调用此方法将请求后台将图片存储到服务器，返回图片请求地址到前端
            	sendfile(file);
            }  
        }
    });
});
function sendfile(file){
	//将图片放入Formdate对象中                                         
    var formData = new FormData();  
    //‘picture’为后台获取的文件名，file[0]是要上传的文件
    formData.append("upload", file[0]); 
    $.ajax({                            
         type:'post',        
         url:'test_upload',                        
         cache: false,
         data:formData, 
         processData: false,
         contentType: false,
         dataType:'text', //请求成功后，后台返回图片访问地址字符串，故此以text格式获取，而不是json格式
         success: function(picture) {    
      	   $('.summernote').summernote('insertImage',picture); 
         },  
         error:function(){                                                  
            alert("上传失败");                                                     
         } 
    });
}
var app = new Vue({
	el:"#app",
	data:{
		checkedName:[]
	}
})

