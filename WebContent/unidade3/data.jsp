<%@ page language="java" %>
<%@ page import="java.time.LocalDate" %>
<HTML>
	<BODY>
		<p>A hora atual é -> <%= LocalDate.now() %></p>
		<p>2 x 5 = <% out.print(2*5); %></p>
	</BODY>
</HTML>