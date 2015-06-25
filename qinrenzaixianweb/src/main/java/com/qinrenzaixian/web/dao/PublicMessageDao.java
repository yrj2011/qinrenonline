package com.qinrenzaixian.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qinrenzaixian.core.util.ListUtil;
import com.qinrenzaixian.web.domain.AddressDo;
import com.qinrenzaixian.web.domain.PictrueDo;
import com.qinrenzaixian.web.domain.PublicMessageAddrDo;
import com.qinrenzaixian.web.domain.PublicMessageDo;
import com.qinrenzaixian.web.domain.PublicMessagePagination;
import com.qinrenzaixian.web.domain.PublicMessagePicDo;

@Repository("publicmessageDao")
public class PublicMessageDao extends BaseDAO{

	/**
	 * 通过ID查询发布
	 * @param id
	 * @return
	 */
	public PublicMessageDo selectPublicMessageById(Long id){
	    return getSqlSession().selectOne("Publicmessage.findPublicmessageById",id);
	}

	/**
	 * 新增发布消息
	 * @param address
	 * @return
	 */
	public int  insertPublicMessage(PublicMessageDo address){
	    int id = getSqlSession().insert("Publicmessage.insertPublicmessage",address);
	    if(ListUtil.isNotEmpty(address.getAddresses())){
	    	List<AddressDo> listd = address.getAddresses();
	    	for(AddressDo a:listd){
	    		PublicMessageAddrDo publicMessageAddrDo = new PublicMessageAddrDo();
	    		publicMessageAddrDo.setAddressId(a.getId());
	    		publicMessageAddrDo.setPublicmessageId(Long.parseLong(String.valueOf(id)));
	    		getSqlSession().insert("Publicmessage.insertPublicmessageAddr",publicMessageAddrDo);
	    	}
	    }
	    if(ListUtil.isNotEmpty(address.getPictrues())){
	    	List<PictrueDo> listp = address.getPictrues();
	    	for(PictrueDo p:listp){
	    		PublicMessagePicDo publicMessagePicDo = new PublicMessagePicDo();
	    		publicMessagePicDo.setPictrueId(p.getId());
	    		publicMessagePicDo.setPublicmessageId(Long.parseLong(String.valueOf(id)));
	    		getSqlSession().insert("Publicmessage.insertPublicmessagePic",publicMessagePicDo);
	    	}
	    }
	    return id;
	}
	/**
	 * 修改发布消息
	 * @param address 发布消息
	 * @return
	 * @throws Exception
	 */
	public int updatePublicMessage(PublicMessageDo address) throws Exception{
		 int rs = getSqlSession().update("Publicmessage.updatePublicMessage",address);
		 Long id = address.getId();
		 PublicMessageAddrDo publicMessageAddrDo = new PublicMessageAddrDo();
		 PublicMessagePicDo publicMessagePicDo = new PublicMessagePicDo();
		 publicMessageAddrDo.setPublicmessageId(id);
		 publicMessagePicDo.setPublicmessageId(id);
		 getSqlSession().update("Publicmessage.delPublicmessageAddr",publicMessageAddrDo);
		 getSqlSession().update("Publicmessage.delPublicmessagePic",publicMessagePicDo);
		 if(ListUtil.isNotEmpty(address.getAddresses())){
		    	List<AddressDo> listd = address.getAddresses();
		    	for(AddressDo a:listd){
		    		publicMessageAddrDo = new PublicMessageAddrDo();
		    		publicMessageAddrDo.setAddressId(a.getId());
		    		publicMessageAddrDo.setPublicmessageId(Long.parseLong(String.valueOf(id)));
		    		getSqlSession().insert("Publicmessage.insertPublicmessageAddr",publicMessageAddrDo);
		    	}
		    }
		    if(ListUtil.isNotEmpty(address.getPictrues())){
		    	List<PictrueDo> listp = address.getPictrues();
		    	for(PictrueDo p:listp){
		    		publicMessagePicDo = new PublicMessagePicDo();
		    		publicMessagePicDo.setPictrueId(p.getId());
		    		publicMessagePicDo.setPublicmessageId(Long.parseLong(String.valueOf(id)));
		    		getSqlSession().insert("Publicmessage.insertPublicmessagePic",publicMessagePicDo);
		    	}
		    }
		 return rs;
	}
	
	/**
	 * 删除发布消息
	 * @param address 发布消息
	 * @return
	 * @throws Exception
	 */
	public int deletePublicMessage(PublicMessageDo address) throws Exception{
		 int rs = getSqlSession().update("Publicmessage.delPublicmessage",address);
		 Long id = address.getId();
		 PublicMessageAddrDo publicMessageAddrDo = new PublicMessageAddrDo();
		 PublicMessagePicDo publicMessagePicDo = new PublicMessagePicDo();
		 publicMessageAddrDo.setPublicmessageId(id);
		 publicMessagePicDo.setPublicmessageId(id);
		 return rs;
	}
	
	/**
	 * 查询用户发布消息列表
	 * @param address 发布消息
	 * @return
	 * @throws Exception
	 */
	public void queryUserPublicMessage(PublicMessagePagination<PublicMessageDo> info) throws Exception{
		queryForPaginate("Publicmessage.queryPublicmessageList", info);
	}

}
