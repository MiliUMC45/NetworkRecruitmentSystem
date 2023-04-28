function login() {
    var name = document.getElementById("username").value;
    var pwd = document.getElementById("password").value;
    window.location.href="LoginServlet?username=" + name + "&password=" + pwd;
}
function register() {
    window.location.href="./register.jsp";
}