<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<style>
    h1{
        color: white;
        text-align: center;
    }
    h3{
        color: white;
        text-align: center;
    }
    img{
        max-width: 30%;
        border: 10px solid white;
    }
    h4 a{
        color: black;
        text-decoration: none;
    }
    h4 a:hover{
        color: #bd724a;
    }
</style>
<div class="d-flex justify-content-center m-5">
    <c:if test="${pet.type == 'Dog'}">
        <img src="../../../pub/images/dog.jpg" class="card-img-top" alt="photo of dog">
    </c:if>
    <c:if test="${pet.type == 'Cat'}">
        <img src="../../../pub/images/cat.jpg" class="card-img-top" alt="photo of cat">
    </c:if>
    <c:if test="${pet.type == 'Guinea Pig'}">
        <img src="../../../pub/images/guineapig.jpg" class="card-img-top" alt="photo of guinea pig">
    </c:if>
    <c:if test="${pet.type == 'Bird'}">
        <img src="../../../pub/images/bird.jpg" class="card-img-top" alt="photo of parakeet">
    </c:if>
    <c:if test="${pet.type == 'Snake'}">
        <img src="../../../pub/images/snake.jpg" class="card-img-top" alt="photo of snake">
    </c:if>
    <c:if test="${pet.type == 'Bearded Dragon'}">
        <img src="../../../pub/images/beardeddragon.jpg" class="card-img-top" alt="photo of bearded dragon">
    </c:if>
    <c:if test="${pet.type == 'Turtle'}">
        <img src="../../../pub/images/turtle.jpg" class="card-img-top" alt="photo of turtle">
    </c:if>
    <c:if test="${pet.type == 'Rabbit'}">
        <img src="../../../pub/images/rabbit.jpg" class="card-img-top" alt="photo of rabbit">
    </c:if>
    <c:if test="${pet.type == 'Chinchilla'}">
        <img src="../../../pub/images/chinchilla.jpg" class="card-img-top" alt="photo of chinchilla">
    </c:if>
    <c:if test="${pet.type == 'Chameleon'}">
        <img src="../../../pub/images/chameleon.jpg" class="card-img-top" alt="photo of chameleon">
    </c:if>
    <c:if test="${pet.type == 'Ferret'}">
        <img src="../../../pub/images/ferret.jpg" class="card-img-top" alt="photo of ferret">
    </c:if>
    <c:if test="${pet.type == 'Sugar Glider'}">
        <img src="../../../pub/images/sugarglider.jpg" class="card-img-top" alt="photo of sugar glider">
    </c:if>
    <c:if test="${pet.type == 'Hedgehog'}">
        <img src="../../../pub/images/hedgehog.jpg" class="card-img-top" alt="photo of hedgehog">
    </c:if>
    <c:if test="${pet.type == 'Hamster'}">
        <img src="../../../pub/images/hamster.jpg" class="card-img-top" alt="photo of hamster">
    </c:if>
    <c:if test="${pet.type == 'Rat'}">
        <img src="../../../pub/images/rat.jpg" class="card-img-top" alt="photo of rat">
    </c:if>
    <c:if test="${pet.type == 'Fish'}">
        <img src="../../../pub/images/fish.jpg" class="card-img-top" alt="photo of fish">
    </c:if>
    <c:if test="${pet.type == 'Gerbil'}">
        <img src="../../../pub/images/gerbil.jpg" class="card-img-top" alt="photo of gerbil">
    </c:if>
    <c:if test="${pet.type == 'Other'}">
        <img src="../../../pub/images/other.jpg" class="card-img-top" alt="photo of many pets together">
    </c:if>
</div>
    <div class="m-3">
        <h1>Name: ${pet.name}</h1>
        <h3>Type: ${pet.type}</h3>
        <h3>Breed: ${pet.breed}</h3>
        <h3>Birthday: ${pet.birthday}</h3>
    </div>

    <c:forEach var="vetVisit" items="${vetVisitList}">
        <div class="card m-5" style="width: 25rem;">
            <div class="card-body">
                <h4 class="card-title p-2" style="text-align: center"><a href="/vetvisit/${vetVisit.id}">Vet Visit : ${vetVisit.date}</a></h4>
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
                        <th>Vet Name:</th>
                        <td>${vetVisit.vet.firstName} ${vetVisit.vet.lastName}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </c:forEach>


<jsp:include page="../include/footer.jsp" />