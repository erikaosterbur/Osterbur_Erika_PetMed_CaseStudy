
<jsp:include page="../include/header.jsp" />

    <style>
        img{
            width: 50%;
            border: 10px solid white;
            margin: 100px;
        }
        .containerError{
            position: relative;
            text-align: center;
            color: white;
        }
        #sorry{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            font-size: 5em;
        }
        #lost{
            position: absolute;
            top: 500px;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        #return{
            position: absolute;
            top: 580px;
            left: 50%;
            transform: translate(-50%, -50%);
        }

    </style>
    <div class="containerError">
        <img src="../../../pub/images/pug404.jpg" alt="sad looking pug" >
        <h1 id="sorry">S O R R Y</h1>
        <h2 id="lost">Looks like you're lost...</h2>
        <h3 id="return">You can either return to the previous page or visit the homepage</h3>
    </div>


<jsp:include page="../include/footer.jsp" />
