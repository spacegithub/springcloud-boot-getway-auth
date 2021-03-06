package com.nriet.datacenter.service.cpzz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nriet.datacenter.mapper.cpzz.PdmTsInfoMapper;
import com.nriet.datacenter.model.cpzz.PdmTsInfo;
import com.nriet.datacenter.service.cpzz.PdmTsInfoService;
import com.nriet.framework.myBatis.AbstractService;

/**
 * Created by CodeGenerator on 2018/02/26.
 */
@Service
@Transactional
public class PdmTsInfoServiceImpl extends AbstractService<PdmTsInfo> implements PdmTsInfoService {

	@Resource
	private PdmTsInfoMapper pdmTsInfoMapper;

	/**
	 * 查询指定发布序号、发布时间的雷暴已发布报文
	 * 
	 * @param msgId
	 *            报文发布序号
	 * @param date
	 *            发布时间
	 * @param reportType
	 *            报文类型
	 * @return 雷暴已发布报文
	 */
	@Override
	public PdmTsInfo queryReport(String msgId, String date, String reportType) {
		return pdmTsInfoMapper.queryReport(msgId, date, reportType);
	}

	/**
	 * 报文保存
	 * 
	 * @param ts
	 *            报文
	 * @return 0:保存成功, 1:保存失败
	 */
	@Override
	public int saveReport(PdmTsInfo ts) {
		try {
			pdmTsInfoMapper.saveReport(ts);
			return 0;
		}catch(Exception e) {
			e.printStackTrace();
			return 1;
		}
	}

}
