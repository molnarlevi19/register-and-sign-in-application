console.log('Login.js loaded.');

function handleAuthenticationSuccess(response) {
    const jwtToken = response.token;

    localStorage.setItem('jwtToken', jwtToken);

    console.log(response);
    window.location.href = '/api/app/home';
}

function loginUser(email, password) {
    fetch('http://localhost:8080/api/v1/auth/authenticate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            email: email,
            password: password,
        }),
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Authentication failed');
            }
        })
        .then(data => handleAuthenticationSuccess(data))
        .catch(error => console.error('Error:', error));
}
