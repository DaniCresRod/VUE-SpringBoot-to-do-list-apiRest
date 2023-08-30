<script setup>
import CardItem from "@/components/TeamCardComponent.vue";

</script>

<template>
  <v-parallax class="imgInfo"
    height="300"
    width="auto"
    src="../../public/img/image.png"
  ></v-parallax>
  <div class="teamGroup">
    <div class="teamItem">
      <CardItem
        imageSrc="../../public/img/image (1).png"
        title="Luci"
        subtitle="UX / UI Designer"
        buttonLabel="Más de mi"
        content='"Su figmita y sus cosas. Siempre se me ha dado bien romper Vuetify"'
      />
      </div>
      <div class="teamItem">
      <CardItem
        imageSrc="../../public/img/image (2).png"
        title="Dani"
        subtitle="Product Owner"
        buttonLabel="Más de mi"
        content='"Algo que no has probado en Postman no tiene validez"'
      />
    </div>
    <div class="teamItem">
      <CardItem
        imageSrc="../../public/img/image (3).png"
        title="Liber"
        subtitle="BackEnd Developer"
        buttonLabel="Más de mi"
        content='"Yo no comento, yo borro"'
      />
    </div>
    <div class="teamItem">
      <CardItem
        imageSrc="../../public/img/image (4).png"
        title="Javi"
        subtitle="Scrum Master"
        buttonLabel="Más de mi"
        content='"No necesito un ordenador para picar código"'
      />
    </div>
    <div class="teamItem">
      <CardItem
        imageSrc="../../public/img/image (5).png"
        title="Alberto"
        subtitle="FrontEnd Developer"
        buttonLabel="Más de mi"
        content='"Yo solo he participado en la creación de estas frases"'
      />
    </div>
  </div>
</template>

<style>

.teamGroup{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

@media (max-width: 768px) {
  .teamGroup {
    justify-content: center;
    margin-bottom: 3rem;
  }
}

.imgInfo {
  border-radius: 0.5rem;
  background-size: contain;
}

.teamItem {
  flex: 0 0 calc(20% - 20px);
}
</style>
