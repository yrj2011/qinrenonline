/**
 * Created with IntelliJ IDEA.

 * User: fengzq
 * Date: 14-11-24
 * Time: 下午2:19
 * To change this template use File | Settings | File Templates.
 */
//js文件中需要引用的一些系统常量

$(document).ready(function () {
	$(".cb-enable").click(function(){
	    var parent = $(this).parents('.switch');
	    $('.cb-disable',parent).removeClass('checked');
	    $(this).addClass('checked');
	    $('.checkbox',parent).attr('checked', true);
	});
	$(".cb-disable").click(function(){
	    var parent = $(this).parents('.switch');
	    $('.cb-enable',parent).removeClass('checked');
	    $(this).addClass('checked');
	    $('.checkbox',parent).attr('checked', false);
	});
	$(".b_logo,.b_name_cn").click(function(){
		window.location.href=sy.ctx + "/merchant";
	});
	/**地址管理模块*/
	$(".ks-ext-close-x").click(function(){
	    $(".ks-dialog").hide();
	});
	$("#update_address_btn").click(function(){
	    $(".ks-dialog").show();
	});
	$(".trigger").click(function(){
	    $(this).parent(".gareas").next(".citys").show();
	});
	$(".close_button").click(function(){
	    $(this).parent().parent(".citys").hide();
	});
	$(".J_Group").change(function(){
	    var isChecked = $(this).attr("checked");
	    var valueArr = $(this).val();
	    var test = valueArr.split(",");
	    if(isChecked !== "checked"){
	        for(var i = 0; i < test.length;i++){
	            $("#J_Province_"+test[i]).attr("checked",false);
	            $("#J_Province_"+test[i]).parent().next(".citys").find("input[type=checkbox]").attr("checked",false);
	            $("#J_Province_"+test[i]).parent().children(".check_num").html("");
	        }
	    }else{
	        for(var i = 0; i < test.length;i++){
	            $("#J_Province_"+test[i]).attr("checked",true);
	            $("#J_Province_"+test[i]).parent().next(".citys").find("input[type=checkbox]").attr("checked",true);
	            var size = $("#J_Province_"+test[i]).parent().next(".citys").find("input[type=checkbox]").size();
	            $("#J_Province_"+test[i]).parent().children(".check_num").html("("+size+")");
	        }
	    }
	});
	$(".J_Province").change(function(){
	    var value = $(this).attr("checked");
	    var size = $(this).parent().next(".citys").find("input[type=checkbox]").size();
	    if(value == "checked"){
	        $(this).parent().next(".citys").find("input[type=checkbox]").attr("checked",true);
	        $(this).parent().children(".check_num").html("("+size+")");
	        var provinceSize = $(this).parent().parent().parent(".province-list").find(".J_Province").length;
	        var checkedProvinceSize = $(this).parent().parent().parent(".province-list").find(".J_Province:checked").length;
	        /** if选择的 省份数量 等于该大区下所有省份的数量 */
	        if(provinceSize == checkedProvinceSize){
	            $(this).parent().parent().parent().parent().find(".group-label").children("input[type=checkbox]").attr("checked",true);
	        }else{
	            $(this).parent().parent().parent().parent().find(".group-label").children("input[type=checkbox]").attr("checked",false);
	        }
	    }else{
	        $(this).parent().next(".citys").find("input[type=checkbox]").attr("checked",false);
	        $(this).parent().children(".check_num").html("");
	        $(this).parent().parent().parent().parent().find(".group-label").children("input[type=checkbox]").attr("checked",false);
	    }
	});
	$(".J_City").change(function(){
	    var size = $(this).parent().parent().find("input:checked").size();
	    var allQuantity = $(this).parent().parent().find("input[type=checkbox]").size();
	    if(size === allQuantity){
	        $(this).parent().parent().parent().children(".gareas").children(".J_Province").attr("checked",true);
	        $(this).parent().parent().parent().children(".gareas").children(".check_num").html("("+size+")");
	        var provinceSize = $(this).parent().parent().parent().parent(".province-list").find(".J_Province").length;
	        var checkedProvinceSize = $(this).parent().parent().parent().parent(".province-list").find(".J_Province:checked").length;
	        if(provinceSize == checkedProvinceSize){
	            $(this).parent().parent().parent().parent().parent().find(".group-label").children("input[type=checkbox]").attr("checked",true);
	        }else{
	            $(this).parent().parent().parent().parent().parent().find(".group-label").children("input[type=checkbox]").attr("checked",false);
	        }
	    } else{
	        $(this).parent().parent().parent().children(".gareas").children(".J_Province").attr("checked",false);
	        if(size == 0){
	            $(this).parent().parent().parent().children(".gareas").children(".check_num").html("");
	        }else{
	            $(this).parent().parent().parent().children(".gareas").children(".check_num").html("("+size+")");
	        }
	        $(this).parent().parent().parent().parent().parent().find(".group-label").children("input[type=checkbox]").attr("checked",false);
	    }
	});

	//初始化重置按钮
	$(".reset_btn").after('<input type="reset" style="display:none;" />');

	//重置按钮
	$(".reset_btn").click(function(){
	    $(this).next().click();
	});
	var Accordion = function(el, multiple) {
	    this.el = el || {};
	    this.multiple = multiple || false;

	    // Variables privadas
	    var links = this.el.find('.link');
	    // Evento
	    links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
	}
	Accordion.prototype.dropdown = function(e) {
	    var $el = e.data.el;
	    $this = $(this),
	        $next = $this.next();
   //控制指标的方向
	    if($this.hasClass("open")) $this.find('.fa-chevron-down').css("background","url("+sy.ctx+"/resources/common/images/chevron-down.png) no-repeat");
	    else $this.find('.fa-chevron-down').css("background","url("+sy.ctx+"/resources/common/images/checron-up.png) no-repeat");
	    $next.slideToggle();
	    $this.toggleClass('open');
	    //TODO 控制打开当前的   关闭上次打开的
//	                if (!e.data.multiple) {
//	                    $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
//	                };
	}
	/*var wH = $(window).height();
	var DH = $('.container').height() + 120;
	var SH = wH - 78;
	if (wH > DH) {
		$('.container').css('height', SH);
	}
	$(window).resize(function() {
		var wH = $(window).height();
		var DH = $('.container').height() + 120;
		var SH = wH - 78;//浏览器时下窗口可视区域高度
		if (wH > DH) {
			$('.container').css('height', SH)
		}
	});*/

	$('.submenu').css('display', 'none');
	$('.open').css('display', 'block');
	var accordion = new Accordion($('#accordion'), true);

	/*tab选项卡*/
	function tabs(tabTit,on,tabCon){
	    $(tabCon).each(function(){
	        $(this).children().eq(0).show();
	    });
	    $(tabTit).each(function(){
	        $(this).children().eq(0).addClass(on);
	    });
	    $(tabTit).children().click(function(){
	        $(this).addClass(on).siblings().removeClass(on);
	        var index = $(tabTit).children().index(this);
	        $(tabCon).children().eq(index).show().siblings().hide();
	    });
	}
	

});

