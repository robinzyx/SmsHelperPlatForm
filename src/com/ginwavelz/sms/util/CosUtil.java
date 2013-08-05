package com.ginwavelz.sms.util;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
public class CosUtil {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static String upload(HttpServletRequest request) throws IOException
	{
		//����·��
		String filePath = "D://upload";
		//�����·��
//		String filePath = request.getRealPath("/")+"upload";
		File uploadPath = new File(filePath);
		//����ļ����Ƿ���� ������ ����һ��
		if(!uploadPath.exists())
		{
			uploadPath.mkdir();
		}
		//�ļ�������� 5M
		int fileMaxSize = 5*1024*1024;
	
		//�ļ���
		String fileName = null;
		//�ϴ��ļ���
		int fileCount = 0;
		//���������
		RandomFileRenamePolicy rfrp=new RandomFileRenamePolicy();
		//�ϴ��ļ�
		MultipartRequest mulit = new MultipartRequest(request,filePath,fileMaxSize,"UTF-8",rfrp);
		
		String userName = mulit.getParameter("userName");
		System.out.println(userName);
		
		Enumeration filesname = mulit.getFileNames();
	      while(filesname.hasMoreElements()){
	           String name = (String)filesname.nextElement();
	           fileName = mulit.getFilesystemName(name);
	           String contentType = mulit.getContentType(name);
	           
	           if(fileName!=null){
	        	   fileCount++;
	           }
	           System.out.println("�ļ���" + fileName);
	           System.out.println("�ļ����ͣ� " + contentType);
	           
	      }
	      System.out.println("���ϴ�" + fileCount + "���ļ���");
	      
	      return fileName;
	}
}
