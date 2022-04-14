<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

    <div>
        <h1>Name: ${pet.name}</h1>
        <h3>Type: ${pet.type}</h3>
        <h3>Breed: ${pet.breed}</h3>
        <h3>Birthday: ${pet.birthday}</h3>
    </div>

    <c:forEach var="vetVisit" items="${vetVisitList}">
        <ul>
            <li>
                Vet Visit Date: ${vetVisit.date}
            </li>
        </ul>
    </c:forEach>


<jsp:include page="../include/footer.jsp" />