/**
 * 表单重置
 * @param resetBtn         重置按钮
 * @param resetForm        重置表单
 */
function formReset(resetBtn, resetForm){
	$(resetBtn).click(function(){
		$(':input',resetForm).not(':button, :submit, :reset, :hidden')
		.val('').removeAttr('checked').removeAttr('selected');
	});
}
/**
 * 左边导航增加样式
 * @param subMenuId    一级菜单ID,从0 1 2往后推
 * @param liId         二级菜单ID,从0 1 2往后推
 */
function navStyle(subMenuId, liId){
	$(".accordion li:eq("+subMenuId+")").children().eq(0).removeClass("open").siblings().addClass("open");
	$('.submenu:eq('+subMenuId+')').addClass("open").css('display', 'block');
	$('.submenu:eq('+subMenuId+') li:eq('+liId+')').addClass("bg_blue");
}
/**
 * new Date(timeStr).formate('yyyy-MM-dd hh:mm:ss)
 * @param format
 * @returns
 */
Date.prototype.format = function(format)
{
	 var o = {
	 "M+" : this.getMonth()+1, //month
	 "d+" : this.getDate(),    //day
	 "h+" : this.getHours(),   //hour
	 "m+" : this.getMinutes(), //minute
	 "s+" : this.getSeconds(), //second
	 "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
	 "S" : this.getMilliseconds() //millisecond
	 }
	 if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
	 (this.getFullYear()+"").substr(4 - RegExp.$1.length));
	 for(var k in o)if(new RegExp("("+ k +")").test(format))
	 format = format.replace(RegExp.$1,
	 RegExp.$1.length==1 ? o[k] :
	 ("00"+ o[k]).substr((""+ o[k]).length));
	 return format;
}
/*tab选项卡*/
function tabs(tabTit,on,tabCon){
    $(tabCon).each(function(){
        $(this).children().eq(0).show();
    });
    $(tabTit).each(function(){
        $(this).children().eq(0).addClass(on);
    });
    $(tabTit).children().click(function(){
        $(this).addClass(on).siblings().removeClass(on);
        var index = $(tabTit).children().index(this);
        $(tabCon).children().eq(index).show().siblings().hide();
    });
}

