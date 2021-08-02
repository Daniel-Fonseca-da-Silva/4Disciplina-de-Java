<%@ page language="java" %>
<%-- Página JSP --%>
<HTML>
<HEAD>
	<TITLE> Primeira Página JSP</TITLE>
</HEAD>
	<BODY>
	<% 
	String seuNome = request.getParameter("nome");
	StringBuffer seuNomeReverso = new StringBuffer(seuNome).reverse();
	out.println("<P> Seu Nome "+ seuNome + " lido de trás para frente é "+ seuNomeReverso); 
	%>
	</BODY>
</HTML>