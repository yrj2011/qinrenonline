package com.qinrenzaixian.domain;

import java.util.Date;

import com.qinrenzaixian.domain.BaseDo;

/**
 * 用户信息
 * @author xiaoyang
 *
 */
public class UserDo extends BaseDo {
	/**
	  用户类型：0 管理员,1 父母，2子女，3 好心人，4 其他'
	*/
	private int type;
	/**
	 * 登录名
	 */
	private String name;
	/**
	 * 性别 0男，1女'
	 */
	private int sex;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 姓名
	 */
	private String realName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 个人图片
	 */
	private String picture;
	/**
	 * 身份证
	 */
	private String identity;
	/**
	 * 身份证图片
	 */
	private String identitypic;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 
	 */
	private String mobile;
	/**
	 * 座机
	 */
	private String telephone;
	/**
	 * qq
	 */
	private String qq;
	/**
	 * 微信号
	 */
	private String weixin;
	/**
	 * 微博
	 */
	private String weibo;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 用户登录次数
	 */
	private String loginTimes;
	/**
	 * 最后登录时间
	 */
	private String lastLoginTime;
	/**
	 * 最后登录IP
	 */
	private String lastLoginIp;
	/**
	 * 创建IP
	 */
	private String createIp;
	/**
	 * 修改IP
	 */
	private String updateIp;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getIdentitypic() {
		return identitypic;
	}
	public void setIdentitypic(String identitypic) {
		this.identitypic = identitypic;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(String loginTimes) {
		this.loginTimes = loginTimes;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public String getCreateIp() {
		return createIp;
	}
	public void setCreateIp(String createIp) {
		this.createIp = createIp;
	}
	public String getUpdateIp() {
		return updateIp;
	}
	public void setUpdateIp(String updateIp) {
		this.updateIp = updateIp;
	}
	
}
