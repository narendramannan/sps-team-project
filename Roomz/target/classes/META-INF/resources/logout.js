 function checkAuthState() {
            firebase.auth().onAuthStateChanged(user => {
                if (user) {
                    // document.getElementById('dashboard').style.display = "block";
                    // document.getElementById('loginScreen').style.display = "none";
                    document.getElementById('signedIn').style.display = "block";
                    document.getElementById('signedOut').style.display = "none";
                    document.getElementById('userSignedIn').innerText = user.displayName;
                    console.log(user);
                    showUserDetails(user)
                } else {
                    document.getElementById('signedIn').style.display = "none";

                }
            })
        }

function LogoutUser() {
            console.log('Logout Btn Call')
            firebase.auth().signOut().then(() => {
                window.location = "login.html";
                // document.getElementById('loginScreen').style.display = "block";
                // document.getElementById('dashboard').style.display = "none";
            }).catch(e => {
                console.log(e)
            })
        }
checkAuthState()