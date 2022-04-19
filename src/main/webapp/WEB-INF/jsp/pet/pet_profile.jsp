<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />

<style>
    h1{
        color: white;
        text-align: center;
    }
    img{
        max-width: 30%;
        border: 10px solid white;
    }
    button a{
        text-decoration: none;
        color: white;
    }
    button a:hover{
        color: #bd724a;
    }
    h4 a{
        color: black;
        text-decoration: none;
    }
    h4 a:hover{
        color: #bd724a;
    }
    .petProfile > th{
        font-size: 30px;
        text-align: end;
    }
    .petProfile > td{
        font-size: 30px;
    }
    th{
        font-size: 40px;
        text-align:center;
    }
    td{
        font-size: 20px;
    }
    .card{
        background-image: url("../../../pub/images/washi.webp");
        background-repeat: repeat;
    }
</style>
<div class="d-flex justify-content-center m-5">
    <c:choose>
        <c:when test="${pet.type == 'Dog'}">
            <img src="../../../pub/images/dog.jpg" class="card-img-top" alt="photo of dog">
        </c:when>
        <c:when test="${pet.type == 'Cat'}">
            <img src="../../../pub/images/cat.jpg" class="card-img-top" alt="photo of cat">
        </c:when>
        <c:when test="${pet.type == 'Guinea Pig'}">
            <img src="../../../pub/images/guineapig.jpg" class="card-img-top" alt="photo of guinea pig">
        </c:when>
        <c:when test="${pet.type == 'Bird'}">
            <img src="../../../pub/images/bird.jpg" class="card-img-top" alt="photo of parakeet">
        </c:when>
        <c:when test="${pet.type == 'Snake'}">
            <img src="../../../pub/images/snake.jpg" class="card-img-top" alt="photo of snake">
        </c:when>
        <c:when test="${pet.type == 'Bearded Dragon'}">
            <img src="../../../pub/images/beardeddragon.jpg" class="card-img-top" alt="photo of bearded dragon">
        </c:when>
        <c:when test="${pet.type == 'Turtle'}">
            <img src="../../../pub/images/turtle.jpg" class="card-img-top" alt="photo of turtle">
        </c:when>
        <c:when test="${pet.type == 'Rabbit'}">
            <img src="../../../pub/images/rabbit.jpg" class="card-img-top" alt="photo of rabbit">
        </c:when>
        <c:when test="${pet.type == 'Chinchilla'}">
            <img src="../../../pub/images/chinchilla.jpg" class="card-img-top" alt="photo of chinchilla">
        </c:when>
        <c:when test="${pet.type == 'Chameleon'}">
            <img src="../../../pub/images/chameleon.jpg" class="card-img-top" alt="photo of chameleon">
        </c:when>
        <c:when test="${pet.type == 'Ferret'}">
            <img src="../../../pub/images/ferret.jpg" class="card-img-top" alt="photo of ferret">
        </c:when>
        <c:when test="${pet.type == 'Sugar Glider'}">
            <img src="../../../pub/images/sugarglider.jpg" class="card-img-top" alt="photo of sugar glider">
        </c:when>
        <c:when test="${pet.type == 'Hedgehog'}">
            <img src="../../../pub/images/hedgehog.jpg" class="card-img-top" alt="photo of hedgehog">
        </c:when>
        <c:when test="${pet.type == 'Hamster'}">
            <img src="../../../pub/images/hamster.jpg" class="card-img-top" alt="photo of hamster">
        </c:when>
        <c:when test="${pet.type == 'Rat'}">
            <img src="../../../pub/images/rat.jpg" class="card-img-top" alt="photo of rat">
        </c:when>
        <c:when test="${pet.type == 'Fish'}">
            <img src="../../../pub/images/fish.jpg" class="card-img-top" alt="photo of fish">
        </c:when>
        <c:when test="${pet.type == 'Gerbil'}">
            <img src="../../../pub/images/gerbil.jpg" class="card-img-top" alt="photo of gerbil">
        </c:when>
        <c:otherwise>
            <img src="../../../pub/images/other.jpg" class="card-img-top" alt="photo of many pets together">
        </c:otherwise>
    </c:choose>
</div>
<div class="d-flex justify-content-center flex-wrap">
    <div class="card m-3" style="width: 25rem;">
        <div class="card-body">
            <table class="table table-light table-striped">
                <tbody>
                    <tr class="petProfile">
                        <th>Name:</th>
                        <td>${pet.name}</td>
                    </tr>
                    <tr class="petProfile">
                        <th>Type:</th>
                        <td>${pet.type}</td>
                    </tr>
                    <tr class="petProfile">
                        <th>Breed:</th>
                        <td>${pet.breed}</td>
                    </tr>
                    <tr class="petProfile">
                        <th>Date of birth:</th>
                        <td><fmt:formatDate value ="${pet.birthday}" pattern="MM/dd/yyyy"/></td>
                    </tr>
                </tbody>
            </table>
            <div class="d-flex justify-content-center">
                <button class="btn btn-dark m-3"><a href="/pet/edit/${pet.id}">Edit Pet Info</a></button>
            </div>
        </div>
    </div>
</div>
<div class="d-flex justify-content-center flex-wrap">
    <c:forEach var="vetVisit" items="${vetVisitList}">
            <div class="card m-5" style="width: 25rem;">
                <div class="card-body">
                    <table class="table table-light table-striped">
                        <tbody id="vetVisitTable">
                        <tr>
                            <th>&#128197;</th>
                            <td><fmt:formatDate value ="${vetVisit.date}" pattern="MM/dd/yyyy"/></td>
                        </tr>
                        <tr>
                            <th>&#128221;</th>
                            <td>${vetVisit.notes}</td>
                        </tr>
                        <tr>
                            <th>&#128137;</th>
                            <td>${vetVisit.vaccines}</td>
                        </tr>
                        <tr>
                            <th>&#9878;&#65039;</th>
                            <c:if test="${vetVisit.weight == null}">
                                <td>NA</td>
                            </c:if>
                            <c:if test="${vetVisit.weight != null}">
                                <td>${vetVisit.weight} lbs</td>
                            </c:if>
                        </tr>
                        <tr>
                            <th>&#128105;&#8205;&#9877;&#65039</th>
                            <td>${vetVisit.vet.firstName} ${vetVisit.vet.lastName}</td>
                        </tr>
                        <tr>
                            <th>&#127973;</th>
                            <td>${vetVisit.vet.clinic}</td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="d-flex justify-content-center">
                        <button class="btn btn-dark m-3"><a href="/vetVisit/${vetVisit.id}">View Vet Visit</a></button>
                        <button class="btn btn-dark m-3"><a href="/vetVisit/deleteVetVisit/${vetVisit.id}">Delete Vet Visit</a></button>
                    </div>
                </div>
            </div>
    </c:forEach>
</div>


<jsp:include page="../include/footer.jsp" />