function wuliuTabs(id){
    $(id).click(function(){
        $(this).each(function(){
            $(id).removeClass("active");
            $(this).addClass("active");
        });
    })
}

//用于保存查找的子类结果
var findCurrentResult;
/**
 * 递归遍历，查找当前分类id的子对象
 * @param data
 * @param categoryId
 */
function getCurrentCategory(data,categoryId){
	for (var i  in data){
		if(data[i].id == categoryId){
			findCurrentResult = data[i];
			break;
		} else {
			getCurrentCategory(data[i].child,categoryId);
		}
	}
}

//用于保存查找的父类结果
var findParentResult;
/**
 * 递归遍历，查找当前分类id的子对象
 * @param data
 * @param categoryId
 */
function getCurrentParentCategory(data,categoryId){
	var child = data.child;
	for (var i in child){
		if(child[i].id == categoryId){
			findParentResult = data.id;
			break;
		} else {
			getCurrentParentCategory(child[i],categoryId);
		}
	}
}

//弹出层
function modalDisplay(modalId){
	$('#'+ modalId).modal('view', {
		speed:500,
        easing:'easeInOutExpo',
        animation:'zoom',
        position:'1% auto',
        overlayClose:true,
        on:'click',
        overlayColor:'#000',
        overlayOpacity:.9,
        close:'.guanbi'
    });
}

function getImageUrl(images){
	if(images == null || images==""){
		return;
	}else{
		return images[0].url;
	}
}

function formateDate(str){
	if(str  == null || typeof(str) == "undefined"){
		return "";
	} else {
		return new Date(str).format('yyyy-MM-dd hh:mm:ss');
	}
}

/**
 * 根据拍品状态码，返回拍品状态名称
 * @param code
 * @returns {String}
 */
function getAuctionStatusByCode(code){
	var status = "";
	switch(code){
		case "0":
			status = "新建";
			break;
		case "1":
			status = "待审核";
			break;
		case "2":
			status = "已审核";
			break;
		case "3":
			status = "未通过";
			break;
		case "4":
			status = "预展";
			break;
		case "5":
			status = "竞买中";
			break;
		case "6":
			status = "已成交";
			break;
		case "7":
			status = "未成交";
			break;
		case "8":
			status = "撤拍";
			break;
		case "9":
			status = "下架";
			break;
	}
	
	return status;
}

/**
 * 根据专场状态码，返回专场状态名称
 * @param code
 * @returns {String}
 */
function getAlbumStatusByCode(code){
	var status = "";
	switch(code){
		case "0":
			status = "待审核";
			break;
		case "1":
			status = "已审核";
			break;
		case "2":
			status = "未通过";
			break;
	}
	
	return status;
}

/**
 * 账务类型
 * @param code
 * @returns {String}
 */
function getFinanceType(code){
	var status = "";
	switch(code){
		case "0":
			status = "收入";
			break;
		case "1":
			status = "支出";
			break;
		case "2":
			status = "冻结";
			break;
		case "3":
			status = "解冻返还,";
			break;
		case "4":
			status = "解冻扣除";
			break;
	}
	return status;
}

/**
 * 获取离当前日期的天数
 * @param AddDayCount
 * @returns {String}
 */
