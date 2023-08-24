<script>
import CardItem from "@/components/TeamComponent.vue"; 

export default {
  components: {
    CardItem,
  },
};
</script>

<template>
  <div class="">
    <div class="groupTeam">
      <CardItem
        imageSrc="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        title="Luci"
        subtitle="1,000 miles of wonder"
        buttonLabel="Explore"
        content="I'm a thing. But, like most politicians, he promised more than he could deliver..."
      />
      <CardItem
        imageSrc="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        title="Dani"
        subtitle="1,000 miles of wonder"
        buttonLabel="Explore"
        content="I'm a thing. But, like most politicians, he promised more than he could deliver..."
      />
      <CardItem
        imageSrc="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        title="Liber"
        subtitle="1,000 miles of wonder"
        buttonLabel="Explore"
        content="I'm a thing. But, like most politicians, he promised more than he could deliver..."
      />
    </div>
    <div class="groupTeam">
      <CardItem
        imageSrc="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        title="Javi"
        subtitle="1,000 miles of wonder"
        buttonLabel="Explore"
        content="I'm a thing. But, like most politicians, he promised more than he could deliver..."
      />
      <CardItem
        imageSrc="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        title="Alberto"
        subtitle="1,000 miles of wonder"
        buttonLabel="Explore"
        content="I'm a thing. But, like most politicians, he promised more than he could deliver..."
      />
    </div>
  </div>
</template>

<style>
.groupTeam{
  display: flex;
}
.cardTeam {
  margin-bottom: 10px;
  width: 300px;
}
</style>
