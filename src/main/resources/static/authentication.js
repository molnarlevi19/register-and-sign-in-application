
function getJwtToken() {
    return localStorage.getItem('jwtToken');
}

function makeAuthenticatedRequestUser() {
    const jwtToken = getJwtToken();

    if (!jwtToken) {
        console.error('User is not authenticated.');
        return;
    }

    fetch('http://localhost:8080/api/app/cant/user', {
        method: 'GET',
        headers: {
            'Authorization': 'Bearer ' + jwtToken,
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('Unauthorized');
            }
        })
        .then(data => {
            document.body.innerHTML = data;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}


function makeAuthenticatedRequestAdmin() {
    const jwtToken = getJwtToken();

    if (!jwtToken) {
        console.error('User is not authenticated.');
        return;
    }


    fetch('http://localhost:8080/api/app/cant/admin', {
        method: 'GET',
        headers: {
            'Authorization': 'Bearer ' + jwtToken,
            'Content-Type': 'text/html',
        },
    })
        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('Unauthorized');
            }
        })
        .then(data => {
            document.body.innerHTML = data;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

