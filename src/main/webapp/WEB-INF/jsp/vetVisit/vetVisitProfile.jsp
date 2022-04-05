<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

    <div>
        <h1>Date: ${vetVisit.date}</h1>
        <h2>Notes: ${vetVisit.notes}</h2>
        <h2>Vaccines: ${vetVisit.vaccines}</h2>
        <h2>Weight: ${vetVisit.weight}</h2>
    </div>
    <h3>Vet seen: Dr. ${vet.firstName} ${vet.lastName}</h3>






<jsp:include page="../include/footer.jsp" />