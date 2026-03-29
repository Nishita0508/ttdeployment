const API = "http://localhost:8080/api";

/* ===========================
   Register User
=========================== */
async function register() {
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const branch = document.getElementById("branch").value;
    const year = document.getElementById("year").value;

    if(!name || !email || !password || !branch || !year){
        alert("Please fill all fields");
        return;
    }

    try{
        const response = await fetch(API + "/auth/register", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({name, email, password, branch, year})
        });

        if(response.ok){
            alert("Registration successful! Please login.");
            window.location.href = "index.html";
        } else {
            const errorText = await response.text();
            alert("Registration failed: " + errorText);
        }

    } catch(error){
        console.error(error);
        alert("Error registering user");
    }
}

/* ===========================
   Login User
=========================== */
async function login() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    if(!email || !password){
        alert("Please fill all fields");
        return;
    }

    try{
        const response = await fetch(API + "/auth/login", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({email, password})
        });

        if(response.ok){
            const data = await response.json();
            localStorage.setItem("user", JSON.stringify(data));
            alert("Login successful!");
            window.location.href = "dashboard.html";
        } else {
            const errorText = await response.text();
            alert("Login failed: " + errorText);
        }

    } catch(error){
        console.error(error);
        alert("Error logging in");
    }
}

/* ===========================
   Load Careers
=========================== */
async function loadCareers(){
    let response = await fetch(API + "/career");
    let data = await response.json();
    let html = "";
    data.forEach(c => {
        html += "<p>" + c + "</p>";
    });
    document.getElementById("careers").innerHTML = html;
}

/* ===========================
   Upload Certificate
=========================== */
async function uploadCertificate(){
    const fileInput = document.getElementById("file");
    const file = fileInput.files[0];
    if(!file){
        alert("Select a file first");
        return;
    }

    const formData = new FormData();
    formData.append("file", file);

    try{
        const response = await fetch(API + "/certificates/upload", {
            method: "POST",
            body: formData
        });

        if(response.ok){
            const data = await response.json();
            document.getElementById("uploadResult").innerHTML = `
                <strong>Certification:</strong> ${data.name}<br>
                <strong>Career Options:</strong> ${data.careers.join(", ")}<br>
                <strong>Roadmap:</strong> <a href="${data.roadmap}" target="_blank">Click Here</a>
            `;
        } else {
            alert("Upload failed");
        }
    } catch(error){
        console.error(error);
        alert("Error uploading certificate");
    }
}

/* ===========================
   Chatbot
=========================== */
async function askBot(){
    const question = document.getElementById("question").value;
    if(!question) return;

    try{
        const response = await fetch(API + "/chat", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(question)
        });

        if(response.ok){
            const text = await response.text();
            document.getElementById("botResponse").innerText = text;
        } else {
            alert("Chatbot error");
        }
    } catch(error){
        console.error(error);
        alert("Error contacting chatbot");
    }
}

/* ===========================
   Get Roadmap
=========================== */
async function getRoadmap(){
    const career = document.getElementById("careerName").value;
    if(!career) return;

    try{
        const response = await fetch(API + "/roadmap/" + career);
        if(response.ok){
            const data = await response.json();
            let html = "<ul>";
            data.forEach(step => html += "<li>" + step + "</li>");
            html += "</ul>";
            document.getElementById("roadmap").innerHTML = html;
        } else {
            document.getElementById("roadmap").innerText = "No roadmap found";
        }
    } catch(error){
        console.error(error);
        alert("Error fetching roadmap");
    }
}