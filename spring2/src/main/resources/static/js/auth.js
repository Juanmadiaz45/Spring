function togglePasswordVisibility(id, toggleBtnId) {
    const input = document.getElementById(id);
    const toggleBtn = document.getElementById(toggleBtnId);
    if (input.type === "password") {
        input.type = "text";
        toggleBtn.innerHTML = `<i class="fas fa-eye-slash"></i>`;
    } else {
        input.type = "password";
        toggleBtn.innerHTML = `<i class="fas fa-eye"></i>`;
    }
}

function checkPasswordMatch() {
    const password = document.getElementById("password").value;
    const confirm = document.getElementById("confirmPassword").value;
    const message = document.getElementById("matchMessage");
    const submitButton = document.querySelector("button[type='submit']");

    if (!password || !confirm) {
        message.textContent = "";
        submitButton.disabled = true;
        return;
    }

    if (password === confirm) {
        message.textContent = "✔ Las contraseñas coinciden";
        message.style.color = "green";
        submitButton.disabled = false;
    } else {
        message.textContent = "✖ Las contraseñas no coinciden";
        message.style.color = "red";
        submitButton.disabled = true;
    }
}
