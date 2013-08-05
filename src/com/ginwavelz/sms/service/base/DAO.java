package com.ginwavelz.sms.service.base;

import java.io.Serializable;
import java.util.LinkedHashMap;

import com.ginwavelz.sms.bean.QueryResult;
/**
 * ʵ�����ͨ�ýӿ�
 * @author robin
 *
 * @param <T>ʵ������
 */

public interface DAO<T> {
	
	/**
	 * ��ȡȫ�����
	 * @return
	 */
	public QueryResult<T> getScrollData();
	/**
	 * ��ҳ��ѯ��ȡ��¼
	 * @param firstResutl ��ʼ�����������ֵΪ-1������ȡȫ�����
	 * @param maxResult ÿҳ��ȡ�ļ�¼���������-1������ȡȫ�����
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResutl,int maxResult);
	/**
	 * ��ҳ��ѯ��ȡ��¼
	 * @param firstResutl ��ʼ�����������ֵΪ-1������ȡȫ�����
	 * @param maxResult ÿҳ��ȡ�ļ�¼���������-1������ȡȫ�����
	 * @param where ������䣬����where�ؼ��֣��������ֻ��ʹ��λ�ò���λ�ò��������ֵ��1��ʼ��
	 * @param params ���������ֵ�λ�ò���ֵ
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResutl,int maxResult,String where ,Object[] params);
	/**
	 * ��ҳ��ѯ��ȡ��¼
	 * @param firstResutl ��ʼ�����������ֵΪ-1������ȡȫ�����
	 * @param maxResult ÿҳ��ȡ�ļ�¼���������-1������ȡȫ�����
	 * @param orderby ����keyΪ�������ԣ�valueΪasc/desc
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResutl,int maxResult,LinkedHashMap<String, String> orderby);
	/**
	 * ��ҳ��ѯ��ȡ��¼
	 * @param firstResutl ��ʼ�����������ֵΪ-1������ȡȫ�����
	 * @param maxResult ÿҳ��ȡ�ļ�¼���������-1������ȡȫ�����
	 * @param where ������䣬����where�ؼ��֣��������ֻ��ʹ��λ�ò���λ�ò��������ֵ��1��ʼ��
	 * @param params ���������ֵ�λ�ò���ֵ
	 * @param orderby ����keyΪ�������ԣ�valueΪasc/desc
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResutl,int maxResult,String where ,Object[] params,LinkedHashMap<String, String> orderby);
	
	/**
	 * ����ʵ��
	 * @param entity
	 */
	public void save (T entity);
	
	/**
	 * ����ʵ��
	 * @param entity
	 */
	public void update (T entity);
	
	/**
	 * ɾ��ʵ��
	 * @param entityid
	 */
	public void delete (Serializable entityid); //jpa �涨ʵ���id���Ա���ʵ�����л��ӿ�
	
	/**
	 * ��ȡʵ��
	 * @param entityid
	 * @return ʵ�����
	 */
	public T find (Serializable entityid);
	
	/**
	 * ��ȡʵ���ܼ�¼��
	 * @return �ܼ�¼��
	 */
	public long getCount();

}
