<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!--  context만 찾는건 스크립틀릿 써도 됨  -->
   <%
      String context = request.getContextPath(); 
   %>
   context : <%= context %> <p>
   <form action="<%=context%>/studentView" method="post">
            이름 : <input type="text" name="name"><br />
            나이 : <input type="text" name="age"><br />
            학년 : <input type="text" name="gradeNum"><br />
               반 : <input type="text" name="classNum"><br />
      <input type="submit" value="전송">            
   </form>
</body>
</html>