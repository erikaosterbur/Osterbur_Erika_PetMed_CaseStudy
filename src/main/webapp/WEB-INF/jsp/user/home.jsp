<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />

    <style>
        h3 a{
            color: black;
            text-decoration: none;
        }
        h3 a:hover{
            color: #bd724a;
        }
    </style>

    <h1 style="color: rgb(255, 255, 255); margin: 50px" class="d-flex justify-content-center">Welcome, ${user.firstName}!</h1>

    <div id="petDiv" class="d-flex justify-content-center flex-wrap m-5">
        <c:forEach var="pet" items="${petList}">
            <div class="card m-5" style="width: 18rem;">
                <div class="card-body">
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
                    <h3 class="card-title p-2" style="text-align: center"><a href="/pet/${pet.id}">${pet.name}</a></h3>
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
                            <td><fmt:formatDate value ="${pet.birthday}" pattern="MM/dd/yyyy"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:forEach>
    </div>


<jsp:include page="../include/footer.jsp" />