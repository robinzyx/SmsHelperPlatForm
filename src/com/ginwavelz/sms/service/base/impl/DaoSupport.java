package com.ginwavelz.sms.service.base.impl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ginwavelz.sms.bean.QueryResult;
import com.ginwavelz.sms.service.base.DAO;
import com.ginwavelz.sms.util.GenericsUtils;
@Transactional
public abstract class DaoSupport<T> implements DAO<T> {
	@PersistenceContext protected EntityManager em;//���� �������
	protected Class<T> entityClass= getEntity();
	public QueryResult<T> getScrollData(){
		return getScrollData(-1, -1, null, null,null);
		
	}
	
	public QueryResult<T> getScrollData(int firstResutl,int maxResult){
		return getScrollData(firstResutl, maxResult, null, null,null);
		
	}
	
	public QueryResult<T> getScrollData(int firstResutl,int maxResult,String where ,Object[] params){
		return getScrollData(firstResutl, maxResult, where, params,null);
		
	}
	public QueryResult<T> getScrollData(int firstResutl,int maxResult,LinkedHashMap<String, String> orderby){
		return getScrollData(firstResutl, maxResult, null, null,orderby);
	}
	
	@SuppressWarnings("unchecked")
	public QueryResult<T> getScrollData(int firstResult,int maxResult,String where ,Object[] params,LinkedHashMap<String, String> orderby){
		String entityName = getEntityName(entityClass);
		String whereql = where!=null && !"".equals(where.trim()) ? " where "+ where : "" ;
		Query query = em.createQuery("select o from "+ entityName +" o" + whereql + buildOrderby(orderby));
		if(firstResult!=-1 && maxResult!=-1) query.setFirstResult(firstResult).setMaxResults(maxResult);
		setQueryParameter(query, params);
		QueryResult<T> qr = new QueryResult<T>();
		qr.setResultlist(query.getResultList());
		query = em.createQuery("select count(o) from "+ entityName +" o"+ whereql);
		setQueryParameter(query, params);
		qr.setRecordtotal((Long)query.getSingleResult());
		return qr;
		
	}
	/**
	 * ���ò�ѯ����
	 * @param query ��ѯ����
	 * @param params ����ֵ
	 */
	public static void setQueryParameter(Query query,Object[] params){
		if(params!=null){
			for(int i=0;i<params.length;i++){
				query.setParameter(i+1, params[i]);
			}
		}
		
	}
	/**
	 * �����������
	 * @param orderby ����������asc/desc,keyΪ���ԣ�valueΪasc/desc
	 * @return
	 */
	public static String buildOrderby(LinkedHashMap<String, String> orderby){
		StringBuilder sb=new StringBuilder();
		if(orderby!=null&&!orderby.isEmpty()){
			sb.append(" order by ");
			for(Map.Entry<String, String> entry:orderby.entrySet()){
				sb.append("o.").append(entry.getKey()).append(" ").append(entry.getValue()).append(',');
			}
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
		
	}
	
	/**
	 * ȡ������ʱ��
	 */
	public String getSubClass(){
		return getClass().getName();
	}
	/**
	 * ������ƣ���ȡʵ����
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public Class<T> getEntity(){
		Type parentType= getClass().getGenericSuperclass();
		if(parentType instanceof ParameterizedType){
			ParameterizedType ptype= (ParameterizedType) parentType;
			return (Class<T>)ptype.getActualTypeArguments()[0];
		}
		return null;
	}


	@Override
	public void save(T entity) {
		em.persist(entity);
	}

	@Override
	public void update(T entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Serializable entityid) {
		System.out.println("entityid"+entityid);
//		em.remove(em.getReference(entityClass, entityid));
		em.remove(em.merge(em.getReference(entityClass, entityid)));
	}

	@Override
	public T find(Serializable entityid) {
		return em.find(entityClass, entityid);
	}

//	@Override
//	public long getCount() {
//		return (Long) em.createQuery("select count(o) form "+getEntityName(this.entityClass)+" o ").getSingleResult();
//	}
//	
	protected static <E>  String getEntityName(Class<E> entityClass){
		String entityName=entityClass.getSimpleName();
		Entity entity=entityClass.getAnnotation(Entity.class);
		if(entity.name()!=null && !"".equals(entity.name()))entityName=entity.name();
		return entityName;
	}
//---------------------------------------------------------------------------------
//	@SuppressWarnings("unchecked")
//	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
//	@PersistenceContext protected EntityManager em;
//	
//	public void clear(){
//		em.clear();
//	}
//
////	public void delete(Serializable ... entityids) {
////		for(Object id : entityids){
////			em.remove(em.getReference(this.entityClass, id));
////		}
////	}
//	
//	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
//	public T find(Serializable entityId) {
//		if(entityId==null) throw new RuntimeException(this.entityClass.getName()+ ":传入的实体id不能为空");
//		return em.find(this.entityClass, entityId);
//	}
//
//	public void save(T entity) {
//		em.persist(entity);
//	}
//	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public long getCount() {
		return (Long)em.createQuery("select count("+ getCountField(this.entityClass) +") from "+ getEntityName(this.entityClass)+ " o").getSingleResult();
	}
//	
//	public void update(T entity) {
//		em.merge(entity);
//	}
//	
//	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
//	public QueryResult<T> getScrollData(int firstindex, int maxresult, LinkedHashMap<String, String> orderby) {
//		return getScrollData(firstindex,maxresult,null,null,orderby);
//	}
//	
//	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
//	public QueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams) {
//		return getScrollData(firstindex,maxresult,wherejpql,queryParams,null);
//	}
//	
//	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
//	public QueryResult<T> getScrollData(int firstindex, int maxresult) {
//		return getScrollData(firstindex,maxresult,null,null,null);
//	}
//	
//	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
//	public QueryResult<T> getScrollData() {
//		return getScrollData(-1, -1);
//	}
//
//	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
//	public QueryResult<T> getScrollData(int firstindex, int maxresult
//			, String wherejpql, Object[] queryParams,LinkedHashMap<String, String> orderby) {
//		QueryResult qr = new QueryResult<T>();
//		String entityname = getEntityName(this.entityClass);
//		Query query = em.createQuery("select o from "+ entityname+ " o "+(wherejpql==null || "".equals(wherejpql.trim())? "": "where "+ wherejpql)+ buildOrderby(orderby));
//		setQueryParams(query, queryParams);
//		if(firstindex!=-1 && maxresult!=-1) query.setFirstResult(firstindex).setMaxResults(maxresult);
//		qr.setResultlist(query.getResultList());
//		query = em.createQuery("select count("+ getCountField(this.entityClass)+ ") from "+ entityname+ " o "+(wherejpql==null || "".equals(wherejpql.trim())? "": "where "+ wherejpql));
//		setQueryParams(query, queryParams);
////		qr.setTotalrecord((Long)query.getSingleResult());
//		return qr;
//	}
//	
//	protected static void setQueryParams(Query query, Object[] queryParams){
//		if(queryParams!=null && queryParams.length>0){
//			for(int i=0; i<queryParams.length; i++){
//				query.setParameter(i+1, queryParams[i]);
//			}
//		}
//	}
//	/**
//	 * 组装order by语句
//	 * @param orderby
//	 * @return
//	 */
//	protected static String buildOrderby(LinkedHashMap<String, String> orderby){
//		StringBuffer orderbyql = new StringBuffer("");
//		if(orderby!=null && orderby.size()>0){
//			orderbyql.append(" order by ");
//			for(String key : orderby.keySet()){
//				orderbyql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
//			}
//			orderbyql.deleteCharAt(orderbyql.length()-1);
//		}
//		return orderbyql.toString();
//	}
//	/**
//	 * 获取实体的名称
//	 * @param <E>
//	 * @param clazz 实体类
//	 * @return
//	 */
//	protected static <E> String getEntityName(Class<E> clazz){
//		String entityname = clazz.getSimpleName();
//		Entity entity = clazz.getAnnotation(Entity.class);
//		if(entity.name()!=null && !"".equals(entity.name())){
//			entityname = entity.name();
//		}
//		return entityname;
//	}
	/**
	 * 获取统计属性,该方法是为了解决hibernate解析联合主键select count(o) from Xxx o语句BUG而增加,hibernate对此jpql解析后的sql为select count(field1,field2,...),显示使用count()统计多个字段是错误的
	 * @param <E>
	 * @param clazz
	 * @return
	 */
	protected static <E> String getCountField(Class<E> clazz){
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			for(PropertyDescriptor propertydesc : propertyDescriptors){
				Method method = propertydesc.getReadMethod();
				if(method!=null && method.isAnnotationPresent(EmbeddedId.class)){					
					PropertyDescriptor[] ps = Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();
					out = "o."+ propertydesc.getName()+ "." + (!ps[1].getName().equals("class")? ps[1].getName(): ps[0].getName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return out;
	}
	
}
