<template>
    <div class="image-container">
      <img class="grayscale" src="/public/tshirt_back.jpg" alt="fabrica de camisetas" />
    </div>
  </template>
  
  <style scoped>
  .image-container {
    display: inline-block;
    position: relative;
    overflow: hidden;
    transition: transform 0.3s;
    cursor: none;
  }
  
  .grayscale {
    width: 100%;
    height: auto;
    filter: grayscale(100%);
    transition: filter 0.3s, transform 0.3s;
  }
  
  .image-container:hover .grayscale {
    filter: none;
    transform: scale(1.2);
  }
  </style>
  