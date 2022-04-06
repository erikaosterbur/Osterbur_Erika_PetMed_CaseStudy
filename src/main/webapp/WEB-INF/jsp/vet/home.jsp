<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<h1>Welcome, ${vet.firstName}!</h1>

<c:forEach var="vetVisit" items="${vetVisitList}">
    <ul>
        <li>
            Pet name: ${vetVisit.pet.name}
        </li>
        <li>
            Date: ${vetVisit.date}
        </li>
        <li>
            Vaccines: ${vetVisit.vaccines}
        </li>
        <li>
            Notes: ${vetVisit.notes}
        </li>
        <li>
            Weight: ${vetVisit.weight}
        </li>
    </ul>
</c:forEach>



<jsp:include page="../include/footer.jsp" />