function getDateStr(count) {
    var dd = new Date();
    dd.setDate(dd.getDate()+parseInt(count));//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = dd.getMonth()+1;//获取当前月份的日期
    var d = dd.getDate();
    return y+"-"+m+"-"+d;
}

/**
 * 一些公用的JS方法
 * eg CommonUtil().trim(" 123 "); return "123" 
 */
function CommonUtil(){
	// 删除左右两端的空格
	this.trim = function(str){
		return str.replace(/(^\s*)|(\s*$)/g, "");
	},
	// 删除左边的空格
	this.ltrim = function(str){
		return str.replace(/(^\s*)/g,"");
	},
	// 删除右边的空格
	this.rtrim = function(str){
		return str.replace(/(\s*$)/g,"");
	},
	// 判断变量是否为空
	this.isNullOrEmpty = function(strVal){
		var str = this.trim(strVal);
		if (str == '' || str == null || typeof(str) == 'undefined') {
			return true;
		} else {
			return false;
		}
	};
	
	this.getLength = function(str) {
	    ///<summary>获得字符串实际长度，中文2，英文1</summary>
	    ///<param name="str">要获得长度的字符串</param>
	    var realLength = 0, len = str.length, charCode = -1;
	    for (var i = 0; i < len; i++) {
	        charCode = str.charCodeAt(i);
	        if (charCode >= 0 && charCode <= 128) realLength += 1;
	        else realLength += 2;
	    }
	    return realLength;
	};
}
/* 
 * formatMoney(s,type) 
 * 功能：金额按千位逗号分割 
 * 参数：s，需要格式化的金额数值. 
 * 参数：type,判断格式化后的金额是否需要小数位. 
 * 返回：返回格式化后的数值字符串. 
 */ 
 function formatMoney(s,type) { 
 if (/[^0-9\.]/.test(s)) 
 return "0"; 
 if (s == null || s == "") 
 return "0"; 
 s = s.toString().replace(/^(\d*)$/, "$1."); 
 s = (s + "00").replace(/(\d*\.\d\d)\d*/, "$1"); 
 s = s.replace(".", ","); 
 var re = /(\d)(\d{3},)/; 
 while (re.test(s)) 
 s = s.replace(re, "$1,$2"); 
 s = s.replace(/,(\d\d)$/, ".$1"); 
 if (type == 0) {// 不带小数位(默认是有小数位) 
 var a = s.split("."); 
 if (a[1] == "00") { 
 s = a[0]; 
 } 
 }
 return s; 
 }
 
 
 // ------------------   判断密码强度        ------------------
 // 判断字符是属于哪一类
 function CharMode(iN) {
     if (iN >= 48 && iN <= 57) //数字 
         return 1;
     if (iN >= 65 && iN <= 90) //大写字母 
         return 2;
     if (iN >= 97 && iN <= 122) //小写 
         return 4;
     else
         return 8; //特殊字符 
 }
 //计算出当前密码当中一共有多少种模式 
 function bitTotal(num) {
     var modes = 0;
     for (var i = 0; i < 4; i++) {
         if (num & 1) {modes++;}
         num >>>= 1;
     }
     return modes;
 }
 //返回密码的强度级别 
 function checkStrong(sPW) {
     if (sPW.length <= 6)
         return 0; //密码太短 
     var Modes = 0;
     for (var i = 0; i < sPW.length; i++) {
         //判断每一个字符的类别并统计一共有多少种模式. 
         Modes |= CharMode(sPW.charCodeAt(i));
     }
     return level(bitTotal(Modes));
 }
 
 function level(level){
	 if(level<=1){
	    return 0;
	 }else if(level == 2){
	    return 1;
	 }else{
	    return 2;
	 }
 }
 // ------------  判断密码强度 结束       ------------------
 // 邮件中间四位用*代替
 function emailHide(value,split){
	 var prefix = value.substring(0,value.indexOf(split));
     var subfix = value.substring(value.indexOf(split), value.length);
     if(prefix.length >=6){
    	var index = (prefix.length-4)/2;
    	value = prefix.substring(0, index) + "****" + prefix.substring(index + 4,prefix.length) + subfix;
     }
     return value;
 }
 
 


 
 

