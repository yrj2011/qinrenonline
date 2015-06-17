/**
 *  用户注册js
 *  @author yrj
 */
/**
 * 页面加载完成
 */
$(document).ready(function () {
	//验证Form
    $(".infodetailForm").Validform({
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
			},
		"sfz":function(gets,obj,curform,regxp){
			var reg1=/(^\d{15}$)|(^\d{17}([0-9]|X)$)/;
			if(gets == null || gets =="" || reg1.test(gets)){
				return true;
				}
			return '输入的身份证号长度不对，或者号码不符合规定！\n15位号码应全为数字，18位号码末位可以为数字或X。';
		},
		"empty": /^\s*$/
	  },callback:function(form){
		  var infodetailForm = $("#infodetailForm");
		  infodetailForm[0].submit();
      	  return false;
		}
    });
    
    /*
     * 提交用户信息
     */
    $("#userinfodetail").click(function(){
    	$(".infodetailForm").submit();
    });
    
    //个人图片上传
    $("#picture_a").click(function(){
        var obj = $(this);
        $("#uploadFile").click();
        $("#uploadFile").change(function(){
            $.ajaxFileUpload({
                url:ctx+'/upload.shtml',
                secureuri: false, //一般设置为false
                fileElementId: 'uploadFile', // 上传文件的id、name属性名
                dataType: 'json',
                type:"post",
                //elementIds: elementIds, //传递参数到服务器
                success: function (result, status){
                    if(result != null ){
                    	$("#picturePicImg").attr("src",result.file_name);
                        obj.next().val(result.file_name);
                        $('.picturePreview').show();
                    }else{
                        alert(result);
                    }
                    
                },error:function(res){
                }
            });
        });
    });
    
    //身份图片上传
    $("#identitypic_a").click(function(){
        var obj = $(this);
        $("#uploadFile").click();
        $("#uploadFile").change(function(){
            $.ajaxFileUpload({
                url:ctx+'/upload.shtml',
                secureuri: false, //一般设置为false
                fileElementId: 'uploadFile', // 上传文件的id、name属性名
                dataType: 'json',
                type:"post",
                //elementIds: elementIds, //传递参数到服务器
                success: function (result, status){
                    if(result != null ){
                    	$("#identitypicPicImg").attr("src",result.file_name);
                        obj.next().val(result.file_name);
                        $('.identitypicPreview').show();
                    }else{
                        alert(result);
                    }
                    
                },error:function(res){
                }
            });
        });
    });
});
