/** animação para banner principal **/
function slider() {
  const esquerdo = document.getElementById("lado-esquerdo");
  const handleMove = (e) => {
    esquerdo.style.width = `${(e.clientX / window.innerWidth) * 100}%`;
  };

  document.onmousemove = (e) => handleMove(e);

  document.ontouchmove = (e) => handleMove(e.touches[0]);
}

slider();
