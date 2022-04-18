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