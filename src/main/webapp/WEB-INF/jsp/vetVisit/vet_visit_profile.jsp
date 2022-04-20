<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />

<style>
    th{
        font-size: 30px;
    }
    td{
        font-size: 30px;
    }
</style>

<div class="d-flex justify-content-center">
    <div class="card m-5" style="width: 40rem;">
        <div class="card-body">
            <div class="m-5">
                <table class="table table-light table-striped">
                    <tbody>
                    <tr>
                        <th>Pet:</th>
                        <td>${vetVisit.pet.name}</td>
                    </tr>
                    <tr>
                        <th>Date:</th>
                        <td><fmt:formatDate value ="${vetVisit.date}" pattern="MM/dd/yyyy"/></td>
                    </tr>
                        <tr>
                            <th>Notes:</th>
                            <td>${vetVisit.notes}</td>
                        </tr>
                        <tr>
                            <th>Vaccines:</th>
                            <td>${vetVisit.vaccines}</td>
                        </tr>
                        <tr>
                            <th>Weight:</th>
                            <c:if test="${vetVisit.weight == null}">
                                <td>NA</td>
                            </c:if>
                            <c:if test="${vetVisit.weight != null}">
                                <td>${vetVisit.weight} lbs</td>
                            </c:if>
                        </tr>
                        <tr>
                            <th>Vet seen:</th>
                            <td>${vetVisit.vet.firstName} ${vetVisit.vet.lastName}</td>
                        </tr>
                        <tr>
                            <th>Clinic:</th>
                            <td>${vetVisit.vet.clinic}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../include/footer.jsp" />