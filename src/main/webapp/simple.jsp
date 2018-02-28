<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show param page</title>
</head>
<body>

<button>
    <i>
        <%=request.getParameter("title")%>
    </i>
</button>

</body>
</html>
