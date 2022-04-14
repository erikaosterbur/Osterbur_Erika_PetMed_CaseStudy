<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />

<style>
    h1{
        color: white;
        text-align: center;
        margin: 10px;
    }
    h2{
        color: white;
        text-align: center;
        margin: 10px;
    }
    button a{
        text-decoration: none;
        color: white;
    }
    button a:hover{
        color: #bd724a;
    }
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
                <h4 class="card-title p-2" style="text-align: center">Date : <fmt:formatDate value ="${vetVisit.date}" pattern="MM/dd/yyyy"/></h4>
                <table class="table table-striped">
                    <tbody>
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
                    </tbody>
                </table>
                <div class="d-flex justify-content-center">
                    <button class="btn btn-dark m-3"><a href="/vetvisit/edit/${vetVisit.id}">Edit Vet Visit</a></button>
                </div>
            </div>
        </div>
    </div>
</div>







<jsp:include page="../include/footer.jsp" />