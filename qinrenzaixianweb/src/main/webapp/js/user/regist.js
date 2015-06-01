/**
 *  用户注册js
 *  @author yrj
 */
/**
 * 页面加载完成
 */
$(document).ready(function () {
	//验证Form
    $(".registeform").Validform({
        tiptype:function(msg,o,cssctl){
            //msg：提示信息;
            //o:{obj:*,type:*,curform:*}, obj指向的是当前验证的表单元素（或表单对象），type指示提示的状态，值为1、2、3、4， 1：正在检测/提交数据，2：通过验证，3：验证失败，4：提示ignore状态, curform为当前form对象;
            //cssctl:内置的提示信息样式控制函数，该函数需传入两个参数：显示提示信息的对象 和 当前提示的状态（既形参o中的type）;
            if(!o.obj.is("form")){//验证表单元素时o.obj为该表单元素，全部验证通过提交表单时o.obj为该表单对象;
                var objtip=o.obj.siblings(".Validform_checktip");
                cssctl(objtip,o.type);
                objtip.text(msg);
            }
        },datatype:{
		 "zuhe":function(gets,obj,curform,regxp){
				//参数gets是获取到的表单元素值，obj为当前表单元素，curform为当前验证的表单，regxp为内置的一些正则表达式的引用;
				var reg1=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
				if(reg1.test(gets)){return true;}
				return '密码必须是字母、数字和符号的组合';
				//注意return可以返回true 或 false 或 字符串文字，true表示验证通过，返回字符串表示验证失败，字符串作为错误提示显示，返回false则用errmsg或默认的错误提示;
			}
	  },callback:function(form){
		  var registForm = $("#registForm");
		  registForm[0].submit();
      	  return false;
		}
    });
   
	//图片上传
    $("#mainPic").click(function(){
        var obj = $(this);
        $("#uploadFile").click();
        $("#uploadFile").change(function(){
            $.ajaxFileUpload({
                url:sy.ctx+'/upload',
                secureuri: false, //一般设置为false
                fileElementId: 'uploadFile', // 上传文件的id、name属性名
                dataType: 'json',
                //elementIds: elementIds, //传递参数到服务器
                success: function (result, status){
                    if(result != null ){
                    	$("#mainPicImg").attr("src",result.url);
                        obj.next().val(result.url);
                    }else{
                        alert(result);
                    }
                    
                },error:function(res){
                }
            });
        });
    });
    
    /*
     * 提交用户注册
     */
    $("#registuser").click(function(){
    	$(".registeform").submit();
    });
});
