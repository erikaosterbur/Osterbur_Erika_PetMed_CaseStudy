<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />

<%--<style>--%>
<%--    button a {--%>
<%--        text-decoration: none;--%>
<%--        color: white;--%>
<%--    }--%>
<%--    button a:hover{--%>
<%--        color: #bd724a;--%>
<%--    }--%>
<%--</style>--%>

<h1 style="color: rgb(255, 255, 255); margin: 30px" class="d-flex justify-content-center">Current Vet List</h1>

<div class="d-flex justify-content-center flex-wrap">
    <div class="card m-3" style="width: 50rem;">
        <div class="card-body">
            <table class="table table-striped">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Clinic</th>
                </tr>
                <tbody>
                <c:forEach var="vet" items="${vets}">
                    <tr>
                        <th scope="row">${vet.id}</th>
                        <td>${vet.firstName}</td>
                        <td>${vet.lastName}</td>
                        <td>${vet.clinic}</td>
<%--                        <td><button type="submit" class="btn btn-dark"><a href="/admin/vetDelete/${vet.id}">Delete Vet From System</a></button></td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <h2>Add New Vet</h2>
        <form action="/admin/vetRegisterSubmit" method="post">
            <input type="text" name="firstName" placeholder="Enter vet's first name" class="form-control form-control-lg mb-3">
            <input type="text" name="lastName" placeholder="Enter vet's last name" class="form-control form-control-lg mb-3">
            <input type="text" name="clinic" placeholder="Enter vet's primary clinic name" class="form-control form-control-lg mb-3">
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-dark">Save Vet</button>
            </div>
        </form>
    </div>
</div>




<jsp:include page="../include/footer.jsp" />
