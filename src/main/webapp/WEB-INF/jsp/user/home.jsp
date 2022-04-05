
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

    <h1>${user.firstName}</h1>

    <c:forEach var="petList" items="${petList}">
        <ul>
            <li>
                ${petList.name}
            </li>
        </ul>
    </c:forEach>




<jsp:include page="../include/footer.jsp" />