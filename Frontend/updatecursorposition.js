function updateCursorPosition(event) {
    const cursorPositionElement = document.getElementById('cursorPosition');
    const x = event.clientX;
    const y = event.clientY;

 cursorPositionElement.innerText = `Cursor Position: (${x}, ${y})`;
}
 document.addEventListener('mousemove', updateCursorPosition);


 const countryTooltip = document.getElementById('country-tooltip');
   const paths = document.querySelectorAll('path');

   paths.forEach(path => {
      path.addEventListener('mouseover', function() {
         var countryName = this.getAttribute('title');
         const boundingBox = this.getBoundingClientRect();

         countryName === 'Western Sahara' ? countryName = 'Morocco' : countryName = countryName;

         countryTooltip.innerHTML = countryName;
         countryTooltip.style.top = `${boundingBox.top + window.scrollY}px`;
         countryTooltip.style.left = `${boundingBox.left + window.scrollX + boundingBox.width / 2}px`;
         countryTooltip.style.display = 'block';
   });

   path.addEventListener('mouseout', function() {
         countryTooltip.style.display = 'none';
});
});