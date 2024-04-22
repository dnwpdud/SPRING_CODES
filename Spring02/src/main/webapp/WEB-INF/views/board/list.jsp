<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
   border-style : solid;
   border-width : 1px;
   text-align : center;
}

ul {
   list-style-type : none;
}

li {
   display : inline-block;
}
</style>
<meta charset="UTF-8">
<!-- jquery 라이브러리 import -->
<script src="https://code.jquery.com/jquery-3.7.1.js">
</script>
<title>게시판 메인 페이지</title>
</head>
<body>
   <h1>게시판 메인</h1>
   <!-- 글 작성 페이지 이동 버튼 -->
   <a href="register"><input type="button" value="글 작성"></a>
   <hr>
   <table>
      <thead>
         <tr>
            <th style="width : 60px">번호</th>
            <th style="width : 700px">제목</th>
            <th style="width : 120px">작성자</th>
            <th style="width : 100px">작성일</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach var="boardVO" items="${boardList }">
            <tr>
               <td>${boardVO.boardId }</td>
               <td>${boardVO.boardTitle }</td>
               <td>${boardVO.memberId }</td>
               <!-- boardDateCreated 데이터 포멧 변경 -->
               <fmt:formatDate value="${boardVO.boardDateCreated }"
               pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated"/>
               <td>${boardDateCreated }</td>
            </tr>
         </c:forEach>
      </tbody>
   </table>
   
</body>
</html>