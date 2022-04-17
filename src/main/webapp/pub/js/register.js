// $(document).ready(function() {
//
//     const emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
//     const passwordRegex = /^(?=.*\d)(?=.*[A-Za-z])([^\s]){8,20}$/;
//
//     $('#petOwnerRegister').on("submit", function(event){
//         let userEmailId = $('#userEmailId').val();
//         let userPasswordId = $('#userPasswordId').val();
//         let userConfirmPasswordId = $('#userConfirmPasswordId').val();
//
//         if(
//             emailRegex.test(userEmailId) &&
//             passwordRegex.test(userPasswordId) &&
//             userPasswordId === userConfirmPasswordId
//         )
//         {
//             console.log("Success!");
//         } else if(!emailRegex.test(userEmailId)){
//             $('#emailMessage').innerText('Not a valid email');
//         } else if(!passwordRegex.test(userPasswordId)){
//             $('#passwordMessage').innerText('Password must contain at least one lowercase letter, one uppercase letter, and one number');
//         } else if(userPasswordId !== userConfirmPasswordId){
//             $('#confirmPasswordMessage').innerText("Passwords do not match");
//         }
//     });
// });

let check = function() {
    if (document.getElementById('userPasswordId').value ===
        document.getElementById('userConfirmPasswordId').value) {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'Passwords match!';
    } else {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Passwords do not match';
    }
}