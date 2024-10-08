let button = document.getElementById("ver");

button.addEventListener("click", () => {
    document.querySelectorAll(".caixa").forEach((e) => {
    e.classList.remove("nao-visto");});
    document.querySelectorAll(".ponto").forEach((e) => {
    e.classList.remove("ponto");});
    document.getElementById("quantidade-de-notificacoes-nao-lidas").innerText = "0";
});
