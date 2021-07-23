/** Fetches users from the server and adds them to the DOM. */
function loadUsers() {
  fetch('/load-users').then(response => response.json()).then((users) => {
    const userListElement = document.getElementById('loadedUsers');
    users.forEach((user) => {
      userListElement.appendChild(createUserElement(user));
    })
  });
}

/** Creates an element that lists a user */
function createUserElement(user) {
// add child instead of innerHTML
     document.getElementById('loadedUsers').innerHTML = `
      
            <div class="w3-card-4 w3-hover-shadow" style="max-width:300px;">
                <img src="http://placeimg.com/300/300/arch" class="w3-hover-sepia w3-image">
                <div class="w3-container w3-center">
                    <h4><b>${user.fullname}</b></h4>
                    <p>${user.age}</p>
                    <p>${user.gender}</p>
                    <p>${user.email}</p>
                    <p>${user.bio}</p>
                    <button class="w3-button w3-green w3-margin-bottom">More Info</button>
                </div>
            </div>
     `
}