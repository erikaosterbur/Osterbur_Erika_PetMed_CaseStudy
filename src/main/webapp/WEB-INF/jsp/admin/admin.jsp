<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />

<div id="formContainer">
    <div id="formDiv" class="col-4">
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
