<template>
    <div class="image-container" @mouseover="activateColor" @mouseleave="deactivateColor">
      <img :src="imageUrl" :style="imageStyle" alt="Image" />
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        imageUrl: "\public\tshirt_back.jpg",
        isColorActive: false,
      };
    },
    computed: {
      imageStyle() {
        return {
          filter: this.isColorActive ? "none" : "grayscale(100%)",
          transform: this.isColorActive ? "scale(1.2)" : "scale(1)",
        };
      },
    },
    methods: {
      activateColor() {
        this.isColorActive = true;
      },
      deactivateColor() {
        this.isColorActive = false;
      },
    },
  };
  </script>
  
  <style scoped>
  .image-container {
    display: inline-block;
    transition: transform 0.3s, filter 0.3s;
    cursor: pointer;
  }
  </style>
  