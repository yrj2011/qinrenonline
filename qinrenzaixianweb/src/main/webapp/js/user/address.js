/**
 *  用户地址js
 *  @author yrj
 */
/**
 * 页面加载完成
 */
$(document).ready(function () {
	//验证Form
    $(".address_form").Validform({
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
		  "empty": /^\s*$/
	    },callback:function(form){
		  var address_form = $("#address_form");
		  address_form[0].submit();
      	  return false;
		}
    });
    
    /*
     * 提交用户地址
     */
    $("#address_btn").click(function(){
    	$(".address_form").submit();
    });
});
