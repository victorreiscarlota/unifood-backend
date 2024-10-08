/** animação para produtos **/
const produtos = document.getElementById("produtos");

window.onmousemove = (e) => {
  if (!produtos) return;
  const mouseX = e.clientX,
    mouseY = e.clientY;

  const xDecimal = mouseX / window.innerWidth,
    yDecimal = mouseY / window.innerHeight;

  const maxX = produtos.offsetWidth - window.innerWidth,
    maxY = produtos.offsetHeight - window.innerHeight;

  const panX = maxX * xDecimal * -1,
    panY = maxY * yDecimal * -1;
  produtos.animate(
    {
      transform: `translate(${panX}px, ${panY}px)`,
    },
    {
      duration: 4000,
      fill: "forwards",
      easing: "ease",
    }
  );
};
