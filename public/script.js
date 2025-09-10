// Drag and Drop functionality
const draggable = document.getElementById('draggable');
const dropzone = document.getElementById('dropzone');
const dragResult = document.getElementById('drag-result');

draggable.addEventListener('dragstart', (e) => {
  e.dataTransfer.setData('text/plain', draggable.id);
});

dropzone.addEventListener('dragover', (e) => {
  e.preventDefault();
  dropzone.classList.add('active');
});

dropzone.addEventListener('dragleave', (e) => {
  dropzone.classList.remove('active');
});

dropzone.addEventListener('drop', (e) => {
  e.preventDefault();
  dropzone.classList.remove('active');
  const data = e.dataTransfer.getData('text/plain');
  if (data === 'draggable') {
    dragResult.textContent = 'Dropped successfully!';
    dropzone.textContent = 'Dropped!';
    dropzone.style.background = '#d1f7c4';
    dropzone.style.color = '#27ae60';
  }
});
