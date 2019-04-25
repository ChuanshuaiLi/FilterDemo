<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.*" %>
<!-- 处理用户提交的留言请求 -->
<% 
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Message message = new Message();
	message.setTitle(title);
	message.setContent(content);
	
	List<Message> messages = (List<Message>)session.getAttribute("messages");
	//为空的时候创建
	if(messages == null){
		messages = new ArrayList<Message>();
		session.setAttribute("messages", messages);
	}
	
	messages.add(message);//留言列表信息存储至session中
	//重定向至留言板页面，并提示处理成功
	response.sendRedirect(request.getContextPath()+"/message.jsp?subFlag=1");//重定向至留言板页面
%>