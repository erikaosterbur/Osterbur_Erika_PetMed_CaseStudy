
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

    <h1>Welcome, ${user.firstName}!</h1>

    <div id="petDiv" class="d-flex justify-content-center m-5">
        <c:forEach var="pet" items="${petList}">
            <div class="card m-5" style="width: 18rem;">
                <div class="card-body">
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
                    <h3 class="card-title p-2" style="text-align: center"><a href="/pet/${pet.id}" style="color: black">${pet.name}</a></h3>
                    <table class="table table-striped">
                        <tbody>
                        <tr>
                            <th>Type:</th>
                            <td>${pet.type}</td>
                        </tr>
                        <tr>
                            <th>Breed:</th>
                            <td>${pet.breed}</td>
                        </tr>
                        <tr>
                            <th>Birthday:</th>
                            <td>${pet.birthday}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:forEach>
    </div>






<jsp:include page="../include/footer.jsp" />