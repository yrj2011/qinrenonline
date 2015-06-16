Date.dayNames = ['\u65e5', '\u4e00', '\u4e8c', '\u4e09', '\u56db', '\u4e94', '\u516d'];
Date.abbrDayNames = ['\u65e5', '\u4e00', '\u4e8c', '\u4e09', '\u56db', '\u4e94', '\u516d'];
Date.monthNames = ['\u4e00\u6708','\u4e8c\u6708','\u4e09\u6708','\u56db\u6708','\u4e94\u6708','\u516d\u6708','\u4e03\u6708','\u516b\u6708','\u4e5d\u6708','\u5341\u6708','\u5341\u4e00\u6708','\u5341\u4e8c\u6708'];
Date.abbrMonthNames = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
Date.firstDayOfWeek = 1;
Date.format = 'yyyy-mm-dd';
Date.fullYearStart = '20';
(function() {
	function add(name, method) {
		if( !Date.prototype[name] ) {
			Date.prototype[name] = method;}};
	add("isLeapYear", function() {
		var y = this.getFullYear();
		return (y%4==0 && y%100!=0) || y%400==0;});
	add("isWeekend", function() {
		return this.getDay()==0 || this.getDay()==6;});
	add("isWeekDay", function() {
		return !this.isWeekend();});
	add("getDaysInMonth", function() {
		return [31,(this.isLeapYear() ? 29:28),31,30,31,30,31,31,30,31,30,31][this.getMonth()];});
	add("getDayName", function(abbreviated) {
		return abbreviated ? Date.abbrDayNames[this.getDay()] : Date.dayNames[this.getDay()];});
	add("getMonthName", function(abbreviated) {
		return abbreviated ? Date.abbrMonthNames[this.getMonth()] : Date.monthNames[this.getMonth()];});
	add("getDayOfYear", function() {
		var tmpdtm = new Date("1/1/" + this.getFullYear());
		return Math.floor((this.getTime() - tmpdtm.getTime()) / 86400000);});
	add("getWeekOfYear", function() {
		return Math.ceil(this.getDayOfYear() / 7);});
	add("setDayOfYear", function(day) {
		this.setMonth(0);
		this.setDate(day);
		return this;});
	add("addYears", function(num) {
		this.setFullYear(this.getFullYear() + num);
		return this;});
	add("addMonths", function(num) {
		var tmpdtm = this.getDate();	
		this.setMonth(this.getMonth() + num);	
		if (tmpdtm > this.getDate())
			this.addDays(-this.getDate());
		return this;});

	add("addDays", function(num) {
		this.setDate(this.getDate() + num);
		return this;
	});
	add("addHours", function(num) {
		this.setHours(this.getHours() + num);
		return this;
	});
	add("addMinutes", function(num) {
		this.setMinutes(this.getMinutes() + num);
		return this;
	});
	add("addSeconds", function(num) {
		this.setSeconds(this.getSeconds() + num);
		return this;
	});

	add("zeroTime", function() {
		this.setMilliseconds(0);
		this.setSeconds(0);
		this.setMinutes(0);
		this.setHours(0);
		return this;
	});

	add("asString", function() {
		var r = Date.format;
		return r
			.split('yyyy').join(this.getFullYear())
			.split('yy').join((this.getFullYear() + '').substring(2))
			.split('mmm').join(this.getMonthName(true))
			.split('mm').join(_zeroPad(this.getMonth()+1))
			.split('dd').join(_zeroPad(this.getDate()));
	});

	Date.fromString = function(s)
	{
		var f = Date.format;
		var d = new Date('01/01/1977');
		var iY = f.indexOf('yyyy');
		if (iY > -1) {
			d.setFullYear(Number(s.substr(iY, 4)));
		} else {
			
			d.setFullYear(Number(Date.fullYearStart + s.substr(f.indexOf('yy'), 2)));
		}
		var iM = f.indexOf('mmm');
		if (iM > -1) {
			var mStr = s.substr(iM, 3);
			for (var i=0; i<Date.abbrMonthNames.length; i++) {
				if (Date.abbrMonthNames[i] == mStr) break;
			}
			d.setMonth(i);
		} else {
			d.setMonth(Number(s.substr(f.indexOf('mm'), 2)) - 1);
		}
		d.setDate(Number(s.substr(f.indexOf('dd'), 2)));
		if (isNaN(d.getTime())) {
			return false;
		}
		return d;
	};
	var _zeroPad = function(num) {
		var s = '0'+num;
		return s.substring(s.length-2)
	}; 
	Date.prototype.format = function(fmt) 
	{ 
	  var o = { 
	    "M+" : this.getMonth()+1,                 //月份 
	    "d+" : this.getDate(),                    //日 
	    "h+" : this.getHours(),                   //小时 
	    "m+" : this.getMinutes(),                 //分 
	    "s+" : this.getSeconds(),                 //秒 
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度 
	    "S"  : this.getMilliseconds()             //毫秒 
	  }; 
	  if(/(y+)/.test(fmt)) 
	    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	  for(var k in o) 
	    if(new RegExp("("+ k +")").test(fmt)) 
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
	  return fmt; 
	};
	Date.prototype.compareTime = function(startTime, endTime){   // 时间大小比较
		var start=new Date(startTime.replace("-", "/").replace("-", "/"));
		var end=new Date(endTime.replace("-", "/").replace("-", "/"));
		if(end<start){
		 	return false;
		}
		return true;
	};
})();