$(document).ready(function(){
    $("#petOwner").click(function(){
        $("#petOwnerRegister").show();
        $("#vetRegister").hide();
    });

    $("#vet").click(function(){
        $("#petOwnerRegister").hide();
        $("#vetRegister").css("display","block");
    });

});