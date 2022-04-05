<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<div>
    <h1>${pet.name}</h1>
    <h3>${pet.type}</h3>
    <h3>${pet.breed}</h3>
    <h3>${pet.birthday}</h3>
</div>

<jsp:include page="../include/footer.jsp" />