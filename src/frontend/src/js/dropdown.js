function toggleDropdown() {
  const dropdownMenu = document.querySelector('.dropdown-content');

  if (!dropdownMenu.classList.contains('active')) {
    return dropdownMenu.classList.add('active');
  }
  dropdownMenu.classList.remove('active');
}
