
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

    <h1>Welcome, ${user.firstName}!</h1>

    <c:forEach var="pet" items="${petList}">
        <ul>
            <li>
                ${pet.name}
            </li>
        </ul>
    </c:forEach>




<jsp:include page="../include/footer.jsp" />